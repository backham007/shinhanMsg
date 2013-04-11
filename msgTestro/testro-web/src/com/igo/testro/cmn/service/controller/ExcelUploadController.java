package com.igo.testro.cmn.service.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

/**
 * 
 * <p>
 * 프로그램명:ExcelUploadController.java<br/>
 * 설명 : 엑셀 업로드 컨트롤<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 9. : kangwoo : 내용
 * </ul> 
 * </p>
 */
@Controller
public class ExcelUploadController {
	
	
	final ITestroLogger logger = TestroLogHelper.getBiz();

	@RequestMapping("cmn.service.excelUpload.do")
	 public ModelAndView excelUpload( HttpServletRequest request, HttpServletResponse response ) throws Exception {
		ModelAndView mav = new ModelAndView();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile mFile = multipartRequest.getFile( "excelFile" );
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        
		if (mFile != null &&  mFile.getSize() > 0) {
			if (logger.isDebugEnabled()) logger.debug("mFile.getSize() : [" + mFile.getSize() + "]");
			String fileName = mFile.getOriginalFilename();
			
			if( fileName.indexOf(".xlsx") > -1 ) {
				readExcel2007After(mFile, result);
			} else if ( fileName.indexOf(".xls") > -1 ) {
				readExcel(mFile, result);
			}
		}
		JSONArray jObject = JSONArray.fromObject(result);
		String strResult = jObject.toString();
		mav.addObject("result", strResult);
		//mav.setViewName("gridFileView");
		mav.setViewName("cmn/grid/excelImportResult");
		return mav;
	}

	private void readExcel2007After(MultipartFile mFile, List<Map<String, Object>> result)
			throws IOException {
		InputStream inputStream = mFile.getInputStream();
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			logger.error(e);
			throw new BizException("WEB_SERVIC0001", "", e);
		}
		Sheet sheet1 = wb.getSheetAt(0);
		
		List<String> headers = new ArrayList<String>();
		int rowCnt = 0;
		int headerCnt = 0;
		for (Row row : sheet1) {
			
			boolean isEmptyRow = true;
			for (Cell cell : row) {
				if(cell.getRichStringCellValue() != null && !"".equals(StringUtils.trimAllWhitespace(cell.getRichStringCellValue().getString()))){
					isEmptyRow = false;
					break;
				}
			}
			if(isEmptyRow) continue;
			
			int cellCnt = 0;
			Map<String, Object> item = new HashMap<String, Object>();
		    for (Cell cell : row) {
		        Object value = null;
		        switch (cell.getCellType()) {
		            case XSSFCell.CELL_TYPE_STRING:
		            	value = cell.getRichStringCellValue().getString();
		            	break;
		            case XSSFCell.CELL_TYPE_NUMERIC:
		                if (DateUtil.isCellDateFormatted(cell)) {
		                	value = cell.getDateCellValue();
		                } else {
		                	value = cell.getNumericCellValue();
		                }
		                break;
		            case XSSFCell.CELL_TYPE_BOOLEAN:
		            	value = cell.getBooleanCellValue();
		                break;
		            case XSSFCell.CELL_TYPE_FORMULA:
		            	value = cell.getCellFormula();
		                break;
		            default:
		            	value = "";
		        }
		        
		        if (rowCnt==0) {
		        	// ie에서는 공백변수가 지원이 되지 않아 공백을 제거한다.
		        	String header = ((String)value).replaceAll(" ", "");
		        	
		        	// 헤더값이 공백이 경우 에러 처리한다.
		        	if (header.trim()==null || "".equals(header.trim())) {
		        		throw new BizException("WEB_CODEMNG003", "", new Exception());
		        	}
		        	headers.add(header);
		        	headerCnt = cellCnt;
		        } else {
		        	item.put(headers.get(cellCnt), value);
		        	if(headerCnt <= cellCnt) break;
		        }
		        cellCnt++;
		    }
		    
		    //헤더개수만큼 반드시 데이터를 만들어준다
		    while(headerCnt > cellCnt){
		    	item.put(headers.get(cellCnt), "");
		    	cellCnt++;
		    }
		    if (rowCnt!=0) result.add(item);
		    rowCnt++;
		}
		
	}

	private void readExcel(MultipartFile mFile, List<Map<String, Object>> result)
			throws IOException {
		InputStream inputStream = mFile.getInputStream();
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(inputStream);
		} catch (Exception e) {
			logger.error(e);
			throw new BizException("WEB_SERVIC0001", "", e);
		}
		Sheet sheet1 = wb.getSheetAt(0);
		
		List<String> headers = new ArrayList<String>();
		int rowCnt = 0;
		int headerCnt = 0;
		for (Row row : sheet1) {
			
			boolean isEmptyRow = true;
			for (Cell cell : row) {
				if(cell.getRichStringCellValue() != null && !"".equals(StringUtils.trimAllWhitespace(cell.getRichStringCellValue().getString()))){
					isEmptyRow = false;
					break;
				}
			}
			if(isEmptyRow) continue;
			
			int cellCnt = 0;
			Map<String, Object> item = new HashMap<String, Object>();
		    for (Cell cell : row) {
		        Object value = null;
		        switch (cell.getCellType()) {
		            case Cell.CELL_TYPE_STRING:
		            	value = cell.getRichStringCellValue().getString();
		            	break;
		            case Cell.CELL_TYPE_NUMERIC:
		                if (DateUtil.isCellDateFormatted(cell)) {
		                	value = cell.getDateCellValue();
		                } else {
		                	value = cell.getNumericCellValue();
		                }
		                break;
		            case Cell.CELL_TYPE_BOOLEAN:
		            	value = cell.getBooleanCellValue();
		                break;
		            case Cell.CELL_TYPE_FORMULA:
		            	value = cell.getCellFormula();
		                break;
		            default:
		            	value = "";
		        }
		        
		        if (rowCnt==0) {
		        	// ie에서는 공백변수가 지원이 되지 않아 공백을 제거한다.
		        	String header = ((String)value).replaceAll(" ", "");
		        	
		        	// 헤더값이 공백이 경우 에러 처리한다.
		        	if (header.trim()==null || "".equals(header.trim())) {
		        		throw new BizException("WEB_CODEMNG003", "", new Exception());
		        	}
		        	headers.add(header);
		        	headerCnt = cellCnt;
		        } else {
		        	item.put(headers.get(cellCnt), value);
		        	if(headerCnt <= cellCnt) break;
		        }
		        cellCnt++;
		    }
		    //헤더개수만큼 반드시 데이터를 만들어준다
		    while(headerCnt > cellCnt){
		    	item.put(headers.get(cellCnt), "");
		    	cellCnt++;
		    }
		    if (rowCnt!=0) result.add(item);
		    rowCnt++;
		}
	}
	
}
