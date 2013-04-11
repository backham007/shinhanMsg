package com.igo.testro.msg.tsmng.biz;

import java.util.*;

/**
 * TDF 의 입력 data parsing용 Logic 집단.<br>
 * 각각의 Logic들의 목록은 다음과 같다.<br>
 * ==================================================<br>
 * <br>
 * 001 : <B style="color:#FF0000">CheckDigit</B><br>
 * : 입력된 문자열이 숫자인지 체크한다.<br>

 * <br>
 * @author Lushiris. morius.Ruxia.
 * @version 1.1c
 * @since JDK 1.3.0 JSDK 2.2
 */
public class Filtering {

	/**
	 * String Buffer
	 */
	private StringBuffer sBuffer;

	/**
	 * Temp Vector
	 */
	private Vector<Byte> fullVector;

	/**
	 * Conversion Mapping Table
	 */
	private HashMap<String, Integer> nameTable;

	/**
	 * data를 Conversion할 준비를 한다.
	 * @since jgate 1.0
	 */
	public Filtering() {
		this.nameTable = new HashMap<String, Integer>();
		this.sBuffer = new StringBuffer();
		this.fullVector = new Vector<Byte>();
		initNameTable();
	}

	/**
	 * data를 Conversion할 준비를 한다.
	 * @param header conversion function name.
	 * @param filedName conversion할 data의 field 이름.
	 * @param reStr conversion할 data.
	 * @param llength field의 max length.
	 * @return 변환된 data.
	 * @since jgate 1.1c
	 */
	public String convertData(String header, String reStr) {

		int i, idx; byte[] half, newBytes; String key; StringTokenizer st;

		fullVector.clear();
		sBuffer.delete(0, sBuffer.length()).append(reStr);

		if((idx = header.indexOf('_')) > 0) key = header.substring(0, idx +1);
		else                                key = header;
		switch(((Integer)nameTable.get(key)).intValue()) {
			case 0 : //DelLeft
				try {
					idx = Integer.valueOf((String) header.subSequence(8, header.length()));
					if(idx < reStr.length()){
						reStr = reStr.substring(idx);
					}else{
						reStr = "";
					}
				} catch (Exception e) {
					reStr = "";
				}
				break;
			case 1 : //DelRight
				try {
					idx = Integer.valueOf((String) header.subSequence(9, header.length()));
					if(idx < reStr.length()){
						reStr = (String) reStr.subSequence(0,( reStr.length()- idx));
					}else{
						reStr = "";
					}
				} catch (Exception e) {
					reStr = "";
				}
				break;
			case 2 : //DelAll
				try {
					String factor = (String) header.subSequence(7, header.length());
					String outData="";
					for (int j2 = 0; j2 < reStr.length(); j2++) {
						if(reStr.length() >= (j2+factor.length())){
							if(factor.equals(reStr.subSequence(j2, j2+factor.length()))){
								j2= j2+factor.length() - 1;
							}else{
								outData = outData + (String) reStr.subSequence(j2, j2+1);
							}
						}else{
							outData = outData + (String) reStr.subSequence(j2, j2+1);
							break;
						}
					}
					reStr = outData;
				} catch (Exception e) {
					reStr = "";
				}
				break;
			case 3 : //FillLeft
				try {
					String factor = (String) header.subSequence(9, header.length());
					reStr = factor + reStr;
				} catch (Exception e) {
					reStr = "";
				}
				break;
			case 4 : //FillRight
				try {
					String factor = (String) header.subSequence(10, header.length());
					reStr = reStr + factor;
				} catch (Exception e) {
					reStr = "";
				}
				break;
			case 5 : //InsStr InsStr_X2_by_2_2_2;  000000 --> 00X200X200"
				idx = header.indexOf("_by_");
				if(idx > 0) {
					reStr = insertStr(reStr, header.substring(7, idx), header.substring(idx +4));
				} else {
					reStr = "";
				}
				break;
			case 6 : //Replace_aa_to_DD  aabbccaa --> DDbbccDD"
				st = new StringTokenizer(header.substring(8), "_");

				String orgStr = st.nextToken();
				st.nextToken();
				String convStr = st.nextToken();
				reStr = replace(reStr, orgStr, convStr);
				break;
			case 7 : //ToUpper
				reStr = reStr.toUpperCase();
				break;
			case 8 : //ToLower
				reStr = reStr.toLowerCase();
				break;
			case 9 : //HalfToFull
				half = reStr.getBytes();

				for(i = 0 ; i < half.length ; i++ ) {
					if((new Byte(half[i])).intValue() < 0) {
						fullVector.addElement(new Byte(half[i]));
					} else {
						if ((new Byte(half[i])).intValue() == 32) {
							fullVector.addElement(new Byte(-95 +""));
							fullVector.addElement(new Byte(-95 +""));
						} else {
//							byte[] newChar = new byte[2];
							fullVector.addElement(new Byte(-93 +""));
							fullVector.addElement(new Byte(((new Byte(half[i])).intValue() -128) +""));
						}
					}
				}
				newBytes = new byte[fullVector.size()];
				for(i = 0; i < newBytes.length; i++) {
					newBytes[i] = ((Byte)fullVector.elementAt(i)).byteValue();
				}
				reStr = new String(newBytes);
				fullVector.clear();
				break;
			default :
				reStr = "";
		}
		
		return reStr;
	}

