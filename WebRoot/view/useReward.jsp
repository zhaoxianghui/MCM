<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <base href="<%=basePath%>">
    
      <title>消费奖励</title>
    
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
      <style type="text/css">
        #win{
            margin-top: 200px;
        }
      </style>
  </head>
  <body>
      <form action="useReward.do?methodName=rewardAdd" method="post">
           <p style="color: red;font-size: 15px;">${useReward}</p>
	      <select id="cc2" name="useBalance" style="width:200px;">   
			    <option value="-1">请选择消费类型 ：(元)</option>
		        <option>200</option>
		        <option>500</option>
		        <option>800</option>
		        <option>1000</option>
		        <option>1500</option>
		        <option>2000</option>
	  	  </select> <br />
	  	  <select id="cc2" name="addMark" style="width:200px;">   
			    <option value="-1">请选择奖励积分：</option>
		        <option>10</option>
		        <option>20</option>
		        <option>80</option>
		        <option>120</option>
		        <option>150</option>
		        <option>200</option>
	  	  </select> <br />
	      <input type="submit" class="submit" value="提交" />
		   
	   </form>  
  </body>
</html>
