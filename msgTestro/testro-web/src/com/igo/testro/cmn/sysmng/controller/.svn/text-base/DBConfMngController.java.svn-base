package com.igo.testro.cmn.sysmng.controller;

import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.sysmng.biz.DBConfMngBiz;
import com.igo.testro.cmn.sysmng.dto.DBConfMngDto;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;


/**
 * 
 * <p>
 * 프로그램명:SysEnvVarMngController.java<br/>
 * 설명 : 시스템환경변수 관리 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 15. : kangwoo : 최초작성
 *	  <li>2012. 3. 19. : kangwoo : 주석보완
 * </ul> 
 * </p>
 */
@Controller
public class DBConfMngController {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private DBConfMngBiz dbConfMngBiz;
	
	
	/**
	 * 
	 * <p>
	 * 시스템환경변수 관리
	 * <p>
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="cmn.sysmng.dBConfMng.do")
	@LogInfo(description="시스템환경변수 관리 화면 호출")
	private void SysEnvVarMng(){
	}
	
	
	/**
	 * 
	 * <p>
	 * 데이터소스 조회
	 * <p>
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.getListDBConfInfo.do")
	@LogInfo(description="데이터소스를 조회한다.")
	public ModelAndView getListDBConfInfo() {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> sysConfInfoList = dbConfMngBiz.getListDBConfInfo();
		mav.addAllObjects(sysConfInfoList);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 데이터소스정보를 수정한다.
	 * <p>
	 * @param jgGridData 데이터소스정보 JSON String
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.modifyDBConfInfo.do")
	@LogInfo(description="데이터소스정보를 수정한다.")
	public ModelAndView modifyDBConfInfo(@RequestParam("jgGridData") String jgGridData) {
		ModelAndView mav = new ModelAndView();
		JSONObject fromObject = JSONObject.fromObject(jgGridData);
		DBConfMngDto dbConfInfo = (DBConfMngDto)JSONObject.toBean(fromObject, DBConfMngDto.class);
		dbConfMngBiz.modifyDBConfInfo(dbConfInfo);
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 데이터소스정보를 삭제한다.
	 * <p>
	 * @param jgGridData 데이터소스정보 JSON String
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.deleteDBconfInfo.do")
	@LogInfo(description="데이터소스정보를 삭제한다.")
	public ModelAndView deleteDBconfInfo(@RequestParam("jgGridData") String jgGridData) {
		ModelAndView mav = new ModelAndView();
		JSONObject fromObject = JSONObject.fromObject(jgGridData);
		DBConfMngDto dbConfInfo = (DBConfMngDto)JSONObject.toBean(fromObject, DBConfMngDto.class);
		dbConfMngBiz.deleteDBconfInfo(dbConfInfo);
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
		
	}
}
