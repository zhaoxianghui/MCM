package com.zhao.dao;

import com.zhao.entity.Card;

public interface CardDao {
	/**
	 * 用户充值
	 * @param uid
	 */
	public Card recharge(int balance,int uid);
	
	/**
	 * 加载个人会员信息
	 * @param cardid
	 * @return
	 */
	public Card showSelfCard(int cardid);

}
