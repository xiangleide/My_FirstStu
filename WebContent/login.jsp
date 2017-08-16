<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
#maindiv {
	height: 500px;
	width: 700px;
	margin: auto;
	background-color: salmon;
}
#div1{
	height: 100%;
	width: 40%;
	margin: auto;
}

</style>
</head>
<body>
	<div id="maindiv">
	<br>
	<br>
	<br>
	<div id="div1">
		<h2 align="center">学生管理系统</h2>
		<form action="login.do" method="post">
			用户名：<input type="text" name="username" /> <br> 
			密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pasword" /><br>
			<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="submit" value="登陆" />
		</form>
		<h3>${inf}</h3>
	</div>
	</div>
</body>
</html>