package com.igo.testro.constant;


public enum PropertyKey {
	CONFIG_PATH("CONFIG_PATH"),
	DATA_SOURCE_LIST("DATA_SOURCE_LIST"),
	WAS_URL_ENCODING("WAS_URL_ENCODING"),
	LOGIN_CHECK_YN("LOGIN_CHECK_YN")
	;
	
	String code;
	
	private PropertyKey(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public static PropertyKey getInstance(String c) {
        for(PropertyKey value : PropertyKey.values()) {
            if(value.getCode().equals(c)) {
                return value;
            }
        }

        throw new IllegalArgumentException("No such JobCycle");
    }
}
