package com.igo.testro.preference;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.igo.testro.exception.FrameworkException;

/**
 * 
 * <p>
 * 프로그램명:TestroPreference.java<br/>
 * 설명 : Preference 관리 클래스<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroPreference {
	
	private static final String REQUIRED_KEYS = "REQUIRED_KEYS";
	public static final String USER = "user";
	public static final String MASTER = "master";
	public static final String DATA_SOURCE = "dataSource";
	public static final String LOG = "log";
	public static final String FRAMEWORK = "framework";
	private static final String TESTRO_CONFIG_PATH = "/com/igo/testro/resource/testro_config.prop";
	private static TestroPreference instance = null;
	private Map<String, Map<String, String>> propertyMap= new LinkedHashMap<String, Map<String, String>>();
	private static List<String> MASTER_CONFIG_KEYS = new ArrayList<String>();
	
	/**
	 * 
	 * <p>
	 * TestroPreference 싱글톤 인스턴스 생성
	 * <p>
	 * @return
	 * @throws FrameworkException
	 */
	public static TestroPreference getInstance() throws FrameworkException {
		if (instance == null) {
			synchronized (TestroPreference.class) {
				if (instance == null) {
					instance = new TestroPreference();
				}
			}
		}
		return instance;
	}
	
	private TestroPreference() {
		init();
	}
	
	
	/**
	 * 
	 * <p>
	 * 환경설정값 다시 읽어 오기
	 * <p>
	 */
	public void reload() {
		instance = null;
	}
	
	
	/**
	 * 
	 * <p>
	 * Preference 초기화
	 * <p>
	 * @throws FrameworkException
	 */
	private void init() throws FrameworkException {
		String configPath = System.getProperty("CONFIG_PATH");
		
		if (configPath == null) throw new FrameworkException("[CONFIG_PATH]가 지정되지 않았습니다. System property에 정상적으로 설정되었는지 확인바랍니다.");
		System.out.println("key : [CONFIG_PATH]      value : [" + configPath + "]");
		
		// 1. Framework default config load
		System.out.println("Framework default config load start..");
        BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(TestroPreference.class.getResourceAsStream(TESTRO_CONFIG_PATH));
		inputProperty(bufferedInputStream, FRAMEWORK);
		String requiredKey = propertyMap.get(FRAMEWORK).get(REQUIRED_KEYS);
		
		if (requiredKey != null) {
			String[] requiredKeys = requiredKey.split("[|]");
			for (int i = 0; i < requiredKeys.length; i++) {
				System.out.println("requiredKey : " + requiredKeys[i]);
				// MASTER_CONFIG_KEYS는 유저가 사용할수 없으면 system propetry로 변경이 가능하다.
				MASTER_CONFIG_KEYS.add(requiredKeys[i]);
			}
		}
		System.out.println("Framework default config load end..");
		
        // 2. master_config load
		System.out.println("master_config load start..");
		String masterConfigPath = configPath+"/master_config.prop";
		setFileProperty(masterConfigPath, MASTER);
		System.out.println("master_config load end..");
		
		// 3. data_source_config load
		System.out.println("data_source_config load start..");
		String dataSourceConfigPath = configPath+"/dataSource_config.prop";
		setFileProperty(dataSourceConfigPath, DATA_SOURCE);
		System.out.println("data_source_config load end..");
		
		// 4. log_config load
		System.out.println("log_config load start..");
		String logConfigPath = configPath + "/" + convConfFolder() + "/config.log.prop";
		setFileProperty(logConfigPath, LOG);
		System.out.println("data_source_config load end..");
		
		// 5. System property로 입력한 값을 오버라이드한다.
		// System property 최우선이고 masterProperty로 간주한다.
		System.out.println("System property load start..");
		Map<String, String> masterProp = propertyMap.get(MASTER);
		for (String key : MASTER_CONFIG_KEYS) {
			String value = System.getProperty(key);
			if (value != null && !"".equals(value)) {
				System.out.println("key : [" + key + "]      value : [" + value + "]");
				masterProp.put(key, value);
			}
		}
		System.out.println("System property load end..");
		
		// 6. user_config load
		System.out.println("user_config load start..");
		String userConfigPath = configPath + "/" + convConfFolder() + "/config.user.prop";
		setFileProperty(userConfigPath, USER);
		System.out.println("user_config load end..");
	}

	
	/**
	 * 
	 * <p>
	 * config파일을 타입별로 셋팅해준다.
	 * <p>
	 * @param configPath 파일경로
	 * @param props 프로퍼티객체
	 * @param type 프로퍼티타입
	 */
	private void setFileProperty(String configPath, String type) {
		LinkedProperties props = new LinkedProperties();
        FileInputStream fileInputStream = null;
        try {
			fileInputStream = new FileInputStream(new File(configPath));
			props.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FrameworkException("property loading error..", e);
		} finally {
			try { if (fileInputStream != null) fileInputStream.close();} catch (Exception ignore){}
		}
		
		Map<String, String> hashMap = new LinkedHashMap<String, String>();
		Enumeration<Object> enumeration = props.keys();
		
		while (enumeration.hasMoreElements()) {
			String key = (String)enumeration.nextElement();
			String value = props.getProperty(key);
			System.out.println("key : [" + key + "]      value : [" + value + "]");
			hashMap.put(key, value);
		}
		propertyMap.put(type, hashMap);
	}
	
	/**
	 * 
	 * <p>
	 * 운영모드코드별 폴더명 convert
	 * <p>
	 * @return
	 * @throws FrameworkException
	 */
	public String convConfFolder() throws FrameworkException {
		
		String code = this.propertyMap.get(MASTER).get("SYS_ENV_CD");
		if ("D".equals(code)) {
			return "dev";
		} else if ("T".equals(code)) {
			return "test";
		} else if ("P".equals(code)) {
			return "prod";
		} else {
			throw new FrameworkException("[SYS_ENV_CD]가 지정되지 않았습니다. master_config.prop 에 정상적으로 설정되었는지 확인바랍니다.");
		}
	}

	/**
	 * 
	 * <p>
	 * 프로퍼티 입력
	 * <p>
	 * @param props
	 * @param inputStream
	 * @param propType
	 * @throws FrameworkException
	 */
	private void inputProperty(InputStream inputStream, String propType)
			throws FrameworkException {
		try {
			LinkedProperties props = new LinkedProperties();
			props.load(inputStream);
			
			Map<String, String> hashMap = new LinkedHashMap<String, String>();
			Enumeration<Object> enumeration = props.keys();
	        while (enumeration.hasMoreElements()) {
	        	String key = (String)enumeration.nextElement();
	        	if (isNotMasterConfigKeys(key)) {
	        		String value = props.getProperty(key).trim();
	        		System.out.println("key : [" + key + "]      value : [" + value + "]");
	        		hashMap.put(key, value);
	        	}
	        }
	        
	        propertyMap.put(propType, hashMap);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FrameworkException("inputProperty config loading error..", e);
		} finally {
			try {inputStream.close();} catch (Exception ignore) {}
		}
	}
	
	
	/**
	 * 
	 * <p>
	 * 예약key 여부 확인
	 * <p>
	 * @param key 예약key
	 * @return
	 */
	private boolean isNotMasterConfigKeys(String key) {
		for (String masterkey : MASTER_CONFIG_KEYS) {
			if (masterkey.equals(key)) return false;
		}
		return true;
	}
	
	
	/**
	 * 
	 * <p>
	 * 프로퍼티 값을 얻기온다.
	 * <p>
	 * @param key 프로퍼티key
	 * @return
	 */
	public String getProperty(String key) {
		
		String value = null;
		Iterator<String> iterator = instance.propertyMap.keySet().iterator();
		while (iterator.hasNext()) {
			String propType = iterator.next();
			String tempValue = instance.propertyMap.get(propType).get(key);
			if (tempValue != null && !"".equals(tempValue)) {
				value = tempValue;
			}
		}
		
		return value;
	}
	
	/**
	 * 
	 * <p>
	 * 프로퍼티 값을 얻기온다.
	 * <p>
	 * @param key 프로퍼티key
	 * @param propType 프로퍼티 타입
	 * @return
	 */
	public String getProperty(String key, String propType) {
		return instance.getPropType(propType).get(key);
	}
	
	
	/**
	 * 
	 * <p>
	 * 프로퍼티 타입의 맵을 얻어온다.
	 * <p>
	 * @param propType 프로퍼티 타입
	 * @return
	 */
	public Map<String, String> getPropType(String propType) {
		return instance.propertyMap.get(propType);
	}
	
	/**
	 * 
	 * <p>
	 * 프로퍼티 값을 추가
	 * <p>
	 * @param key 프로퍼티key
	 * @param value 프로퍼티value
	 * @param propType 프로퍼티Type
	 */
	public void setProperty(String key, String value, String propType) {
		instance.propertyMap.get(propType).put(key, value);
	}
	
	
	/**
	 * 
	 * <p>
	 * proertyMap 객체를 가져옴
	 * <p>
	 * @return
	 */
	protected Map<String, Map<String,String>> getPropertyMap() {
		return instance.propertyMap;
	}
	
	/**
	 * 
	 * <p>
	 * proertyMap에서 타입에 해당되는 맵를 가져옴
	 * <p>
	 * @param propType 프로퍼티Type
	 * @return
	 */
	protected Map<String, String> getPropertyMap(String propType) {
		return instance.propertyMap.get(propType);
	}
	
}
