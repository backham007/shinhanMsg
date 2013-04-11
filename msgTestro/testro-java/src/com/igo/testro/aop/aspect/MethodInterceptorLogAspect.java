package com.igo.testro.aop.aspect;

import java.lang.reflect.Method;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import com.igo.testro.anot.LogInfo;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.thread.ThreadAttribute;

/**
 * 
 * <p>
 * 프로그램명:MethodInterceptorLogAspect.java<br/>
 * 설명 : 컨트롤러 메소드 인포로그출력을 위한 Aspect<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 5. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
@Aspect
public class MethodInterceptorLogAspect {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	ThreadLocal<String> threadLocal;
	
	@Around("execution(* *..*Controller..*(..))")
	public Object doSomething(ProceedingJoinPoint joinPoint) throws Throwable{
		try {
			String shortString = joinPoint.toShortString();
			int dotIdx = shortString.indexOf(".")+1;
			int endIdx = shortString.indexOf("(", dotIdx);
			String methodNm = shortString.substring(dotIdx, endIdx);
			Object target = joinPoint.getTarget();
			Method[] methods = target.getClass().getMethods();
			
			String strTarget = target.getClass().getName() + "." + methodNm + "()";
			String info = "호출 대상 : [" + strTarget + "]";
			
			for (int i = 0; i < methods.length; i++) {
				if (methodNm.equals(methods[i].getName())) {
					LogInfo annotation = methods[i].getAnnotation(LogInfo.class);
					if (annotation != null) {
						info = info + "  대상 설명 : [" + annotation.description() + "]";
					}
					break;
				}
			}
			Map<String, Object> map = ThreadAttribute.get();
			if (map.get("USER_INFO") != null) {
				if (logger.isInfoEnabled()) logger.info(map.get("USER_INFO") + info);
			}
		} finally {
			ThreadAttribute.clear();
		}
		return joinPoint.proceed();
	}
	
}
