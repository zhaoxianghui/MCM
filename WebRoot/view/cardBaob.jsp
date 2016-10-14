<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员卡管理报表</title>
    
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
			    url:'showLevel.do?methodName=showLevel&pageNo=1&pageSize=10', 
			    frozenColumns:[[{field:'code',checkbox:true}]], 
			    rownumbers:true,
			    striped:true,
			    pagination:true,  
			    columns:[[   
			        {field:'cardid',title:'会员卡号',width:100,align:'center'}, 
			        {field:'name',title:'会员名称',width:50,align:'center'},
			        {field:'regtime',title:'发卡时间',width:100,align:'center'},
			        {field:'dueTotime',title:'到期时间',width:80,align:'center'},
			        {field:'level',title:'等级类别',width:200,align:'center'}    
			    ]],
			    toolbar:[{
			        text:'导出会员卡报表',
			        iconCls:'icon-add',
			        handler: function(){
			            window.location.href="levelBaob.do?methodName=levelBaob";
			            
			        }
			    }]
	        });
	        var pager = $('#dg').datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNumber, pageSize){
					refreshData(pageNumber, pageSize);
				}
			});
	     });
	      //刷新表格数据
		function refreshData(){
		    $('#dg').pagination('loading');
			$.post("showLevel.do",{
			    methodName:'showLevel',
			    pageNo:pageNumber,
			    pageSize:pageSize
			},function(data){
			    $('#dg').datagrid('loadData',{
			        rows:data.rows,
			        total:data.total
			    })
			    $('#dg').pagination('loaded');
			},'json');
		} 
     </script>
  </head>
  <body>
      <table id="dg"></table> 
  </body>
</html>
