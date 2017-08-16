<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="div1">
				<br />
				<br />
				<br />
				<br />
					<%-- <c:if test="${stu!=null}"> --%>
					<table border="solid">
						<tr>
							<th>number</th>
							<th>name</th>
							<th>sex</th>
							<th>age</th>
							<th>sclass</th>
							<th>修改<th/>
							<th>删除<th/>
						</tr>
						<c:forEach var="s" items="${stu}">
							<tr>
								<th>${s.id}</th>
								<th>${s.name}</th>
								<th>${s.sex}</th>
								<th>${s.age}</th>
								<th>${s.sclass}</th>
								<th><a  href="changepage.do?id=${s.id}">修改</a><th />
								<th><a href="deleteStudent.do?id=${s.id}">删除 </a><th />
							</tr>
						</c:forEach>
					</table>
					<%-- </c:if> --%>
				</div>
</body>
</html>