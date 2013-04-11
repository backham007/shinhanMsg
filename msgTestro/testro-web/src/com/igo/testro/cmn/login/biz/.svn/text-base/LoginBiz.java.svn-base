package com.igo.testro.cmn.login.biz;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import com.igo.testro.bean.util.TestroBeanUtil;
import com.igo.testro.cmn.login.dao.LoginDao;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

/**
 * <p>
 * 프로그램명:LoginBiz.java<br/>
 * 설명 : 로그인 biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class LoginBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	@Autowired
	private LoginDao loginDao;
	

	/**
	 * <p>
	 * 로그인 사용자정보
	 * <p>
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public LoginDto getuserinfo(Map param){
		LoginDto userinfo;
		LoginDto projectinfo;
			
		userinfo = loginDao.getuserinfo(param);
		if( null != userinfo){
			projectinfo = loginDao.getprojectinfo(param);
			if( null != projectinfo){
				TestroBeanUtil.copyDtoToBean(projectinfo, userinfo);
			}else{
				userinfo.setProjname("정보없음");
				userinfo.setTeststgename("정보없음");
			}
		}
		if (logger.isDebugEnabled()){
			logger.debug("#########로그인 사용자 정보 STR##############################");
			logger.debug("userinfo.getUsrid       ==>"+userinfo.getUsrid       ());
			logger.debug("userinfo.getUsrname     ==>"+userinfo.getUsrname     ());
			logger.debug("userinfo.getUsrlevel    ==>"+userinfo.getUsrlevel    ());
			logger.debug("userinfo.getProjno      ==>"+userinfo.getProjno      ());
			logger.debug("userinfo.getProjname    ==>"+userinfo.getProjname    ());
			logger.debug("userinfo.getTeststgename==>"+userinfo.getTeststgename());
			logger.debug("userinfo.getTeststartyms==>"+userinfo.getTeststartyms());
			logger.debug("userinfo.getTestendyms  ==>"+userinfo.getTestendyms  ());
			logger.debug("#########로그인 사용자 정보 END##############################");
		}
		return userinfo;
	}
	
	/**
	 * <p>
	 * 로그인 정보 체크(ID,PW)
	 * <p>
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public String getusercheck(Map param) throws BizException{
		String message="";
		int userYnCnt = loginDao.getuserIdCount(param); //사용자 존재여부
		if(1 > userYnCnt){
			message = "미등록된 아이디 입니다.";
			return message;
		}
		int pwEqYn = loginDao.getuserPwCount(param); //패스워드 일치여부
		if(1 > pwEqYn){
			message = "패스워드가 일치하지 않습니다.";
			return message;
		}
		return message;
	}
}
