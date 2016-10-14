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
    
    <title>用户注销</title>
    
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
			    url:'showUser.do?methodName=showUser&pageNo=1&pageSize=10', 
			    frozenColumns:[[{field:'code',checkbox:true}]], 
			    rownumbers:true,
			    striped:true,
			    pagination:true,  
			    columns:[[    
			        {field:'uid',title:'用户编号',width:100,align:'center'},
			        {field:'userName',title:'用户名',width:100,align:'center'},
			        {field:'password',title:'密码',width:100,align:'center'},
			        {field:'name',title:'真实名称',width:50,align:'center'},
			        {field:'sex',title:'性别',width:300,align:'center'},
			        {field:'address',title:'住址',width:100,align:'center'},    
			        {field:'phone',title:'电话',width:100,align:'center'},
			        {field:'email',title:'邮箱',width:100,align:'center'}, 
			        {field:'card',title:'信用卡号码',width:100,align:'center'}, 
			        {field:'mark',title:'积分',width:100,align:'center'},     
			    ]],
			    toolbar: [{
			    	text:'注销',
					iconCls: 'icon-modify',
					handler: function(){
						var selection = $('#dg').datagrid('getSelections');
						if(selection.length<=0){
							alert("没有选中行");
							return;
						}
						if(selection.length>1){
							alert("一次只能注销一个用户");
							return;
						}
						var array = new Array();
						for(var i in selection){
							array.push(selection[i].uid);
						}
						//将数组对象转换成字符串
						var str = array.join(',');	
						if(${login.uid}==str){
							alert("管理员不能被注销")
						}else{
							$.post('cancellation.do',{
								methodName:'cancellation',
								uid  : str
							},function(){
								alert("注销成功"),
								$('#dg').datagrid('reload')
							},'text');
						}
					}
				}]
			}); 
		}); 
	</script>
  </head>
  <body>
      <table id="dg"></table> 
      
  </body>
</html>
