package com.igo.testro.msg.layout.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;

/**
 * 
 * <p>
 * 프로그램명:ILayoutBiz.java<br/>
 * 설명 : 전문관리기Biz Interface<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 4. 2. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public interface ILayoutBiz {
	/**
	 * 
	 * <p>
	 * 전문레이아웃조회
	 * <p>
	 * <p>레이아웃기본정보조회 후 기본정보가 조회된경우 상세개별부를 조회한다
	 * <p>개별부 레이아웃이고 헤더부참조코드가 입력되어 있을경우 상세 해더부를 조회한다
	 * 
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @param fldIO 입출력 구분 (I:입력,O:출력,null:전체)
	 * @return LayoutDto 전문레이아웃DTO
	 */
	public LayoutDto getLayout(String chnlDstcd, String tranCd, String fldIO);
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃조회 건수
	 * <p>
	 * <p>전문기본정보의 건수를 조회한다
	 * 
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @return LayoutDto 전문레이아웃DTO
	 */
	public LayoutDto getLayoutCnt(String chnlDstcd, String tranCd);
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃 저장
	 * <p>
	 * <p>입력할 레이아웃을 삭제한다
	 * <p>신규입력일 경우 작성자와 생성일시를 세팅하고 레이아웃을 입력한 후 레이아웃변경로그에 INSERT정보를 입력한다
	 * <p>수정일 경우 레이아웃을 입력한 후 레이아웃변경로그에 UPDATE정보를 입력한다
	 * 
	 * @param request HttpServletRequest
	 * @param layoutDto 전문레이아웃DTO
	 */
	public void registerLayout(HttpServletRequest request, LayoutDto layoutDto);
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃삭제
	 * <p>
	 * <p>전문레이아웃을 삭제한다
	 * <p>레이아웃변경로그에 DELETE정보를 입력한다
	 * 
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @param tranName 거래명
	 */
	public void deleteLayout(HttpServletRequest request, String chnlDstcd, String tranCd, String tranName);
	
	/**
	 * <p>
	 * 레이아웃 목록조회
	 * <p>
	 * @param request 거래코드, 거래명
	 * @return
	 */
	public Map<String, Object> getListLayout(HttpServletRequest request);
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃 반복부필드조회
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @param fldDiv 필드구성(01:헤더,02:개별)
	 * @param fldName 필드명(반복회차의 필드명)
	 * @return List<LayoutDetailDto> 전문레이아웃상세DTO 
	 */
	public List<LayoutDetailDto> getListRptLayout(String chnlDstcd, String tranCd, String fldDiv, String fldName);
}
