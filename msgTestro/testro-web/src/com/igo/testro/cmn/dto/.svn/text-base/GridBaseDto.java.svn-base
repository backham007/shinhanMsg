package com.igo.testro.cmn.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:GridBaseDto.java<br/>
 * 설명 : 그리의 기본정보 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 20. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class GridBaseDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	// 페이지번호
	private int page;
	
	// 페이지의 로우갯수
	private int rows;
	
	// 소트기준 idx
	private String sidx;
	
	// 소트형태
	private String sord;
	
	// 총로우수
	private int records;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}
	
	// 페이징 시작레코드
	public int getStartnum() {
		return (this.page - 1) * this.rows;
	}
	
	// 페이지 마지막레코드
	public int getEndnum() {
		return rows * page;
	}
	
	// 총페이지번호
	public int getTotal() {
		return (int) Math.ceil((double)records/rows);
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

}
