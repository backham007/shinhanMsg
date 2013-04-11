package com.igo.testro.msg.tsmng.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.igo.testro.msg.tsmng.dao.TsListDao;
import com.igo.testro.msg.tsmng.dto.TestSnrioDetailDTO;

/**
 * <p>
 * 프로그램명:TsListBiz.java<br/>
 * 설명 : 테스트시나리오 불러오기 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TsListBiz {
	
	@Autowired
	private TsListDao tsListDao;

	/**
	 * <p>
	 * Grid를 위한 테스트 시나리오 기본 List 불러오기
	 * <p>
	 * @param params 조회 조건 파라메터
	 * @return Grid 리턴 데이터 
	 */
	public Map<String, Object> getListTsInfo(HashMap<String, Object> params) {
		int startnum = 0;
		int endnum = 0;
		int page = (Integer)params.get("page");
		int rows = (Integer)params.get("rows");
		
		startnum = (page - 1) * rows;
		endnum   = (rows * page);
		
		params.put("startnum", startnum);
		params.put("endnum", endnum);
		
		int totcnt = tsListDao.getTsCnt(params);
		
		//그리드값리턴
		HashMap<String, Object> output = new HashMap<String, Object>();
		output.put("rows", tsListDao.getListTsInfo(params));
		output.put("records", totcnt);
		output.put("page", page);
		output.put("total",  Math.ceil((double)totcnt/rows));
		
		return output;
	}

	/**
	 * <p>
	 * Grid를 위한 테스트 시나리오 상세 List 불러오기
	 * <p>
	 * @param tsSnrioID 조회할 테스트 시나리오 Id
	 * @return Grid 리턴 데이터 
	 */
	public Map<String, Object> getListTsDetailInfo(HashMap<String, Object> params) {
		int startnum = 0;
		int endnum = 0;
		int page = (Integer)params.get("page");
		int rows = (Integer)params.get("rows");
		
		startnum = (page - 1) * rows;
		endnum   = (rows * page);
		
		params.put("startnum", startnum);
		params.put("endnum", endnum);
		
		int totcnt = tsListDao.getTsDetailCnt(params);
		
		//그리드값리턴
		ArrayList<TestSnrioDetailDTO> arrTsDetailInfo = tsListDao.getListTsDetailInfo(params);
		
		for(TestSnrioDetailDTO dto : arrTsDetailInfo){
			dto.setTsSnrioNO(dto.getTsSnrioNO().trim());
		}
		
		HashMap<String, Object> output = new HashMap<String, Object>();
		output.put("rows", arrTsDetailInfo);
		output.put("records", totcnt);
		output.put("page", page);
		output.put("total",  Math.ceil((double)totcnt/rows));
		
		return output;
	}
	
	/**
	 * <p>
	 * 특수문자 제거
	 * <p>
	 * @param str - 특수문자를 제거할 String
	 * @return 특수문자를 제거 후 String
	 */
	public String sqlInjectionReplacer(String str){
	    String str_imsi   = ""; 
	    String[] filter_word = {"","\\.","\\?","\\/","\\~","\\!","\\@","\\#","\\$","\\%","\\^","\\&","\\*","\\(","\\)","\\_","\\+","\\=","\\|","\\\\","\\}","\\]","\\{","\\[","\\\"","\\'","\\:","\\;","\\<","\\,","\\>","\\.","\\?","\\/"};
	    for(int i=0;i<filter_word.length;i++){
	        str_imsi = str.replaceAll(filter_word[i],"");
	        str = str_imsi;
	    }
	    return str;
	}
}
