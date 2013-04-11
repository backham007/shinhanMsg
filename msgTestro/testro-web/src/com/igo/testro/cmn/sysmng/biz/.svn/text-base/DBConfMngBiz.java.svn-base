package com.igo.testro.cmn.sysmng.biz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.igo.testro.bean.util.TestroBeanUtil;
import com.igo.testro.cmn.sysmng.dto.DBConfMngDto;
import com.igo.testro.constant.PropertyKey;
import com.igo.testro.das.SqlMapper;
import com.igo.testro.exception.BizException;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.preference.LinkedProperties;
import com.igo.testro.preference.TestroPreference;
import com.igo.testro.service.ServiceFinder;

/**
 * 
 * <p>
 * 프로그램명:DBConfMngBiz.java<br/>
 * 설명 : DB설정관리 BIZ<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class DBConfMngBiz {
	
	private static final String DATA_SOURCE_CONFIG_PROP = "dataSource_config.prop";
	private static final String PROP = ".prop";
	private static final String DATA_SOURCE = "dataSource.";
	private static final String DS_NAME = "dsName";
	private static final String TRANSACTION_MANAGER = "transactionManager";
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * 
	 * <p>
	 * DB설정정보 리스트 조회
	 * <p>
	 * @return DB설정정보 리스트 및 그리드 페이징 변수
	 */
	public Map<String, Object> getListDBConfInfo() {
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		String dataSourceList = TestroPreference.getInstance().getProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), TestroPreference.DATA_SOURCE);
		String[] strDataSourceList = dataSourceList.split("[|]");
		List<DBConfMngDto> dbConfMngDtos = new ArrayList<DBConfMngDto>();
		
		for (String dsName : strDataSourceList) {
			DBConfMngDto dBconfInfo = getDBconfInfo(dsName);
			dBconfInfo.setDsName(dsName);
			dbConfMngDtos.add(dBconfInfo);
		}
		
		outputMap.put("rows", dbConfMngDtos );
		outputMap.put("records", dbConfMngDtos.size());
		outputMap.put("page", 1);
		outputMap.put("total",  1);
		return outputMap;
	}
	
	/**
	 * 
	 * <p>
	 * dsName에 해당되는 연결정보를 가져온다
	 * <p>
	 * @param dsName 데이터소스명
	 * @return 데이터소스정보
	 */
	private DBConfMngDto getDBconfInfo(String dsName) {
		String configPath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
		String confingName = DATA_SOURCE + dsName + PROP;
		String detailDsInfoPath = configPath + "/" + TestroPreference.getInstance().convConfFolder() + "/" + confingName;
		
		LinkedProperties props = new LinkedProperties();
        FileInputStream fileInputStream = null;
        try {
			fileInputStream = new FileInputStream(new File(detailDsInfoPath));
			props.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FrameworkException("property loading error..", e);
		} finally {
			try { if (fileInputStream != null) fileInputStream.close();} catch (Exception ignore){}
		}
		
		DBConfMngDto dbConfMngDto = new DBConfMngDto();
		TestroBeanUtil.copyPropeToBean(props, dbConfMngDto);
		return dbConfMngDto;
	}
	
	/**
	 * 
	 * <p>
	 * 데이터소스의 연결정보를 저장한다.
	 * <p>
	 * @param confMngDto DB설정관리 DTO
	 */
	public void modifyDBConfInfo(DBConfMngDto confMngDto) {
		
		String dataSourceList = TestroPreference.getInstance().
			getProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), TestroPreference.DATA_SOURCE);
		String[] dataSources = dataSourceList.split("[|]");
		
		boolean existDsName = false;
		
		for (String ds : dataSources) {
			if (confMngDto.getDsName().equals(ds)) {
				existDsName = true;
				break;
			}
		}
		
		LinkedProperties linkedProperties = new LinkedProperties();
		TestroBeanUtil.copyDtoToPropery(confMngDto, linkedProperties);
		
		// 기존 데이터소스의 정보가 수정될 경우
		if (existDsName) {
			
			// 동적으로 datasource와 slqMapClient를 생성 시킨다.
			modifyDataSource(confMngDto, linkedProperties);
			
			// 상세 파일저장
			String dbConfFilePath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
			dbConfFilePath = dbConfFilePath + "/" + TestroPreference.getInstance().convConfFolder() + "/";
			dbConfFilePath = dbConfFilePath + DATA_SOURCE + confMngDto.getDsName() + PROP;
			createConfFile(confMngDto, linkedProperties, dbConfFilePath);
		
		// 새롭게 데이터소스를 추가했을 경우	
		} else {
			
			// 동적으로 datasource와 slqMapClient를 생성 시킨다.
			modifyDataSource(confMngDto, linkedProperties);
			
			
			// dataSource파일 저장
			String dsFilePath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
			dsFilePath = dsFilePath + "/" + DATA_SOURCE_CONFIG_PROP;
			LinkedProperties dsProp = new LinkedProperties();
			if ("".equals(dataSourceList)) {
				dataSourceList = confMngDto.getDsName();
			} else {
				dataSourceList = dataSourceList + "|" + confMngDto.getDsName();
			}
			dsProp.setProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), dataSourceList);
			createConfFile(confMngDto, dsProp, dsFilePath);
			TestroPreference.getInstance().setProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), dataSourceList, TestroPreference.DATA_SOURCE);
			
			
			// 상세 파일저장
			String dbConfFilePath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
			dbConfFilePath = dbConfFilePath + "/" + TestroPreference.getInstance().convConfFolder() + "/";
			dbConfFilePath = dbConfFilePath + DATA_SOURCE + confMngDto.getDsName() + PROP;
			createConfFile(confMngDto, linkedProperties, dbConfFilePath);
			
			
		}
		
	}
	
	/**
	 * 
	 * <p>
	 * DataSource 삭제
	 * <p>
	 * @param confMngDto DB설정관리 DTO
	 */
	public void deleteDBconfInfo(DBConfMngDto confMngDto) {
		
		String dsName = confMngDto.getDsName();
		String dataSourceList = TestroPreference.getInstance().
		getProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), TestroPreference.DATA_SOURCE);
		
		String[] dataSources = dataSourceList.split("[|]");
		
		// 먼저 삭제대상 데이터명이 존재하는지 확인하고 없으면 그냥 리턴해준다.
		boolean isExist = false;
		for (String propDsName : dataSources) {
			if (dsName.equals(propDsName)) {
				isExist = true;
				break;
			}
		}
		
		if (!isExist) {
			if (logger.isDebugEnabled()) logger.debug("[" + dsName + "] : 해당 데이터소스는 존재하지 않습니다.");
			return;
		}

		SqlMapper.getInstance().deleteTestroSqlMapClient(dsName);
		String newDataSourceList = "";
		
		for (String propDsName : dataSources) {
			if (dsName.equals(propDsName)) {
				continue;
			}
			
			newDataSourceList =  newDataSourceList + "|" + propDsName;
		}
		
		newDataSourceList = newDataSourceList.substring(1);
		
		// 데이터소스 리스트 설정파일 갱신
		String dsFilePath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
		dsFilePath = dsFilePath + "/" + DATA_SOURCE_CONFIG_PROP;
		LinkedProperties dsProp = new LinkedProperties();
		dsProp.setProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), newDataSourceList);
		createConfFile(confMngDto, dsProp, dsFilePath);
		TestroPreference.getInstance().setProperty(PropertyKey.DATA_SOURCE_LIST.getCode(), newDataSourceList, TestroPreference.DATA_SOURCE);
		
		// DB상세정보파일 삭제
		String dbConfFilePath = TestroPreference.getInstance().getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
		dbConfFilePath = dbConfFilePath + "/" + TestroPreference.getInstance().convConfFolder() + "/";
		dbConfFilePath = dbConfFilePath + DATA_SOURCE + confMngDto.getDsName() + PROP;
		File dbConfFile = new File(dbConfFilePath);
		dbConfFile.delete();
	}
	
	/**
	 * 
	 * <p>
	 * 설정파일 생성
	 * <p>
	 * @param confMngDto DB설정관리 DTO
	 * @param linkedProperties 프로퍼티 객체
	 * @param filePath 저장할 파일경로
	 */
	private void createConfFile(DBConfMngDto confMngDto,
			LinkedProperties linkedProperties, String filePath) {
		// 변견되 내용을 파일로 저정한다.
		BufferedWriter bufferedWriter = null;
		try {
			
			if (logger.isDebugEnabled()) logger.debug("userConfFilePath : [" + filePath + "]");
			
			Enumeration<Object> keys = linkedProperties.keys();
			
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(filePath)),"UTF-8"));
			
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				if (DS_NAME.equals(key)) continue;
				String strLine = key + "=" + linkedProperties.getProperty(key);
				bufferedWriter.write(strLine);
				bufferedWriter.newLine();
				
			}
			bufferedWriter.flush();
		} catch (IOException e) {
			logger.error("", e);
			throw new BizException("MSG_SYSMNG0002","", e);
		} finally {
			try {if (bufferedWriter != null) bufferedWriter.close();} catch (Exception ignore) {}
		}
	}
	
	/**
	 * 
	 * <p>
	 * DataSource 동적 변경
	 * <p>
	 * @param confMngDto DB설정관리 DTO
	 * @param linkedProperties 프로퍼티 객체
	 */
	private void modifyDataSource(DBConfMngDto confMngDto, LinkedProperties linkedProperties) {
		SqlMapper.getInstance().createTransMng(confMngDto.getDsName(), linkedProperties);
		DataSourceTransactionManager service = (DataSourceTransactionManager) ServiceFinder.getInstance().getService(TRANSACTION_MANAGER);
		service.setDataSource(SqlMapper.getInstance().getTranDs());
	}

	
}
