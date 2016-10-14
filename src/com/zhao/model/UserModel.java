package com.zhao.model;

import java.util.List;

import com.zhao.entity.Card;
import com.zhao.entity.Level;
import com.zhao.entity.Menu;
import com.zhao.entity.MenuRole;
import com.zhao.entity.Page;
import com.zhao.entity.Reward;
import com.zhao.entity.Role;
import com.zhao.entity.User;
import com.zhao.entity.CZCardType;
import com.zhao.entity.UserRole;
import com.zhao.vo.CardVo;


public interface UserModel {
	
	/**
	 * 通过用户加载一个用户对象（登录）
	 * @param mobile 用户输入的账号
	 * @return 返回NULL 表示账号不存在
	 */
	public User loadUserByMobile(String userName);
	
	/**
	 * 权限菜单管理
	 */
	public List<Menu> loadMenu(int uid);
	
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
//	/**
//	 * 查询角色
//	 * @return
//	 */
//	public List<Role> showRole();
//	
//	/**
//	 * 查询菜单和角色拥有的菜单
//	 */
//	public List<Object[]> showRolemenu(int rid);
//	
//	/**
//	 * 修改用户权限
//	 */
//	public void delectRoleMenu(MenuRole mr);
//	
//	/**
//	 * 查询出rid的角色
//	 * @param rid
//	 * @return
//	 */
//	public Role showRoleRid(int rid);
//	
//	/**
//	 * 查询用户
//	 * @return
//	 */
//	public User showUsers();
//	
//	/**
//	 * 查询出用户所拥有的角色
//	 * @return
//	 */
//	public List<Object[]> showUserRoles(int uid);
//	
//	/**
//	 * 修改用户角色
//	 * @param name
//	 * @param rids
//	 */
//	public void updateUserRoles(UserRole userrole);
//	/**
//	 * 检查过滤用户菜单
//	 * @param sid
//	 * @param mid
//	 * @return
//	 */
//	public boolean chekedUserMenu(String url,int uid);
//	
	/**
	 * 查询显示私人积分及积分排名前十名的人
	 * @return
	 */
	public List<User> loadSelfAndAllmark10(int uid);
//	
//	/**
//	 * 注册用户
//	 */
//	public void zhuce(String userName,String password,String name,String sex,
//			String address,String phone,String email,String card,int mark);
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
//	
	/**
	 * 注销用户
	 * @param uid
	 */
	public void cancellation(int uid);
//	
//	/**
//	 * 用户充值
//	 * @param uid
//	 */
//	public Card recharge(int balance,int uid);
//	
//	/**
//	 * 用户管理报表
//	 * @return
//	 */
//	public List<User> userBaob();
//	
//	/**
//	 * 查询所有会员及关联的的详细信息
//	 * @return
//	 */
//	public Page<CardVo> loadAllCard(int pageNo,int pageSize);
//
//	/**
//	 * 会员管理报表
//	 * @return
//	 */
//	public List<CardVo> cardBaob();
//	
//	/**
//	 * 查询所有会员卡等级及关联的详细信息
//	 * @return
//	 */
//	public Page<Level> loadAllLevel(int pageNo,int pageSize);
//	
//	/**
//	 * 会员卡管理报表
//	 * @return
//	 */
//	public Page<Level> levelBaob(int pageNo,int pageSize);
//	
//	/**
//	 * 设定会员等级
//	 * @param level
//	 * @param needMark
//	 */
//	public void setUpLevel(String level,int needMark);
//	
//	/**
//	 * 设定充值卡类型
//	 * @param level
//	 * @param needMark
//	 */
//	public void setUpRechargeType(int rechargeBalance,int czid);
//	
//	/**
//	 * 设定充值奖励
//	 * @param rechargeBalance
//	 * @param addmark
//	 */
//	public void rechargeAdd(int rechargeBalance,int addmoney);
//	
//	/**
//	 * 加载个人会员信息
//	 * @param cardid
//	 * @return
//	 */
//	public Card showSelfCard(int cardid);
//	public CZCardType showSelfzcCard(int czid);
//	public User showSelfUser(int uid);
//	/**
//	 * 加载充值奖励
//	 * @param rechargeBalance
//	 * @return
//	 */
//	public Reward showReward();
//	
//	/**
//	 * 设定消费奖励
//	 * @param useBalance
//	 * @param addMark
//	 */
//	public void rewardAdd(int useBalance,int addMark);
	
}