	/**
	 * 원본 문자열을 지정한 형태의 포맷으로 문자열을 삽입시킨다.<br>
	 * 원본 문자열이 모두 Space일 경우, Space를 넘김<br>
	 * ex) 포맷 : 3_2_3 원본 문자열 : 12345678 삽입문자열 : / ==> 123/45/678<br>
	 * @param orgStr 원본 문자열.
	 * @param insStr 삽입될 문자열.
	 * @param format 삽입 형식.
	 * @return 변환된 문자열.
	 * @since jgate 1.1c
	 */
	protected String insertStr(String orgStr, String insStr, String format) {
		String convStr = "";
		StringTokenizer st = new StringTokenizer(format, "_");

		// 모두 Space일 경우 원본 넘김
		if(orgStr.trim().length() == 0) return orgStr;

		int i = 0;
		try {
			while(st.hasMoreTokens()) {
				int j = Integer.parseInt(st.nextToken());
				convStr += orgStr.substring(i, i+j);
				i += j;
				if (st.hasMoreTokens()) convStr += insStr;
			}
		} catch (Exception e) {
			convStr = orgStr;
		}
		return convStr;
	}

	/**
	 * 원본 문자열의 특정 부분을 replace한다.
	 * ex1) 원본 문자열 : 1234 삽입문자열 : 백만원   ==> 1234백만원
	 * ex2) 원본 문자열 : 1234 삽입문자열 : _백만원  ==> 1234 백만원
	 * @param reStr 결과 문자열.
	 * @param orgStr 원본 문자열.
	 * @param convCode replace할 문자열.
	 * @return 변환된 문자열.
	 * @since jgate 1.1c
	 */
	protected String replace(String reStr, String orgStr, String convStr) {
		orgStr = orgStr.replace('$', ' ');
		while ( reStr.indexOf(orgStr) >=0 ) {
			reStr = reStr.substring(0, reStr.indexOf(orgStr))
					+ convStr
					+ reStr.substring(reStr.indexOf(orgStr) + orgStr.length());
		}

		return reStr;
	}

	/**
	 * Conversion function name을 table화 한다.
	 * @since jgate 1.1c
	 */
	private void initNameTable() {
		
		nameTable.put("DelLeft_",      new Integer(0));
		nameTable.put("DelRight_",      new Integer(1));
		nameTable.put("DelAll_",      new Integer(2));
		nameTable.put("FillLeft_",      new Integer(3));
		nameTable.put("FillRight_",      new Integer(4));
		nameTable.put("InsStr_",      new Integer(5));
		nameTable.put("Replace_",      new Integer(6));
		nameTable.put("ToUpper",      new Integer(7));
		nameTable.put("ToLower",      new Integer(8));
		nameTable.put("HalfToFull",      new Integer(9));
	}
}

