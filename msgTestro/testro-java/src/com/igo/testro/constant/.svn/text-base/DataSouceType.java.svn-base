package com.igo.testro.constant;


public enum DataSouceType {
	JDBC("jdbc"),
	JNDI("jndi")
	;
	
	String code;
	
	private DataSouceType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public static DataSouceType getInstance(String c) {
        for(DataSouceType value : DataSouceType.values()) {
            if(value.getCode().equals(c)) {
                return value;
            }
        }

        throw new IllegalArgumentException("No such JobCycle");
    }
}
