package com.igo.testro.cmn;

import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.svclistener.init.IBootstrap;



public class Bootstrap implements IBootstrap{
	
	ITestroLogger logger = TestroLogHelper.getBootstrap();

	public void Initialized() {
		
	}

	public void destroyed() {
		
	}

}
