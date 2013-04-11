package com.igo.testro.msg.myjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * ���α׷���:MyJobController.java<br/>
 * ���� : �����ֱ��۾���ȸ controller<br/>
 * �����̷�<br/>
 * <ul>
 *	  <li>2012. 2. 22. : �ȵ��� : �����ۼ�
 * </ul> 
 * </p>
 */
@Controller
public class MyJobController {
	/**
	 * <p>
	 * �ֱ��۾���ȸ �������� ȣ��
	 * <p>
	 * @return
	 */
	@RequestMapping("msg.myjob.myRecentJob.do")
	public ModelAndView getlistV(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
