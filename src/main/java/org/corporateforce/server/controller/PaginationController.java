package org.corporateforce.server.controller;

public class PaginationController extends AbstractController {
	
	private Integer pageSize = 10;

	private Integer offset = 0;
	
	private Integer recordCount = 0;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

}
