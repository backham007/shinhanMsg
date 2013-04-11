package com.igo.testro.bean.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.preference.LinkedProperties;

/**
 * 
 * <p>
 * 프로그램명:TestroBeanUtil.java<br/>
 * 설명 : Bean Util<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroBeanUtil {
	
	
	private static final String SET = "set";
	private static final String GET = "get";
	private static final String LONG = "long";
	private static final String INT = "int";
	private static final String JAVA_LANG_STRING = "java.lang.String";
	
	
	/**
	 * 
	 * <p>
	 * 프로퍼티를 값을 Bean으로 복사해준다.<br/>
	 * Bean객체의 메소드 파라미터가 String, int, long인것만 가능하다.<br/>
	 * <p>
	 * @param props 프로퍼티객체
	 * @param dsBean 복사할 대상 빈객체
	 */
	public static void copyPropeToBean(Properties props, Object bean) {
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String substring = key.substring(0,1);
			String upperCase = substring.toUpperCase();
			String methodNm = SET + upperCase + key.substring(1);
			
			Method[] methods = bean.getClass().getMethods();
			try {
				for (int i = 0; i < methods.length; i++) {
					if (methodNm.equals(methods[i].getName())) {
						
						Class<?>[] parameterTypes = methods[i].getParameterTypes();
						
						if (JAVA_LANG_STRING.equals(parameterTypes[0].getName())) {
							methods[i].invoke(bean, props.getProperty(key));
						} else if (INT.equals(parameterTypes[0].getName())) {
							methods[i].invoke(bean, Integer.parseInt(props.getProperty(key)));
						} else if (LONG.equals(parameterTypes[0].getName())) {
							methods[i].invoke(bean, Long.parseLong(props.getProperty(key)));
						}
						
					}
					
				}
			} catch (Exception e) {
				throw new FrameworkException("bean copy reflection error..", e);
			}
		}
	}

	
	/**
	 * 
	 * <p>
	 * dto의 값을 객체빈에 복사해준다.
	 * <p>
	 * @param fromBean 복사할 값을 가진 Dto
	 * @param toBean 복사할 대상 빈객체
	 */
	public static void copyDtoToBean(Object fromBean, Object toBean) {
		Field[] fields = fromBean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			String fieldName = field.getName();
			String substring = fieldName.substring(0,1);
			String upperCase = substring.toUpperCase();
			upperCase =  upperCase + fieldName.substring(1);
			String getMethodName = GET + upperCase;
			
			Method method = null;
			
			try {
				method = fromBean.getClass().getMethod(getMethodName, null);
			
			} catch (Exception ignore) {
				//e.printStackTrace();
				continue;
			}
			
			String returValue = null;
			
			try {
				returValue = (String)method.invoke(fromBean, null);
			} catch (Exception ignore) {
				//e.printStackTrace();
				continue;
			} 
			
			if (returValue == null || "".equals(returValue)) continue;
			
			String setMethodName = SET + upperCase;
			Method[] methods = toBean.getClass().getMethods();
			try {
				for (int i = 0; i < methods.length; i++) {
					if (setMethodName.equals(methods[i].getName())) {
						
						Class<?>[] parameterTypes = methods[i].getParameterTypes();
						
						if (JAVA_LANG_STRING.equals(parameterTypes[0].getName())) {
							methods[i].invoke(toBean, returValue);
						} else if (INT.equals(parameterTypes[0].getName())) {
							methods[i].invoke(toBean, Integer.parseInt(returValue));
						} else if (LONG.equals(parameterTypes[0].getName())) {
							methods[i].invoke(toBean, Long.parseLong(returValue));
						}
						
					}
					
				}
			} catch (Exception e) {
				throw new FrameworkException("bean copy reflection error..", e);
			}
		}
	}
	
	
	/**
	 * 
	 * <p>
	 * dto 값을 프로퍼티 객체값에 복사
	 * <p>
	 * @param dtoBean fromBean 복사할 값을 가진 Dto
	 * @param prop 복사할 대상 프로퍼티 객체
	 */
	public static void copyDtoToPropery(Object dtoBean, LinkedProperties prop) {
		Field[] fields = dtoBean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			String fieldName = field.getName();
			String substring = fieldName.substring(0,1);
			String upperCase = substring.toUpperCase();
			upperCase =  upperCase + fieldName.substring(1);
			String getMethodName = GET + upperCase;
			
			Method method = null;
			
			try {
				method = dtoBean.getClass().getMethod(getMethodName, null);
			
			} catch (Exception ignore) {
				//e.printStackTrace();
				continue;
			}
			
			String returValue = null;
			
			try {
				returValue = (String)method.invoke(dtoBean, null);
			} catch (Exception ignore) {
				//e.printStackTrace();
				continue;
			} 
			
			if (returValue == null || "".equals(returValue)) continue;
			
			prop.setProperty(fieldName, returValue);
			
		}
	}
}
