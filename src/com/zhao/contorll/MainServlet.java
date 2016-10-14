package com.zhao.contorll;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
import com.zhao.entity.Level;
import com.zhao.entity.Menu;
import com.zhao.entity.MenuRole;
import com.zhao.entity.Page;
import com.zhao.entity.Role;
import com.zhao.entity.User;
import com.zhao.entity.UserRole;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
//import com.zhao.util.JasperReportHelper;
import com.zhao.vo.CardVo;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet{
	//控制层持有模型层
	private UserModel userModel=new UserModelImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
    
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//利用反射机制获取方法
		//接受所有请求
		req.setCharacterEncoding("utf-8");
		String methodName=req.getParameter("methodName");
		Class c=MainServlet.class;
		Method m;
		try {
			m = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this,req,resp);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		System.out.println("contorller控制层");
		User user = userModel.loadUserByMobile(userName);
		
		if(null!=user){
			if(password.equals(user.getPassword())){
				List<Menu> menulist = userModel.loadMenu(user.getUid());
				req.setAttribute("menulist", menulist);
				//登录成功，保存数据
				req.getSession().setAttribute("login", user);
				req.getRequestDispatcher("view/welcom.jsp").forward(req, resp);
			}else{
				//this.getServletContext().setAttribute("login", user);
				req.setAttribute("Error1", "密码错误");
				req.getRequestDispatcher("view/login.jsp").forward(req, resp);
			}
		}else{
			this.getServletContext().setAttribute("Error2", "账号不存在");
			req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		}
	}
	
