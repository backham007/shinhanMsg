package com.igo.testro.msg.cmn.execute.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.msg.cmn.execute.dto.ExecuteDto;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;

/**
 * 
 * <p>
 * 프로그램명:IExecuteBiz.java<br/>
 * 설명 : 전문테스트실행 Biz Interface<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 4. 2. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public interface IExecuteBiz {
	
	/**
	 * 
	 * <p>
	 * 테스트실행
	 * <p>
	 * <p>입력된 전문DTO를 Byte배열로 변환한다
	 * <p>변환된 Byte를 송수신한다
	 * <p>수신된 Byte를 DTO로 파싱하여 리턴한다
	 *  
	 * @param connSevrDstcd 접속서버구분코드 
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd	거래코드
	 * @param inputDto	입력전문Dto
	 * @return ExecuteDto 테스트실행Dto
	 */
	public ExecuteDto mciExecute(String connSevrDstcd, String chnlDstcd, String tranCd, TestDataDto inputDto);
}
