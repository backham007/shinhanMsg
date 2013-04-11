package com.igo.testro.preference;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;

import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

public class LinkedProperties extends Properties {
	private static final long serialVersionUID = 1L;
	
	final ITestroLogger logger = TestroLogHelper.getFramework();
	
	private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>(); 
	 
    public Enumeration<Object> keys() { 
        return Collections.<Object>enumeration(keys); 
    } 
 
    public Object put(Object key, Object value) { 
        keys.add(key); 
        return super.put(key, value); 
    }
    
    public String getProperty(String key) {
    	String property = super.getProperty(key);
    	try {
    		property = new String(property.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new FrameworkException("LinkedProperties getProperty ecoding error..", e);
		}
		return property;
    }
    
    
}
