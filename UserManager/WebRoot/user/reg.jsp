<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>" />
	<meta charset="UTF-8">
	<title>Basic Form - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="用户注册" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form action="user" id="ff" method="post">
	    	<input type="hidden" name="oper" value="reg" />
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input type="text" name="uname" value="" class="easyui-validatebox textbox" missingMessage="用户名必填" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input type="text" name="pwd" value="" class="easyui-validatebox textbox" missingMessage="密码必填" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>男:<input type="radio" name="sex" value="1" />&emsp;女:<input type="radio" name="sex" value="0" /></td>
	    		</tr>
	    		<tr>
	    			<td>年龄:</td>
	    			<td><input type="text" name="age" value="" /></td>
	    		</tr>
	    		<tr>
	    			<td>生日:</td>
	    			<td>
	    				<input name="birth" type="text" value="" class="easyui-datebox" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" style="text-align:center;vertical-align:middle;"><input type="submit" value="提交用户信息" /></td>
	    		</tr>
	    	</table>
	    </form>
	    <!-- <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">注册</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
	    </div> -->
	    </div>
	</div>
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>
	<script>
		function submitForm(){
			$('#ff').form('submit');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>