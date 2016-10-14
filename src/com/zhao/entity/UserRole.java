package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色关联实体类
 * @author 赵翔  项目4组
 * @lastModify 2016/10/10 15:50
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="userrole")
public class UserRole implements Serializable{
	
	@Id
	@Column(name="urid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int urid;
	
	@Column(name="rid",unique=true,nullable=false)
	private int rid;
	
	@Column(name="uid",unique=true,nullable=false)
	private int uid;
	
	public UserRole() {}
	public UserRole(int uid, int rid) {
		this.uid = uid;
		this.rid = rid;
	}
	
	public UserRole(int urid, int uid, int rid) {
		this.urid = urid;
		this.uid = uid;
		this.rid = rid;
	}

	public int getUrid() {
		return urid;
	}
	public void setUrid(int urid) {
		this.urid = urid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	

}
