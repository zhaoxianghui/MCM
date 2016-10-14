package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 消费奖励实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/11 11:20
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="usereward")
public class UseReward implements Serializable{
	
	//消费ID
	@Id
	@Column(name="urid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int urid;
	
	//消费金额
	@Column(name="useBalance")
	private int useBalance;
	
	//消费增加积分数
	@Column(name="addMark")
	private int addMark;

	public UseReward() {}
	public UseReward(int useBalance, int addMark) {
		this.useBalance = useBalance;
		this.addMark = addMark;
	}
	
	public UseReward(int urid, int useBalance, int addMark) {
		this.urid = urid;
		this.useBalance = useBalance;
		this.addMark = addMark;
	}
	public int getUrid() {
		return urid;
	}
	public void setUrid(int urid) {
		this.urid = urid;
	}
	public int getUseBalance() {
		return useBalance;
	}
	public void setUseBalance(int useBalance) {
		this.useBalance = useBalance;
	}
	public int getAddMark() {
		return addMark;
	}
	public void setAddMark(int addMark) {
		this.addMark = addMark;
	}
	
    

}
