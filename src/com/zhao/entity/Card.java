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
 * @lastModfiy 2016/10/10 15:50
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="card")
public class Card implements Serializable{
	
	//会员卡ID
	@Id
	@Column(name="cardid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int cardid;
	
	//卡内余额
	@Column(name="balance",nullable=false)
	private int balance;
	
	//本卡持有者ID
	@Column(name="uid",unique=true,nullable=false)
	private int uid;
	
	//注册时间
	@Column(name="regtime",nullable=false)
	private String regtime;
	//到期时间
	@Column(name="dueTotime",nullable=false)
	private String dueTotime;
	public Card() {}
	
	

	public Card(int balance, int uid) {
		this.balance = balance;
		this.uid = uid;
	}



	public Card(int cardid, int balance, int uid,String regtime,String dueTotime) {
		this.cardid = cardid;
		this.balance = balance;
		this.uid = uid;
		this.regtime = regtime;
		this.dueTotime=dueTotime;
	}

	
	
	public String getDueTotime() {
		return dueTotime;
	}



	public void setDueTotime(String dueTotime) {
		this.dueTotime = dueTotime;
	}



	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	


}
