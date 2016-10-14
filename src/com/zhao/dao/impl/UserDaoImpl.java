package com.zhao.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhao.dao.BaseMapper;
import com.zhao.dao.UserDao;
import com.zhao.entity.Page;
import com.zhao.entity.User;

/**
 * 相关用户操作接口实现类
 * @author 赵翔
 * @lastModify 2016/10/11 11:10
 * @version
 */
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseMapper implements UserDao{
	
	/**
	 * 通过用户加载一个用户对象（登录）
	 * @param userName表示用户输入的账号
	 * @return 返回NULL 表示账号不存在
	 */
	public User loadUserByMobile(String userName) {
		return (User)this.selectOne("UserMapper.loadUserByName", userName);
	}
	
//	
//	/**
//	 * 查询菜单和角色拥有的菜单
//	 */
//	public List<Object[]> showRolemenu(int rid){
//		String sql = "select m.mid,m.name,m.parentid,(select 1 from menurole rm where " +
//				"rm.mid=m.mid and rm.rid=?) from menu m";
//		List<Object[]> list = executeQueryArray(sql, rid);
//		return list;
//	}
//	
//	/**
//	 * 查询出用户所拥有的角色
//	 * @return
//	 */
//	public List<Object[]> showUserRoles(int uid){
//		String sql = "select b.uid, b.userName,(select 1 from userrole  br where  br.uid=b.uid and br.rid=?) from user b;";
//		List<Object[]> list = executeQueryArray(sql, uid);
//		return list;
//	}
//	
//	/**
//	 * 检查过滤用户菜单
//	 * @param sid
//	 * @param mid
//	 * @return
//	 */
//	public boolean chekedUserMenu(String url,int uid){
//		String sql = "select 1 from userrole ur,menurole rm,menu m where" +
//				" ur.rid=rm.rid and rm.mid = m.mid and ur.uid=? and m.url like '%"+url+"%'";
//		List<Object[]> list = executeQueryArray(sql, uid);
//		if(null!=list&&list.size()>0){
//			return true;
//		}
//		return false;
//	}
//	
	
	/**
	 * 查询所有用户资料
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 */
	public Page<User> loadAllUser(int pageNo,int pageSize){
		long tatal=(Long)this.selectOne("UserMapper.selectCount", null);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("beginIndex", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<User> list = this.selectList("UserMapper.selectPageData", map);
		return new Page<User>(pageNo, pageSize, list, tatal);
	}
	
//	/**
//	 * 查询显示积分排名前十名的用户或个人积分和积分排名前十名的用户
//	 * @return
//	 */
//	public List<User> loadSelfAndAllmark10(int uid) {
//		//查询出积分排行前十的会员的id
//		List<User> List = selectList("UserMapper.loadSelfAndAllmark10", null);
//		boolean t = false;
//		//判断当前用户的id是否存在这个集合里面
//		for(User u: List.getDataList()){
//			if(uid == u.getUid()){
//				t = true;
//				break;
//			}
//		}
//		//如果前10名未包含当前用户 则添加当前用户到该集合
//		if(!t){
//			//通过这个当前用户id查询出当前用户的所有信息得到一个对象
//			User user = this.selectOne("UserMapper.loadById", uid);
//			page.getDataList().add(user);
//		}
//		return page.getDataList();
//	}
//
//
////	/**
////	 * 注册
////	 * @param mobile
////	 * @return
////	 */
////	public void zhuce(String userName,String password,String name,String sex,
////			String address,String phone,String email,String card,int mark){
//////		String sql="select * from user where userName=?";
//////		List<Object[]> list = DButil.executeQurry(sql,new Object[]{userName});
//////		if(list.size()>0){
//////			this.getServletContext().setAttribute("Error", "账号已存在，请重新注册或登录");
//////			request.getRequestDispatcher("view/register.jsp").forward(req, resp);
//////		}else{
////////		    String sql2="insert into user(userName, password, name, sex, address, phone, email, card,mark) values(?,?,?,?,?,?,?,?,?)";
////////		    DButil.executeDML(sql2, new Object[]{userName, password, name, sex, address, phone, email, card,mark});
////////		    req.getRequestDispatcher("view/login.jsp").forward(req, resp);
//////		}
////		String sql = "insert into user(userName, password, name, sex, address, phone, email, card,mark) values(?,?,?,?,?,?,?,?,?)";
////		DButil.executeDML(sql, new Object[]{userName, password, name, sex, address, phone, email, card,mark});
////		
////		sql = "select * from user where userName=?";
////		List<Object[]> userList = DButil.executeQurry(sql, new Object[]{userName});
////		User user = null;
////		if(null!=userList&userList.size()>0){
////			for(Object[] os :userList){
////				user = new User((Integer)os[0],String.valueOf(os[1]), String.valueOf(os[2]), String.valueOf(os[3]), String.valueOf(os[4]), String.valueOf(os[5]), String.valueOf(os[6]), String.valueOf(os[7]), String.valueOf(os[8]), (Integer)os[9]);
////			}
////		}
////		sql = "insert into userrole(uid,rid) values(?,2)";
////		DButil.executeDML(sql, new Object[]{user.getUid()});
////		
////		
////	}
//
//	/**
//	 * 链接到用户页面
//	 * @return
//	 */
//	public List<User> showUser(){
//		String sql ="select * from menu where level in(1,2)";
//		List<User> userList =executeQuery(sql);
//		return userList;
////		String sql ="select * from menu where level in(1,2)";
////		List<Object[]> listUser = DButil.executeQurry(sql, null);
////		List<User> userList = new ArrayList<User>();
////		User user=null;
////		System.out.println("sfasfasf");
////		if(null!=listUser&&listUser.size()>0){
////			for(Object[] os:listUser){
////				user = new User((Integer)os[0],String.valueOf(os[1]), String.valueOf(os[2]), String.valueOf(os[3]), String.valueOf(os[4]), String.valueOf(os[5]), String.valueOf(os[6]), String.valueOf(os[7]), String.valueOf(os[8]), (Integer)os[9]);
////				userList.add(user);
////			}
////		}
//		
//	}
//	
//	/**
//	 * 修改个人信息
//	 * @param rid
//	 * @param uids
//	 */
//	public User modifySelf(User user){
//		
//		User olduser = get(user.getUid());
//		
//		olduser.setUserName(user.getUserName());
//		olduser.setName(user.getName());
//		olduser.setSex(user.getSex());
//		olduser.setAddress(user.getAddress());
//		olduser.setPhone(user.getPhone());
//		olduser.setEmail(user.getEmail());
//		
//		User user2 = Update(olduser);
////		Session session = this.getSession();
////		Transaction tx = session.beginTransaction();
////		tx.begin();
////		String sql = "update user set userName = ?,name = ?,sex= ?,address=?,phone=?,email=? where uid = ?";
//////    session.createSQLQuery(sql).executeUpdate();
////		User user = get(uid);
////		tx.commit();
////		session.close();
//		return user2;
//	}       

	/**
	 * 注销用户
	 * @param uid
	 */
	public void cancellation(int uid){
		this.delete("UserMapper.deleteUser", uid);
	}
//	
//	/**
//	 * 用户管理报表
//	 * @return
//	 */
//	public List<User> userBaob(){
//		return executeHQLQuery("from User");
//	}
//	
//	/**
//	 * 充值时加载用户
//	 * 
//	 */
//	public User showSelfUser(int uid) {
//		String sql = "select mark from user where uid=?";
//		List<User> list = executeQuery(sql, uid);
//		User user=null;
//		if(null!=list && list.size()>0){
//			user=list.get(0);
//		}
//		return user;
//	}
//	
//
//	@Override
//	public User showUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void zhuce(String userName, String password, String name,
//			String sex, String address, String phone, String email,
//			String card, int mark) {
//		// TODO Auto-generated method stub
//		
//	}


	
//	/**
//	 * 查询用户
//	 * @return
//	 */
//	public User showUsers(){
//		String sql ="select * from user";
//		List<Object[]> objectList = DButil.executeQurry(sql, null);
//		User user = null;
//		for(Object[] os :objectList){
//			user = new User((Integer)os[0],String.valueOf(os[1]), String.valueOf(os[2]), String.valueOf(os[3]), String.valueOf(os[4]), String.valueOf(os[5]), String.valueOf(os[6]), String.valueOf(os[7]), String.valueOf(os[8]), (Integer)os[9]);
//		}
//		return user;
//	}
	

}
