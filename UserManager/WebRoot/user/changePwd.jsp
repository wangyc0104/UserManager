<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'changePwd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function validatePwd() {
		var oldPwd = document.getElementsByName("oldPwd")[0].value;
		var newPwd = document.getElementsByName("newPwd")[0].value;
		var newPwd2 = document.getElementsByName("newPwd2")[0].value;
		if (oldPwd == "") {
			var p1 = document.getElementById("p1");
			p1.innerHTML = "密码不能为空";
			return false;
		}
		if (newPwd == "") {
			var p2 = document.getElementById("p2");
			p2.innerHTML = "新密码不能为空";
			return false;
		}
		if ((newPwd == newPwd2) == false) {
			var p3 = document.getElementById("p3");
			p3.innerHTML = "两次密码不一致";
			return false;
		}
	}
</script>
</head>

<body>
	<form action="user" onsubmit="return validatePwd();" target="_top">
		<input type="hidden" name="oper" value="pwd" /> 
		原始密码：<input type="text" name="oldPwd" value="" /><label id="p1"></label><br /> 
		&nbsp;&nbsp;新密码：<input type="text" name="newPwd" value="" /><label id="p2"></label><br /> 
		确认密码：<input type="text" name="newPwd2" value="" /><label id="p3"></label><br />
		<input type="submit" value="确认修改密码" />
	</form>
</body>
</html>
