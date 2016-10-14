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
    
    <title>个人信息修改</title>
    
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
	 	.editUser{
	 		display: none;
	 	}
 	</style>
 	<script type="text/javascript">
		$(function(){
			$("#btn2").hide();
		});
		function editMySelf(){
			$(".editUser").show();
			$(".showUser").hide();
			$("#btn2").show();
			$("#btn1").hide();
		}
		function ModifyMySelf(){
			$.post('modifySelf.do',{
				methodName : 'modifySelf',
				uid : $("#uid").val(),
				userName : $("#user_Name").val(),
				name : $("#real_Name").val(),
				sex : $("input[name = sex]:checked").val(),
				address : $("#address").val(),
				phone : $("#phone").val(),
				email : $("#email").val()
			},function(){
				$('#win').window('close');	
				alert("修改成功");
			},'json');
			
		}
 	</script>
  </head>
  <body>
  	  <div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px;top: 100px;"   
        data-options="iconCls:'icon-save',modal:true">   
	      <table id="table"></table>
	          <table>
	          	  <tr>
	              	  <td>
	           	  	  	  <input id="uid" type="hidden" readonly="readonly" value="${login.uid}" />
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>账号</label></td>
	           	  	  <td>
	           	  	  	  <input id="user_Name" type="text" class="editUser" readonly="readonly" value="${login.userName}"/>
	           	  	  	  <span class="showUser">${login.userName}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>姓名</label></td>
	           	  	  <td>
	           	  	  	  <input id="real_Name" type="text" class="editUser" value="${login.name}"/>
	           	  	  	  <span class="showUser" >${login.name}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>性别</label></td>
	           	  	  <td>
	           	  	  	  <span class="editUser" >
	           	  	  	   	  <input type="radio" name="sex" value="1" <c:if test="${login.sex==1}">checked</c:if>/>男
							  <input type="radio" name="sex" value="2" <c:if test="${login.sex==2}">checked</c:if>/>女
						  </span>
						  <span class="showUser" >
							  <c:if test="${login.sex==1}">男</c:if>
			           	  	  <c:if test="${login.sex==2}">女</c:if>
			           	  </span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>地址</label></td>
	           	  	  <td>
	           	  	  	  <input id="address" type="text" class="editUser" value="${login.address}"/>
	           	  	  	  <span class="showUser" >${login.address}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>电话</label></td>
	           	  	  <td>
	           	  	  	  <input id="phone" type="text" class="editUser" value="${login.phone}"/>
	           	  	  	  <span class="showUser" >${login.phone}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td><label>邮箱</label></td>
	           	  	  <td>
	           	  	  	  <input id="email" type="text" class="editUser" value="${login.email}"/>
	           	  	  	  <span class="showUser" >${login.email}</span>
	           	  	  </td>
	           	  </tr>
	           	  <tr>
	           	  	  <td colspan="2">
	           	  	  	  <a id="btn1" href="javascript:editMySelf();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">编辑</a>  
	           	  	  	  <a id="btn2" href="javascript:ModifyMySelf();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>   
	           	  	  </td>
	           	  </tr>
	          </table>
           </div>	   	  
     </body>
</html>
