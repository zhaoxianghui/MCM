package com.zhao.entity;

import java.io.Serializable;


/**
 * 用户实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/10 15:50
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	
	//用户编号
	private int uid;
	
	//用户名
	private String userName;
	
	//密码
    private String password;
	
	//真实姓名
	private String name;
	
	//性别
	private int sex;
	
	//住址
	private String address;
	
	//电话号码
	private String phone;
	
	//E-mail
	private String email;
	
	//信用卡号码
	private String card;
	
	//积分
	private int mark;
	
	public User() {}
	
	public User(int mark) {
		this.mark = mark;
	}

	public User(String userName, int mark) {
		this.userName = userName;
		this.mark = mark;
	}
	

	public User(int uid, String userName, String name, int sex, String address,
			String phone, String email) {
		this.uid = uid;
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public User(int uid, String userName, String password, String name,
			int sex, String address, String phone, String email, String card,
			int mark) {
		this.uid = uid;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.card = card;
		this.mark = mark;
	}


	public User(String userName, String password, String name, int sex,
			String address, String phone, String email, String card, int mark) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.card = card;
		this.mark = mark;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	

}
