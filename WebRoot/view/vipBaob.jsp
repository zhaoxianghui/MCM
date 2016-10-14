<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员管理报表</title>
    
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
			    url:'showCard.do?methodName=showCard&pageNo=1&pageSize=10', 
			    frozenColumns:[[{field:'code',checkbox:true}]], 
			    rownumbers:true,
			    striped:true,
			    pagination:true,  
			    columns:[[
			    	{field:'uid',title:'会员ID',width:100,align:'center'},    
			        {field:'balance',title:'会员卡余额',width:100,align:'center'},
			        {field:'name',title:'真实名称',width:100,align:'center'},
			        {field:'sex',title:'性别',width:80,align:'center'},
			        {field:'address',title:'住址',width:200,align:'center'},    
			        {field:'phone',title:'电话',width:100,align:'center'},
			        {field:'email',title:'邮箱',width:100,align:'center'}, 
			        {field:'mark',title:'积分',width:50,align:'center'},  
			    ]],
			    toolbar:[{
			        text:'导出会员报表',
			        iconCls:'icon-add',
			        handler: function(){
			            window.location.href="userBaob.do?methodName=cardBaob";
			            
			        }
			    }]
	        });
	        var pager = $('#dg').datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNumber, pageSize){
					$('#dg').pagination('loading');
					$.post("showCard.do",{
					    methodName:'showCard',
					    pageNo:pageNumber,
					    pageSize:pageSize
					},function(data){
					    $('#dg').datagrid('loadData',{
					        rows:data.rows,
					        total:data.total
					    })
					},'json');
					$('#dg').pagination('loaded');
				}
			});
	     });
     </script>
  </head>
  <body>
      <table id="dg"></table> 
  </body>
</html>
