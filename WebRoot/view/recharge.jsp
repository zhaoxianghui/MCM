<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <base href="<%=basePath%>">
    
      <title>充值界面</title>
    
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
	<style type="text/css">
	 	.fi{
	 	    text-align: center;
	 	    margin-left:300px;
	 	    height: 200px;
	 	    width: 400px;
	 	}
 	</style>
 	<script type="text/javascript">
 	 
		/*$(function(){
			$("#btn2").hide();
		});
		function editMySelf(){
			$(".editUser").show();
			$(".showUser").hide();
			$("#btn2").show();
			$("#btn1").hide();
		}
		function ModifyMySelf(){
			$('#win').window('close');
			$.post('recharge.do',{
				methodName : 'recharge',
				uid : $("#uid").val(),
				userName : $("#balance").val(),
			},function(){},'json');
			alert("修改成功");
			
		}*/
 	</script>
  </head>
  <body>
      <p style="color: red;font-size: 15px;">${recharge}</p>
      <form action="recharge.do?methodName=recharge" method="post">
          <fieldset class="fi">
          <input type="text" id="cc3" name="uid" placeholder="请输入用户ID" style="width:200px;">   
	      <select id="cc1" class="easyui-combobox" name="cardid" style="width:200px;">   
		      <option value="-1">请选择会员卡号(ID)</option>
	          <option>1</option>
	          <option>2</option>
	          <option>3</option>
	          <option>4</option>   
		  </select>  
		  <select id="cc2" class="easyui-combobox" name="czid" style="width:200px;">   
		      <option value="-1">请选择充值卡号</option>
	          <option>1</option>
	          <option>2</option>
	          <option>3</option>
	          <option>4</option>
		  </select> <br/> 
	      <input type="submit" class="submit" value="充值" />
	      </fieldset>
      </form>	
  </body>
</html>
