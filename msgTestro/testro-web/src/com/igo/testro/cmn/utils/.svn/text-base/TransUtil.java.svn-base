package com.igo.testro.cmn.utils;

import java.io.UnsupportedEncodingException;

/**
 * 
 * <p>
 * 프로그램명:TransUtil.java<br/>
 * 설명 : 변환 Util<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class TransUtil {
	
	/**
	 * 
	 * <p>
	 * hex String to byte[]
	 * <p>
	 * @param hex hex String
	 * @return byte[]
	 */
	public static byte[] hexToByteArray(String hex) {
	    
	    hex = hex.trim();
	 
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
	    return sb.toString().toUpperCase();
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
	
    /**
     * 
     * <p>
     * HEX String을 포맷팅 (0000 | 00 00 00 00 | : 1234)
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
					
						outStr += "| "+ new String(hexToByteArray(hex.substring(in*32-32,hex.length())),"euc-kr")+"\n";
					break;
				}else{
					outStr += "| "+ new String(hexToByteArray(hex.substring(in*32-32,in*32)),"euc-kr")+"\n";
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
		return str + " |  ";
	}	
}