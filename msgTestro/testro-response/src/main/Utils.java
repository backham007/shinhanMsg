package main;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Document;


public class Utils {
	/**
	 * White Space 정보
	 */
	private final static String WHITE_SPACE = " \t\n\r\f";
	
	/**
	 * Empty String인지 체크
	 * @param val - String
	 * @return boolean - 공백문자일경우 true, 그렇지 않을경우 false.
	 */
	public static boolean isEmptyString(String val) {
		if (val == null || val.equalsIgnoreCase("") || val.length() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Object 객체를 String 문자열로 반환한다.<br>
	 * Object 객체가 Document 객체를 담고 있는 Vector 이거나, <br>
	 * Object 객체가 Document 객체일 경우 XML 문자열을 생성하여 반환한다.<br>
	 * 그 외의 경우는 객체에 대한 toString() 문자열을 반환한다.
	 * @param obj Object 객체
	 * @return String - Object가 null 이면 null을 반환.
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return null;
		} else if (obj instanceof Vector) {
			return toString((Vector) obj);
		} else if (obj instanceof Document) {
			return toString((Document) obj);
		} else {
			return obj.toString();
		}
	}

	/**
	 * Vector 객체를 String 문자열로 반환한다.<br>
	 * 단, Document 객체를 담고있는 Vector 인경우는 Document 객체들만 포함하고<br>
	 * 있어야 정상적인 문자열을 반환한다.
	 * @param v Vector 객체
	 * @return String - Object가 null 이면 null을 반환.
	 */
	public static String toString(Vector v) {
		if (v == null)
			return null;
		Object obj = v.firstElement();
		if (obj instanceof Document) {
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < v.size(); i++) {
				if (i != 0)
					sb.append(", ");
				sb.append(toString((Document) v.elementAt(i)));
			}
			sb.append("]");
			return sb.toString();
		} else {
			return v.toString();
		}
	}

	/**
	 * 문자열(str)내에 해당 문자열(repleatStr)이 몇 개 있는지 반환한다.
	 * @param str - 원본문장
	 * @param repeatStr - 원본문장에서 찾아낼 문자
	 * @return int
	 */
	public static int getRepeatCnt(String str, String repeatStr) {
		int cnt = 0;
		int pos = -1;
		while ((pos = str.indexOf(repeatStr)) >= 0) {
			str = str.substring(pos + repeatStr.length());
			cnt++;
		}
		return cnt;
	}	
	
	/**
	 * 특정 문자열이 boolean형의 값으로 변환이 가능한지 체크하고, <br>
	 * 변환이 가능하면 true 반환, 불가능한 문자열이면 false를 반환<br>
	 * 입력 문자열이 null 값이면 디폴트 boolean 값을 반환한다.
	 * @param value - boolean으로 변환할 문자열
	 * @param defaultValue - 디폴트 boolean 값
	 * @return boolean
	 */
	public static boolean parseBoolean(String value, boolean defaultValue) {
		return (value == null) ? defaultValue : Boolean.valueOf(value).booleanValue();
	}

	/**
	 * 특정 문자열이 boolean형의 값으로 변환이 가능한지 체크하고, <br>
	 * 변환이 가능하면 true 반환, 불가능한 문자열이면 false를 반환<br>
	 * 입력 문자열이 null 값이면 false 값을 반환한다.
	 * @param value - boolean으로 변환할 문자열
	 * @return boolean
	 */
	public static boolean parseBoolean(String value) {
		return parseBoolean(value, false);
	}

	/**
	 * 문자열을 입력받아 문자열의 첫번째 문자를 반환한다.<br>
	 * 단, 입력 문자열이 없거나, 공백일경우는 디폴트 문자 반환.
	 * @param value - 문자열
	 * @param defaultValue - 디폴트 문자
	 * @return char - 문자열의 첫번째 문자
	 */
	public static char parseChar(String value, char defaultValue) {
		return (value == null || value.equals("")) ? defaultValue : value.charAt(0);
	}

	/**
	 * 문자열을 입력받아 문자열의 첫번째 문자를 반환한다.<br>
	 * 단, 입력 문자열이 없거나, 공백일경우는 '0' 반환.
	 * @param value - 문자열
	 * @return char - 문자열의 첫번째 문자
	 */
	public static char parseChar(String value) {
		return parseChar(value, (char) 0);
	}

	/**
	 * 문자열을 정수형(int)으로 변환하여 반환한다.<br>
	 * 단, 정수형으로 변경할 수 없는 문자열의 경우는 디폴트 정수값 반환.
	 * @param value - 정수형으로 변환할 문자열
	 * @param defaultValue - 디폴트 int값
	 * @return int - 문자열을 정수형으로 변환한 값
	 */
	public static int parseInt(String value, int defaultValue) {
		try {
			return (value == null || value.equals("")) ? defaultValue : Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 문자열을 정수형(int)으로 변환하여 반환한다.<br>
	 * 단, 정수형으로 변경할 수 없는 문자열의 경우는 -1 반환.
	 * @param value - 정수형으로 변환할 문자열
	 * @return int - 문자열을 정수형으로 변환한 값
	 */
	public static int parseInt(String value) {
		return parseInt(value, -1);
	}

	/**
	 * 문자열을 long형으로 변환하여 반환한다.<br>
	 * 단, long형으로 변경할 수 없는 문자열의 경우는 디폴트값 반환.
	 * @param value - long으로 변환할 문자열
	 * @param defaultValue - 디폴트 long값
	 * @return int - 문자열을 long형으로 변환한 값
	 */
	public static long parseLong(String value, long defaultValue) {
		try {
			return (value == null || value.equals("")) ? defaultValue : Long.parseLong(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 문자열을 long형으로 변환하여 반환한다.<br>
	 * 단, long형으로 변경할 수 없는 문자열의 경우는 -1L 반환.
	 * @param value - long으로 변환할 문자열
	 * @return int - 문자열을 long형으로 변환한 값
	 */
	public static long parseLong(String value) {
		return parseLong(value, -1L);
	}

	/**
	 * 문자열을 Float형으로 변환하여 반환한다.<br>
	 * 단, Float형으로 변환할수 없는 문자열의 경우 디폴트 Float 값을 반환.
	 * @param value - Float형으로 변환할 문자열
	 * @param defaultValue - 디폴트 Float값
	 * @return Float - 문자열을 Float형으로 변환한 값.
	 */
	public static float parseFloat(String value, float defaultValue) {
		try {
			return (value == null || value.equals("")) ? defaultValue : Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 문자열을 Float형으로 변환하여 반환한다.<br>
	 * 단, Float형으로 변환할수 없는 문자열의 경우 -1.0F 값을 반환.
	 * @param value - Float형으로 변환할 문자열
	 * @return Float - 문자열을 Float형으로 변환한 값.
	 */
	public static float parseFloat(String value) {
		return parseFloat(value, -1.0F);
	}

	/**
	 * 문자열을 Double형으로 변환하여 반환한다.<br>
	 * 단, Double형으로 변환할수 없는 경우 디폴트 값을 반환.
	 * @param value - Double형으로 변환할 문자열
	 * @param defaultValue - 디폴트 Double값
	 * @return 문자열을 Double형으로 변환한 값.
	 */
	public static double parseDouble(String value, double defaultValue) {
		try {
			return (value == null || value.equals("")) ? defaultValue : Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 문자열을 Double형으로 변환하여 반환한다.<br>
	 * 단, Double형으로 변환할수 없는 경우 -1.0 을 반환.
	 * @param value - Double형으로 변환할 문자열
	 * @return 문자열을 Double형으로 변환한 값.
	 */
	public static double parseDouble(String value) {
		return parseDouble(value, -1.0);
	}

	/**
	 * 문자열의 null값이나 공백("")문자열 일경우 default 문자열로 대체한다.
	 * @param value - 원본 문자열
	 * @param defaultValue - default 문자열
	 * @return String
	 */
	public static String evl(String value, String defaultValue) {
		String	retVal	=	"";
		if (value == null || value.equals("") || value.equals("undefined")) {
			retVal	=	defaultValue;
		} else {
			retVal	=	value;
		}
		retVal = retVal.replace("&", "&amp;");
		retVal = retVal.replace("<", "&lt;");
		retVal = retVal.replace(">", "&gt;");
		retVal = retVal.replace("\"", "&qout;");
		retVal = retVal.replace("\'", "&#039;");
		
		return retVal;
	}

	/**
	 * 문자열의 null값이나 트림 후 공백("")문자열 일경우 default 문자열로 대체한다.
	 * @param value - 원본 문자열
	 * @param defaultValue - default 문자열
	 * @return String
	 */
	public static String evlTrim(String value, String defaultValue) {
		return (value == null) ? defaultValue : ((value.trim().equals("")) ? defaultValue : value.trim());
	}

	/**
	 * 문자열의 null값이나 공백("")문자열 일경우 default 문자열로 대체한다.
	 * @param obj - 원본 문자열
	 * @param defaultValue - default 문자열
	 * @return String
	 */
	public static String evl(Object obj, String defaultValue) {
		String	retVal	=	"";
		if ((obj == null) || obj.equals("") || obj.equals("undefined")) {
			retVal	=	defaultValue;
		} else {
			retVal	=	obj.toString();
		}
		retVal = retVal.replace("&", "&amp;");
		retVal = retVal.replace("<", "&lt;");
		retVal = retVal.replace(">", "&gt;");
		retVal = retVal.replace("\"", "&qout;");
		retVal = retVal.replace("\'", "&#039;");
		
		return retVal;
	}
	
	public static String evl(Object obj) {
		String	retVal	=	"";
		
		if(obj == null){
			retVal	=	null;
		}
		else {
			if (obj.equals("") || obj.equals("undefined")) {
				retVal	=	"";
			}
			else {
				retVal	=	obj.toString();
				
				retVal = retVal.replace("&", "&amp;");
				retVal = retVal.replace("<", "&lt;");
				retVal = retVal.replace(">", "&gt;");
				retVal = retVal.replace("\"", "&qout;");
				retVal = retVal.replace("\'", "&#039;");
			}
		}
		return retVal;
	}

	/**
	 * 문자열의 null값일 경우 default 문자열로 대체한다.
	 * @param value - 원본 문자열
	 * @param defaultValue - default 문자열
	 * @return String
	 */
	public static String nvl(String value, String defaultValue) {
		String	retVal	=	"";
		if(value == null || value.equals("") || value.equals("undefined")) {
			retVal	=	defaultValue; 
		} else {
			retVal	=	value;
		}
		
		retVal = retVal.replace("&", "&amp;");
		retVal = retVal.replace("<", "&lt;");
		retVal = retVal.replace(">", "&gt;");
		retVal = retVal.replace("\"", "&qout;");
		retVal = retVal.replace("\'", "&#039;");
		
		return retVal;
	}
	
	public static String nvl(String value) {
		String	retVal	=	"";
		if(value == null) {
			retVal = null;
		}
		else {
			if(value.equals("undefined")) {
				retVal	=	""; 
			}
			else {
				retVal	=	value;
				
				retVal = retVal.replace("&", "&amp;");
				retVal = retVal.replace("<", "&lt;");
				retVal = retVal.replace(">", "&gt;");
				retVal = retVal.replace("\"", "&qout;");
				retVal = retVal.replace("\'", "&#039;");
			}
		}
		
		return retVal;
	}
	
	public static String evl(String value) {
		String	retVal	=	"";
		if(value == null) {
			retVal = null;
		}
		else {
			if(value.equals("undefined")) {
				retVal	=	""; 
			}
			else {
				retVal	=	value;
				
				retVal = retVal.replace("&", "&amp;");
				retVal = retVal.replace("<", "&lt;");
				retVal = retVal.replace(">", "&gt;");
				retVal = retVal.replace("\"", "&qout;");
				retVal = retVal.replace("\'", "&#039;");
			}
		}
		
		return retVal;
	}
	
	/**
	 * 아래에 정의된 공백이 제거된 문자열을 반환한다.<br>
	 * If the argument string is null, returns empty string (&quot;&quot;).<br>
	 * <caption>white space</caption> <table>
	 * <tr>
	 * <td>'\t'</td>
	 * <td>&#92;u0009</td>
	 * <td><code>HORIZONTAL TABULATION</code></td>
	 * </tr>
	 * <tr>
	 * <td>'\n'</td>
	 * <td>&#92;u000A</td>
	 * <td><code>NEW LINE</code></td>
	 * </tr>
	 * <tr>
	 * <td>'\f'</td>
	 * <td>&#92;u000C</td>
	 * <td><code>FORM FEED</code></td>
	 * </tr>
	 * <tr>
	 * <td>'\r'</td>
	 * <td>&#92;u000D</td>
	 * <td><code>CARRIAGE RETURN</code></td>
	 * </tr>
	 * <tr>
	 * <td>'&nbsp;&nbsp;'</td>
	 * <td>&#92;u0020</td>
	 * <td><code>SPACE</code></td>
	 * </tr>
	 * </table>
	 * @param value 공백을 제거할 문자열
	 * @return String - 공백이 제거된 문자열
	 */
	public static String trim(String value) {
		return (value == null) ? "" : value.trim();
	}

	/**
	 * 문자열의 왼쪽에 존재하는 공백을 제거하여 반환한다.
	 * @param value - 공백을 제거할 문자열
	 * @return String - 문자열 왼쪽부분의 공백이 제거된 문자열.
	 */
	public static String ltrim(String value) {
		if (value == null)
			return "";

		for (int i = 0; i < value.length(); i++) {
			if (WHITE_SPACE.indexOf(value.charAt(i)) == -1)
				return value.substring(i);
		}

		return "";
	}

	/**
	 * 문자열의 오른쪽에 존재하는 공백을 제거하여 반환한다.
	 * @param value - 공백을 제거할 문자열
	 * @return String - 문자열 오른쪽 부분의 공백이 제거된 문자열.
	 */
	public static String rtrim(String value) {
		if (value == null || value.equals(""))
			return "";

		for (int i = value.length() - 1; i >= 0; i--) {
			if (WHITE_SPACE.indexOf(value.charAt(i)) == -1)
				return value.substring(0, i + 1);
		}

		return "";
	}

	/**
	 * 문자열의 길이가 특정 길이 보다 작을경우 왼쪽에 특정 길이가 될때까지<br>
	 * 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - 문자열
	 * @param padLen - 특정 길이
	 * @param padChar - 왼쪽에 붙일 문자
	 * @return String
	 */
	public static String lpad(String value, int padLen, char padChar) {
		if (value == null)
			value = "";

		while (value.length() < padLen) {
			value = padChar + value;
		}

		return value;
	}

	/**
	 * Short형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 왼쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - Short형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 왼쪽에 붙일 문자
	 * @return String
	 */
	public static String lpad(short value, int padLen, char padChar) {
		return lpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * int형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 왼쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - int형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 왼쪽에 붙일 문자
	 * @return String
	 */
	public static String lpad(int value, int padLen, char padChar) {
		return lpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * long형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 왼쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - long형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 왼쪽에 붙일 문자
	 * @return String
	 */
	public static String lpad(long value, int padLen, char padChar) {
		return lpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * float형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 왼쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - float형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 왼쪽에 붙일 문자
	 * @return String
	 */
	public static String lpad(float value, int padLen, char padChar) {
		return lpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * double형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 왼쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - double형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 왼쪽에 붙일 문자
	 * @return String
	 */
	public static String lpad(double value, int padLen, char padChar) {
		return lpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * 문자열의 길이가 특정 길이 보다 작을경우 오른쪽에 특정 길이가 될때까지<br>
	 * 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - 문자열
	 * @param padLen - 특정 길이
	 * @param padChar - 오른쪽에 붙일 문자
	 * @return String
	 */
	public static String rpad(String value, int padLen, char padChar) {
		if (value == null)
			value = "";

		while (value.length() < padLen) {
			value = value + padChar;
		}

		return value;
	}

	/**
	 * Short형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 오른쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - Short형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 오른쪽에 붙일 문자
	 * @return String
	 */
	public static String rpad(short value, int padLen, char padChar) {
		return rpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * int형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 오른쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - int형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 오른쪽에 붙일 문자
	 * @return String
	 */
	public static String rpad(int value, int padLen, char padChar) {
		return rpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * long형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 오른쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - long형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 오른쪽에 붙일 문자
	 * @return String
	 */
	public static String rpad(long value, int padLen, char padChar) {
		return rpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * float형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 오른쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - float형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 오른쪽에 붙일 문자
	 * @return String
	 */
	public static String rpad(float value, int padLen, char padChar) {
		return rpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * double형 값을 받아 문자열로 변환 한 후 문자열의 길이가 특정 길이 보다 작을경우<br>
	 * 오른쪽에 특정 길이가 될때까지 특정 문자를 붙인 후 문자열을 반환한다.
	 * @param value - double형 값
	 * @param padLen - 특정 길이
	 * @param padChar - 오른쪽에 붙일 문자
	 * @return String
	 */
	public static String rpad(double value, int padLen, char padChar) {
		return rpad(String.valueOf(value), padLen, padChar);
	}

	/**
	 * 숫자로이루어진 문자열을 숫자 포멧 형식에 맞게 변환 하여<br>
	 * 포멧이 적용된 문자열을 반환한다.
	 * @param no - number 문자열
	 * @param formatter - number 포멧 형식
	 * @return String - 포멧 형식으로 변환된 문자열
	 */
	public static String format(String no, String formatter) {
		return format(Double.parseDouble(no), formatter);
	}

	/**
	 * int형 정수를 숫자 포멧 형식에 맞게 변환 하여<br>
	 * 포멧이 적용된 문자열을 반환한다.
	 * @param no - int형 정수
	 * @param formatter - number 포멧 형식
	 * @return String - 포멧 형식으로 변환된 문자열
	 */
	public static String format(int no, String formatter) {
		return format((long) no, formatter);
	}

	/**
	 * float형 실수를 숫자 포멧 형식에 맞게 변환 하여<br>
	 * 포멧이 적용된 문자열을 반환한다.
	 * @param no - float형 실수
	 * @param formatter - number 포멧 형식
	 * @return String - 포멧 형식으로 변환된 문자열
	 */
	public static String format(float no, String formatter) {
		return format((double) no, formatter);
	}

	/**
	 * long형 정수를 숫자 포멧 형식에 맞게 변환 하여<br>
	 * 포멧이 적용된 문자열을 반환한다.
	 * @param no - long형 정수
	 * @param formatter - number 포멧 형식
	 * @return String - 포멧 형식으로 변환된 문자열
	 */
	public static String format(long no, String formatter) {
		DecimalFormat df = new DecimalFormat(formatter);
		return df.format(no);
	}

	/**
	 * double형 실수를 숫자 포멧 형식에 맞게 변환 하여<br>
	 * 포멧이 적용된 문자열을 반환한다.
	 * @param no - double형 실
	 * @param formatter - number 포멧 형식
	 * @return String - 포멧 형식으로 변환된 문자열
	 */
	public static String format(double no, String formatter) {
		DecimalFormat df = new DecimalFormat(formatter);
		return df.format(no);
	}

	/**
	 * 문자열을 특정 구분 문자로 잘라서 String 배열로 반환한다.
	 * @param str - 문자열
	 * @param delim - 구분문자
	 * @param isSkipNull - true :널값무시 , false : null값 포함.
	 * @return String[]
	 */
	public static String[] split(String str, char delim, boolean isSkipNull) {
		if (str == null)
			return null;

		String[] arr = null;
		String strDelim = String.valueOf(delim);

		if (isSkipNull) {
			StringTokenizer st = new StringTokenizer(str, strDelim);
			arr = new String[st.countTokens()];
			for (int i = 0; i < arr.length && st.hasMoreTokens(); i++) {
				arr[i] = st.nextToken();
			}
		} else {
			Vector<Object> vt = new Vector<Object>();
			boolean setNull = str.startsWith(strDelim);
			StringTokenizer st = new StringTokenizer(str, strDelim, true);
			while (st.hasMoreTokens()) {
				String value = st.nextToken();
				if (strDelim.equals(value)) {
					if (setNull)
						vt.add((String) null);
					else
						setNull = true;
				} else {
					vt.add(value);
					setNull = false;
				}
			}

			if (setNull) // if (str.endsWith(strDelim))
				vt.add((String) null);

			if (vt.size() > 0) {
				arr = new String[vt.size()];
				vt.copyInto(arr);
			}
		}

		return arr;
	}

	/**
	 * 문자열을 콤마(',') 구분 문자로 잘라서 String 배열로 반환한다.
	 * @param str - 문자열
	 * @param isSkipNull - true :널값무시 , false : null값 포함.
	 * @return String[]
	 */
	public static String[] split(String str, boolean isSkipNull) {
		return split(str, ',', isSkipNull);
	}

	/**
	 * 문자열을 특정 구분 문자로 잘라서 String 배열로 반환한다.
	 * @param str - 문자열
	 * @param delim - 구분문자
	 * @return String[]
	 */
	public static String[] split(String str, char delim) {
		return split(str, delim, true);
	}

	/**
	 * 문자열을 콤마(',') 구분 문자로 잘라서 String 배열로 반환한다.
	 * @param str - 문자열
	 * @return String[]
	 */
	public static String[] split(String str) {
		return split(str, ',', true);
	}

	/**
	 * String 배열을 입력 받아 배열의 인덱스에 해당하는 문자열에 <br>
	 * 특정 문자(delim)를 연결한 문자열을 반환한다.<br>
	 * ex) String str[]={"aa","bb","cc"};<br>
	 * delim이 콤마(,) 일경우 결과값은 ==> "aa,bb,cc" 문자열이 된다.
	 * @param arr 문자열 배열
	 * @param delim 문자
	 * @param isSkipNull true :널값무시 , false : null값 포함.
	 * @return String
	 */
	public static String join(String[] arr, char delim, boolean isSkipNull) {
		if (arr == null || arr.length == 0)
			return null;

		int intCnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (isSkipNull) {
				if (arr[i] != null) {
					if (intCnt > 0)
						sb.append(delim);
					sb.append(arr[i]);
					intCnt++;
				}
			} else {
				if (i > 0)
					sb.append(delim);
				sb.append(arr[i] == null ? "" : arr[i]);
			}
		}

		return sb.toString();
	}

	/**
	 * String 배열을 입력 받아 배열의 인덱스에 해당하는 문자열에 <br>
	 * 콤마(,)를 연결한 문자열을 반환한다.<br>
	 * ex) String str[]={"aa","bb","cc"};<br>
	 * delim이 콤마(,) 일경우 결과값은 ==> "aa,bb,cc" 문자열이 된다.
	 * @param arr 문자열 배열
	 * @param isSkipNull true :널값무시 , false : null값 포함.
	 * @return String
	 */
	public static String join(String[] arr, boolean isSkipNull) {
		return join(arr, ',', isSkipNull);
	}

	/**
	 * String 배열을 입력 받아 배열의 인덱스에 해당하는 문자열에 <br>
	 * 특정 문자(delim)를 연결한 문자열을 반환한다.<br>
	 * ex) String str[]={"aa","bb","cc"};<br>
	 * delim이 콤마(,) 일경우 결과값은 ==> "aa,bb,cc" 문자열이 된다.
	 * @param arr 문자열 배열
	 * @param delim 문자
	 * @return String
	 */
	public static String join(String[] arr, char delim) {
		return join(arr, delim, true);
	}

	/**
	 * String 배열을 입력 받아 배열의 인덱스에 해당하는 문자열에 <br>
	 * 콤마(,)를 연결한 문자열을 반환한다.<br>
	 * ex) String str[]={"aa","bb","cc"};<br>
	 * delim이 콤마(,) 일경우 결과값은 ==> "aa,bb,cc" 문자열이 된다.
	 * @param arr 문자열 배열
	 * @return String
	 */
	public static String join(String[] arr) {
		return join(arr, ',', true);
	}

	/**
	 * 특정 문자열에서 특정 문자를 제거한 문자열을 반환한다.
	 * @param str - 문자열
	 * @param rmChar - 제거할 문자
	 * @return String
	 */
	public static String removeChar(String str, char rmChar) {
		if (str == null || str.indexOf(rmChar) == -1)
			return str;

		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != rmChar)
				sb.append(arr[i]);
		}

		return sb.toString();
	}

	/**
	 * 특정 문자열에서 특정 문자를 제거한 문자열을 반환한다.
	 * @param str - 문자열
	 * @param rmChar - 제거할 문자 배열
	 * @return String
	 */
	public static String removeChar(String str, char[] rmChar) {
		if (str == null || rmChar == null)
			return str;

		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			boolean isAppend = true;
			for (int k = 0; k < rmChar.length; k++) {
				if (arr[i] == rmChar[k]) {
					isAppend = false;
					break;
				}
			}
			if (isAppend)
				sb.append(arr[i]);
		}

		return sb.toString();
	}
	
	/**
	 * 원본 문자열을 입력 받아 특정 문자열을 찾아서 요청 문자열로 대체하여 <br>
	 * 새로운 문자열로 반환하여 준다.
	 * @param originString -원본문자열
	 * @param srchString -특정 문자열
	 * @param repString -요청문자열
	 * @return String
	 */
	public static String replace(String originString, String srchString, String repString) {
		if (originString == null)
			return null;
		if (originString.equals(""))
			return "";
		if (srchString == null || srchString.equals(""))
			return originString;

		String result = "";
		int i;

		do {
			i = originString.indexOf(srchString);

			if (i != -1) {
				result += originString.substring(0, i);
				result += repString;
				originString = originString.substring(i + srchString.length());
			} else {
				result += originString;
				break;
			}
		} while (i != -1);

		return result;
	}

	public static String removeAcn(String orgAcn) {
		if (orgAcn == null)
			return orgAcn;

		StringBuilder sb = new StringBuilder();
		char[] arr = orgAcn.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] != '-') && (arr[i] != ',') && (arr[i] != '/') && (arr[i] != ')'))
				sb.append(arr[i]);
		}

		return sb.toString();
	}
	


	/**
	 * 원본 문자열을 입력 받아 특정 문자열을 찾아서 요청 문자열로 대체하여 <br>
	 * 새로운 문자열로 반환하여 준다. 단, 특정 문자를 찾음에 있어서 <br>
	 * 대소문자 구별을 하지 않는다.
	 * @param originString -원본문자열
	 * @param srchString -특정 문자열
	 * @param repString -요청문자열
	 * @return String
	 */
	public static String replaceIgnoreCase(String originString, String srchString, String repString) {
		if (originString == null)
			return null;
		if (originString.equals(""))
			return "";
		if (srchString == null || srchString.equals(""))
			return originString;
		String result = "";
		int i;

		do {
			i = originString.toLowerCase().indexOf(srchString.toLowerCase());

			if (i != -1) {
				result += originString.substring(0, i);
				result += repString;
				originString = originString.substring(i + srchString.length());
			} else {
				result += originString;
				break;
			}
		} while (i != -1);

		return result;
	}

	/**
	 * 입력받은 문자열을 왼쪽부터 특정 길이 만큼 잘라서 반환한다.
	 * @param str - 문자열
	 * @param len - 잘라낼 길이
	 * @return String
	 */
	public static String left(String str, int len) {
		return str.substring(0, len);
	}

	/**
	 * 입력받은 문자열을 오른쪽 부터 특정 길이 만큼 잘라서 반환한다.
	 * @param str - 문자열
	 * @param len - 잘라낼 길이
	 * @return String
	 */
	public static String right(String str, int len) {
		return str.substring(str.length() - len);
	}

	/**
	 * 특정 문자열에 대해서 시작문자열 , 끝 문자열을 입력 받아서 시작과 끝사이의<br>
	 * 문자열을 반환한다. <br>
	 * 단, 시작 또는 끝에 해당하는 문자열을 찾지 못할경우 공백("")을 반환.
	 * 
	 * <pre>
	 *                                                      String str = &quot;TbbbbT&quot;;
	 *                                                      getInnerString(str,&quot;T&quot;,&quot;T&quot;)의 결과값 ==&gt; &quot;bbbb&quot; 반환 
	 * </pre>
	 * 
	 * @param str - 문자열
	 * @param start - 시작문자열
	 * @param last - 끝문자열
	 * @return String
	 */
	public static String getInnerString(String str, String start, String last) {
		int pos = str.indexOf(start);
		if (pos >= 0) {
			int pos1 = str.indexOf(last, pos + 1);
			if (pos1 > pos) {
				return str.substring(pos + start.length(), pos1);
			}
		}
		return "";
	}

	/**
	 * 특정 문자열에 대해서 시작문자열 , 끝 문자열을 입력 받아서 시작과 끝사이의<br>
	 * 문자열을 반환한다. 단, <br>
	 * 단, 시작 또는 끝에 해당하는 문자열을 찾음에 있어서 대소문자를 구별하지 않는다.<br>
	 * 시작 또는 끝에 해당하는 문자열을 찾지 못할경우 공백("")을 반환.
	 * 
	 * <pre>
	 *                                                      String str = &quot;TbbbbT&quot;;
	 *                                                      getInnerString(str,&quot;T&quot;,&quot;T&quot;)의 결과값 ==&gt; &quot;bbbb&quot; 반환 
	 * </pre>
	 * 
	 * @param str - 문자열
	 * @param start - 시작문자열
	 * @param last - 끝문자열
	 * @return String
	 */
	public static String getInnerStringIgnoreCase(String str, String start, String last) {
		String str1 = str.toUpperCase();
		int pos = str1.indexOf(start.toUpperCase());
		if (pos >= 0) {
			int pos1 = str1.indexOf(last.toUpperCase(), pos + 1);
			if (pos1 > pos) {
				return str.substring(pos + start.length(), pos1);
			}
		}
		return "";
	}

	/**
	 * 캐리지리턴(CR)과 라인피드(LF)를 반화하여 줄바꿈 문자열을 반환한다.
	 * @return String - \r\n
	 */
	public static String getNewLine() {
		char[] newLine = new char[2];
		newLine[0] = 13;
		newLine[1] = 10;
		return new String(newLine);
	}

	/**
	 * 특정문자열에서 줄바꿈(\r\n)문자열을 공백("")으로 교체한다.
	 * @param str - 문자열
	 * @return String - 줄바꿈 문자가 제거된 문자열.
	 */
	public static String removeNewLine(String str) {
		return Utils.replace(str, getNewLine(), "");
	}

	/**
	 * 
	 * <p>
	 * hex String to byte[]
	 * <p>
	 * @param hex hex String
	 * @return byte[]
	 */
	public static byte[] hexToByteArray(String hex) {
	    if (hex == null || hex.trim().length() == 0) {
	        return " ".getBytes();
	    }
	 
	    byte[] ba = new byte[hex.length() / 2];
	    for (int i = 0; i < ba.length; i++) {
	        ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	    }
	    return ba;
	}
	 
	/**
	 * 
	 * <p>
	 * byte[] to hex String
	 * <p>
	 * @param ba byte[]
	 * @return String hex String
	 */
	public static String byteArrayToHex(byte[] ba) {
	    if (ba == null || ba.length == 0) {
	        return null;
	    }
	 
	    StringBuffer sb = new StringBuffer(ba.length * 2);
	    String hexNumber;
	    for (int x = 0; x < ba.length; x++) {
	        hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
	 
	        sb.append(hexNumber.substring(hexNumber.length() - 2));
	    }
	    return sb.toString();
	}
	
	/**
	 * 
	 * <p>
	 * converToDecimalFromHex
	 * <p>
	 * @param hex hex
	 * @return String Decimal
	 */
	public static String converToDecimalFromHex( String hex )
    {
            String decimal = "";
            hex = hex.trim( );
            for ( int i = 0 ; i < hex.length( ) ; i += 2 )
            {
                    String tmp = hex.substring( i , i + 2 );
                    long val = Long.parseLong( tmp , 16 );
                    decimal += val;
                    decimal += ",";
            }
            return decimal;
    }

    /**
     * 
     * <p>
     * converToHexFromDecimal
     * <p>
     * @param decimal decimal
     * @return String Hex
     */
    public static String converToHexFromDecimal( String decimal )
    {
            String hex = "";
            decimal = decimal.trim();
            for ( int i = 0 ; i < decimal.length() ; i += 4 )
            {
                    String tmp = decimal.substring( i , i + 4 );
                    tmp = Long.toHexString( Long.parseLong( tmp ) );
                    hex += tmp;
                    //hex += ",";
            }
            System.out.println("decimal : "+ decimal + ", hex : "+hex);
            return hex;
    }
    
    /**
     * 
     * <p>
     * HEX String을 포맷팅
     * <p>
     * @param hex HEX String
     * @return String 포맷팅된 HEX 
     */
	public static String getOutPutHexFlet(String hex) {
		
		if(hex == null || hex.length() == 0){
			return "";
		}
		
		int in = 0;
		String outStr = "";
		while (true) {
			
			outStr += setSeqCode(in++);
			for (int i = (in*32-32); i < (in*32); i = i+2) {
				if(hex.length() <= i){
					//마지막줄 나머지채움문자
					outStr += "   ";
				}else{
					outStr += hex.substring(i, i + 2).toUpperCase() + " ";
				}
				if((i+2)%16 == 0){
					//4byte마다 공백
					outStr += "  ";
				}
				
			}
			try {
				if(hex.length() < (in*32)){
					
						outStr += "] : "+ new String(hexToByteArray(hex.substring(in*32-32,hex.length())),"euc-kr")+"\n";
					break;
				}else{
					outStr += "] : "+ new String(hexToByteArray(hex.substring(in*32-32,in*32)),"euc-kr")+"\n";
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return outStr.toString();
		
	}
	
	private static String setSeqCode(int in) {
		String str = String.valueOf(in);
		for (int i = 0; i < 4; i++) {
			if(str.length() <= i){
				str = "0"+str;
			}
		}
		return str + " [  ";
	}
	
	public static int parseHex(String hexString){
		int value = convertHexToDec(hexString.charAt(0));
		for (int i = 1; i < hexString.length(); i++) {
			value = value * 16 + convertHexToDec(hexString.charAt(i));
		}

		return value;
	}

	public static int convertHexToDec(char ch){
		if(ch == 'A'){
			return 10;
		}
		else if(ch == 'B'){
			return 11;
		}
		else if(ch == 'C'){
			return 12;
		}
		else if(ch == 'D'){
			return 13;
		}
		else if(ch == 'E'){
			return 14;
		}
		else if(ch == 'F'){
			return 15;
		}
		else if(ch <= '9' && ch >= '0'){
			return ch - '0';
		}
		else
			throw new NumberFormatException("Wrong character: " + ch);
	}

}
