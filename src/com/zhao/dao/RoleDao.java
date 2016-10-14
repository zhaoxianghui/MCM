package com.zhao.dao;

import java.util.List;

import com.zhao.entity.Role;

public interface RoleDao {
	
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> showRole();
	
	/**
	 * 查询出rid对应的角色
	 * @param rid
	 * @return
	 */
	public Role showRoleRid(int rid);

}
