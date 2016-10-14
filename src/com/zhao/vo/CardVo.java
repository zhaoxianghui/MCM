package com.zhao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="v_card")
public class CardVo {
	
	//会员卡或充值卡ID
	@Id
	@Column(name="uid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int uid;
	
	//卡内余额
	@Column(name="balance")
	private int balance;
	
	//真实姓名
	@Column(name="name")
	private String name;
	
	//性别
	@Column(name="sex")
	private String sex;
	
	//住址
	@Column(name="address")
	private String address;
	
	//电话号码
	@Column(name="phone",unique=true,nullable=false)
	private String phone;
	
	//E-mail
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	//积分
	@Column(name="mark")
	private int mark;
	
	public CardVo() {}
	public CardVo(int balance, String name, String sex, String address,
			String phone, String email, int mark) {
		this.balance = balance;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.mark = mark;
	}

	public CardVo(int uid, int balance, String name, String sex, String address,
			String phone, String email,int mark) {
		this.uid = uid;
		this.balance = balance;
	
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.mark=mark;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
