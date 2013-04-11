package com.igo.testro.msg.cmn.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.dao.MngUserDao;
import com.igo.testro.msg.cmn.dto.MngUserDto;

/**
 * <p>
 * 프로그램명:MngUserBiz.java<br/>
 * 설명 : 사용자 정보 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class MngUserBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	@Autowired
	private MngUserDao mngUserDao;
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 조회
	 * <p> 
	 * <p> 사용자 정보를 조회한다.
	 * <p> 입력 조건인 사용자ID/명, 사용자 권한의 조건에 따라 조회 한다.
	 * @param request HttpServletRequest
	 * @return outputMap 생성 데이터 값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getlist(HttpServletRequest request){
		Map outputMap = new HashMap();
		Map param = new HashMap();
		int startnum = 0;
		int endnum = 0;
		try{
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			param.put("usrID", request.getParameter("usrID"));
			param.put("usrName", request.getParameter("usrName"));				//사용자 ID
			String userLevel = request.getParameter("usrLevel");				//사용자명
			if(!"00".equals(userLevel)){										//사용자 Level 선택했을 경우
				param.put("usrLevel", request.getParameter("usrLevel"));		//사용자 Level
			}
			MngUserDto mngUserDto = new MngUserDto();
			mngUserDto.setLastModfiEmpLevel(request.getParameter("lastModfiEmpLevel"));
			String level = request.getParameter("lastModfiEmpLevel");
			ArrayList<MngUserDto> dlist = new ArrayList<MngUserDto>();
			if ("01".equals(level)){											//세션 Level이 테스트로 관리자일 경우
				dlist= mngUserDao.getlist(param);								//전체를 조회
			}else{																//세션 Level이 관리자인 경우
				dlist= mngUserDao.getlistlowLevel(param);						//레벨 01인 테스트로 관리자를 제외하고 조회
			}
			int totcnt = mngUserDao.getCnt(param);
			
			outputMap.put("rows", dlist );                         
			outputMap.put("records", totcnt);                       
			outputMap.put("page", page);                          
			outputMap.put("total",  Math.ceil((double)totcnt/rows));
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MNGUSR0001","", e);
		}
		return outputMap;
	}
	/**
	 * <p>
	 * 메소드 설명 : 사용자 리스트 행 삭제
	 * <p> 
	 * <p>선택한 행을 완전 삭제 하는게 아니라 삭제 여부만 Y로 변경해준다.
	 * @param mngUserDto 전문레이아웃DTO
	 * @return result 삭제 여부 구분
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getDelete(MngUserDto mngUserDto) {
		int result = 0;
		try{
			mngUserDao.deletUserTestInfo(mngUserDto);			//정보 삭제(DELYN(=삭제여부)을 Y로 변경)
			result = 1;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MNGUSR0002","", e);
		}
		return result;
	}
}
