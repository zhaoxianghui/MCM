<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>设置会员等级</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
      <p>${setUpLevel}</p>
      <form action="setUpLevel.do" method="post">
          <fieldset class="fi">
	      <input type="hidden" name="methodName" value="setUpLevel"/>
	      <select id="cc1" name="level" style="width:200px;">   
		      <option value="-1">请选择会员等级：</option>
	          <option>临时会员</option>
	          <option>普通会员</option>
	          <option>VIP</option>
		  </select>  
		  <select id="cc2" name="needMark" style="width:200px;">   
		      <option value="-1">请选择所需积分：(点)</option>
	          <option>0</option>
	          <option>3000</option>
	          <option>10000</option>
		  </select> <br/> 
	      <input type="submit" class="submit" value="提交" />
	      </fieldset>
      </form>	
  </body>
</html>
