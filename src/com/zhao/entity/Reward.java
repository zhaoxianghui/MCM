package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 充值奖励实体类
 * @author 赵翔 
 * @lastModfiy 2016/9/2 17:50
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="reward")
public class Reward implements Serializable{
	
	//充值奖励ID
	@Id
	@Column(name="reid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int reid;
	
	//充值金额
	@Column(name="rechargeBalance",unique=true,nullable=false)
	private int rechargeBalance;
	
	//奖励金额
	@Column(name="addmoney",unique=true,nullable=false)
	private int addmoney;
	
	public Reward() {}
	public Reward(int rechargeBalance, int addmoney) {
		this.rechargeBalance = rechargeBalance;
		this.addmoney = addmoney;
	}

	public Reward(int reid, int rechargeBalance, int addmoney) {
		this.reid = reid;
		this.rechargeBalance = rechargeBalance;
		this.addmoney = addmoney;
	}

	public int getReid() {
		return reid;
	}

	public void setReid(int reid) {
		this.reid = reid;
	}

	public int getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(int rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public int getAddmoney() {
		return addmoney;
	}

	public void setAddmoney(int addmoney) {
		this.addmoney = addmoney;
	}
	
	

}
