package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 充值类型实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/10 15:50
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="czcardType")
public class CZCardType implements Serializable{
	
	//充值卡类型ID
	@Id
	@Column(name="uid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int cztid;
	
	//充值卡面额
	@Column(name="rechargeBalance")
	private int rechargeBalance;
	
	//充值卡ID
	@Column(name="czid",unique=true,nullable=false)
	private int czid;
	
	//等价积分
	@Column(name="priceMark")
	private int priceMark;
	
	public CZCardType() {}

	public CZCardType(int cztid, int rechargeBalance, int czid,int priceMark) {
		super();
		this.cztid = cztid;
		this.rechargeBalance = rechargeBalance;
		this.czid = czid;
		this.priceMark = priceMark;
	}
	

	public int getPriceMark() {
		return priceMark;
	}

	public void setPriceMark(int priceMark) {
		this.priceMark = priceMark;
	}

	public int getCztid() {
		return cztid;
	}

	public void setCztid(int cztid) {
		this.cztid = cztid;
	}

	public int getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(int rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public int getCzid() {
		return czid;
	}

	public void setCzid(int czid) {
		this.czid = czid;
	}
	
   
}
