package com.igo.testro.cmn.sysmng.biz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.igo.testro.cmn.dto.GridBaseDto;
import com.igo.testro.cmn.sysmng.dto.SysEnvVarMngDto;
import com.igo.testro.constant.PropertyKey;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.preference.TestroPreference;

/**
 * 
 * <p>
 * 프로그램명:SysEnvVarMngBiz.java<br/>
 * 설명 : 시스템환경변수 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 21. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class SysEnvVarMngBiz {
	
	private static final String CONFIG_USER_PROP = "config.user.prop";
	private static final String SYSTEM = "system";
	final ITestroLogger logger = TestroLogHelper.getBiz();

	/**
	 * 
	 * <p>
	 * 시스템환경변수 조회
	 * <p>
	 * @param gridBaseDto 기본그리드 DTO
	 * @return
	 */
	public Map<String, Object> getListSysConfInfo(GridBaseDto gridBaseDto) {
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		
		ArrayList<SysEnvVarMngDto> sysConfInfoList = new ArrayList<SysEnvVarMngDto>();
		
		String[] typeList = new String[] {TestroPreference.FRAMEWORK, TestroPreference.MASTER, 
				TestroPreference.DATA_SOURCE, TestroPreference.LOG, TestroPreference.USER};
		
		for (int i = 0; i < typeList.length; i++) {
			inputSysEnvVar(typeList[i], sysConfInfoList);
		}
		
		Properties properties = System.getProperties();
		Enumeration<Object> keys = properties.keys();
		while (keys.hasMoreElements()) {
			SysEnvVarMngDto sysEnvVarMngDto = new SysEnvVarMngDto();
			String key = (String) keys.nextElement();
			String value = (String) properties.get(key);
			sysEnvVarMngDto.setType(SYSTEM);
			sysEnvVarMngDto.setSysEnvVar(key);
			sysEnvVarMngDto.setSysEnvVarValue(value);
			sysConfInfoList.add(sysEnvVarMngDto);
		}
		
		outputMap.put("rows", sysConfInfoList );
		outputMap.put("records", sysConfInfoList.size());
		outputMap.put("page", 1);
		outputMap.put("total",  1);
		return outputMap;
	}
	
	/**
	 * 
	 * <p>
	 * 시스템환경변수 수정...현재 사용하지 않음
	 * <p>
	 * @param sysConfInfoList 시스템환경변수 리스트
	 */
	public void modifySysConfInfo(List<SysEnvVarMngDto> sysConfInfoList) {
		BufferedWriter bufferedWriter = null;
		try {
			String userConfFilePath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
			userConfFilePath = userConfFilePath + "/" + TestroPreference.getInstance().convConfFolder() + "/" + CONFIG_USER_PROP;
			
			if (logger.isDebugEnabled()) logger.debug("userConfFilePath : [" + userConfFilePath + "]");
			
			for (SysEnvVarMngDto sysEnvVarMngDto : sysConfInfoList) {
				if (!TestroPreference.USER.equals(sysEnvVarMngDto.getType())) continue;
				if (bufferedWriter == null) bufferedWriter = 
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(userConfFilePath)),"UTF-8"));
				String sysEnvVar = sysEnvVarMngDto.getSysEnvVar();
				String sysEnvVarValue = sysEnvVarMngDto.getSysEnvVarValue();
				TestroPreference.getInstance().setProperty(sysEnvVar, sysEnvVarValue, TestroPreference.USER);
				
				String strLine = sysEnvVarMngDto.getSysEnvVar() + "=" + sysEnvVarMngDto.getSysEnvVarValue();
				bufferedWriter.write(strLine);
				bufferedWriter.newLine();
				if (logger.isDebugEnabled()) logger.debug("strLine : [" + strLine + "]");
			}
			bufferedWriter.flush();
		} catch (IOException e) {
			logger.error("", e);
			throw new BizException("MSG_SYSMNG0001", e);
		} finally {
			try {if (bufferedWriter != null) bufferedWriter.close();} catch (Exception ignore) {}
		}
	}
	
	/**
	 * 
	 * <p>
	 * 프로퍼티값을 리스트객체로 만든다.
	 * <p>
	 * @param type 프로퍼티타입
	 * @param sysConfInfoList 리스트객체
	 */
	private void inputSysEnvVar(String type, ArrayList<SysEnvVarMngDto> sysConfInfoList) {
		Map<String, String> propTypeMap = TestroPreference.getInstance().getPropType(type);
		Iterator<String> iterator = propTypeMap.keySet().iterator();
		while (iterator.hasNext()) {
			SysEnvVarMngDto sysEnvVarMngDto = new SysEnvVarMngDto();
			String key = (String) iterator.next();
			sysEnvVarMngDto.setType(type);
			sysEnvVarMngDto.setSysEnvVar(key);
			sysEnvVarMngDto.setSysEnvVarValue(propTypeMap.get(key));
			sysConfInfoList.add(sysEnvVarMngDto);
		}
	}
	
	
	/**
	 * 
	 * <p>
	 * 시스템환경변수 다시불러오기
	 * <p>
	 */
	public void executeReload() {
		TestroPreference.getInstance().reload();
	}
}
