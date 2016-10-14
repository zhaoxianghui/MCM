<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    
     <title>查询显示私人积分及积分排名前十名用户</title>
    
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
	     $(function(){
	         
	         $('#dg').datagrid({    
			     url:'show10Mark.do?methodName=show10Mark&uid=${login.uid}', 
			     frozenColumns:[[{field:'code',checkbox:true}]], 
			     rownumbers:true,
			     striped:true,
			     pagination:true,  
			     columns:[[    
			         {field:'userName',title:'用户名',width:100,align:'center'},
			         {field:'mark',title:'积分',width:100,align:'center'}
			     ]]
			 });
			 
		 }); 
	 </script>

  </head>
  <body>
      <table id="dg"></table> 
    

     

     
      <!-- <p>${Error3}</p>
       <p>
      <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
      </p> 
      <table border="1" width=300px; bordercolor="blue" cellpadding="0">
          <tr>
              <td>用户名</td>
              <td>积分</td>
              
          </tr>
          <c:forEach items="${userlist}" var="u">
          <tr>
               <td>${u.userName}</td>
               <td>${u.mark}</td>
              
          </tr>
          </c:forEach>
      </table>
       -->
  </body>
</html>
