package com.zhao.model.impl;

import java.util.List;
import com.zhao.dao.CZCardTypeDao;
import com.zhao.dao.CardDao;
import com.zhao.dao.CardVoDao;
import com.zhao.dao.LevelDao;
import com.zhao.dao.MenuDao;
import com.zhao.dao.MenuRoleDao;
import com.zhao.dao.RewardDao;
import com.zhao.dao.RoleDao;
import com.zhao.dao.UseRewardDao;
import com.zhao.dao.UserDao;
import com.zhao.dao.UserRoleDao;
//import com.zhao.dao.impl.CZCardTypeDaoImpl;
//import com.zhao.dao.impl.CardDaoImpl;
//import com.zhao.dao.impl.CardVoDaoImpl;
//import com.zhao.dao.impl.LevelDaoImpl;
import com.zhao.dao.impl.MenuDaoImpl;
//import com.zhao.dao.impl.MenuRoleImpl;
//import com.zhao.dao.impl.RewardDaoImpl;
//import com.zhao.dao.impl.RoleDaoImpl;
//import com.zhao.dao.impl.UseRewardDaoImpl;
import com.zhao.dao.impl.UserDaoImpl;
//import com.zhao.dao.impl.UserRoleImpl;
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
import com.zhao.model.UserModel;
import com.zhao.vo.CardVo;

/**
 * 模型层接口实现类
 * @author 赵翔
 * @lastModify 2016/10/11
 * @version
 */
public class UserModelImpl implements UserModel{
	
	//模型层持有数据层对象
	private UserDao userDao=new UserDaoImpl();
	//模型层持有数据层对象
	private MenuDao menuDao=new MenuDaoImpl();
	//模型层持有数据层对象
//	private RoleDao roleDao=new RoleDaoImpl();
//	//模型层持有数据层对象
//	private MenuRoleDao menuroleDao=new MenuRoleImpl();
//	//模型层持有数据层对象
//	private UserRoleDao userroleDao=new UserRoleImpl();
//	//模型层持有数据层对象
//	private CardDao cardDao=new CardDaoImpl();
//	//模型层持有数据层对象
//	private LevelDao levelDao=new LevelDaoImpl();
//	//模型层持有数据层对象
//	private CardVoDao cardVoDao=new CardVoDaoImpl();
//	//模型层持有数据层对象
//	private CZCardTypeDao czcardTypeDao=new CZCardTypeDaoImpl();
//	//模型层持有数据层对象
//	private RewardDao rewardDao=new RewardDaoImpl();
//	//模型层持有数据层对象
//	private UseRewardDao userewardDao=new UseRewardDaoImpl();
	
	/**
	 * 通过用户加载一个用户对象（登录）
	 * @param mobile 用户输入的账号
	 * @return 返回NULL 表示账号不存在
	 */
	public User loadUserByMobile(String userName){
	    return userDao.loadUserByMobile(userName);
	}
	
