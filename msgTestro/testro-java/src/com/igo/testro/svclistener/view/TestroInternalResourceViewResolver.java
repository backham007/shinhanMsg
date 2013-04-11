package com.igo.testro.svclistener.view;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

/**
 * InternalResourceViewResolver wrapper class
 * @author kangwoo
 *
 */
public class TestroInternalResourceViewResolver extends InternalResourceViewResolver{
	
	final ITestroLogger logger = TestroLogHelper.getFramework();
	
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		if (logger.isDebugEnabled()) logger.debug("buildView viewName : [" + viewName + "]");
		
		// "."로 구분된 부분을 폴더의 "/"으로 인식하고 치환하다.
		viewName = viewName.replaceAll("[.]", "/");
		
		if (logger.isDebugEnabled()) logger.debug("buildView replace viewName : [" + viewName + "]");
		return super.buildView(viewName);
	}

}
