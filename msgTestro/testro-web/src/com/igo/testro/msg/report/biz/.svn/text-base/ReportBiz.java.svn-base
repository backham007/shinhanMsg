package com.igo.testro.msg.report.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.report.dao.ReportDao;
import com.igo.testro.msg.report.dto.RptCaseInfoDto;
import com.igo.testro.msg.report.dto.RptCheckpointDto;
import com.igo.testro.msg.report.dto.RptInOutDataDto;
import com.igo.testro.msg.report.dto.RptSnrioInfoDto;
import com.igo.testro.msg.report.dto.RptTsResultDto;

/**
 * <p>
 * 프로그램명:ReportDetailBiz.java<br/>
 * 설명 : 결과보고서 상세 biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 25. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class ReportBiz {
	
	@Autowired
	private ReportDao reportDao;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();	//logger
	
	/**
	 * <p>
	 * 결과보고서 (테스트케이스,시나리오 masterInfo, 결과보고서 초기호출)
	 * <p>
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map getRptTsRsultMain(Map param){
		
		try{
			String gubun = (String)param.get("gubun");	//케이스,시나리오구분
			
			Map outputMap = new HashMap();
			
			if("01".equals(gubun)){	//테스트케이스
				
				RptCaseInfoDto rptCaseInfoDto = reportDao.getTsCaseBasic(param); //테스트케이스 기본
				rptCaseInfoDto.setTeststartyms(DateUtil.convertQuicsFormat(rptCaseInfoDto.getTeststartyms()));	//테스트시작일자
				rptCaseInfoDto.setTestendyms(DateUtil.convertQuicsFormat(rptCaseInfoDto.getTestendyms()));	//테스트종료일자
				if(rptCaseInfoDto.getTscasename().length() > 30){
					rptCaseInfoDto.setTscasename(rptCaseInfoDto.getTscasename().substring(0, 30)+"......");
				}
				
				outputMap.put("rptMaster", rptCaseInfoDto);
				
				if( null != rptCaseInfoDto){
					
					ArrayList<RptCaseInfoDto> dataDtoList = reportDao.getListTsCaseData(param); //테스트데이터 리스트
					outputMap.put("dataList", dataDtoList);
					if(dataDtoList.size() > 0){
						outputMap.put("firstTsDataId", dataDtoList.get(0).getTsdataid());
						outputMap.put("firstTsDataAcmplnth", dataDtoList.get(0).getTsdataacmplnth());
					}
				}
				
			} else if("02".equals(gubun)){	//테스트시나리오
				
				RptSnrioInfoDto rptSnrioInfoDto = reportDao.getTsSnrioBasic(param); //테스트시나리오 기본
				rptSnrioInfoDto.setTeststartyms(DateUtil.convertQuicsFormat(rptSnrioInfoDto.getTeststartyms()));	//테스트시작일자
				rptSnrioInfoDto.setTestendyms(DateUtil.convertQuicsFormat(rptSnrioInfoDto.getTestendyms()));	//테스트종료일자
				if(rptSnrioInfoDto.getTssnrioname().length() > 30){
					rptSnrioInfoDto.setTssnrioname(rptSnrioInfoDto.getTssnrioname().substring(0, 30)+"......");
				}
				
				outputMap.put("rptMaster", rptSnrioInfoDto);
				
				if( null != rptSnrioInfoDto){
					ArrayList<RptSnrioInfoDto> dataDtoList = reportDao.getListTsSnrioData(param); //테스트데이터 리스트
					outputMap.put("dataList", dataDtoList);
					if(dataDtoList.size() > 0){
						outputMap.put("firstTsDataId", dataDtoList.get(0).getTsdataid());
						outputMap.put("firstTsDataAcmplnth", dataDtoList.get(0).getTsdataacmplnth());
					}
				}
				
				
			}
			
			outputMap.put("gubun", gubun);
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_REPORT0001","", e);
		}
	}
	
	/**
	 * <p>
	 * 테스트결과
	 * <p>
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map getTestResult(Map param){
		
		try{
			String gubun = (String)param.get("gubun");	//케이스,시나리오구분
			
			Map outputMap = new HashMap();
			
			if("01".equals(gubun)){	//테스트케이스
				RptTsResultDto rptTsResultDto = reportDao.getTestCaseResult(param);
				rptTsResultDto.setTeststartyms(DateUtil.convertQuicsFormat(rptTsResultDto.getTeststartyms()));	//테스트시작일자
				rptTsResultDto.setTestendyms(DateUtil.convertQuicsFormat(rptTsResultDto.getTestendyms()));	//테스트시작일자
				
				outputMap.put("rptTsResult", rptTsResultDto);;//테스트결과
			} else if("02".equals(gubun)){	//테스트시나리오
				RptTsResultDto rptTsResultDto = reportDao.getTestSnrioResult(param);
				rptTsResultDto.setTeststartyms(DateUtil.convertQuicsFormat(rptTsResultDto.getTeststartyms()));	//테스트시작일자
				rptTsResultDto.setTestendyms(DateUtil.convertQuicsFormat(rptTsResultDto.getTestendyms()));	//테스트시작일자
				
				outputMap.put("rptTsResult", rptTsResultDto);//테스트결과
			}
			outputMap.put("gubun", gubun);
			
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_REPORT0002","", e);
		}
	}
	
	/**
	 * <p>
	 * 입출력데이터
	 * <p>
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map getListInOutData(Map param){
		try{
			Map outputMap = new HashMap();
			RptInOutDataDto rptInOutDataDto = reportDao.getInOutDataBasic(param); //테스트데이터 기본
			outputMap.put("master", rptInOutDataDto);
			
			if( null != rptInOutDataDto){
				param.put("fldDiv", "01");	//필드구분
				ArrayList<RptInOutDataDto> dataDtoList = reportDao.getListInOutDataDetail(param); //테스트데이터 헤더부 상세
				outputMap.put("headerList", dataDtoList);
				
				param.put("fldDiv", "02");	//필드구분
				dataDtoList = reportDao.getListInOutDataDetail(param); //테스트데이터 개별부 상세
				outputMap.put("inviList", dataDtoList);
			}
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_REPORT0003","", e);
		}
	}
	
	/**
	 * <p>
	 * 체크포인트 실적
	 * <p>
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map getListCheckPoint(Map param){
		try{
			Map outputMap = new HashMap();
			ArrayList<RptCheckpointDto> dataDtoList = reportDao.getListCheckPoint(param); //테스트데이터 상세
			outputMap.put("dataList", dataDtoList);
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_REPORT0004","", e);
		}
	}
}
