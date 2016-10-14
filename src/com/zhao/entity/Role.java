package com.zhao.entity;

import java.io.Serializable;


/**
 * 角色实体类
 * @author 赵翔  项目4组
 * @lastModify  2016-10-10 15:20
 *
 */

@SuppressWarnings("serial")
public class Role implements Serializable{
	
	//角色编号
	private int rid;
	
	//角色名称
	private String rname;
	
	public Role() {}
	public Role(int rid, String rname) {
		this.rid = rid;
		this.rname = rname;
	}
	
	public Role(String rname) {
		this.rname = rname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}

}