	/**
	 * 权限菜单管理
	 */
	public List<Menu> loadMenu(int uid){
		return menuDao.loadMenu(uid);
	}
	
//	/**
//	 * 查询角色
//	 * @return
//	 */
//	public List<Role> showRole(){
//		return roleDao.showRole();
//	}
//	
//	/**
//	 * 查询菜单和角色拥有的菜单
//	 */
//	public List<Object[]> showRolemenu(int rid){
//		return userDao.showRolemenu(rid);	
//	}
//	
//	/**
//	 * 查询出rid的角色
//	 * @param rid
//	 * @return
//	 */
//	public Role showRoleRid(int rid){
//		return roleDao.showRoleRid(rid);
//	}
//	
//	/**
//	 * 修改用户权限
//	 */
//	public void delectRoleMenu(MenuRole mr){
//		menuroleDao.delectRoleMenu(mr);
//	}
//	
//	/**
//	 * 查询用户
//	 * @return
//	 */
//	public User showUsers(){
//		return userDao.showUsers();
//	}
//	
//	/**
//	 * 查询出用户所拥有的角色
//	 * @return
//	 */
//	public List<Object[]> showUserRoles(int uid){
//		return userDao.showUserRoles(uid);
//	}
//	
//	/**
//	 * 修改用户角色
//	 * @param name
//	 * @param rids
//	 */
//	public void updateUserRoles(UserRole userrole){
//		userroleDao.updateUserRoles(userrole);
//	}
//	
//	/**
//	 * 检查过滤用户菜单
//	 * @param uid
//	 * @return
//	 */
//	public boolean chekedUserMenu(String url,int uid){
//	    return userDao.chekedUserMenu(url,uid);
//	}
//	
//	
	/**
	 * 查询显示所有用户资料
	 * @return
	 */
	public Page<User> loadAllUser(int pageNo,int pageSize){
		return userDao.loadAllUser(pageNo,pageSize);
	}
//	
//	/**
//	 * 查询显示私人积分及积分排名前十名的人
//	 * @return
//	 */
//	public List<User> loadSelfAndAllmark10(int uid){
//		return userDao.loadSelfAndAllmark10(uid);
//	}
//	
//	/**
//	 * 注册用户
//	 */
//	public void zhuce(String userName,String password,String name,String sex,
//			String address,String phone,String email,String card,int mark){
//		userDao.zhuce(userName, password, name, sex, address, phone, email, card, mark);
//	}
//	
//	/**
//	 * 链接到用户页面
//	 * @return
//	 */
//	public List<User> showUser(){
//		return userDao.showUser();
//	}
//	
//	/**
//	 * 修改个人信息
//	 * @param rid
//	 * @param uids
//	 */
//	public User modifySelf(User user){
//		return userDao.modifySelf(user);
//	}
//	
	/**
	 * 注销用户
	 * @param uid
	 */
	public void cancellation(int uid){
		userDao.cancellation(uid);
	}
//	
//	/**
//	 * 用户充值
//	 * @param uid
//	 */
//	public Card recharge(int balance,int uid){
//		return cardDao.recharge(balance,uid);
//	}
//	
//	/**
//	 * 用户管理报表
//	 * @return
//	 */
//	public List<User> userBaob(){
//		return userDao.userBaob();
//	}
//	
//	/**
//	 * 查询所有会员及关联的详细信息
//	 * @return
//	 */
//	public Page<CardVo> loadAllCard(int pageNo,int pageSize){
//		return cardVoDao.loadAllCard(pageNo, pageSize);
//	}
//
//	/**
//	 * 会员管理报表
//	 * @return
//	 */
//	public List<CardVo> cardBaob(){
//		return cardVoDao.cardBaob();
//		
//	}
//	
//	/**
//	 * 查询所有会员卡等级及关联的详细信息
//	 * @return
//	 */
//	public Page<Level> loadAllLevel(int pageNo,int pageSize){
//		return levelDao.loadAllLevel(pageNo,pageSize);
//	}
//	
//	/**
//	 * 会员卡管理报表
//	 * @return
//	 */
//	public Page<Level> levelBaob(int pageNo,int pageSize){
//		return levelDao.levelBaob(pageNo, pageSize);
//	}
//	
//	/**
//	 * 设定会员等级
//	 * @param level
//	 * @param needMark
//	 */
//	public void setUpLevel(String level,int needMark){
//		levelDao.setUpLevel(level,needMark);
//	}
//	
//	/**
//	 * 设定充值卡类型
//	 * @param level
//	 * @param needMark
//	 */
//	public void setUpRechargeType(int rechargeBalance,int czid){
//		czcardTypeDao.setUpRechargeType(rechargeBalance, czid);
//	}
//	
//	/**
//	 * 设定充值奖励
//	 * @param rechargeBalance
//	 * @param addmark
//	 */
//	public void rechargeAdd(int rechargeBalance,int addmoney){
//		rewardDao.rechargeAdd(rechargeBalance,addmoney);
//	}
//	
//	/**
//	 * 加载个人会员信息
//	 * @param cardid
//	 * @return
//	 */
//	public Card showSelfCard(int cardid){
//		return cardDao.showSelfCard(cardid);
//	}
//	
//	/**
//	 * 充值时加载该卡充值类型
//	 * 
//	 */
//	public CZCardType showSelfzcCard(int czid){
//		return czcardTypeDao.showSelfzcCard(czid);
//	}
//	
//	/**
//	 * 充值时加载用户
//	 */
//	public User showSelfUser(int uid){
//		return userDao.showSelfUser(uid);
//	}
//	
//	/**
//	 * 充值时加载充值奖励
//	 * @param rechargeBalance
//	 * @return
//	 */
//	public Reward showReward(){
//		return rewardDao.showReward();
//	}
//	
//	/**
//	 * 设定消费奖励
//	 * @param useBalance
//	 * @param addMark
//	 */
//	public void rewardAdd(int useBalance,int addMark){
//		userewardDao.rewardAdd(useBalance,addMark);
//	}
//	
}
