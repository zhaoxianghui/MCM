package com.zhao.dao;

import com.zhao.entity.CZCardType;

public interface CZCardTypeDao {
	/**
	 * 设定充值卡类型
	 * @param level
	 * @param needMark
	 */
	public void setUpRechargeType(int rechargeBalance,int czid);
	
	/**
	 * 充值时加载该卡充值类型
	 * 
	 */
	public CZCardType showSelfzcCard(int czid);

}
