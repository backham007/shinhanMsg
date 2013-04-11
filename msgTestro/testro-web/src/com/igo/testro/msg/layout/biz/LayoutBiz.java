package com.igo.testro.msg.layout.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.layout.dao.LayoutDao;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;

/**
 * 
 * <p>
 * 프로그램명:LayoutBiz.java<br/>
 * 설명 : 전문관리기 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class LayoutBiz implements ILayoutBiz{
	
	@Autowired
	private LayoutDao layoutDao;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();	//logger	
	
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
	@Transactional(readOnly = true)
	public LayoutDto getLayout(String chnlDstcd, String tranCd, String fldIO){
	
		try{
			
			//전문레이아웃기본정보조회
			LayoutDto layout = layoutDao.getLayoutBasic(chnlDstcd, tranCd);
			
			if(layout != null){	//레이아웃이 존재할경우
				layout.setHeaderList(new ArrayList());
				layout.setInviList(new ArrayList());
				
				layout.setInviList(layoutDao.getListLayoutDetail(layout.getChnlDstcd(), layout.getTranCd(), fldIO));	//개별부상세조회
				if("02".equals(layout.getFldDiv()) && layout.getRefTranCd() != null){	//개별부 레이아웃이고 헤더부참조코드가 입력되어 있을경우
					layout.setHeaderList(layoutDao.getListLayoutDetail(layout.getChnlDstcd(), layout.getRefTranCd(), fldIO));	//헤더부상세조회
				}
				
			}
			
			return layout;
		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_LAYOUT0001","", e);
		}
	}
	
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
	@Transactional(readOnly = true)
	public LayoutDto getLayoutCnt(String chnlDstcd, String tranCd){
		
		try{
		
			//전문레이아웃기본정보조회
			LayoutDto layout = layoutDao.getLayoutBasic(chnlDstcd, tranCd);
			
			return layout;
		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_LAYOUT0004","", e);
		}
	}
	
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
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerLayout(HttpServletRequest request, LayoutDto layoutDto){
		
		try{
			
			//세션정보
			LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
			
			//전문레이아웃삭제
			if(layoutDao.deleteLayout(layoutDto.getChnlDstcd(), layoutDto.getTranCd()) == 0){
				//전문신규입력일때 작성자와 생성일시를 세팅한다
				layoutDto.setWriteId(userinfoDto.getUsrid());	//작성자ID
				layoutDto.setWriteName(userinfoDto.getUsrname());	//작성자명
				layoutDto.setCretnYMS(DateUtil.getDateString());	//생성일시
				
				layoutDto.setLastModfiId(userinfoDto.getUsrid());	//최종변경자ID
				layoutDto.setLastModfiYMS(DateUtil.getDateString());	//최종변경일시
				
				layoutDao.registerLayout(layoutDto);	//전문레이아웃저장
				layoutDao.registerLayoutLog(layoutDto, "INSERT");	//레이아웃변경 로그
			} else {
				//전문수정
				layoutDto.setLastModfiId(userinfoDto.getUsrid());	//최종변경자ID
				layoutDto.setLastModfiYMS(DateUtil.getDateString());	//최종변경일시
				
				layoutDao.registerLayout(layoutDto);	//전문레이아웃저장
				
				//변경자
				layoutDto.setWriteId(userinfoDto.getUsrid());	//작성자ID
				layoutDto.setWriteName(userinfoDto.getUsrname());	//작성자명
				layoutDao.registerLayoutLog(layoutDto, "UPDATE");	//레이아웃변경 로그
			}
		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_LAYOUT0002","", e);
		}
	}
	
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
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteLayout(HttpServletRequest request, String chnlDstcd, String tranCd, String tranName){
		
		try{
		
			layoutDao.deleteLayout(chnlDstcd, tranCd);	//전문레이아웃삭제
			
			//세션정보
			LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
			
			LayoutDto layoutDto = new LayoutDto();
			layoutDto.setChnlDstcd(chnlDstcd);
			layoutDto.setTranCd(tranCd);
			layoutDto.setTranName(tranName);
			layoutDto.setWriteId(userinfoDto.getUsrid());
			layoutDto.setWriteName(userinfoDto.getUsrname());
			layoutDto.setLastModfiYMS(DateUtil.getDateString());
			
			layoutDao.registerLayoutLog(layoutDto, "DELETE");	//레이아웃변경 로그
			
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_LAYOUT0003","", e);
		}
	}

	
	/**
	 * <p>
	 * 레이아웃 목록조회
	 * <p>
	 * @param request 거래코드, 거래명
	 * @return
	 */
	public Map<String, Object> getListLayout(HttpServletRequest request){
		
		try{
		
			Map<String, Object> outputMap = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			param.put("chnlDstcd", request.getParameter("chnlDstcd"));
			param.put("tranCd", request.getParameter("tranCd"));
			param.put("tranName", request.getParameter("tranName"));
			param.put("fldDiv", request.getParameter("fldDiv"));
			
			ArrayList<LayoutDto> dlist= layoutDao.getListLayout(param);
			int totcnt = layoutDao.getCnt(param);
			
			outputMap.put("rows", dlist );                          //조회된 list 데이터
			outputMap.put("records", totcnt);                       //조회된 총건수
			outputMap.put("page", page);                            // 조회 요청페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));//총 페이지수
			return outputMap;
		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_LAYOUT0005","", e);
		}
	}
	
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
	@Transactional(readOnly = true)
	public List<LayoutDetailDto> getListRptLayout(String chnlDstcd, String tranCd, String fldDiv, String fldName){
		
		try{
		
			//전문레이아웃기본정보조회
			LayoutDto layout = layoutDao.getLayoutBasic(chnlDstcd, tranCd);
			
			List<LayoutDetailDto> LayoutDetailDtoList = null;
			
			if(layout != null){	//레이아웃이 존재할경우
				if("01".equals(fldDiv)){	//헤더부
					LayoutDetailDtoList = layoutDao.getListLayoutDetail(chnlDstcd, layout.getRefTranCd(), "I", fldName);	//헤더부상세조회
				} else if("02".equals(fldDiv)){	//개별부
					LayoutDetailDtoList = layoutDao.getListLayoutDetail(chnlDstcd, tranCd, "I", fldName);	//개별부상세조회
				}
			}
			
			return LayoutDetailDtoList;
		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_LAYOUT0006","", e);
		}
	}
}
 