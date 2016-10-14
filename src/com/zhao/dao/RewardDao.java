package com.zhao.dao;

import com.zhao.entity.Reward;

public interface RewardDao {
	
	/**
	 * 设定充值奖励
	 * @param rechargeBalance
	 * @param addmark
	 */
	public void rechargeAdd(int rechargeBalance,int addmoney);
	
	/**
	 * 充值时加载充值奖励
	 */
	public Reward showReward();

}
