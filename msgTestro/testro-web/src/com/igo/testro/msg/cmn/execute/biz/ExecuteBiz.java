package com.igo.testro.msg.cmn.execute.biz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import tmax.webt.WebtBuffer;
import tmax.webt.WebtConnection;
import tmax.webt.WebtRemoteService;
import tmax.webt.WebtSystem;

import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.cmn.utils.StringUtil;
import com.igo.testro.cmn.utils.TransUtil;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.execute.dto.ExecuteDto;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.preference.TestroPreference;


/**
 * 
 * <p>
 * 프로그램명:executeBiz.java<br/>
 * 설명 : 전문테스트실행 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class ExecuteBiz implements IExecuteBiz {
	
	@Autowired
	private ILayoutBiz layoutBiz;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();	//logger
	
	/**
	 * 
	 * <p>
	 * 테스트실행
	 * <p>
	 * <p>입력된 전문DTO를 Byte배열로 변환한다
	 * <p>변환된 Byte를 송수신한다
	 * <p>수신된 Byte를 DTO로 파싱하여 리턴한다
	 *  
	 * @param connSevrDstcd 접속서버구분코드 
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd	거래코드
	 * @param inputDto	입력전문Dto
	 * @return ExecuteDto 테스트실행Dto
	 */
	public ExecuteDto mciExecute(String connSevrDstcd, String chnlDstcd, String tranCd, TestDataDto inputDto){
		
		ExecuteDto executeDto = new ExecuteDto();
		executeDto.setConnSevrDstcd(connSevrDstcd);
		executeDto.setChnlDstcd(chnlDstcd);
		executeDto.setTranCd(tranCd);
		executeDto.setInputDto(inputDto);
		
		long startTime = Calendar.getInstance().getTimeInMillis();	//실행시작시각 얻기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//Date Format
		executeDto.setStartTime(sdf.format(new Date(startTime)));	//실행시작시각
		
		try {
			//입력전문 Btye생성
			LayoutDto inputLayoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "I");	//입력전문레이아웃조회
			executeDto.setInputBytes(parseDtoToBytes(inputDto, inputLayoutDto));
		} catch(Exception e){
			if (logger. isDebugEnabled()) logger.error("", e);
			executeDto.setRsultSucssYn("N");	//송수신실패
			executeDto.setRsultMsg("입력 전문 파싱 오류");//에러 메시지
			
			long endTime = Calendar.getInstance().getTimeInMillis();	//실행종료시각 얻기
			executeDto.setEndTime(sdf.format(new Date(endTime)));	//실행종료시각
			executeDto.setElapsedTime(String.valueOf(endTime - startTime));	//경과시간

			//로그
			if (logger. isDebugEnabled()) logger.debug("실행결과 : "+executeDto.getRsultMsg());
			
			return executeDto;
		}
		
		try{
			
			LayoutDto outputLayoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "O");	//출력전문레이아웃조회
			
			if(outputLayoutDto.getHeaderList().size() > 0){	//전문길이 필드의 길이와 속성을 얻는다
				executeDto.setLengthFldSize(outputLayoutDto.getHeaderList().get(0).getTscsFldSize());
				executeDto.setLengthFldType(outputLayoutDto.getHeaderList().get(0).getFldType());
			}
		
			//전문 송수신
			executeDto = tranMessage(executeDto);
			
			//출력전문 Dto파싱
			executeDto.setOutputDto(parseBytesToDto(executeDto.getOutputBytes(), outputLayoutDto));	//byte[] -> Dto
		} catch(Exception e){
			if (logger. isDebugEnabled()) logger.error("", e);
			executeDto.setRsultSucssYn("N");	//송수신실패
			executeDto.setRsultMsg(e.getMessage());//에러 메시지
			
			long endTime = Calendar.getInstance().getTimeInMillis();	//실행종료시각 얻기
			executeDto.setEndTime(sdf.format(new Date(endTime)));	//실행종료시각
			executeDto.setElapsedTime(String.valueOf(endTime - startTime));	//경과시간

			//로그
			if (logger. isDebugEnabled()) logger.debug("실행결과 : "+executeDto.getRsultMsg());
			
			return executeDto;
		}
		
		long endTime = Calendar.getInstance().getTimeInMillis();	//실행종료시각 얻기
		executeDto.setEndTime(sdf.format(new Date(endTime)));	//실행종료시각
		executeDto.setElapsedTime(String.valueOf(endTime - startTime));	//경과시간

		executeDto.setRsultSucssYn("Y");	//송수신성공
		
		//로그
		if (logger. isDebugEnabled()) logger.debug("실행결과 : 송수신성공");
		
		return executeDto;
	}
	
	/**
	 * 
	 * <p>
	 * TestDataDto -> byte[] 생성
	 * <p>
	 * <p>입력된 Dto를 순회하며 필드이름으로 매치하여 필드 레이아웃 위치를 찾는다
	 * <p>Dto의 데이터를 길이를 맞추어 Byte로 변환하며 Byte배열에 추가한다
	 * <p>전문길이필드(첫번째필드)에 전문 총길이를 계산하여 세팅한다 
	 * 
	 * @param testDataDto 테스트데이터DTO
	 * @param layoutDto	레이아웃DTO
	 * @return byte[] 전문Byte 
	 * @throws UnsupportedEncodingException 
	 * @throws NumberFormatException 
	 */
	private byte[] parseDtoToBytes(TestDataDto testDataDto, LayoutDto layoutDto) throws Exception{
		byte[] msg = new byte[0];
		
		if(layoutDto == null){
			throw new Exception("전문 레이아웃 미정의");
		}
		
		//헤더부
		for(TestDataDetailDto testDataDetailDto : testDataDto.getHeaderList()){
			
			if("@SYSDATE".equals(testDataDetailDto.getTsdataFldData())){
				testDataDetailDto.setTsdataFldData(DateUtil.getDateString().substring(0, 8));
			}
			
			LayoutDetailDto layoutDetailDto = null;
			//해당필드와 매치되는 레이아웃정보를 찾는다
			for(LayoutDetailDto layoutDetailDto2 : layoutDto.getHeaderList()){
				if(testDataDetailDto.getTsdataFldName().equals(layoutDetailDto2.getFldName()) &&
						(StringUtil.isEmptyString(testDataDetailDto.getRptName()) == StringUtil.isEmptyString(layoutDetailDto2.getRptName()))){
					layoutDetailDto = layoutDetailDto2;
					break;
				}
			}
			
			//String -> byte배열로 변환
			byte[] fldData = getByteData(testDataDetailDto.getTsdataFldData(), layoutDetailDto.getFldType(), layoutDetailDto.getTscsFldSize(), layoutDetailDto.getRanType(), layoutDetailDto.getFillData());
			if("hex".equals(layoutDetailDto.getFldType())){
				testDataDetailDto.setTsdataFldData(TransUtil.byteArrayToHex(fldData));
			} else {
				testDataDetailDto.setTsdataFldData(new String(fldData,"euc-kr"));
			}
			
			//기존바이트에 추가
			byte[] newBytes = new byte[msg.length + fldData.length];
			System.arraycopy(msg, 0, newBytes, 0, msg.length);
			System.arraycopy(fldData, 0, newBytes, msg.length, fldData.length);
			msg = newBytes;
		}
		
		//개별부
		for(TestDataDetailDto testDataDetailDto : testDataDto.getInviList()){
			
			if("@SYSDATE".equals(testDataDetailDto.getTsdataFldData())){
				testDataDetailDto.setTsdataFldData(DateUtil.getDateString().substring(0, 8));
			}
			
			LayoutDetailDto layoutDetailDto = null;
			//해당필드와 매치되는 레이아웃정보를 찾는다
			for(LayoutDetailDto layoutDetailDto2 : layoutDto.getInviList()){
				if(testDataDetailDto.getTsdataFldName().equals(layoutDetailDto2.getFldName()) &&
						(StringUtil.isEmptyString(testDataDetailDto.getRptName()) == StringUtil.isEmptyString(layoutDetailDto2.getRptName()))){
					layoutDetailDto = layoutDetailDto2;
					break;
				}
			}
			
			//String -> byte배열로 변환
			byte[] fldData = getByteData(testDataDetailDto.getTsdataFldData(), layoutDetailDto.getFldType(), layoutDetailDto.getTscsFldSize(), layoutDetailDto.getRanType(), layoutDetailDto.getFillData());
			if("hex".equals(layoutDetailDto.getFldType())){
				testDataDetailDto.setTsdataFldData(TransUtil.byteArrayToHex(fldData));
			} else {
				testDataDetailDto.setTsdataFldData(new String(fldData,"euc-kr"));
			}
			
			//기존바이트에 추가
			byte[] newBytes = new byte[msg.length + fldData.length];
			System.arraycopy(msg, 0, newBytes, 0, msg.length);
			System.arraycopy(fldData, 0, newBytes, msg.length, fldData.length);
			msg = newBytes;
		}
		
		//전문길이필드 세팅(첫번째 필드)
		if(testDataDto.getHeaderList().size() > 0){	//헤더부가 존재할경우
			
			TestDataDetailDto testDataDetailDto = testDataDto.getHeaderList().get(0);	//전문길이필드(헤더부 첫번째필드의 정보)
			int lengthFldSize = Integer.parseInt(testDataDetailDto.getTscsFldSizeCnt());	//전문길이필드 Size
			int msgLength = msg.length - lengthFldSize;	//전문길이 = 전체길이 - 전문길이필드Size
			
			if("hex".equals(testDataDetailDto.getTscsFldType())){	//길이필드가 hex일 경우
				String msgLengthString = StringUtil.lpad(Integer.toHexString(msgLength), lengthFldSize * 2, '0');
				byte[] msgLengthByte = TransUtil.hexToByteArray(msgLengthString);
				System.arraycopy(msgLengthByte, 0, msg, 0, lengthFldSize);
				
				testDataDetailDto.setTsdataFldData(msgLengthString);
			} else {	//길이필드가 text or num일 경우
				String msgLengthString = StringUtil.lpad(msgLength, lengthFldSize, '0');
				System.arraycopy(msgLengthString.getBytes("euc-kr"), 0, msg, 0, lengthFldSize);
				
				testDataDetailDto.setTsdataFldData(msgLengthString);
			}
		}
		
		return msg;
	}
	
	/**
	 *  
	 * <p>
	 * 필드에 길이만큼 데이터를 채워준다
	 * <p>
	 * <p>입력된값이 필드길이보다 클경우 필드길이만큼 잘라 리턴한다
	 * <p>입력된값이 필드길이보다 작을경우 채움값을 채워 리턴한다
	 * <p>변환방식은 필드타입(hex,text,num)에 따라 다르다
	 * 
	 * @param tsdataFldData 필드데이터
	 * @param fldType 필드타입
	 * @param tscsFldSize 필드사이즈
	 * @param ranType 정렬타입
	 * @param fillData 빈값데이터
	 * @return byte[] 필드Byte
	 * @throws UnsupportedEncodingException 
	 * @throws NumberFormatException 
	 */
	private byte[] getByteData(String tsdataFldData, String fldType, String tscsFldSize, String ranType, String fillData) throws NumberFormatException, UnsupportedEncodingException{
		
		if(tscsFldSize.indexOf(".") != -1){
			tscsFldSize = tscsFldSize.split("\\.")[0];		//필드 길이
		}
		
		byte[] returnBytes = new byte[Integer.parseInt(tscsFldSize)];
		
		if(tsdataFldData == null){
			tsdataFldData = "";
		}
		
		if("hex".equals(fldType)){	//hex String
			
			if(fillData == null || "".equals(fillData)){	//빈값데이터가 없을시 기본값
				fillData = " ";
			}
			
			int fillSize = Integer.parseInt(tscsFldSize) - TransUtil.hexToByteArray(tsdataFldData).length;

			//입력된값이 필드사이즈보다 클때
			if(fillSize < 0){
				System.arraycopy(TransUtil.hexToByteArray(tsdataFldData), 0, returnBytes, 0, Integer.parseInt(tscsFldSize));
				return returnBytes;
			}
			
			for(int i = 0 ; i < fillSize ; ){
				if("L".equals(ranType)){
					if(fillSize - i >= fillData.getBytes("euc-kr").length){
						tsdataFldData = tsdataFldData + TransUtil.byteArrayToHex(fillData.getBytes("euc-kr"));
						i += fillData.getBytes("euc-kr").length;
					} else {
						tsdataFldData = tsdataFldData + "00";	//남는부분 0x00으로 채움
						i += TransUtil.hexToByteArray("00").length;
					}
				} else if("R".equals(ranType)){
					if(fillSize - i >= fillData.getBytes("euc-kr").length){
						tsdataFldData = TransUtil.byteArrayToHex(fillData.getBytes("euc-kr")) + tsdataFldData;
						i += fillData.getBytes("euc-kr").length;
					} else {
						tsdataFldData = "00" + tsdataFldData;	//남는부분 0x00으로 채움
						i += TransUtil.hexToByteArray("00").length;
					}
				}
			}
			
			/*** filldata를 hex값으로 입력하였을경우
			if(fillData == null || "".equals(fillData)){	//빈값데이터가 없을시 기본값
				fillData = "00";
			}
			
			int fillSize = Integer.parseInt(tscsFldSize) - TransUtil.hexToByteArray(tsdataFldData).length;
			
			for(int i = 0 ; i < fillSize ; ){
				if("L".equals(ranType)){
					if(fillSize - i >= TransUtil.hexToByteArray(fillData).length){
						tsdataFldData = tsdataFldData + fillData;
						i += TransUtil.hexToByteArray(fillData).length;
					} else {
						tsdataFldData = tsdataFldData + "00";	//남는부분 0x00으로 채움
						i += TransUtil.hexToByteArray("00").length;
					}
				} else if("R".equals(ranType)){
					if(fillSize - i >= TransUtil.hexToByteArray(fillData).length){
						tsdataFldData = fillData + tsdataFldData;
						i += TransUtil.hexToByteArray(fillData).length;
					} else {
						tsdataFldData = "00" + tsdataFldData;	//남는부분 0x00으로 채움
						i += TransUtil.hexToByteArray("00").length;
					}
				}
			}*///
			
			returnBytes = TransUtil.hexToByteArray(tsdataFldData);
			
		} else if("num".equals(fldType)){	//num
			
			if(fillData == null || "".equals(fillData)){	//빈값데이터가 없을시 기본값
				fillData = "0";
			}
			
			int fillSize = Integer.parseInt(tscsFldSize) - tsdataFldData.getBytes("euc-kr").length;
			
			//입력된값이 필드사이즈보다 클때
			if(fillSize < 0){
				System.arraycopy(tsdataFldData.getBytes("euc-kr"), 0, returnBytes, 0, Integer.parseInt(tscsFldSize));
				return returnBytes;
			}
			
			for(int i = 0 ; i < fillSize ; ){
				if("L".equals(ranType)){
					if(fillSize - i >= fillData.getBytes("euc-kr").length){
						tsdataFldData = tsdataFldData + fillData;
						i += fillData.getBytes("euc-kr").length;
					} else {
						tsdataFldData = tsdataFldData + "0";	//남는부분 0으로 채움
						i += "0".getBytes("euc-kr").length;
					}
				} else if("R".equals(ranType)){
					if(fillSize - i >= fillData.getBytes("euc-kr").length){
						tsdataFldData = fillData + tsdataFldData;
						i += fillData.getBytes("euc-kr").length;
					} else {
						tsdataFldData = "0" + tsdataFldData;	//남는부분 0으로 채움
						i += "0".getBytes("euc-kr").length;
					}
				}
			}
			
			returnBytes = tsdataFldData.getBytes("euc-kr"); 
		}  else {	//text or etc
			
			if(fillData == null || "".equals(fillData)){	//빈값데이터가 없을시 기본값
				fillData = " ";
			}
			
			int fillSize = Integer.parseInt(tscsFldSize) - tsdataFldData.getBytes("euc-kr").length;
			
			//입력된값이 필드사이즈보다 클때
			if(fillSize < 0){
				System.arraycopy(tsdataFldData.getBytes("euc-kr"), 0, returnBytes, 0, Integer.parseInt(tscsFldSize));
				return returnBytes;
			}
			
			for(int i = 0 ; i < fillSize ; ){
				if("L".equals(ranType)){
					if(fillSize - i >= fillData.getBytes("euc-kr").length){
						tsdataFldData = tsdataFldData + fillData;
						i += fillData.getBytes("euc-kr").length;
					} else {
						tsdataFldData = tsdataFldData + " ";	//남는부분 공백으로 채움
						i += " ".getBytes("euc-kr").length;
					}
				} else if("R".equals(ranType)){
					if(fillSize - i >= fillData.getBytes("euc-kr").length){
						tsdataFldData = fillData + tsdataFldData;
						i += fillData.getBytes("euc-kr").length;
					} else {
						tsdataFldData = " " + tsdataFldData;	//남는부분 공백으로 채움
						i += " ".getBytes("euc-kr").length;
					}
				}
			}
			
			returnBytes = tsdataFldData.getBytes("euc-kr");
			
		}
		
		return returnBytes;
	}
	
	/**
	 * 
	 * <p>
	 * byte[] -> TestDataDto 생성
	 * <p>
	 * <p>레이아웃헤더부와 개별부를 순회하며 Byte를 Dto로 파싱한다
	 * <p>일반 필드일 경우 필드의 길이만큼 Byte를 데이터로 변환하여 Dto에 추가한다
	 * <p>반복회차 필드일 경우(필드속성이 03) 반복부전체회차필드명에 RPT0부터 순차적으로 별명을 붙인다
	 * <p>반복부 필드일 경우 반복회차필드를 찾아 반복횟수만큼 파싱한다
	 * <p>반복부 필드의 반복부명에는 반복회차필드의 반복부전체회차필드명을 세팅한다
	 *  
	 * @param msgBytes 전문Byte
	 * @param layoutDto 레이아웃DTO
	 * @return TestDataDto 테스트데이터DTO
	 * @throws Exception 
	 */
	private TestDataDto parseBytesToDto(byte[] msgBytes, LayoutDto layoutDto) throws Exception{
				
		TestDataDto testDataDto = new TestDataDto();
		
		//byte배열 파싱위치
		int bytePos = 0;
		//테스트데이터일련번호
		int tsdataNO = 0;
		//반복부전체회차필드번호
		int rptCntNo = 0;
		//거래결과성공여부
		String rsultSucssYn = "";
		
		///////////////////////////////////////////헤더부////////////////////////////////////////////////
		List<TestDataDetailDto> headerList = new ArrayList<TestDataDetailDto>();
		testDataDto.setHeaderList(headerList);
		
		for(int i = 0 ; i < layoutDto.getHeaderList().size() ; i++){
			
			LayoutDetailDto layoutDetailDto = layoutDto.getHeaderList().get(i);
			
			//일반필드일 경우
			if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){
				
				//전문에서 필드길이 만큼 바이트를 얻는다
				byte[] fldByte = null;
				
				//파싱중인 전문(bytes)의 길이가 종료부보다 짧을경우  멈춘다
				if(msgBytes.length - bytePos <= 2){
					return testDataDto;
				}
				
				//필드사이즈 소숫점제거
				String tscsFldSize = null;
				if(layoutDetailDto.getTscsFldSize().indexOf(".") != -1){
					tscsFldSize = layoutDetailDto.getTscsFldSize().split("\\.")[0];		//필드 길이
				} else {
					tscsFldSize = layoutDetailDto.getTscsFldSize();		//필드 길이
				}
				
				//남은 전문길이가 필드길이보다 작으면 남은길이만큼만 사용한다
				if(Integer.parseInt(tscsFldSize) > msgBytes.length - bytePos){
					fldByte = new byte[msgBytes.length - bytePos];
					System.arraycopy(msgBytes, bytePos, fldByte, 0, msgBytes.length - bytePos);
					bytePos += msgBytes.length - bytePos;
				} else {
					fldByte = new byte[Integer.parseInt(tscsFldSize)];
					System.arraycopy(msgBytes, bytePos, fldByte, 0, fldByte.length);
					bytePos += Integer.parseInt(tscsFldSize);
				}
				
				//바이트를 파싱하여 DTO에 추가한다
				TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
				//DTO필드속성 세팅
				testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));	//테스트데이터 일련번호
				testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());	//테스트데이터 필드명
				testDataDetailDto.setTscsFldDiv(layoutDetailDto.getFldDiv());	//테스트데이터필드 구분
				testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());	//테스트데이터필드 타입
				testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());	//테스트데이터필드 속성
				testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());	//테스트데이터필드 크기
				testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());	//테스트데이터필드 한글명
				if("03".equals(layoutDetailDto.getFldAttrib())){
					testDataDetailDto.setRptCntName("RPT"+String.valueOf(rptCntNo));
					rptCntNo++;
				}
				
				if("hex".equals(layoutDetailDto.getFldType())) {	//hex String
					testDataDetailDto.setTsdataFldData(TransUtil.byteArrayToHex(fldByte));
				} else {
					testDataDetailDto.setTsdataFldData(new String(fldByte,"euc-kr"));
				}
				
				if (logger. isDebugEnabled()) logger.debug("Header ["+testDataDetailDto.getTsdataFldName()+"] ["+testDataDetailDto.getTsdataFldData()+"]");
				headerList.add(testDataDetailDto);
				
				// 거래결과성공여부 Set
				if("TR_PRCS_RSLT_DSCD".equals(layoutDetailDto.getFldName())){
					if("0".equals(testDataDetailDto.getTsdataFldData())){
						testDataDto.setRsultSucssYn("Y");
						rsultSucssYn = "Y";
					} else {
						testDataDto.setRsultSucssYn("N");
						rsultSucssYn = "N";
					}
				}
				
			} else {	//반복부필드일 경우
				
				//반복부명
				String rptFldName = layoutDetailDto.getRptName();
				
				//반복횟수, 반복부명 가져오기
				int rtpCount = 0;
				String rptName = null;
				for(int j = headerList.size()-1 ; j >= 0 ; j--){
					TestDataDetailDto testDataDetailDto = headerList.get(j);
					if(rptFldName.equals(testDataDetailDto.getTsdataFldName())){
						if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
							rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
						} else {
							rtpCount = Integer.parseInt(testDataDetailDto.getTsdataFldData().trim());
						}
						//반복부명
						rptName = testDataDetailDto.getRptCntName();
					}
				}
				
				//반복부 파싱이 끝난후 레이아웃 인덱스 위치
				int nextIndex = i;
				
				//반복횟수만큼 반복한다
				for(int j = 0 ; j < rtpCount ; j++){
					int k = i;
					for( ; k < layoutDto.getHeaderList().size() ; k++){
						if(!rptFldName.equals(layoutDto.getHeaderList().get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
							break;
						} else {	//반복부일 경우
							//전문에서 필드길이 만큼 바이트를 얻는다
							byte[] fldByte = null;
							
							//파싱중인 전문(bytes)의 길이가 종료부보다 짧을경우  멈춘다
							if(msgBytes.length - bytePos <= 2){
								return testDataDto;
							}
							
							//필드사이즈 소숫점제거
							String tscsFldSize = null;
							if(layoutDto.getHeaderList().get(k).getTscsFldSize().indexOf(".") != -1){
								tscsFldSize = layoutDto.getHeaderList().get(k).getTscsFldSize().split("\\.")[0];		//필드 길이
							} else {
								tscsFldSize = layoutDto.getHeaderList().get(k).getTscsFldSize();		//필드 길이
							}
							
							//남은 전문길이가 필드길이보다 작으면 남은길이만큼만 사용한다
							if(Integer.parseInt(tscsFldSize) > msgBytes.length - bytePos){
								fldByte = new byte[msgBytes.length - bytePos];
								System.arraycopy(msgBytes, bytePos, fldByte, 0, msgBytes.length - bytePos);
								bytePos += msgBytes.length - bytePos;
							} else {
								fldByte = new byte[Integer.parseInt(tscsFldSize)];
								System.arraycopy(msgBytes, bytePos, fldByte, 0, fldByte.length);
								bytePos += Integer.parseInt(tscsFldSize);
							}
							
							//바이트를 파싱하여 DTO에 추가한다
							TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
							//DTO필드속성 세팅
							testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));	//테스트데이터 일련번호
							testDataDetailDto.setTsdataFldName(layoutDto.getHeaderList().get(k).getFldName());	//테스트데이터 필드명
							testDataDetailDto.setTscsFldDiv(layoutDto.getHeaderList().get(k).getFldDiv());	//테스트데이터필드 구분
							testDataDetailDto.setTscsFldType(layoutDto.getHeaderList().get(k).getFldType());	//테스트데이터필드 타입
							testDataDetailDto.setTscsFldAttrib(layoutDto.getHeaderList().get(k).getFldAttrib());	//테스트데이터필드 속성
							testDataDetailDto.setTscsFldSizeCnt(layoutDto.getHeaderList().get(k).getTscsFldSize());	//테스트데이터필드 크기
							testDataDetailDto.setTscsFldDesc(layoutDto.getHeaderList().get(k).getTscsFldDesc());	//테스트데이터필드 한글명
							testDataDetailDto.setRptName(rptName);	//반복부명
							testDataDetailDto.setRptCnt(String.valueOf(j+1));	//반복부회차
							
							if("hex".equals(layoutDto.getHeaderList().get(k).getFldType())) {	//hex String
								testDataDetailDto.setTsdataFldData(TransUtil.byteArrayToHex(fldByte));
							} else {
								testDataDetailDto.setTsdataFldData(new String(fldByte,"euc-kr"));
							}
							
							if (logger. isDebugEnabled()) logger.debug("Header ["+testDataDetailDto.getTsdataFldName()+"] ["+testDataDetailDto.getTsdataFldData()+"]");
							headerList.add(testDataDetailDto);
						}
						nextIndex = k;	//반복부의 마지막 인덱스
					}
				}
				
				i = nextIndex;
				
			}
		}
		
		///////////////////////////////////////////개별부////////////////////////////////////////////////
		List<TestDataDetailDto> inviList = new ArrayList<TestDataDetailDto>();
		testDataDto.setInviList(inviList);
		
		for(int i = 0 ; i < layoutDto.getInviList().size() ; i++){
			
			LayoutDetailDto layoutDetailDto = layoutDto.getInviList().get(i);
			
			//일반필드일 경우
			if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){
				
				//전문에서 필드길이 만큼 바이트를 얻는다
				byte[] fldByte = null;
				
				//파싱중인 전문(bytes)의 길이가 종료부보다 짧을경우  멈춘다
				if(msgBytes.length - bytePos <= 2){
					return testDataDto;
				}
				
				//필드사이즈 소숫점제거
				String tscsFldSize = null;
				if(layoutDetailDto.getTscsFldSize().indexOf(".") != -1){
					tscsFldSize = layoutDetailDto.getTscsFldSize().split("\\.")[0];		//필드 길이
				} else {
					tscsFldSize = layoutDetailDto.getTscsFldSize();		//필드 길이
				}
				
				//남은 전문길이가 필드길이보다 작으면 남은길이만큼만 사용한다
				if(Integer.parseInt(tscsFldSize) > msgBytes.length - bytePos){
					fldByte = new byte[msgBytes.length - bytePos];
					System.arraycopy(msgBytes, bytePos, fldByte, 0, msgBytes.length - bytePos);
					bytePos += msgBytes.length - bytePos;
				} else {
					fldByte = new byte[Integer.parseInt(tscsFldSize)];
					System.arraycopy(msgBytes, bytePos, fldByte, 0, fldByte.length);
					bytePos += Integer.parseInt(tscsFldSize);
				}
				
				//바이트를 파싱하여 DTO에 추가한다
				TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
				//DTO필드속성 세팅
				testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));	//테스트데이터 일련번호
				testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());	//테스트데이터 필드명
				testDataDetailDto.setTscsFldDiv(layoutDetailDto.getFldDiv());	//테스트데이터필드 구분
				testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());	//테스트데이터필드 타입
				testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());	//테스트데이터필드 속성
				testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());	//테스트데이터필드 크기
				testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());	//테스트데이터필드 한글명
				if("03".equals(layoutDetailDto.getFldAttrib())){
					testDataDetailDto.setRptCntName("RPT"+String.valueOf(rptCntNo));
					rptCntNo++;
				}
				
				if("hex".equals(layoutDetailDto.getFldType())) {	//hex String
					testDataDetailDto.setTsdataFldData(TransUtil.byteArrayToHex(fldByte));
				} else {
					testDataDetailDto.setTsdataFldData(new String(fldByte,"euc-kr"));
				}
				
				if (logger. isDebugEnabled()) logger.debug("Invi ["+testDataDetailDto.getTsdataFldName()+"] ["+testDataDetailDto.getTsdataFldData()+"]");
				inviList.add(testDataDetailDto);
				
			} else {	//반복부필드일 경우
				
				//반복부명
				String rptFldName = layoutDetailDto.getRptName();
				
				//반복횟수, 반복부명 가져오기
				int rtpCount = 0;
				String rptName = null;
				for(int j = inviList.size()-1 ; j >= 0 ; j--){
					TestDataDetailDto testDataDetailDto = inviList.get(j);
					if(rptFldName.equals(testDataDetailDto.getTsdataFldName())){
						if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
							rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
						} else {
							rtpCount = Integer.parseInt(testDataDetailDto.getTsdataFldData().trim());
						}
						//반복부명
						rptName = testDataDetailDto.getRptCntName();
					}
				}
				
				//반복부 파싱이 끝난후 레이아웃 인덱스 위치
				int nextIndex = i;
				
				//반복횟수만큼 반복한다
				for(int j = 0 ; j < rtpCount ; j++){
					int k = i;
					for( ; k < layoutDto.getInviList().size() ; k++){
						if(!rptFldName.equals(layoutDto.getInviList().get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
							break;
						} else {	//반복부일 경우
							//전문에서 필드길이 만큼 바이트를 얻는다
							byte[] fldByte = null;
							
							//파싱중인 전문(bytes)의 길이가 종료부보다 짧을경우  멈춘다
							if(msgBytes.length - bytePos <= 2){
								return testDataDto;
							}
							
							//필드사이즈 소숫점제거
							String tscsFldSize = null;
							if(layoutDto.getInviList().get(k).getTscsFldSize().indexOf(".") != -1){
								tscsFldSize = layoutDto.getInviList().get(k).getTscsFldSize().split("\\.")[0];		//필드 길이
							} else {
								tscsFldSize = layoutDto.getInviList().get(k).getTscsFldSize();		//필드 길이
							}
							
							//남은 전문길이가 필드길이보다 작으면 남은길이만큼만 사용한다
							if(Integer.parseInt(tscsFldSize) > msgBytes.length - bytePos){
								fldByte = new byte[msgBytes.length - bytePos];
								System.arraycopy(msgBytes, bytePos, fldByte, 0, msgBytes.length - bytePos);
								bytePos += msgBytes.length - bytePos;
							} else {
								fldByte = new byte[Integer.parseInt(tscsFldSize)];
								System.arraycopy(msgBytes, bytePos, fldByte, 0, fldByte.length);
								bytePos += Integer.parseInt(tscsFldSize);
							}
							
							//바이트를 파싱하여 DTO에 추가한다
							TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
							//DTO필드속성 세팅
							testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));	//테스트데이터 일련번호
							testDataDetailDto.setTsdataFldName(layoutDto.getInviList().get(k).getFldName());	//테스트데이터 필드명
							testDataDetailDto.setTscsFldDiv(layoutDto.getInviList().get(k).getFldDiv());	//테스트데이터필드 구분
							testDataDetailDto.setTscsFldType(layoutDto.getInviList().get(k).getFldType());	//테스트데이터필드 타입
							testDataDetailDto.setTscsFldAttrib(layoutDto.getInviList().get(k).getFldAttrib());	//테스트데이터필드 속성
							testDataDetailDto.setTscsFldSizeCnt(layoutDto.getInviList().get(k).getTscsFldSize());	//테스트데이터필드 크기
							testDataDetailDto.setTscsFldDesc(layoutDto.getInviList().get(k).getTscsFldDesc());	//테스트데이터필드 한글명
							testDataDetailDto.setRptName(rptName);	//반복부명
							testDataDetailDto.setRptCnt(String.valueOf(j+1));	//반복부회차
							
							if("hex".equals(layoutDto.getInviList().get(k).getFldType())) {	//hex String
								testDataDetailDto.setTsdataFldData(TransUtil.byteArrayToHex(fldByte));
							} else {
								testDataDetailDto.setTsdataFldData(new String(fldByte,"euc-kr"));
							}
							
							if (logger. isDebugEnabled()) logger.debug("Invi ["+testDataDetailDto.getTsdataFldName()+"] ["+testDataDetailDto.getTsdataFldData()+"]");
							inviList.add(testDataDetailDto);
						}
						nextIndex = k;	//반복부의 마지막 인덱스
					}
				}
				
				i = nextIndex;
				
			}
		}
		
		
		return testDataDto;
	}
	
	/**
	 * 
	 * <p>
	 * 전문 전송
	 * <p>
	 * <p>프로퍼티설정에서 테스트대상시스템의 ip,port,protocol 정보를 가져온다
	 * <p>해당 protocol 의 방식에 맞춰 전문을 송수신한다
	 * 
	 * @param executeDTO 전문실행 DTO
	 * @return ExecuteDto 전문실행 DTO
	 * @throws Exception
	 */
	private ExecuteDto tranMessage(ExecuteDto executeDto) throws Exception {
		
		//전송URL 가져오기
		String ip = "";	//IP
		String port = "";	//PORT
		String protocol = "";	//통신방식
		String[] mciPropArray = TestroPreference.getInstance().getProperty("CONN_SEVER_LIST", TestroPreference.USER).split(",");
		for(int i = 0 ; i < mciPropArray.length ; i++){
			
			String[] mciProp = mciPropArray[i].split(":");
			
			if(executeDto.getConnSevrDstcd().equals(mciProp[0])){
				if("01".equals(executeDto.getChnlDstcd())){	//단말
					ip = TestroPreference.getInstance().getProperty(mciProp[2] + "_TER_IP", TestroPreference.USER);
					port = TestroPreference.getInstance().getProperty(mciProp[2] + "_TER_PORT", TestroPreference.USER);
					protocol = TestroPreference.getInstance().getProperty(mciProp[2] + "_TER_PROTOCOL", TestroPreference.USER);
					break;
				} else if("02".equals(executeDto.getChnlDstcd())){	//자동화기기
					ip = TestroPreference.getInstance().getProperty(mciProp[2] + "_ATM_IP", TestroPreference.USER);
					port = TestroPreference.getInstance().getProperty(mciProp[2] + "_ATM_PORT", TestroPreference.USER);
					protocol = TestroPreference.getInstance().getProperty(mciProp[2] + "_ATM_PROTOCOL", TestroPreference.USER);
					break;
				} else if("03".equals(executeDto.getChnlDstcd())){	//인터넷뱅킹
					ip = TestroPreference.getInstance().getProperty(mciProp[2] + "_INB_IP", TestroPreference.USER);
					port = TestroPreference.getInstance().getProperty(mciProp[2] + "_INB_PORT", TestroPreference.USER);
					protocol = TestroPreference.getInstance().getProperty(mciProp[2] + "_INB_PROTOCOL", TestroPreference.USER);
					break;
				} else if("04".equals(executeDto.getChnlDstcd())){	//콜센터
					ip = TestroPreference.getInstance().getProperty(mciProp[2] + "_IVR_IP", TestroPreference.USER);
					port = TestroPreference.getInstance().getProperty(mciProp[2] + "_IVR_PORT", TestroPreference.USER);
					protocol = TestroPreference.getInstance().getProperty(mciProp[2] + "_IVR _PROTOCOL", TestroPreference.USER);
					break;
				}
			}
		}
		
		if (logger. isDebugEnabled())  logger.debug("통신IP : " + ip);
		if (logger. isDebugEnabled())  logger.debug("통신PORT : " + port);
		if (logger. isDebugEnabled())  logger.debug("통신PROTOCOL : " + protocol);
		
		String urlString = ip + ":" + port;	//URL
		
		//HTTP통신 GET방식
		if("HTTP_GET".equals(protocol)){
			URLConnection urlConnection;
			//연결, 전송
			try{
				URL url = new URL(urlString + "?" + new String(executeDto.getInputBytes(),"euc-kr"));
				urlConnection = url.openConnection();
			} catch(Exception e) {
				throw new Exception("연결 실패");
			}
				
			try{
				//응답
				String recvString = printByInputStream(urlConnection.getInputStream());
				executeDto.setOutputBytes(recvString.getBytes("euc-kr"));
			} catch(Exception e) {
				throw new Exception("응답 실패");
			}
		}
		//HTTP통신 POST방식
		else if("HTTP_POST".equals(protocol)){
			
			URLConnection urlConnection;
			BufferedReader br;
			try{
				//연결
				URL url = new URL(urlString);
				urlConnection = url.openConnection();
	            urlConnection.setDoOutput(true);
	            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); 
			} catch(Exception e) {
				throw new Exception("연결 실패");
			}
			
			try{
	            //메시지 URL Encoding 
	            String mciMsgCtnt = new String(executeDto.getInputBytes(),"euc-kr");
	            mciMsgCtnt = mciMsgCtnt.replaceAll("'","\"");
				mciMsgCtnt = URLEncoder.encode(mciMsgCtnt,"euc-kr");
				mciMsgCtnt = "MESSAGE="+mciMsgCtnt;	//parameter name = MESSAGE
				
				//전송
	            printByOutputStream(urlConnection.getOutputStream(), mciMsgCtnt);
			} catch(Exception e) {
				throw new Exception("전송 실패");
			}
            
			try{
	            //응답
	            String line;
	            String recvString = "";
	            while ( (line=br.readLine())!= null ) {
					recvString += line;
				}
	            executeDto.setOutputBytes(recvString.getBytes("euc-kr"));
			} catch(Exception e) {
				throw new Exception("응답 실패");
			}
		}
		//SOCKET통신
		else if("SOCKET".equals(protocol)) {
			
			BufferedInputStream bis;
			BufferedOutputStream bos;
			Socket socket;
			
			try{
				if (logger. isDebugEnabled())  logger.debug("[소켓연결] IP : "+ip+", PORT : "+port);
				
				//연결
				socket = new Socket();
				String timeOut = TestroPreference.getInstance().getProperty("SOCKET_TIME_OUT", TestroPreference.USER);
				logger.debug("SOCKET TIME OUT : "+timeOut);
				socket.setSoTimeout(Integer.valueOf(timeOut));
				socket.connect(new InetSocketAddress(ip, Integer.parseInt(port)));
				bis = new BufferedInputStream(new DataInputStream(socket.getInputStream()));
				bos = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()));
			} catch(Exception e) {
				throw new Exception("연결 실패");
			}
			
			if (logger. isDebugEnabled())  logger.debug("소켓연결 성공 ");
			if (logger. isDebugEnabled())  logger.debug("전송 전문 >> ["+new String(executeDto.getInputBytes(),"euc-kr")+"]");
			
			try{
				//전송
				printByOutputStream(bos, executeDto.getInputBytes());
			} catch(Exception e) {
				throw new Exception("전송 실패");
			}
				
			try{
				//응답
				int lengthField = Integer.parseInt(executeDto.getLengthFldSize());	//전문길이필드Size
				byte[] length = readData(bis,lengthField);	//전문길이필드 읽어오기
				
				int msgLength = 0;
				if("hex".equals(executeDto.getLengthFldType())){	//전문길이필드속성이 hex
					msgLength = Integer.parseInt(TransUtil.byteArrayToHex(length),16);
				} else {	//text,num
					msgLength = Integer.parseInt(new String(length,"euc-kr").trim());
				}
				
				byte[] receiveBytes = readData(bis,msgLength);	//전문 나머지 읽어오기
				byte[] outputBytes = new byte[length.length + receiveBytes.length];
				System.arraycopy(length, 0, outputBytes, 0, length.length);
				System.arraycopy(receiveBytes, 0, outputBytes, length.length, receiveBytes.length);
				
				executeDto.setOutputBytes(outputBytes);
				
				if (logger. isDebugEnabled())  logger.debug("응답 전문 >> ["+new String(outputBytes,"euc-kr")+"]");
			}  catch(Exception e) {
				throw new Exception("응답 실패");
			}
		}
		//TP-CALL
		else if("TP".equals(protocol)) {
			WebtConnection con = null;
			WebtRemoteService service = null;
			WebtBuffer sndbuf = null;
			WebtBuffer rcvbuf = null;
			
			WebtSystem.setDefaultCharset("euc-kr");
			
			try{
				if (logger. isDebugEnabled())  logger.debug("[TP연결] IP : "+ip+", PORT : "+port);
				
				con = new WebtConnection(ip,Integer.parseInt(port));
				
				service = new WebtRemoteService(executeDto.getTranCd(), con);
				service.createStringBuffer(2084);
			} catch(Exception e) {
				throw new Exception("연결 실패");
			}
			
			if (logger. isDebugEnabled())  logger.debug("소켓연결 성공 ");
			if (logger. isDebugEnabled())  logger.debug("전송 전문 >> ["+new String(executeDto.getInputBytes(),"euc-kr")+"]");
			
			try{
				sndbuf = service.createStringBuffer();
				//전송
				sndbuf.setBytes(executeDto.getInputBytes());
				rcvbuf = service.tpcall(sndbuf);
//				printByOutputStream(bos, executeDto.getInputBytes());
				
				executeDto.setOutputBytes(rcvbuf.getBytes());
				
				if (logger. isDebugEnabled())  logger.debug("응답 전문 >> ["+new String(rcvbuf.getBytes(),"euc-kr")+"]");
			} catch(Exception e) {
				e.printStackTrace();
				throw new Exception("송수신 실패");
			}
		}
				
		return executeDto;
	}
	
	// 웹 서버로 파라미터명과 값의 쌍을 전송하는 메소드
    private static void printByOutputStream(OutputStream os, String msg) {
        try {
            byte[] msgBuf = msg.getBytes("euc-kr");
            os.write(msgBuf, 0, msgBuf.length);
            os.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    // 웹 서버로 파라미터명과 값의 쌍을 전송하는 메소드
    private static void printByOutputStream(OutputStream os, byte[] msgBuf) {
        try {
            os.write(msgBuf, 0, msgBuf.length);
            os.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    // 웹 서버로 부터 받은 웹 페이지 결과를 콘솔에 출력하는 메소드
    private static String printByInputStream(InputStream is) {
        byte[] buf = new byte[1024];
        int len = -1;
        String str="";
       
        try {
            while((len = is.read(buf, 0, buf.length)) != -1) {
                str += new String(buf, 0, len).trim();
            }
            
        } catch(IOException e) {
            e.printStackTrace();
            //logger.debug("송신 실패! MCI시스템 확인요망!!!");
            //str = "송신 실패! MCI시스템 확인요망!!!";
        }
        
        return str;
    }
    
    //응답데이터 읽어오기
	private byte[] readData(InputStream in, int length) throws IOException {
		java.io.ByteArrayOutputStream bout = new java.io.ByteArrayOutputStream();
		
		int totalCount = 0;
		byte[] buf = new byte[2048];
		//byte[] totalBuf = new byte[length];		
		
		try {
			int i = 0;
			while( totalCount < length ) { 
			  int readCount = in.read(buf,0, length-totalCount < 2048 ? length-totalCount : 2048 );
	  
			  if (readCount == -1) break;
			  i++;
			  //System.arraycopy(buf, 0, totalBuf, totalCount, readCount);
			  totalCount += readCount;
			  bout.write(buf,0,readCount);
			}	
		}catch(Exception e){
			//logger.error("readData Error>>"+e);
		}finally {
			bout.flush();
		}
 		
 		//logger.debug("totalBuf.length: "+totalBuf.length);
 		//logger.debug("ByteArrayOutputStream.length: "+bout.toByteArray().length);
 		return bout.toByteArray();//totalBuf;
	}

	//정책금융공사 인터페이스 수정에 맞춤
	public ExecuteDto mciExecute(String connSevrDstcd, String chnlDstcd,
			String tranCd, TestDataDto inputDto, HttpServletRequest request, String usrid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
