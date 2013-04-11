package com.igo.testro.service;

import java.lang.reflect.Proxy;
import javax.servlet.ServletContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.igo.testro.exception.FrameworkException;


/**
 * 
 * <p>
 * 프로그램명:ServiceFinder.java<br/>
 * 설명 : 서비스를 얻기 위한 싱글턴 WebApplicationContext 객체 생성 서비스bean을 WebApplicationContext 에서 찾아옴<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 8. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class ServiceFinder {

	public static final String GENERIC = "Generic";

	public final static String FRAMEWORK = "Framework";

	public final static String WEB = "Service";

	private static final String EXCEPTION_MSG_0 = "해당 ";

	private static final String EXCEPTION_MSG_1 = " Object[";

	private static final String EXCEPTION_MSG_2 = "] 를 생성 할 수 없습니다.";

	private ServiceFinder() {
	}

	private static ServiceFinder instance = null;

	public static ServiceFinder getInstance() {
		if (instance == null) {
			synchronized (ServiceFinder.class) {
				if (instance == null) {
					instance = new ServiceFinder();
				}
			}
		}
		return instance;
	}

	/** framwork 모듈 영역 */
	private ApplicationContext ctx;

	/** webService 영역 */
	private WebApplicationContext wac;
	
	public void init(ServletContext ctx) {
		
		this.ctx = new ClassPathXmlApplicationContext(
				"com/igo/testro/resource/testro_applicationContext.xml");
		
		this.wac = WebApplicationContextUtils
		.getWebApplicationContext(ctx);
		wac.publishEvent(new ContextRefreshedEvent(wac));
		
	}

	/**
	 * spring에 등록된 bean객체를 반환한다 moduleGubun의 인자값으로 판별하여 framework bean과 web
	 * bean을 반환한다
	 * 
	 * @param serviceNm
	 * @param moduleGubun
	 * @return
	 * @throws FrameworkException
	 */
	public Object getService(String serviceNm, String moduleGubun)
			throws FrameworkException {

		try {
			// framework에서 정의된 bean
			if (FRAMEWORK.equals(moduleGubun)) {
				return instance.ctx.getBean(serviceNm);
				// // web에서 정의된 bean
			} else if (WEB.equals(moduleGubun)) {
				return instance.wac.getBean(serviceNm);
			} else {
				// default는 web으로 설정
				moduleGubun = WEB;
				return instance.wac.getBean(serviceNm);
			}
		} catch (BeansException e) {
			e.printStackTrace();
			throw new FrameworkException(EXCEPTION_MSG_0 + moduleGubun
					+ EXCEPTION_MSG_1 + serviceNm + EXCEPTION_MSG_2, e);
		}
	}

	/**
	 * spring에 등록된 bean객체를 반환한다 serviceNm 만 인자값으로 올 경우 default로 web bean을 반환한다
	 * 
	 * @param serviceNm bean id
	 * @return
	 * @throws FrameworkException
	 */
	public Object getService(String serviceNm) throws FrameworkException {

		try {
			return instance.wac.getBean(serviceNm);
		} catch (BeansException e) {
			throw new FrameworkException(EXCEPTION_MSG_0 + WEB
					+ EXCEPTION_MSG_1 + serviceNm + EXCEPTION_MSG_2, e);
		}
	}

	/**
	 * beans의 type 얻어온다. IAction을 상속받은 webservice bean의 경우만 해당됨
	 * 
	 * @param serviceNm
	 * @param moduleGubun
	 * @return
	 * @throws FrameworkException
	 */
	@SuppressWarnings("unchecked")
	public Class getType(String serviceNm) throws FrameworkException {

		try {

			Object obj = instance.wac.getBean(serviceNm);

			// proxyClass인지 판별하여 class type 추출
			if (Proxy.isProxyClass(obj.getClass())) {
				return AopUtils.getTargetClass(obj);
			}

			return obj.getClass();
		} catch (BeansException e) {
			e.printStackTrace();
			throw new FrameworkException(EXCEPTION_MSG_0 + WEB
					+ EXCEPTION_MSG_1 + serviceNm + EXCEPTION_MSG_2, e);
		}
	}

}