//	/**
//	 * 查看角色
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void showroel(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		
//		List<Role> rolelist=userModel.showRole();
//		req.setAttribute("rolelist", rolelist);
//		req.setAttribute("date", new Date());
//		req.getRequestDispatcher("view/showRole.jsp").forward(req, resp);
//	}
//	
//	/**
//	 * 查询出用户所拥有的权限返回   Jurisdiction
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void updateRoleMenu(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String rid = req.getParameter("rid");
//		
//		List<Object[]>  objectList = userModel.showRolemenu(Integer.valueOf(rid));
//		req.setAttribute("show", objectList);
//		Role role = userModel.showRoleRid(Integer.valueOf(rid));
//		
//		req.setAttribute("role", role);
//		req.getRequestDispatcher("view/updateRoleMenu.jsp").forward(req, resp);
//	}
//	
//	/**
//	 * 修改角色权限
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	
//	public void delectRoleMenu(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String rid = req.getParameter("rid");
//		String mid = req.getParameter("mid");
//		
//		MenuRole mr = new MenuRole(Integer.valueOf(mid), Integer.valueOf(rid));
//		userModel.delectRoleMenu(mr);
//		req.setAttribute("userRoleList", "修改用户权限成功");
//		this.updateRoleMenu(req, resp);
//	}
//	
//	/**
//	 * 修改用户角色
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void updateUserRole(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String uid = req.getParameter("uid");
//		String rid = req.getParameter("rid");
//		
//		
//		Role role = userModel.showRoleRid(Integer.valueOf(rid));
//		req.setAttribute("role", role);
//		//返回一个角色集合
//		List<Object[]> objectList = userModel.showUserRoles(Integer.valueOf(rid));
//		
//		req.setAttribute("userRoleList", objectList);
//		req.getRequestDispatcher("view/updateUserRole.jsp").forward(req, resp);
//	}
//	
//	/**
//	 * 返回修改的角色
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void updateUserRoles(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String uid = req.getParameter("uid");
//		String rid = req.getParameter("rid");
////		String[] bids = req.getParameterValues("uids");
//		
//		UserRole userrole=new UserRole(Integer.valueOf(uid), Integer.valueOf(rid));
//		userModel.updateUserRoles(userrole);
//		req.setAttribute("userRole", "修改角色成功");
//		this.updateUserRole(req, resp);
//	}
//	
//	/**
//	 * 用户注册
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void zhuce(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		
//		req.setCharacterEncoding("utf-8");
//		String userName=req.getParameter("userName");
//		String password=req.getParameter("password");
//		String name=req.getParameter("name");
//		String sex=req.getParameter("sex");
//		String address=req.getParameter("address");
//		String phone=req.getParameter("phone");
//		String email=req.getParameter("email");
//		String card=req.getParameter("card");
//		String mark=req.getParameter("mark");
//		
//		userModel.zhuce(userName, password, name, sex, address, phone, email, card,Integer.valueOf(mark));
//		
//		
////		String sql="select * from user where userName=?";
////		List<Object[]> list = DButil.executeQurry(sql,new Object[]{userName});
////		if(list.size()>0){
////			this.getServletContext().setAttribute("Error", "账号已存在，请重新注册或登录");
////			req.getRequestDispatcher("view/register.jsp").forward(req, resp);
////		}else{
////		    String sql2="insert into user(userName, password, name, sex, address, phone, email, card,mark) values(?,?,?,?,?,?,?,?,?)";
////		    DButil.executeDML(sql2, new Object[]{userName, password, name, sex, address, phone, email, card,mark});
////		    req.getRequestDispatcher("view/login.jsp").forward(req, resp);
////		}
//	}
//	
////	/**
////	 * 链接到用户页面
////	 * @param req
////	 * @param resp
////	 * @throws ServletException
////	 * @throws IOException
////	 */
////	public void byZhucePage(HttpServletRequest req, HttpServletResponse resp)
////	throws ServletException, IOException {
////		
////		List<User> zhuCe = userModel.showUser();
////		req.setAttribute("zhuCe", zhuCe);
////		req.getRequestDispatcher("view/register.jsp").forward(req, resp);
////	}
//	
//	/**
//	 * 退出登录
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void logout(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		req.getSession().invalidate();
//		req.getRequestDispatcher("view/login.jsp").forward(req, resp);
//	}
//	
	/**
	 * 查询显示所有用户资料
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		String name = req.getParameter("name");
//		String phone = req.getParameter("phone");
//		int mark=Integer.valueOf(req.getParameter("mark"));
		int pageNo=Integer.valueOf(req.getParameter("pageNo"));
		int pageSize=Integer.valueOf(req.getParameter("pageSize"));
		 
		Page<User> page=userModel.loadAllUser(pageNo,pageSize);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", page.getDataList());
		map.put("total", page.getTotal());
		
		String json = JSONObject.fromObject(map).toString();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
	
	}

//	/**
//	 * 查询显示私人积分及积分排名前十名的人
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void show10Mark(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String uid = req.getParameter("uid");
//		
//		List<User> list=userModel.loadSelfAndAllmark10(Integer.valueOf(uid));
//		String json = JSONArray.fromObject(list).toString();
//		resp.setCharacterEncoding("utf-8");
//		resp.getWriter().write(json);
//		resp.getWriter().flush();
//		
//	}
//	
//	/**
//	 * 修改个人信息
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void modifySelf(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		
//		String uid = req.getParameter("uid");
//		String userName = req.getParameter("userName");
//		String name = req.getParameter("name");
//		String sex = req.getParameter("sex");
//		String address = req.getParameter("address");
//		String phone = req.getParameter("phone");
//		String email = req.getParameter("email");
//		
//		User user = new User(Integer.valueOf(uid), userName, name, Integer.valueOf(sex), address, phone, email);
//		User user1=userModel.modifySelf(user);
//		
//	}
	
	/**
	 * 注销用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void cancellation(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String uid=req.getParameter("uid");
		userModel.cancellation(Integer.valueOf(uid));
		
	}
//	
//	
//	/**
//	 * 用户管理报表
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void userBaob(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		
//		List<User> listuser=userModel.userBaob();
//		JasperReportHelper<User> heper= new JasperReportHelper<User>();
//		//Map集合返回数据
//		Map<String,Object> map = new HashMap<String,Object>();
//		//生成报表
//		String jasperFilePath = this.getServletContext().getRealPath("")+"/jasper/users.jasper";
//		heper.export(jasperFilePath, "用户管理报表.xls", map, listuser, resp);
//	}
//	
//	/**
//	 * 查询所有会员及关联的详细信息
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void showCard(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		
//		int pageNo=Integer.valueOf(req.getParameter("pageNo"));
//		int pageSize=Integer.valueOf(req.getParameter("pageSize"));
//		Page<CardVo> page=userModel.loadAllCard(pageNo,pageSize);
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("rows", page.getDataList());
//		map.put("total", page.getTotal());
//		
//		String json = JSONObject.fromObject(map).toString();
//		resp.setCharacterEncoding("utf-8");
//		resp.getWriter().write(json);
//		resp.getWriter().flush();
//	}
//	
//	/**
//	 * 会员管理报表
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void cardBaob(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		
//		List<CardVo> listcardvo=userModel.cardBaob();
//		JasperReportHelper<CardVo> heper= new JasperReportHelper<CardVo>();
//		//Map集合返回数据
//		Map<String,Object> map = new HashMap<String,Object>();
//		//生成报表
//		String jasperFilePath = this.getServletContext().getRealPath("")+"/jasper/vipBaob.jasper";
//		heper.export(jasperFilePath, "会员管理报表.xls", map, listcardvo, resp);
//	}
//	
//	/**
//	 * 查询所有会员卡及关联的详细信息
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void showLevel(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		
//		int pageNo=Integer.valueOf(req.getParameter("pageNo"));
//		int pageSize=Integer.valueOf(req.getParameter("pageSize"));
//		Page<Level> page=userModel.loadAllLevel(pageNo,pageSize);
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("rows", page.getDataList());
//		map.put("total", page.getTotal());
//		
//		String json = JSONObject.fromObject(map).toString();
//		resp.setCharacterEncoding("utf-8");
//		resp.getWriter().write(json);
//		resp.getWriter().flush();
//	}
//	/**
//	 * 会员卡管理报表
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void levelBaob(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		
//		//获取展示页面的当前第几页
//		String pN=req.getParameter("pageNo");
//		int pageNo=null!=pN&&!"".equals(pN)?Integer.valueOf(pN):1;
//		//获取一页展示多少行
//		String pS=req.getParameter("pageSize");
//		int pageSize=null!=pS&&!"".equals(pS)?Integer.valueOf(pS):10;
//		Page<Level> page=userModel.levelBaob(pageNo,pageSize);
//		JasperReportHelper<Level> heper= new JasperReportHelper<Level>();
//		//Map集合返回数据
//		Map<String,Object> map = new HashMap<String,Object>();
//		//生成报表
//		String jasperFilePath = this.getServletContext().getRealPath("")+"/jasper/cardBaob.jasper";
//		heper.export(jasperFilePath, "会员卡管理报表.xls", map, page.getDataList(), resp);
//	}
//	
//	/**
//	 * 设定会员等级
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void setUpLevel(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String level=req.getParameter("level");
//		int needMark=Integer.valueOf(req.getParameter("needMark"));
//		
//		if(needMark==-1&&level=="-1"){
//			req.setAttribute("setUpLevel", "会员等级设定错误，请重新选择！！！");
//			req.getRequestDispatcher("view/setUpLevel.jsp").forward(req, resp);
//		}else{
//			userModel.setUpLevel(level,needMark);
//			req.setAttribute("setUpLevel", "会员等级设定成功");
//			req.getRequestDispatcher("view/setUpLevel.jsp").forward(req, resp);
//		}
//	}
//	
//	/**
//	 * 设定充值卡类型
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void setUpRechargeType(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		int rechargeBalance=Integer.valueOf(req.getParameter("rechargeBalance"));
//		int czid=Integer.valueOf(req.getParameter("czid"));
//		if(rechargeBalance==-1&&czid==-1){
//			req.setAttribute("setUpRechargeType", "充值类型设定错误，请重新选择！！！");
//			req.getRequestDispatcher("view/setUpRechargeType.jsp").forward(req, resp);
//		}else{
//			userModel.setUpRechargeType(rechargeBalance,czid);
//			req.setAttribute("setUpRechargeType", "充值类型设定成功");
//			req.getRequestDispatcher("view/setUpRechargeType.jsp").forward(req, resp);
//		}
//	}
//	
//	/**
//	 * 设定充值奖励
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void rechargeAdd(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		int rechargeBalance=Integer.valueOf(req.getParameter("rechargeBalance"));
//		int addmoney=Integer.valueOf(req.getParameter("addmoney"));
//		
//		if(rechargeBalance==-1&&addmoney==-1){
//			req.getRequestDispatcher("view/rechargeAdd.jsp").forward(req, resp);
//		}else{
//			userModel.rechargeAdd(rechargeBalance,addmoney);
//			req.setAttribute("rechargeAdd", "充值奖励设定成功");
//			req.getRequestDispatcher("view/rechargeAdd.jsp").forward(req, resp);
//		}
//		
//		
//	}
//	
//	/**
//	 * 用户充值管理
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	/*
//	public void recharge(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		
//		req.setCharacterEncoding("utf-8");
//		String uid=req.getParameter("uid");
//		String czid=req.getParameter("czid");
//		String cardid=req.getParameter("cardid");
//		String balance=req.getParameter("balance");
//		String addmoney=req.getParameter("addmoney");
//		
//		Card card =userModel.showSelfCard(Integer.valueOf(cardid));
//		CZCardType czCardType = userModel.showSelfzcCard(Integer.valueOf(czid));
//		Reward reward =userModel.showReward();
//		User user = userModel.showSelfUser(Integer.valueOf(uid));
//		//会员卡余额增加
//		int i=card.getBalance()+czCardType.getRechargeBalance()+reward.getAddmoney();
//		String sql = "update card set balance=? where card=?";
//		DButil.executeDML(sql, new Object[]{i,cardid});
//        //会员积分增加
//		int j=czCardType.getPriceMark()+user.getMark();
//		sql = "update user set mark=? where uid=?";
//		DButil.executeDML(sql, new Object[]{j,uid});
//		
//		//用户等级上升
//		if(j>=3000&&j<10000){
//			if(user.getMark()<3000){
//				req.setAttribute("recharge", "恭喜你成为普通会员");
//				req.getRequestDispatcher("view/recharge.jsp").forward(req, resp);
//			}else{
//				req.setAttribute("recharge", "充值成功");
//				req.getRequestDispatcher("view/recharge.jsp").forward(req, resp);
//			}
//		}else if(j>=10000){
//			if(user.getMark()<10000){
//				req.setAttribute("recharge", "恭喜你成为VIP会员");
//				req.getRequestDispatcher("view/recharge.jsp").forward(req, resp);
//			}else{
//				req.setAttribute("recharge", "充值成功");
//				req.getRequestDispatcher("view/recharge.jsp").forward(req, resp);
//			}
//		}else{
//			req.setAttribute("recharge", "充值成功");
//			req.getRequestDispatcher("view/recharge.jsp").forward(req, resp);
//		}
//		
//	}
//	*/
//	/**
//	 * 自动消费结算（用户消费）
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void using(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//		String uid=req.getParameter("uid");
//		String cardid=req.getParameter("cardid");
//		String usid=req.getParameter("usid");
//		
//		User user = userModel.showSelfUser(Integer.valueOf(uid));
////		Useing us=userModel.use(Integer.valueOf(usid));
//		
//	}
//	
//	/**
//	 * 设定消费奖励
//	 * @param req
//	 * @param resp
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void rewardAdd(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
//        int useBalance=Integer.valueOf(req.getParameter("useBalance"));
//        int addMark=Integer.valueOf(req.getParameter("addMark"));
//		
//		if(useBalance==-1&&addMark==-1){
//			req.setAttribute("useReward", "消费奖励设定错误，请重新设定！！！");
//			req.getRequestDispatcher("view/useReward.jsp").forward(req, resp);
//		}else{
//			userModel.rewardAdd(useBalance,addMark);
//			req.setAttribute("useReward", "消费奖励设定成功");
//			req.getRequestDispatcher("view/useReward.jsp").forward(req, resp);
//		}
//	}
	
}