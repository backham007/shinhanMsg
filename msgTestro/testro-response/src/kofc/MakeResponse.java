package kofc;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import main.Utils;

public class MakeResponse {
	
	private static MakeResponse makeResponse = new MakeResponse();
	private Connection conn;
	private Connection conn2;
	private Statement stmt;
	private Statement stmt2;

	private static final String DERBY_DB_URL = "jdbc:derby://192.168.0.14:1527/C:/derby/testro_DevDB";
	private static final String ORCLE_DB_URL = "jdbc:oracle:thin:@192.168.0.14:1521:orcl";
	private static final String DB_ID = "TESTRO1";
	private static final String DB_PASSWORD = "igo123";
	private static final String DB_ID2 = "hnd";
	private static final String DB_PASSWORD2 = "hnd";
	
	private static final String charset = "euc-kr";	//인코딩 charset
	private static final String makeString = "RESPONSE_TEXT_DATA ";	//text,hex응답
	private static final String makeNumber = "1234567890";	//number응답
	
	private MakeResponse(){
		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver"); //jdbc derby 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); //jdbc oracle 드라이버 로드
			//conn=DriverManager.getConnection(DERBY_DB_URL,DB_ID,DB_PASSWORD);//DERBY DB 접속
			conn=DriverManager.getConnection(ORCLE_DB_URL,DB_ID,DB_PASSWORD);//ORACLE DB 접속
			conn2=DriverManager.getConnection(ORCLE_DB_URL,DB_ID2,DB_PASSWORD2);//ORACLE DB 접속(정책금융공사 프레임웍)

			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt2=conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();   
		}
	}
	
	public static MakeResponse getInstance(){
		try {
			if(makeResponse.conn.isClosed() || makeResponse.conn2.isClosed()){
				makeResponse = new MakeResponse();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return makeResponse;
	}
	
	private ResultSet executeQuery(String sql){
		try {
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ResultSet executeQuery2(String sql){
		try {
			ResultSet rs = stmt2.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] getResponse(String tranCd){
		byte[] msg = new byte[0];
		
		if(tranCd == null || "".equals(tranCd)){
			System.out.println("조회할 거래코드가 없습니다");
			return null;
		}
		
		Random random = new Random();
		int randomInt = random.nextInt(3);
		String TR_PRCS_RSLT_DSCD = "";
		if(randomInt == 0){
			TR_PRCS_RSLT_DSCD = "0";
		} else {
			TR_PRCS_RSLT_DSCD = "1";
		}
		System.out.println("정상거래구분코드 : "+TR_PRCS_RSLT_DSCD);
		String sql =   "SELECT    FLDNAME                                                           " +
						"        ,FLDDIV                                                            " +
						"		 ,TRANNO                                                            " +
						"		 ,FLDTYPE                                                           " +
						"		 ,CASE WHEN FLDNAME IN (SELECT RPTNAME                              " +
						"		 					 FROM MNGLOUT02                                 " +
						"						     WHERE CHNLDSTCD = '01'                         " +
						"						       AND TRANCD = TRANCD) THEN '03'               " +
						"			  ELSE FLDATTRIB END FLDATTRIB                                  " +
						"		 ,TSCSFLDSIZE                                                       " +
						"FROM MNGLOUT02                                                             " +
						"WHERE CHNLDSTCD = '01'                                                     " +
						"  AND TRANCD = 'KOFCHEAD'                                                  " +
						"  AND (FLDIO = 'O' OR FLDIO = 'B')                                         " +
						"ORDER BY FLDDIV, TRANNO                                                    ";
		
		String sql2 = null;
		if(randomInt == 0){	//정상
			sql2 =  "SELECT   FLDNAME                                                           " +
					"        ,FLDDIV                                                            " +
					"		 ,TRANNO                                                            " +
					"		 ,FLDTYPE                                                           " +
					"		 ,CASE WHEN FLDNAME IN (SELECT RPTNAME                              " +
					"		 					 FROM MNGLOUT02_V                               " +
					"						     WHERE CHNLDSTCD = '01'                         " +
					"						       AND TRANCD = TRANCD) THEN '03'               " +
					"			  ELSE FLDATTRIB END FLDATTRIB                                  " +
					"		 ,TSCSFLDSIZE                                                       " +
					"FROM MNGLOUT02_V                                                           " +
					"WHERE CHNLDSTCD = '01'                                                     " +
					"  AND TRANCD = '"+tranCd.trim()+"'                                         " +
					"  AND (FLDIO = 'O' OR FLDIO = 'B')                                         " +
					"ORDER BY FLDDIV, TRANNO                                                    ";
		} else {	//오류
			sql2 =  "SELECT   FLDNAME                                                           " +
				"        ,FLDDIV                                                            " +
				"		 ,TRANNO                                                            " +
				"		 ,FLDTYPE                                                           " +
				"		 ,CASE WHEN FLDNAME IN (SELECT RPTNAME                              " +
				"		 					 FROM MNGLOUT02                                 " +
				"						     WHERE CHNLDSTCD = '01'                         " +
				"						       AND TRANCD = TRANCD) THEN '03'               " +
				"			  ELSE FLDATTRIB END FLDATTRIB                                  " +
				"		 ,TSCSFLDSIZE                                                       " +
				"FROM MNGLOUT02                                                             " +
				"WHERE CHNLDSTCD = '01'                                                     " +
				"  AND TRANCD = 'ERRPRIVT'                                                  " +
				"  AND (FLDIO = 'O' OR FLDIO = 'B')                                         " +
				"ORDER BY FLDDIV, TRANNO                                                    ";
		}
		
		try {
			ResultSet rs = executeQuery(sql);	//헤더부
			
			String lengthFldType = null;	//전문길이 필드의 속성(hex,text,num)
			int lengthFldSize = 0;	//전문길이 필드의 Size
			
			//헤더부
			while(rs.next()){
				String fldName = rs.getString("FLDNAME");
				String fldType = rs.getString("FLDTYPE");
				String fldAttrib = rs.getString("FLDATTRIB");
				String tscsFldSize = rs.getString("TSCSFLDSIZE");
				byte[] fldData = null;
				
				if(rs.isFirst() && "01".equals(rs.getString("FLDDIV"))){	//헤더부 첫번째 필드일경우 필드속성세팅
					lengthFldType = fldType;
					lengthFldSize = Integer.parseInt(tscsFldSize);
				}
				
				if("TR_PRCS_RSLT_DSCD".equals(fldName)){	//정책금융공사 결과구분필드
					fldData = TR_PRCS_RSLT_DSCD.getBytes(charset);
				} else if("03".equals(fldAttrib)){
					
					if("hex".equals(fldType)){
						fldData = Utils.hexToByteArray(Utils.lpad(1, Integer.parseInt(tscsFldSize) * 2, '0'));
					} else {
						fldData = (Utils.lpad(1, Integer.parseInt(tscsFldSize), '0').getBytes(charset));
					}
				} else {
					
					if("hex".equals(fldType)){
						String data = "";
						for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
							data = data + makeString.charAt(i % makeString.length()); 
						}
						fldData = data.getBytes(charset);
					} else if("text".equals(fldType)){
						String data = "";
						for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
							data = data + makeString.charAt(i % makeString.length()); 
						}
						fldData = data.getBytes(charset);
					} else if("num".equals(fldType)){
						String data = "";
						for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
							data = data + makeNumber.charAt(i % makeNumber.length()); 
						}
						fldData = data.getBytes(charset);
					} else {
						String data = "";
						for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
							data = data + makeString.charAt(i % makeString.length()); 
						}
						fldData = data.getBytes(charset);
					}
				}
				
				byte[] newByte = new byte[msg.length + fldData.length];
				System.arraycopy(msg, 0, newByte, 0, msg.length);
				System.arraycopy(fldData, 0, newByte, msg.length, fldData.length);
				
				msg = newByte;
				
				//System.out.println("["+fldName+"] : " + new String(fldData,charset));
			}
			
			ResultSet rs2 = null;
			if(randomInt == 0){	//정상
				rs2 = executeQuery2(sql2);	//개별부
			} else if(randomInt == 1) {	//오류(오류부를 넘겨주는 경우)
				rs2 = executeQuery(sql2);	//개별부
			}
			
			//개별부
			if(rs2 != null){
				while(rs2.next()){
					String fldName = rs2.getString("FLDNAME");
					String fldType = rs2.getString("FLDTYPE");
					String fldAttrib = rs2.getString("FLDATTRIB");
					String tscsFldSize = rs2.getString("TSCSFLDSIZE");
					byte[] fldData = null;
					
					if("03".equals(fldAttrib)){
						
						if("hex".equals(fldType)){
							fldData = Utils.hexToByteArray(Utils.lpad(1, Integer.parseInt(tscsFldSize) * 2, '0'));
						} else {
							fldData = (Utils.lpad(1, Integer.parseInt(tscsFldSize), '0').getBytes(charset));
						}
					} else {
						
						if("hex".equals(fldType)){
							String data = "";
							for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
								data = data + makeString.charAt(i % makeString.length()); 
							}
							fldData = data.getBytes(charset);
						} else if("text".equals(fldType)){
							String data = "";
							for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
								data = data + makeString.charAt(i % makeString.length()); 
							}
							fldData = data.getBytes(charset);
						} else if("num".equals(fldType)){
							String data = "";
							for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
								data = data + makeNumber.charAt(i % makeNumber.length()); 
							}
							fldData = data.getBytes(charset);
						} else {
							String data = "";
							for(int i = 0 ; i < Integer.parseInt(tscsFldSize) ; i++){
								data = data + makeString.charAt(i % makeString.length()); 
							}
							fldData = data.getBytes(charset);
						}
					}
					
					byte[] newByte = new byte[msg.length + fldData.length];
					System.arraycopy(msg, 0, newByte, 0, msg.length);
					System.arraycopy(fldData, 0, newByte, msg.length, fldData.length);
					
					msg = newByte;
					
					//System.out.println("["+fldName+"] : " + new String(fldData,charset));
				}
			}
			
			//종료부
			byte[] fldData = "@@".getBytes(charset);
			byte[] newByte = new byte[msg.length + fldData.length];
			System.arraycopy(msg, 0, newByte, 0, msg.length);
			System.arraycopy(fldData, 0, newByte, msg.length, fldData.length);
			
			msg = newByte;
			
			//길이필드 세팅(처음필드)
			if(lengthFldType != null){
				int msgLength = msg.length;
				
				if("hex".equals(lengthFldType)){	//길이필드가 hex일 경우
					if(msg.length >= lengthFldSize){
						String msgLengthString = Utils.lpad(Integer.toHexString(msgLength), lengthFldSize * 2, '0');
						byte[] msgLengthByte = Utils.hexToByteArray(msgLengthString);
						System.arraycopy(msgLengthByte, 0, msg, 0, lengthFldSize);
						
					}
				} else {	//길이필드가 text or num일 경우
					if(msg.length >= lengthFldSize){
						String msgLengthString = Utils.lpad(msgLength, lengthFldSize, '0');
						System.arraycopy(msgLengthString.getBytes(charset), 0, msg, 0, lengthFldSize);
						
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}
}
