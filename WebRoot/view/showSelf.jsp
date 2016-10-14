<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
	    <base href="<%=basePath%>">
	    <title>个人信息查询</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

  	</head>
  	<body>
       <div id="win" class="easyui-window" title="个人信息" style="width:600px;height:400px;top: 100px;"   
        data-options="iconCls:'icon-save',modal:true">   
	     
	          <table>
	          	  <tr>
	              	  <td>
	           	  	  	  <input id="uid" type="hidden" readonly="readonly" value="${login.uid}" />
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	          	  
	           	  <tr>
	           	  	  <td><label>账号:</label></td>
	           	  	  <td>
	           	  	  	  <span class="showUser">${login.userName}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>姓名:</label></td>
	           	  	  <td>
	           	  	  
	           	  	  	  <span class="showUser" >${login.name}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
		           	  <td><label>性别:</label>
		           	  	  <c:if test="${login.sex==1}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;男</c:if>
			           	  <c:if test="${login.sex==2}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女</c:if>
		           	  </td>	  
	           	  <tr>
	           	  	  <td><label>地址:</label></td>
	           	  	  <td>
	           	  	  	  <span class="showUser" >${login.address}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>电话:</label></td>
	           	  	  <td>
	           	  	  	  <span class="showUser" >${login.phone}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>邮箱:</label></td>
	           	  	  <td>
	           	  	  	  <span class="showUser" >${login.email}</span>
	           	  	  </td>
	           	  </tr>
	          </table>
           </div>	  
  	</body>
</html>
