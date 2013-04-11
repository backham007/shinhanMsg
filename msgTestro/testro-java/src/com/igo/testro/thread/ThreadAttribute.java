package com.igo.testro.thread;

import java.util.HashMap;
import java.util.Map;



/**
 * <p>
 * 프로그램명:ThreadAttribute.java<br>
 * 설명 : <br>
 * 변경이력<br>
 * <ul>
 *	  <li>Jan 28, 2008 : 이름() : 내용
 * </ul> 
 * </p>
 */
public class ThreadAttribute {
	private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>> () {
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
	};

	public static final Map<String, Object> get() {
		return threadLocal.get();
	}
	
	public static final void clear() {
		threadLocal.remove();
		
	}

	private ThreadAttribute() {}
}
