package com.igo.testro.msg.flaw.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.cmn.utils.StringUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.flaw.dao.FlawDao;
import com.igo.testro.msg.flaw.dto.FlawDto;

/**
 * 
 * <p>
 * 프로그램명:FlawBiz.java<br/>
 * 설명 : 결함관리BIZ<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 20. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class FlawBiz {
	
	@Autowired
	private FlawDao flawDao;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();	//logger
	
	/**
	 * 
	 * <p>
	 * 결함관리 조회
	 * <p>
	 * @param tsDataId 테스트데이터ID
	 * @param acmplNth 수행회차
	 * @return List<FlawDto> 결함DTO List 
	 */
	@Transactional(readOnly = true)
	public List<FlawDto> getListFlaw(String tsDataId, String acmplNth){
		
		try{
			List<FlawDto> flawDtoList = flawDao.getListFlaw(tsDataId, acmplNth);
			
			for(FlawDto flawDto : flawDtoList){
				//결함ID세팅(테스트데이터ID 20자 + 수행회차 3자 + 결함일련번호 3자)
				flawDto.setFlawId(StringUtil.rpad(flawDto.getTsDataId(), 20, '0') + StringUtil.lpad(flawDto.getAcmplNth(), 3, '0') + StringUtil.lpad(flawDto.getDefNo(), 3, '0'));
				//조치완료예정일
				flawDto.setActCloseYMS(DateUtil.convertShortQuicsFormat(flawDto.getActCloseYMS()));
				//재테스트일시
				flawDto.setReTestYMS(DateUtil.convertShortQuicsFormat(flawDto.getReTestYMS()));
			}
			return flawDtoList;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0001","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 신규
	 * <p>
	 * <p>결함관리를 신규 등록한다
	 * <p>결함상태코드가 (04:승인)일때 승인일자와 승인완료여부(Y)를 입력한다
	 * @param flawDto 결함DTO 
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerFlaw(FlawDto flawDto){
		
		try{
			
			flawDao.registerFlaw(flawDto);
		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0002","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 수정
	 * <p>
	 * <p>결함관리를 수정한다
	 * <p>결함상태코드가 (04:승인)일때 승인일자와 승인완료여부(Y)를 입력한다
	 * @param flawDto 결함DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void modifyFlaw(FlawDto flawDto){
		
		try{
			flawDao.modifyFlaw(flawDto);
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0003","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 삭제
	 * <p>
	 * @param tsDataId 테스트데이터ID
	 * @param acmplNth 수행회차
	 * @param defNo 결함일련번호
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteFlaw(String tsDataId, String acmplNth, String defNo){
		try{
			flawDao.deleteFlaw(tsDataId, acmplNth, defNo);
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0004","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 결함조치 수정
	 * <p>
	 * <p>결함조치를 수정한다
	 * <p>결함상태코드가 (04:승인)일때 승인일자와 승인완료여부(Y)를 입력한다
	 * @param flawDto 결함DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void modifyTreat(FlawDto flawDto){
		try{
			flawDao.modifyTreat(flawDto);
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0005","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스 결함조회
	 * <p>
	 * <p>현재 사용자가 배분자 또는 조치자로 등록된 테스트케이스 결함을 조회한다
	 * @param request HttpServletRequest
	 * @return Map 조회결과
	 */
	@Transactional(readOnly = true)
	public Map getListMyTCFlaw(HttpServletRequest request){
		
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			
			param.put("projNo", request.getParameter("projNo"));	//프로젝트번호
			param.put("testStgeName", request.getParameter("testStgeName"));	//테스트단계명
			param.put("defCd", request.getParameter("defCd"));	//결함진행구분코드
			//세션정보
			LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
			param.put("usrId", userinfoDto.getUsrid());	//사용자ID
	
			List<FlawDto> flawDtoList = flawDao.getListMyTCFlaw(param);	//나의테스트케이스결함조회
	
			//결함ID세팅(테스트데이터ID 20자 + 수행회차 3자 + 결함일련번호 3자)
			for(FlawDto flawDto : flawDtoList){
				flawDto.setFlawId(StringUtil.rpad(flawDto.getTsDataId(), 20, '0') + StringUtil.lpad(flawDto.getTsdataAcmplNth(), 3, '0') + StringUtil.lpad(flawDto.getDefNo(), 3, '0'));
			}
			int totcnt = flawDao.getListMyTCFlawCnt(param);	//나의테스트케이스결함조회 건수
			
			outputMap.put("rows", flawDtoList );                          //조회된 list 데이터
			outputMap.put("records", totcnt);                       //조회된 총건수
			outputMap.put("page", page);                            // 조회 요청페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));//총 페이지수
			
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0006","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오 결함조회
	 * <p>
	 * <p>현재 사용자가 배분자 또는 조치자로 등록된 테스트시나리오 결함을 조회한다
	 * @param request HttpServletRequest
	 * @return Map 조회결과
	 * @return List<FlawDto> 결함DTO List
	 */
	@Transactional(readOnly = true)
	public Map getListMyTSFlaw(HttpServletRequest request){
		
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			
			param.put("projNo", request.getParameter("projNo"));	//프로젝트번호
			param.put("testStgeName", request.getParameter("testStgeName"));	//테스트단계명
			param.put("defCd", request.getParameter("defCd"));	//결함진행구분코드
			//세션정보
			LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
			param.put("usrId", userinfoDto.getUsrid());	//사용자ID
	
			List<FlawDto> flawDtoList = flawDao.getListMyTSFlaw(param);	//나의테스트케이스결함조회
	
			//결함ID세팅
			for(FlawDto flawDto : flawDtoList){
				flawDto.setFlawId(StringUtil.rpad(flawDto.getTsDataId(), 20, '0') + StringUtil.lpad(flawDto.getTsdataAcmplNth(), 3, '0') + StringUtil.lpad(flawDto.getDefNo(), 3, '0'));
			}
			int totcnt = flawDao.getListMyTSFlawCnt(param);	//나의테스트케이스결함조회 건수
			
			outputMap.put("rows", flawDtoList );                          //조회된 list 데이터
			outputMap.put("records", totcnt);                       //조회된 총건수
			outputMap.put("page", page);                            // 조회 요청페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));//총 페이지수
			
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0007","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스 재테스트조회
	 * <p>
	 * <p>현재 사용자가 등록한 테스트케이스 결함을 조회한다
	 * @param request HttpServletRequest
	 * @return Map 조회결과
	 */
	@Transactional(readOnly = true)
	public Map getListMyTCReTest(HttpServletRequest request){
		
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			
			param.put("projNo", request.getParameter("projNo"));	//프로젝트번호
			param.put("testStgeName", request.getParameter("testStgeName"));	//테스트단계명
			param.put("defCd", request.getParameter("defCd"));	//결함진행구분코드
			//세션정보
			LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
			param.put("usrId", userinfoDto.getUsrid());	//사용자ID
	
			List<FlawDto> flawDtoList = flawDao.getListMyTCReTest(param);	//나의테스트케이스재테스트 조회
	
			//결함ID세팅
			for(FlawDto flawDto : flawDtoList){
				flawDto.setFlawId(StringUtil.rpad(flawDto.getTsDataId(), 20, '0') + StringUtil.lpad(flawDto.getTsdataAcmplNth(), 3, '0') + StringUtil.lpad(flawDto.getDefNo(), 3, '0'));
			}
			int totcnt = flawDao.getListMyTCReTestCnt(param);	//나의테스트케이스재테스트 조회 건수
			
			outputMap.put("rows", flawDtoList );                          //조회된 list 데이터
			outputMap.put("records", totcnt);                       //조회된 총건수
			outputMap.put("page", page);                            // 조회 요청페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));//총 페이지수
			
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0008","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오 재테스트조회
	 * <p>
	 * <p>현재 사용자가 등록한 테스트시나리오 결함을 조회한다
	 * @param request HttpServletRequest
	 * @return Map 조회결과
	 * @return List<FlawDto> 결함DTO List
	 */
	@Transactional(readOnly = true)
	public Map getListMyTSReTest(HttpServletRequest request){
		
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			
			param.put("projNo", request.getParameter("projNo"));	//프로젝트번호
			param.put("testStgeName", request.getParameter("testStgeName"));	//테스트단계명
			param.put("defCd", request.getParameter("defCd"));	//결함진행구분코드
			//세션정보
			LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
			param.put("usrId", userinfoDto.getUsrid());	//사용자ID
	
			List<FlawDto> flawDtoList = flawDao.getListMyTSReTest(param);	//나의테스트케이스재테스트 조회
	
			//결함ID세팅
			for(FlawDto flawDto : flawDtoList){
				flawDto.setFlawId(StringUtil.rpad(flawDto.getTsDataId(), 20, '0') + StringUtil.lpad(flawDto.getTsdataAcmplNth(), 3, '0') + StringUtil.lpad(flawDto.getDefNo(), 3, '0'));
			}
			int totcnt = flawDao.getListMyTSReTestCnt(param);	//나의테스트케이스재테스트 조회 건수
			
			outputMap.put("rows", flawDtoList );                          //조회된 list 데이터
			outputMap.put("records", totcnt);                       //조회된 총건수
			outputMap.put("page", page);                            // 조회 요청페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));//총 페이지수
			
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_FLAWXX0009","", e);
		}
	}
}
 