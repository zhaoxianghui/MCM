<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>welcom to MCM</title>
    
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
			        {field:'mark',title:'积分',width:100,align:'center'}   
			    ]]
			    /*
			    toolbar: [{
			    	text:'添加用户',
					iconCls: 'icon-add',
					handler: function(){
						$('reg.do',{
							methodName:'register',
							userName : $("#userName").val(),
							password:$("#password").val(),
							name : $("#name").val(),
							sex : $("input[name = sex]:checked").val(),
							address : $("#address").val(),
							phone : $("#phone").val(),
							email : $("#email").val(),
							card:$("#card").val(),
							mark:$("#mark").val()
						},function(){
							alert("添加用户成功");
						});
					}
			    }];*/
			});
			var pager = $('#dg').datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNumber,pageSize){
					$('#dg').datagrid('loading');
					$.post("showUser.do",{
						methodName:'showUser',
						pageNo:pageNumber,
						pageSize:pageSize
					},function(data){
						$("#dg").datagrid("loadData",{
							rows:data.rows,
							total:data.total
						});	
					},"json");
					$('#dg').datagrid('loaded');
				}
			});
			
		}); 
		/*
		//刷新表格数据
		function refreshData(){
		    $('#dg').pagination('loading');
			$.post("showUser.do",{
			    methodName:'showUser',
			    pageNo:pageNumber,
			    pageSize:pageSize
			},function(data){
			    $('#dg').datagrid('loadData',{
			        rows:data.rows,
			        total:data.total
			    })
			    $('#dg').pagination('loaded');
			},'json');
		}*/ 
	</script>
  </head>
  <body>
  	  <a id="btn" href="javascript:query();"  class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
  	  <table id="dg"></table> 
      <!-- 
	  <label>姓名：</label>
	  <input class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:100px" id="name"> 
      <label>电话：</label>
      <input class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:120px" id="phone"> 
      <label>积分：</label>
      <input class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:120px" id="mark">   
   	  <a id="btn" href="javascript:query();"  class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
  	  <table id="dg"></table> 
  	  
  	  <script type="text/javascript">
   	  		//查询用户 
	   	  	function query(){
	   	  	    $('showUser.do',{
	   	  	    	methodName:'showUser',
	   	  	    	name:$('#name').val(), 
					phone: $('#phone').val(),
					mark: $('#mark').val()
	   	  	    },function(){},'text');
				
				/*
				mark= $('#mark').combo('getValue'); 
				var sql = "";
				$("#dg").datagrid("load",{
						sql:sql,
				}*/
			}
   	  </script>
   	 -->
  </body>
</html>
