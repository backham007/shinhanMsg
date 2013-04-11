package com.igo.testro.msg.tsmng.biz;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.bean.util.TestroBeanUtil;
import com.igo.testro.cmn.login.dao.LoginDao;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.execute.biz.TestDataExecuteBiz;
import com.igo.testro.msg.cmn.execute.dto.RptTestDataBasicDTO;
import com.igo.testro.msg.tsmng.dao.TsExecuteDao;
import com.igo.testro.msg.tsmng.dao.TsMngDao;
import com.igo.testro.msg.tsmng.dto.IODataUseDTO;
import com.igo.testro.msg.tsmng.dto.RptSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.RptSnrioDetailDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioDetailDTO;

/**
 * <p>
 * 프로그램명:TsExecuteBiz.java<br/>
 * 설명 : 테스트시나리오 실행 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TsExecuteBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private TsMngDao tsMngDao;
	@Autowired
	private TsExecuteDao tsExecuteDao;
	@Autowired
	private TestDataExecuteBiz testDataExecuteBiz;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private TsMngBiz tsMngBiz;
	
	
	/**
	 * <p>
	 * 테스트시나리오 기본실적을 저장한다.
	 * <p>
	 * @param tsSnrioID - 테스트 시나리오 아이디
	 * @param loginDto - 로그인 사용자 정보
	 * @return 테스트시나리오 기본실적 정보
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized RptSnrioBasicDTO registerRptSnrio(String tsSnrioID, LoginDto loginDto) {
		RptSnrioBasicDTO rptSnrioBasicDTO = new RptSnrioBasicDTO();
		try {
			String currentDate = DateUtil.getDateString();
			TestSnrioBasicDTO testSnrioBasicDTO = tsMngDao.getTsBasicInfo(tsSnrioID);
			
			BeanUtils.copyProperties(rptSnrioBasicDTO, testSnrioBasicDTO);
			rptSnrioBasicDTO.setAcmplNth(tsExecuteDao.getRptSnrioNextAcmplNth(tsSnrioID));
			rptSnrioBasicDTO.setConnSevrDstcd(loginDto.getConnsevrdstcd());
			rptSnrioBasicDTO.setProjNo(loginDto.getProjno());
			rptSnrioBasicDTO.setProjName(loginDto.getProjname());
			rptSnrioBasicDTO.setTstrID(loginDto.getUsrid());
			rptSnrioBasicDTO.setTstrName(loginDto.getUsrname());
			rptSnrioBasicDTO.setRsultSucssYN("");
			rptSnrioBasicDTO.setRsultMsg("");
			rptSnrioBasicDTO.setRsultImgFileYN("");
			rptSnrioBasicDTO.setTestStartYMS(currentDate);
			rptSnrioBasicDTO.setTestEndYMS("");
			rptSnrioBasicDTO.setTestStgeName(loginDto.getTeststgename());
			rptSnrioBasicDTO.setWriteID(loginDto.getUsrid());
			rptSnrioBasicDTO.setWriteName(loginDto.getUsrname());
			rptSnrioBasicDTO.setCretnYMS(currentDate);
			rptSnrioBasicDTO.setLastModfiID(loginDto.getUsrid());
			rptSnrioBasicDTO.setLastModfiYMS(currentDate);
			rptSnrioBasicDTO.setRmark("");
			rptSnrioBasicDTO.setRptSnrioDetailDTOs(new ArrayList<RptSnrioDetailDTO>());
			
			tsExecuteDao.registerRptSnrio(rptSnrioBasicDTO);
		} catch (IllegalAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_EXECUT0002","", e);
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_EXECUT0002","", e);
		}
		
		return rptSnrioBasicDTO;
	}

	/**
	 * <p>
	 * 테스트 데이터를 실행한다.
	 * <p>
	 * @param testSnrioDetailDTO - 테스트 시나리오 상세정보
	 * @param loginDto - 로그인 사용자 정보
	 * @param rptSnrioBasicDTO - 테스트시나리오 기본실적 정보
	 * @param ioDataUseDTOs - 입출력값 정보
	 * @return 테스트 시나리오 상세실적정보
	 */
	public RptSnrioDetailDTO executeTestData(TestSnrioDetailDTO testSnrioDetailDTO, LoginDto loginDto, RptSnrioBasicDTO rptSnrioBasicDTO, List<IODataUseDTO> ioDataUseDTOs) {
		RptSnrioDetailDTO rptSnrioDetailDTO = new RptSnrioDetailDTO();
		try {
			
			RptTestDataBasicDTO rptTestDataBasicDTO = null;
			
			if(ioDataUseDTOs.size() > 0){
				rptTestDataBasicDTO = testDataExecuteBiz.executeTestData(testSnrioDetailDTO.getTsdataID(), loginDto, rptSnrioBasicDTO, ioDataUseDTOs);
			}else{
				rptTestDataBasicDTO = testDataExecuteBiz.executeTestData(testSnrioDetailDTO.getTsdataID(), loginDto);
			}
			
			BeanUtils.copyProperties(rptSnrioDetailDTO, testSnrioDetailDTO);
			rptSnrioDetailDTO.setTsdataAcmplNth(rptTestDataBasicDTO.getAcmplNth());
			rptSnrioDetailDTO.setRsultSucssYN(rptTestDataBasicDTO.getRsultSucssYN());
			rptSnrioDetailDTO.setChkYN(rptTestDataBasicDTO.getChkYN());
			rptSnrioDetailDTO.setLastModfiID(loginDto.getUsrid());
			rptSnrioDetailDTO.setLastModfiYMS(rptTestDataBasicDTO.getLastModfiYMS());
			rptSnrioDetailDTO.setRmark("");
			
			rptSnrioDetailDTO.setInputRptTestDataDetailDTOs(rptTestDataBasicDTO.getInputRptTestDataDetailDTOs());
			rptSnrioDetailDTO.setOutputRptTestDataDetailDTOs(rptTestDataBasicDTO.getOutputRptTestDataDetailDTOs());
		} catch (IllegalAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_EXECUT0002","", e);
		} catch (InvocationTargetException e) {
			logger.error("", e);
			throw new BizException("MSG_EXECUT0002","", e);
		}
		
		return rptSnrioDetailDTO;
	}
	
	/**
	 * <p>
	 * 테스트 시나리오 기본실적정보를 수정한다.
	 * <p>
	 * @param rptSnrioBasicDTO - 테스트시나리오기본실적정보
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void modifyRptSnrio(RptSnrioBasicDTO rptSnrioBasicDTO) {
		String currentDate = DateUtil.getDateString();
		rptSnrioBasicDTO.setTestEndYMS(currentDate);
		
		tsExecuteDao.modifyRptSnrio(rptSnrioBasicDTO);
		
		for(RptSnrioDetailDTO dto : rptSnrioBasicDTO.getRptSnrioDetailDTOs()){
			tsExecuteDao.registerRptSnrioDetail(dto);
		}
	}
	
	/**
	 * <p>
	 * 테스트 시나리오를 실행한다.
	 * <p>
	 * @param tsSnrioID - 테스트시나리오 ID
	 * @param usrID - 사용자 아이디
	 * @return 테스트시나리오기본실적 수행회차 
	 */
	public long executeTsSnrio(String tsSnrioID, String usrID, String connSevrDstCd) {
		LoginDto loginDto = loginDao.getUserIdInfo(usrID);
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("usrid", usrID);
		if(connSevrDstCd != null){
			loginDto.setConnsevrdstcd(connSevrDstCd);
		}
		TestroBeanUtil.copyDtoToBean(loginDao.getprojectinfo(param), loginDto);
				
		//테스트시나리오 가져오기
		TestSnrioBasicDTO testSnrioBasicDTO = tsMngBiz.getTsInfo(tsSnrioID);
		
		//테스트시나리오 기본 실적 저장
		RptSnrioBasicDTO rptSnrioBasicDTO = this.registerRptSnrio(tsSnrioID, loginDto);
		List<RptSnrioDetailDTO> rptSnrioDetailDTOs = new ArrayList<RptSnrioDetailDTO>();
		rptSnrioBasicDTO.setRptSnrioDetailDTOs(rptSnrioDetailDTOs);
		
		for(TestSnrioDetailDTO testSnrioDetailDTO : testSnrioBasicDTO.getTestSnrioDetailDTOList()){
			List<IODataUseDTO> ioDataUseDTOs = new ArrayList<IODataUseDTO>();
			if("Y".equals(testSnrioDetailDTO.getUseIO())){
				ioDataUseDTOs = testSnrioDetailDTO.getIoDataUseDTOList();
			}
			
			RptSnrioDetailDTO rptSnrioDetailDTO = this.executeTestData(testSnrioDetailDTO, loginDto, rptSnrioBasicDTO, ioDataUseDTOs);
			rptSnrioDetailDTO.setTsSnrioID(rptSnrioBasicDTO.getTsSnrioID());
			rptSnrioDetailDTO.setAcmplNth(rptSnrioBasicDTO.getAcmplNth());
			
			rptSnrioBasicDTO.getRptSnrioDetailDTOs().add(rptSnrioDetailDTO);
			
			if("N".equals(rptSnrioDetailDTO.getRsultSucssYN())){
				rptSnrioBasicDTO.setRsultSucssYN("N");
			}
		}
		
		//최종으로 성공실패여부 저장
		if(rptSnrioBasicDTO.getRsultSucssYN() == null || "".equals(rptSnrioBasicDTO.getRsultSucssYN())){
			rptSnrioBasicDTO.setRsultSucssYN("Y");
		}
		this.modifyRptSnrio(rptSnrioBasicDTO);
		
		return rptSnrioBasicDTO.getAcmplNth();
	}
}
