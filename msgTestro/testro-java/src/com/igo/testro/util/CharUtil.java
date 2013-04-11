package com.igo.testro.util;

import java.io.UnsupportedEncodingException;

import com.igo.testro.constant.PropertyKey;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.preference.TestroPreference;

/**
 * 
 * <p>
 * 프로그램명 : CharUtil.java<br/>
 * 설명 : Testro Charator Util<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 28. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class CharUtil {
	
	private static final String UTF_8 = "UTF-8";
	private static final String ISO_8859_1 = "ISO-8859-1";

	/**
	 * 
	 * <p>
	 * Get방식으로 들어온 request parameter를 UTF-8로 변환해준다.<br/>
	 * master_config.prop에 정의하지 않으면 디폴트로 WAS_URL_ENCODING을 ISO-8859-1로 인식하여 처리한다. 
	 * <p>
	 * @param param request parameter
	 * @return utf-8 character
	 */
	public static String convUrlParam(String param) {
		
		if (param == null) return null;
		String result = null;
		try {
			String wasUrlEncoding = TestroPreference.getInstance().getProperty(PropertyKey.WAS_URL_ENCODING.getCode(), TestroPreference.MASTER);
			if (wasUrlEncoding == null || "".equals(wasUrlEncoding)) wasUrlEncoding = ISO_8859_1;
			if (UTF_8.equals(wasUrlEncoding)) {
				result = param;
			} else {
				result =  new String(param.getBytes(wasUrlEncoding), UTF_8);
			}
		} catch (UnsupportedEncodingException e) {
			throw new FrameworkException("convUrlParam exception..", e);
		}
		return result;
	}
}
