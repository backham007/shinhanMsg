package com.igo.testro.msg.cmn.biz;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.msg.cmn.dao.MngSeqIdDao;

/**
 * <p>
 * 프로그램명:MngSeqIdBiz.java<br/>
 * 설명 : seq ID 관리 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class MngSeqIdBiz {
	@Autowired
	private MngSeqIdDao mngSeqIdDao;
	
	public static final String[] TEST_SNRO = {"S", "TESSNRO01", "TSSNRIOID"};
	public static final String[] TEST_CASE = {"C", "TESCASE01", "TSCASEID"};
	public static final String[] TEST_DATA = {"D", "TESDATA01", "TSDATAID"};
	public static final String[] TEST_DATA3 = {"B", "TESDATA03", "TSDATAID"};
	public static final String[] TEST_DATA5 = {"T", "TESDATA05", "TSDATAID"};
	
	public static final String TYPE_WEB = "1";
	public static final String TYPE_MSG = "2";
	
	/**
	 * <p>
	 * 새로운 seq ID를 만든다.
	 * <p>
	 * @param table - 테이블 종류
	 * @param type - 1:WEB, 2:전문
	 * @return
	 */
	@Transactional(readOnly = true)
	public String getNewSeqId(String[] table, String type){
		String currentDate = DateUtil.getDateString().substring(0, 8);
		String preCondition = table[0] + type + currentDate;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("preCondition", preCondition);
		params.put("tableName", table[1]);
		params.put("seqIdName", table[2]);
		
		String seqId = mngSeqIdDao.getCurrentSeqId(params);
		String nextSeqId = "";
		if(seqId != null && !"".equals(seqId.trim())){
			int seq = Integer.parseInt(seqId.replaceFirst(preCondition, ""));
			nextSeqId = preCondition + new DecimalFormat("000000").format(seq+1);
		}else{
			nextSeqId = preCondition + "000001";
		}
		
		return nextSeqId;
	}
}
