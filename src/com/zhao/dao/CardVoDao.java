package com.zhao.dao;

import java.util.List;
import com.zhao.entity.Page;
import com.zhao.vo.CardVo;

public interface CardVoDao {
	
	/**
	 * 查询所有会员及关联的详细信息
	 * @return
	 */
	public Page<CardVo> loadAllCard(int pageNo,int pageSize);
	
	/**
	 * 会员管理报表
	 * @return
	 */
	public List<CardVo> cardBaob();

}
