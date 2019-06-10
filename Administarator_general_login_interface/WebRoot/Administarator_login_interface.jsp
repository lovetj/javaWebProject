<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form method="post" name="form1">
		<div
			style="width: 480px;higth :100px;margin-top: 10%;padding-left:1%;padding-right:1%;padding-top:1%;padding-bottom: 1%;margin-left:30%;border: 1px solid darkgrey;"
			align="center">
			<table style="font-family: '楷体';">
				<tr style="font-size: 50px;">
					<th colspan="4"><p align="center">管理员登录</p>
					</th>
				</tr>

				<tr>
					<th>&nbsp;&nbsp; <label> <span
							class="glyphicon glyphicon-user"></span> </label></th>
					<th><input type="text" class="form-control" name="adminname"
						placeholder="请输入账号" onclick="mes.innerHTML=''"
						value="${param.adminname }" /></th>
				</tr>

				<tr>
					<th>&nbsp;&nbsp; <label> <span
							class="glyphicon glyphicon-lock"></span> </label></th>
					<th><input type="password" class="form-control"
						name="adminpassword" placeholder="请输入密码"
						value="${param.adminpassword }" /></th>
				</tr>

				<tr>
					<th align="center" style="font-size: 20px;">验证码:</th>
					<th><input type="text" class="form-control"
						placeholder="请输入验证码" name="checkcode" /></th>
					<th><img border="0" src="CheckCode" /></th>
					<th><input type="submit" class="btn btn-link btn-sm"
						value="看不清,换一张" onclick="form1.action='ChangeCheckCode_one'" /></th>
				</tr>

				<tr>
					<th colspan="4"><p align="center" style="color: red;">
							${info}</p>
					</th>
				</tr>

				<tr>
					<th colspan="2">
						<div align="center">
							<input type="button" class="btn btn-success" value="重置"
								onclick="window.parent.location.href='Administarator_login_interface.jsp'" />
						</div></th>
					<th colspan="1"><input type="submit" value="登录"
						onclick="form1.action='Admin_servlet'" class="btn btn-success" />
					</th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
