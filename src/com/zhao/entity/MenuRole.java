package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单角色关联实体类
 * @author 赵翔  项目4组
 * @lastModify 2016/10/10 15:50
 * @version
 */
@SuppressWarnings("serial")
@Entity
@Table(name="menurole")
public class MenuRole implements Serializable{
	
	@Id
	@Column(name="mrid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int mrid;
	
	@Column(name="mid",unique=true,nullable=false)
	private int mid;
	
	@Column(name="rid",unique=true,nullable=false)
	private int rid;
	
	public MenuRole() {}
	public MenuRole(int mid, int rid) {
		this.mid = mid;
		this.rid = rid;
	}
	
	public MenuRole(int mrid, int mid, int rid) {
		this.mrid = mrid;
		this.mid = mid;
		this.rid = rid;
	}

	public int getMrid() {
		return mrid;
	}
	public void setMrid(int mrid) {
		this.mrid = mrid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	

}
