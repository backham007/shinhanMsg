package com.igo.testro.cmn.service.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

/**
 * 
 * <p>
 * 프로그램명:ExcelGenerator.java<br/>
 * 설명 : 엑셀 생성 API<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 9. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class ExcelGenerator {

	private HSSFWorkbook wb;
	private Font headerFont;
	private CellStyle headerStyle;
	private Font valueFont;
	private CellStyle valueStyleLeft;
	private CellStyle valueStyleCenter;
	private CellStyle valueStyleRight;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();

	public ExcelGenerator() {

		wb = new HSSFWorkbook();

		// 헤더폰트설정
		headerFont = wb.createFont();
		headerFont.setFontHeightInPoints((short)11);
		headerFont.setFontName("맑은 고딕");
		headerFont.setColor(new HSSFColor.WHITE().getIndex());

		// 헤더셀스타일
		headerStyle = wb.createCellStyle();
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setFillForegroundColor(new HSSFColor.BLACK().getIndex());
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

		// 본문 폰트설정
		valueFont = wb.createFont();
		valueFont.setFontHeightInPoints((short)11);
		valueFont.setFontName("맑은 고딕");

		// 본문 셀스타일(ALIGN_LEFT)
		valueStyleLeft = createValueStyle(CellStyle.ALIGN_LEFT);

		// 본문 셀스타일(ALIGN_CENTER)
		valueStyleCenter = createValueStyle(CellStyle.ALIGN_CENTER);

		// 본문 셀스타일(ALIGN_RIGHT)
		valueStyleRight = createValueStyle(CellStyle.ALIGN_RIGHT);

	}


	private  CellStyle createValueStyle(short align) {
		CellStyle valueStyle = wb.createCellStyle();
		valueStyle.setFont(valueFont);
		valueStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		valueStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		valueStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		valueStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		valueStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		valueStyle.setWrapText(true);
		valueStyle.setAlignment(align);

		return valueStyle;
	}


	@SuppressWarnings("unchecked")
	public void createSheet(List<Object> resultList, List attributeList, String sheetNm) {
		HSSFSheet sheet = wb.createSheet(sheetNm);
		HSSFRow row = sheet.createRow((short)0);
		row.setHeightInPoints(17);

		try {
			// 헤더 작성
			for (int i = 0; i < attributeList.size() ; i++) {
				HSSFCell cell = row.createCell(i);
				ExcelAttributeDTO attributeDTO = (ExcelAttributeDTO)attributeList.get(i);
				cell.setCellValue(attributeDTO.getHeaderNm());
				attributeDTO.setColumnMaxLangth(attributeDTO.getHeaderNm().length() * 2);
				cell.setCellStyle(headerStyle);
			}


			// 본문 작성
			for (int i = 0; i < resultList.size(); i++) {
				HSSFRow dataRow = sheet.createRow(i+1);
				dataRow.setHeightInPoints(17);
				Object object = resultList.get(i);
				
				//리스트로 값이 직접왔을때
				if (object instanceof List) {
					List dataList = (List) object;
					for (int j = 0; j < attributeList.size(); j++) {
						creatListToCellValue( sheet, dataRow, j, dataList.get(j), (ExcelAttributeDTO)attributeList.get(j), false);
					}
				// Dto로 값을 가져올때	
				} else {
					for (int j = 0; j < attributeList.size(); j++) {
						creatDtoToCellValue( sheet, dataRow, j, resultList.get(i), (ExcelAttributeDTO)attributeList.get(j), false);
					}
				}
			}

			// 컬럼 길이 자동
			for (int i = 0; i < attributeList.size() ; i++) {
				if (logger.isDebugEnabled()) logger.debug("columMaxLength : [" + ((ExcelAttributeDTO)attributeList.get(i)).getColumnMaxLangth() + "]");
				//엑셀 칼럼 크기 제한 (IGO-KJH)
				int columnMaxLangth = (((ExcelAttributeDTO)attributeList.get(i)).getColumnMaxLangth());
				if(columnMaxLangth > 100) columnMaxLangth = 100;
				sheet.setColumnWidth(i, columnMaxLangth * 380);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void creatDtoToCellValue(HSSFSheet sheet, HSSFRow dataRow, int j, Object data, ExcelAttributeDTO attribute, boolean isErr) throws Exception {
		HSSFCell cell = dataRow.createCell(j);

		Object value = null;

		try {
			value = PropertyUtils.getProperty(data, attribute.getFieldNm());

			switch (attribute.getType()) {
			case ExcelAttribute.STRING:
				cell.setCellValue((String)value);
				attribute.setColumnMaxLangth(((String)value).length());
				break;
			case ExcelAttribute.INT:
				cell.setCellValue((Integer)value);
				attribute.setColumnMaxLangth(String.valueOf((Integer)value).length());
				break;
			case ExcelAttribute.BOOLEAN:
				cell.setCellValue((Boolean)value);
				attribute.setColumnMaxLangth(String.valueOf((Boolean)value).length());
				break;
			default:
				break;
			}

			switch (attribute.getAlign()) {
			case ExcelAttribute.ALIGN_LEFT:
				cell.setCellStyle(valueStyleLeft);
				break;
			case ExcelAttribute.ALIGN_CENTER:
				cell.setCellStyle(valueStyleCenter);
				break;
			case ExcelAttribute.ALIGN_RIGHT:
				cell.setCellStyle(valueStyleRight);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			logger.error("엑셀 생성중에 오류가 발생하였습니다.", e);
			throw e;
		}
	}
	
	private void creatListToCellValue(HSSFSheet sheet, HSSFRow dataRow, int j, Object value, ExcelAttributeDTO attribute, boolean isErr) throws Exception {
		HSSFCell cell = dataRow.createCell(j);

		try {
			switch (attribute.getType()) {
			case ExcelAttribute.STRING:
				cell.setCellValue((String)value);
				attribute.setColumnMaxLangth(((String)value).length());
				break;
			case ExcelAttribute.INT:
				cell.setCellValue((Integer)value);
				attribute.setColumnMaxLangth(String.valueOf((Integer)value).length());
				break;
			case ExcelAttribute.BOOLEAN:
				cell.setCellValue((Boolean)value);
				attribute.setColumnMaxLangth(String.valueOf((Boolean)value).length());
				break;
			default:
				break;
			}

			switch (attribute.getAlign()) {
			case ExcelAttribute.ALIGN_LEFT:
				cell.setCellStyle(valueStyleLeft);
				break;
			case ExcelAttribute.ALIGN_CENTER:
				cell.setCellStyle(valueStyleCenter);
				break;
			case ExcelAttribute.ALIGN_RIGHT:
				cell.setCellStyle(valueStyleRight);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			logger.error("엑셀 생성중에 오류가 발생하였습니다.", e);
			throw e;
		}
	}



	public void write(OutputStream out) throws IOException {
		wb.write(out);

	}

}
