package com.igo.testro.cmn.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * <p>
 * 프로그램명:DateUtil.java<br/>
 * 설명 : 날짜관련 Util Class<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class DateUtil {
	
	/**
	 * 
	 * <p>
	 * 현재 날짜와 시간을 반환(YYYYMMDDKKMMSS)
	 * <p>
	 * @return String
	 */
	public static String getDateString() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 날짜를 yyyy/MM/dd HH:mm:ss 형식으로 바꾼다.<br>
	 * 입력된 날짜가 null 일경우 "" 리턴, 에러 발생시 입력된 날짜 반환.
	 * @param dt 날짜(8자리 또는 14자리)
	 * @return 특정 포멧으로 변환된 날짜
	 */
    public static String convertQuicsFormat(String dt) {
		if (dt == null)
		    return "";
		try {
		    return convertFormat(dt, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
		    return dt;
		}
    }

    /**
	 * 날짜String을 yyyy-MM-dd 형식으로 바꾼다.<br>
	 * 입력된 날짜가 null 일경우 "" 리턴, 에러 발생시 입력된 날짜 반환.
	 * @param dt 날짜(8자리 또는 14자리)
	 * @return 특정 포멧으로 변환된 날짜
	 */
    public static String convertShortQuicsFormat(String dt) {
		if (dt == null)
		    return "";
		try {
		    return convertFormat(dt, "yyyy-MM-dd");
		} catch (Exception e) {
		    return dt;
		}
    }
	
	/**
	 * 날짜를 formatter 형식으로 바꾸어 반환한다.
	 * @param dt 날짜 (8자리 또는 14자리)-yyyyMMdd 또는 yyyyMMddHHmmss
	 * @param formatter 보여줄 형식
	 * @return String 특정 포멧으로 변환된 날짜
	 */
    public static String convertFormat(String dt, String formatter) {
		if (dt == null)
		    throw new IllegalArgumentException("dt can not be null");
	
		int len = dt.length();
		if (!(len == 8 || len == 14))
		    throw new IllegalArgumentException("dt length must be 8 or 14 (yyyyMMdd or yyyyMMddHHmmss)");
	
		if (dt.length() == 8)
		    dt += "000000";
	
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(getDate(dt));
    }
    
    /**
	 * 14 자리의 String 문자열을 받아 Data 객체를 생성하여 반환한다.
	 * @param dt String 14 자리 날짜 (yyyyMMddHHmmss)
	 * @return Date
	 */
    private static java.util.Date getDate(String dt) {
    	Calendar cal = Calendar.getInstance();
    	cal.set(Integer.valueOf(dt.substring(0, 4)).intValue(), Integer.valueOf(dt.substring(4, 6)).intValue() - 1, Integer.valueOf(
		dt.substring(6, 8)).intValue(), Integer.valueOf(dt.substring(8, 10)).intValue(), Integer.valueOf(dt.substring(10, 12)).intValue(),
		Integer.valueOf(dt.substring(12, 14)).intValue());

    	return cal.getTime();
    }
}