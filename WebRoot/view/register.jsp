<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <meta charset="UTF-8">
		<title>盒老师</title>
		<meta name="keywords" content="盒老师">
		<meta name="content" content="盒老师">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
	    <link type="text/css" rel="stylesheet" href="css/login.css">
	    <script type="text/javascript" src="js/jquery.min.js"></script>
	
	</head>
	<body class="login_bj" >
		<form id="" action="zhuce.do" method="post">
			<div class="zhuce_body">
				<div class="logo"><a href="#"><img src="<%=basePath%>images/logo.png" width="114" height="54" border="0"></a></div>
			    <div class="zhuce_kong">
			    	<div class="zc">
			        	 <div class="bj_bai">
			             <h3>欢迎注册</h3>
			       	     <form action="register.do" method="post">
			       	         <input type="hidden" name="methodName" value="zhuce"/>
			       	         <input name="userName" type="text" class="kuang_txt phone" placeholder="用户名">
			       	         <input name="password" type="text" class="kuang_txt phone" placeholder="密码">
		       	  	         <input name="name" type="text" class="kuang_txt phone" placeholder="真实姓名">
		       	  	         <label>性别</label>
		       	  	         <input type="radio" name="sex" value="1">男
		       	  	         <input type="radio" name="sex" value="2">女
		       	  	         
			                 <input name="address" type="text" class="kuang_txt email" placeholder="地址">
			                 <input name="phone" type="text" class="kuang_txt possword" placeholder="电话号码">
			                 <input name="email" type="text" class="kuang_txt possword" placeholder="E-mail">
			                 <input name="card" type="text" class="kuang_txt yanzm" placeholder="信用卡号码">
			                 <input name="mark" type="text" class="kuang_txt yanzm" placeholder="积分">
			                 <div>
			                	 <div class="hui_kuang"><img src="images/zc_22.jpg" width="92" height="31"></div>
			                	 <div class="shuaxin"><a href="#"><img src="images/zc_25.jpg" width="13" height="14"></a></div>
			                 </div>
			                 <div>
			               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
			                 </div>
			                 <!-- <input name="注册" type="button" class="btn_zhuce" value="注册"> -->
		                    <input name="注册" type="submit" value="注册">
		                </form>
			            </div>
			        	<div class="bj_right">
			                <p>已有账号？<a href="view/login.jsp">立即登录</a></p>
			        	</div>
			    </div>
			</div>
		</form>
	</body>
</html>
