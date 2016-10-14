package com.zhao.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/10 15:50
 */
@SuppressWarnings("serial")
public class Page<T> implements Serializable {
	
	private int pageNo = 1;
	private int pageSize = 20;
	private List<T> dataList;
	private long total;
	
	public Page(){}
	public Page(int pageNo, int pageSize,List<T> dataList, long total) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.total = total;
		this.dataList = dataList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
}
