package com.igo.testro.cmn.sysmng.dto;

import com.igo.testro.dto.AbstractDTO;

public class DBConfMngDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	// 데이터소스명
	private String dsName;
	
	// 데이터소스타입 (jdbc, jndi)
	private String type;
	
	// 트랜잭션 매니저 사용여부
	private String transaction;
	
	// sqlmap config 경로
	private String configLocation;
	
	// jndi명
	private String jndiName;
	
	// 접속 URL
	private String url;
	
	// 드라이버클래스명
	private String driverClassName;
	
	// 사용자명
	private String username;
	
	// 비밀번호
	private String password;
	
	/**
	 * 설정을 하지 않을 경우 디폴트로 0으로 설정된다.</br>
	 * 초기화시 생성되는 connection 객체의 개수를 의미한다.</br>
	 * MaxIdle<InitialSize 일 경우 MaxIdle만큼생성하여 idle상태로 만들고 나머지는 버려진다.</br>
	 * 최초에 connection을 가져올 경우, idle상태의 connection을 가져온다</br>
	 * 
	 */
	private String initialSize;
	
	/**
	 * 설정을 하지 않을 경우 디폴트로 8로 설정된다.</br>
	 * 동시에 동작할수 있는 최대 connection 개수를 의미하며 값이상의 connection을 요구할경우 반환할때까지 락이 걸린다.</br>
	 * 
	 */
	private String maxActive;
	
	/**
	 * 설정을 하지 않을 경우 디폴트로 0으로 설정된다.</br>
	 * idle상태를 유지하는 최대 개수를 의미한다.<br/>
	 * 
	 */
	private String maxIdle;
	
	/**
	 * 설정을 하지 않을 경우 디폴트로 0으로 설정된다.<br/>
	 * evict요청이 왔을때 최소한으로 유지해야 하는 idle상태의 connection객체의 개수를 의미<br/>
	 * 
	 */
	private String minIdle;
	
	
	/**
	 * 설정을 하지 않을 경우 디폴트로 1800000Millis(30분)로 설정된다.<br/>
	 * evict요청이 왔을때 MinEvictableIdleTimeMillis으로 기준으로 생성된지 오래된 idle객체를 제거한다.<br/>
	 * (즉 , MinEvictableIdleTimeMillis < (evit()요청한 현재시간 - idle객체가 생성된 시간))<br/>
	 * 
	 */
	private String minEvictableIdleTimeMillis;
	
	/**
	 * 설정을 하지 않을 경우 디폴트로 -1L로 설정된다.<br/>
	 * evict요청 주기를 의미한다.<br/>
	 * 
	 */
	private String timeBetweenEvictionRunsMillis;

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String string) {
		this.transaction = string;
	}

	public String getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}

	public String getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}

	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}
	
	

}
