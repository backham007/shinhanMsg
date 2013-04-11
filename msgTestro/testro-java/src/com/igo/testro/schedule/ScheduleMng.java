package com.igo.testro.schedule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.igo.testro.constant.PropertyKey;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.preference.TestroPreference;
import com.igo.testro.schedule.dto.ScheduleDto;

/**
 * 
 * <p>
 * 프로그램명:ScheduleMng.java<br/>
 * 설명 : 스퀘줄 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 22. : kangwoo : 내용
 * </ul> 
 * </p>
 */
public class ScheduleMng {
	
	
	private static final String CONFIG_SCHEDULE_XML = "config.schedule.xml";
	private static ScheduleMng instance;
	private List<ScheduleDto> scheduleList = new ArrayList<ScheduleDto>();
	
	
	final ITestroLogger logger = TestroLogHelper.getSchedule();
	
	private TestroTimer testroTimer;

	/**
	 * 
	 * <p>
	 * ScheduleMng 싱글톤 인스턴스 생성
	 * <p>
	 * @return
	 * @throws FrameworkException
	 */
	public static ScheduleMng getInstance() throws FrameworkException {
		if (instance == null) {
			synchronized (TestroPreference.class) {
				if (instance == null) {
					instance = new ScheduleMng();
				}
			}
		}
		return instance;
	}
	
	
	
	public void init() {
		
		if (logger.isInfoEnabled()) logger.info("스케줄러 초기화 시작...");
		
		String scheduleConfPath = TestroPreference.getInstance().
			getProperty(PropertyKey.CONFIG_PATH.getCode(), TestroPreference.MASTER);
		scheduleConfPath = scheduleConfPath + "/" + TestroPreference.getInstance().convConfFolder() 
			+ "/" + CONFIG_SCHEDULE_XML;
		
		File file = new File(scheduleConfPath);
		if (!file.exists()) return;
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setIgnoringComments(true);
			dbf.setValidating(false);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			
			NodeList scheduleList = document.getElementsByTagName("schedule");
			
			for (int i = 0; i < scheduleList.getLength(); i++) {
				ScheduleDto scheduleDto = new ScheduleDto();
				Node item = scheduleList.item(i);
				
				NamedNodeMap attributes = item.getAttributes();
				scheduleDto.setMsgScheduleName(attributes.getNamedItem("name").getNodeValue());
				scheduleDto.setRunnable("true".equals(attributes.getNamedItem("runnable").getNodeValue()) ? true : false);
				
				
				NodeList nodes = item.getChildNodes();
				NamedNodeMap attributes2 = nodes.item(1).getAttributes();
				scheduleDto.setExecuteBeanServieName(attributes2.getNamedItem("name").getNodeValue());
				scheduleDto.setInvokeMethod(attributes2.getNamedItem("invokeMethod").getNodeValue());
				scheduleDto.setParamDateFormat(attributes2.getNamedItem("ParamDateFormat").getNodeValue());
				if (scheduleDto.isRunnable()) {
					this.scheduleList.add(scheduleDto);
					if (logger.isInfoEnabled()) logger.info("msgScheduleName : [" + scheduleDto.getMsgScheduleName() + "] start..");
				}
			}
			
			if (this.scheduleList.size()!=0) {
				testroTimer = new TestroTimer(this.scheduleList);
				new Thread(testroTimer).start();
			}
		} catch (Exception e) {
			logger.error(e);
			new FrameworkException("스케줄러 설정파일 파싱중에 오류가 발생하였습니다.", e);
		}
		
		if (logger.isInfoEnabled()) logger.info("스케줄러 초기화 종료...");
		
	}
	
	
	public void destroy() {
		if (testroTimer != null) testroTimer.stop = true;
	}
}
