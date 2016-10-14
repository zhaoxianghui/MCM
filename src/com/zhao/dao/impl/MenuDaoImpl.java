package com.zhao.dao.impl;

import java.util.List;
import com.zhao.dao.BaseMapper;
import com.zhao.dao.MenuDao;
import com.zhao.entity.Menu;

public class MenuDaoImpl extends BaseMapper<Menu> implements MenuDao{

	/**
	 * 菜单权限管理
	 * 
	 */
	public List<Menu> loadMenu(int uid){
		List<Menu> menuList = selectList("MenuMapper.loadMenu", uid);
		return menuList;
	}
	
	
}
