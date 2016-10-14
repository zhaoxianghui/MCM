package com.zhao.dao;

import com.zhao.entity.Page;
import com.zhao.entity.User;

/**
 * 有关用户操作接口
 * @author 赵翔
 * @lastModify 2016/10/10 15:10
 * @version
 */
public interface UserDao {
	
	/**
	 * 通过用户加载一个用户对象（登录）
	 * @param mobile 用户输入的账号
	 * @return 返回NULL 表示账号不存在
	 */
	public User loadUserByMobile(String userName);
	
	/**
	 * 查询显示所有用户资料
	 * @return
	 */
	public Page<User> loadAllUser(int pageNo,int pageSize);
//	
////	/**
////	 * 查询显示个人信息
////	 * @param uid
////	 * @return
////	 */
////	public User loadSelfUser(String uid);
//	
//	
//	
//	/**
//	 * 查询菜单和角色拥有的菜单
//	 */
//	public List<Object[]> showRolemenu(int rid);
//	
//	/**
//	 * 查询出用户所拥有的角色
//	 * @return
//	 */
//	public List<Object[]> showUserRoles(int uid);
//	
//	/**
//	 * 查询用户
//	 * @return
//	 */
//	public User showUsers();
//	
//	
//	/**
//	 * 检查过滤用户菜单
//	 * @param sid
//	 * @param mid
//	 * @return
//	 */
//	public boolean chekedUserMenu(String url,int uid);
//	
//	/**
//	 * 查询显示私人积分及积分排名前十名的人
//	 * @return
//	 */
//	public List<User> loadSelfAndAllmark10(int uid);
//	
//	/**
//	 * 注册用户
//	 */
//	public void zhuce(String userName,String password,String name,String sex,String address,
//			String phone,String email,String card,int mark);
//	
//	/**
//	 * 链接到用户页面
//	 * @return
//	 */
//	public List<User> showUser();
//	
//	/**
//	 * 修改个人信息
//	 * @param rid
//	 * @param uids
//	 */
//	public User modifySelf(User user);
	
	/**
	 * 注销用户
	 * @param uid
	 */
	public void cancellation(int uid);
//	
//	/**
//	 * 用户管理报表
//	 * @return
//	 */
//	public List<User> userBaob();
//	
//	/**
//	 * 充值时加载用户
//	 * 
//	 */
//	public User showSelfUser(int uid);
	
	
}

