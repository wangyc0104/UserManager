<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		});
	});
	function unameOnBlur(text) {
		var ajax;
		if (window.XMLHttpRequest){
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		}
		if(text.value==""){
			text.parentNode.getElementsByTagName("label")[0].innerHTML="必填！";
		}
	}
</script>
</head>

<body
	style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
	</div>
	
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox loginbox1">
			<form action="user" method="post">
				<input type="hidden" name="oper" value="login"/>
				<ul>
					<li><input id="uname" name="uname" type="text" class="loginuser" onblur="unameOnBlur(this);"/><label></label></li>
					<li><input id="pwd" name="pwd" type="text" class="loginpwd" onblur=""/><label></label></li>
					<li><input name="" type="submit" class="loginbtn" value="登录" /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="user/reg.jsp">注册用户</a></label><label><a href="#">忘记密码？</a></label></li>
				</ul>
			</form>
			<div style="text-align: center; color: red; font-weight: bold;">
				<c:if test="${sessionScope.flag==1 }">
					<c:out value="用户注册成功！"></c:out>
				</c:if>
				<c:if test="${sessionScope.flag==2 }">
					<c:out value="密码修改成功！"></c:out>
				</c:if>
			</div>
		</div>
	</div>

	<div class="loginbm">仅供学习交流，勿用于任何商业用途！QQ：79370772</div>

</body>
</html>
