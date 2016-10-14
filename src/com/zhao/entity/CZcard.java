package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 充值卡实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/10 15:50
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="czcard")
public class CZcard implements Serializable{
	
	//充值卡ID
	@Id
	@Column(name="czid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int czid;
	
	//充值卡持有者ID
	@Column(name="uid",nullable=false)
	private int uid;
	
	public CZcard() {}
    
	public CZcard(int uid) {
		this.uid = uid;
		
	}

	public CZcard(int czid, int uid) {
		this.uid = uid;
		this.czid = czid;
	}

	public int getCzid() {
		return czid;
	}

	public void setCzid(int czid) {
		this.czid = czid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}


}
