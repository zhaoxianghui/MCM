<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <base href="<%=basePath%>">
    
      <title>充值奖励</title>
    
	  <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
	  <meta http-equiv="expires" content="0">    
	  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	  <meta http-equiv="description" content="This is my page">
	  <script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/jquery.min.js"></script>
	  <script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
      <script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
      <link rel="stylesheet" type="text/css" href="<%=basePath%>/jquery-easyui-1.3.3/themes/icon.css"/>
      <link rel="stylesheet" type="text/css" href="<%=basePath%>/jquery-easyui-1.3.3/themes/default/easyui.css"/>
      <script type="text/javascript">
          
      </script>
  </head>
  <body>
  <p style="color: red;font-size: 15px;">${rechargeAdd}</p>
      <form action="rechargeAdd.do" method="post">
      	  <input type="hidden" name="methodName" value="rechargeAdd"/>
	      <select id="cc2" name="rechargeBalance" style="width:200px;">   
			    <option value="-1">请选择充值类型 ：(元)</option>
		        <option>200</option>
		        <option>500</option>
		        <option>800</option>
		        <option>1000</option>
		        <option>1500</option>
		        <option>2000</option>
	  	  </select> 
	  	  <select id="cc2" name="addmoney" style="width:200px;">   
			    <option value="-1">请选择奖励金额：</option>
		        <option>10</option>
		        <option>20</option>
		        <option>80</option>
		        <option>100</option>
		        <option>150</option>
		        <option>300</option>
	  	  </select> 
	      <input type="submit" class="submit" value="提交" />
      </form>
  </body>
</html>
