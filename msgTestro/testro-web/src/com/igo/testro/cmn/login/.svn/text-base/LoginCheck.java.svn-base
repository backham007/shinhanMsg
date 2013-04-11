package com.igo.testro.cmn.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.infra.ILoginCheck;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.util.LoginUtil;

/**
 * <p>
 * 프로그램명:LoginCheck.java<br/>
 * 설명 : <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : 안도현 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class LoginCheck implements ILoginCheck {

	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * session logininfo key
	 */
	public static final String USERINFO = "userinfo";
	
	public boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		/*
		ㅇ getSession(true) :
			   Session object를 얻어옴에 있어서 Request에 대한 새로운
			   Session을 create 해줍니다.
		ㅇ getSession(false) :
			   현재의 Session이 존재한다면 그 Session은 그대로 return 해줍니다.
			   Session이 존재하지 않는다면 null로 리턴해 줍니다.
		*/
		if(session == null ) return false;
		LoginDto info = (LoginDto) session.getAttribute(USERINFO);
		//IckContext 
		return (info != null);
	}

	/**
	 * <p>
	 * login userinfo를 받아서 session에 넣어 준다.
	 * </p>
	 * @param request
	 * @param userinfo
	 */
	public void setLoginInfo(HttpServletRequest request, LoginDto userinfo){
		HttpSession session = request.getSession();
		//session.setAttribute("usrid"          ,  userinfo.getUsrid       ()              );         /*사용자id     */
		//session.setAttribute("usrname"        ,  userinfo.getUsrname     ()              );         /*이름        */
		//session.setAttribute("usrlevel"       ,  userinfo.getUsrlevel    ()              );         /*유저레벨      */
		//session.setAttribute("projno"         ,  userinfo.getProjno      ()              );         /*프로젝트번호    */
		//session.setAttribute("projname"       ,  userinfo.getProjname    ()              );         /*프로젝트명     */
		//session.setAttribute("teststgename"   ,  userinfo.getTeststgename()              );         /*테스트 단계명   */
		//session.setAttribute("teststartyms"   ,  userinfo.getTeststartyms()              );         /*테스트 시작일시  */
		//session.setAttribute("testendyms"     ,  userinfo.getTestendyms  ()              );         /*테스트 종료일시  */
		session.setAttribute(USERINFO, userinfo);
	}
	
	/**
	 * <p>
	 * login session을 삭제한다.
	 * </p>
	 * @param request
	 * @param userinfo
	 */
	public void delLoginSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	/**
	 * <p>
	 * login userinfo를 받아서 session에 넣어 준다.
	 * </p>
	 * @param request
	 * @param userinfo
	 */
	public LoginDto getLoginInfo(HttpServletRequest request, LoginDto userinfo){
		HttpSession session = request.getSession(false);
		if(session != null){
			return (LoginDto) session.getAttribute(LoginUtil.USERINFO);
		}
		return null;
	}

}
