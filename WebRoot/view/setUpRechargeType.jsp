<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	    <base href="<%=basePath%>">
	    
	    <title>设定冲值类型</title>
	    
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
		    /*$('#win').window('close');  // close a window  
		    $(function(){
		        $('#dg').datagrid({    
				    url:'showUser.do?methodName=showUser&pageNo=1&pageSize=10', 
				    frozenColumns:[[{field:'code',checkbox:true}]], 
				    rownumbers:true,
				    striped:true,
				    pagination:true,  
				    columns:[[    
				        {field:'cztid',title:'充值类型ID',width:100,align:'center'},
				        {field:'rechargeBalance',title:'充值面额',width:100,align:'center'},
				        {field:'czid',title:'充值卡ID',width:100,align:'center'},
				    ]]
		    });*/
	   </script>
	   <style type="text/css">
	       #form{
	           width: 500px;
	           height: 400px;
	           margin-top:100px;
	           text-align: center;
	       }
	   </style>
  </head>
  <body>
 	  <form id="form" action="setUpRechargeType.do?methodName=setUpRechargeType" method="post">
 	  <p style="color: red;font-size: 15px;" > ${setUpRechargeType}</p>
	      <select id="cc2" name="czid" style="width:200px;">   
		      <option value="-1">请选择充值卡编号：</option>
	          <option>1</option>
	          <option>2</option>
	          <option>3</option>
	          <option>4</option>
	          <option>5</option>
	          <option>6</option>
		  </select> 
		  <select id="cc2" name="rechargeBalance" style="width:200px;">   
		      <option value="-1">请选择充值类型 ：(元)</option>
	          <option>200</option>
	          <option>500</option>
	          <option>800</option>
	          <option>1000</option>
	          <option>1500</option>
	          <option>2000</option>
		  </select> <br/> 
	      <input type="submit" class="submit" value="提交" />   
      </form>
  </body>
</html>
