package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会员卡实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/11 14:50
 * @version
 */
@SuppressWarnings("serial")
@Entity
@Table(name="useing")
public class Useing implements Serializable{
	
	//消费编号ID
	@Id
	@Column(name="usid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int usid;
	
	//消费名称
	@Column(name="uname",nullable=false)
	private String uname;
	
	//消费金额
	@Column(name="price",nullable=false)
	private int price;

	public Useing() {}
	public Useing(String uname, int price) {
		this.uname = uname;
		this.price = price;
	}

	public Useing(int usid, String uname, int price) {
		this.usid = usid;
		this.uname = uname;
		this.price = price;
	}

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}
