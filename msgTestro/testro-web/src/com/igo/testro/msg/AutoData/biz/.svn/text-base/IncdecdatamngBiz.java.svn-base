package com.igo.testro.msg.AutoData.biz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.igo.testro.msg.AutoData.dto.IncdecdatamngDto;

/**
 * <p>
 * 프로그램명:IncdecdatamngBiz.java<br/>
 * 설명 : 증감 데이터 입력<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class IncdecdatamngBiz {
	/**
	 * <p>
	 * 메소드 설명 : 증감데이터 입력 생성
	 * <p> 
	 * <p>숫자로 생성할 경우 시작값, 종료값, 간격을 입력받아 데이터를 계산하여 생성한다.
	 * <p>날짜로 생성할 경우 시작일, 종료일을 입력 받아 데이터를 계산하여 생성한다.
	 * @param dataDTO 전문레이아웃DTO
	 * @return outputMap 생성 데이터 값
	 */
	public Map createIncDecData(IncdecdatamngDto dataDTO){

		Map outputMap = new HashMap();  											//tempDto담은 데이터를 담을 MAP생성
		IncdecdatamngDto tempDto = new IncdecdatamngDto();							//데이터를 담을 전문레이아웃DTO
		ArrayList<IncdecdatamngDto> tempList = new ArrayList<IncdecdatamngDto>(); 	//데이터를 담을 전문레이아웃DTO를 담을 LIST 생성
		if("date".equals(dataDTO.getDstCd())){										//날짜로 생성할 경우
			String sdate = dataDTO.getStartDate();									//시작일값
			String edate = dataDTO.getEndDate();									//종료일값
			String month = "";														//월
			String date = "";														//일
			Calendar startCal = Calendar.getInstance ( );							
			startCal.set (Integer.valueOf(sdate.substring(0,4))						//시작값 substring으로 짜르기
					, Integer.valueOf(sdate.substring(5,7))-1
					, Integer.valueOf(sdate.substring(8,10))-1); 

			Calendar endCal = Calendar.getInstance ( ); 
			endCal.set ( Integer.valueOf(edate.substring(0,4))						//종료값 substirng으로 짜르기
					, Integer.valueOf(edate.substring(5,7))-1
					, Integer.valueOf(edate.substring(8,10))-1);
			int i = 0;																//일련번호
			while ( !startCal.after ( endCal ) ){									//값 계산하기 위한 while문
				tempDto = new IncdecdatamngDto();									//tempDto 비워주기
				i++;																//일련번호 올려주기
				String dstName= dataDTO.getDstName();								//dstName값 가져오기(숫자,날짜)
				startCal.add ( Calendar.DATE, 1 ); 									
				month = String.valueOf(startCal.get ( Calendar.MONTH)+1);			//월 값
				date = String.valueOf(startCal.get ( Calendar.DATE ));				//일 값
				if(month.length() == 1){
					month = "0" + month;
				}
				if(date.length() == 1){
					date = "0" + date;
				}
				String date1 =  startCal.get ( Calendar.YEAR ) + "-" + month + "-" + date;	//날짜 합치기
				tempDto.setResultData(String.valueOf(date1));								//입력값 set하기
				tempDto.setDstCd(String.valueOf(i));										//일련번호 set하기
				tempDto.setDstName(dstName);												//구분명 set하기
				tempList.add(tempDto);														//tempList에 담기
			}
		}else if("amt".equals(dataDTO.getDstCd())){									//숫자일 생성할 경우
			int startVal = Integer.valueOf(dataDTO.getStartVal());					//시작값
			int endVal = Integer.valueOf(dataDTO.getEndVal());						//종료값
			int step = Integer.valueOf(dataDTO.getStep());							//간격
			String dstName= dataDTO.getDstName();									//구분명

			int i = 0;																//일련번호
			for (;startVal<=endVal; startVal = startVal+step) {						//값 계산하기 위한 for문
				i++;																//일련번호 올려주기
				tempDto = new IncdecdatamngDto();									//tempDto 비워주기
				tempDto.setResultData(String.valueOf(startVal));					//입력값 set하기
				tempDto.setDstCd(String.valueOf(i));								//일련번호 set하기
				tempDto.setDstName(dstName);										//구분명 set하기
				tempList.add(tempDto);												//tempList에 담기
			}
		}
		dataDTO.setIncDecDataResult(tempList);										//입력값 set하기
		outputMap.put("rows", dataDTO.getIncDecDataResult() );                    	//입력값
		outputMap.put("records", dataDTO.getIncDecDataResult().size());           	//행의 길이
		outputMap.put("dstName",  dataDTO.getDstName());							//구분명

		return outputMap;															//outputMap 리턴해주기
	}
}
