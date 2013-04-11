package com.igo.testro.msg.cmn.execute.dto;

import com.igo.testro.msg.pretst.dto.TestDataDetailDto;

/**
 * <p>
 * 프로그램명:RptTestDataDetailDTO.java<br/>
 * 설명 : 테스트데이터 상세 실적 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@SuppressWarnings("serial")
public class RptTestDataDetailDTO extends TestDataDetailDto{
	private long acmplNth;

	public long getAcmplNth() {
		return acmplNth;
	}

	public void setAcmplNth(long acmplNth) {
		this.acmplNth = acmplNth;
	}
}
