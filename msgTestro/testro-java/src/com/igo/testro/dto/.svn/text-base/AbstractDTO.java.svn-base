package com.igo.testro.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * <p>
 * 프로그램명:AbstractDTO.java<br/>
 * 설명 : Formatted Element toString method 제공과, equals, hashCode 제공을 위한 DTO의 abtraction<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2008. 02. 25 : 이강우 : 최초작성
 * </ul> 
 * </p>
 */
public abstract class AbstractDTO implements IDTO {
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
