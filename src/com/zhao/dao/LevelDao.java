package com.zhao.dao;

import com.zhao.entity.Level;
import com.zhao.entity.Page;

public interface LevelDao {

	/**
	 * 查询所有会员卡等级及关联的详细信息
	 * @return
	 * 
	 */
	public Page<Level> loadAllLevel(int pageNo,int pageSize);
	
	/**
	 * 会员卡管理报表
	 * @return
	 */
	public Page<Level> levelBaob(int pageNo,int pageSize);
	
	/**
	 * 设定会员等级
	 * @param level
	 * @param needMark
	 */
	public void setUpLevel(String level,int needMark);

}
