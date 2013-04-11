package com.igo.testro.cmn.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;

import com.igo.testro.cmn.service.excel.ExcelAttribute;
import com.igo.testro.cmn.service.excel.ExcelAttributeDTO;
import com.igo.testro.cmn.service.excel.ExcelGenerator;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

import net.sf.json.JSONArray;

public class GridExcelService extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String excelContents=request.getParameter("excelContents");
		String sheetName=request.getParameter("sheetName");
		
		JSONArray jsonArray = JSONArray.fromObject(excelContents);
		List<ExcelAttributeDTO> attributeList = new ArrayList<ExcelAttributeDTO>();
		List<Object> resultList = new ArrayList<Object>();
		
		for (int i = 0; i < jsonArray.size(); i++) {
			Object object = jsonArray.get(i);
			List<String> rowDatas = new ArrayList<String>();
			for (Object value : (JSONArray)object) {
				if (logger.isDebugEnabled()) logger.debug("data : [" + value + "]");
				if (i==0) {
					ExcelAttributeDTO excelAttributeDTO = new ExcelAttributeDTO();
					excelAttributeDTO.setAlign(CellStyle.ALIGN_LEFT);
					excelAttributeDTO.setHeaderNm((String)value);
					excelAttributeDTO.setType(ExcelAttribute.STRING);
					attributeList.add(excelAttributeDTO);
				} else {
					if (value instanceof net.sf.json.JSONNull) {
						rowDatas.add("");
					} else {
						rowDatas.add((String)value);
					}
				}
			}
			if (i != 0) resultList.add(rowDatas);
		}
		ExcelGenerator excelGenerator = new ExcelGenerator();
		excelGenerator.createSheet(resultList, attributeList, sheetName);
		
		response.addHeader("Content-disposition", "attachment; filename="+new String((sheetName+".xls").getBytes("euc-kr"),"8859_1"));
		response.setContentType("application/vnd.ms-excel");
		ServletOutputStream outputStream = response.getOutputStream();
		excelGenerator.write(outputStream);
		outputStream.flush();
	}

}
