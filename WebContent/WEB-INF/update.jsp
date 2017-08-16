<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="div3">
				<br />
				<br />
				<br />
				<br />
				<br />
				当前修改的id为:${id}
					<form action="updateStudent.do?id=${id}" method="get">
					<br />
					姓名: <input type="text" name="name" id="name" value=""/> <br />
					性别: <input type="text" name="sex" id="sex"/> <br />
					年龄: <input type="text" name="age" id="age"/> <br />
					班级: <input type="text" name="sclass" id="sclass"/> <br />
					<input type="submit" value="修改">
				</form> 
				<br>
				<br>
				${ref}
				</div>

</body>
</html>