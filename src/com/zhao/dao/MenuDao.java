package com.zhao.dao;

import java.util.List;

import com.zhao.entity.Menu;

public interface MenuDao {
	/**
	 * 权限菜单管理
	 */
	public List<Menu> loadMenu(int uid);

}
