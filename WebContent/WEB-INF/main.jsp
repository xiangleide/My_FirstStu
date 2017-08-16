<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">
			#outdiv{
				height: 500px;
				width: 1000px;
				margin: auto;
			}
			#leftdiv{
				height: 100%;
				width: 20%;
				background-color: salmon;
				float: left;
			}
			#rightdiv{
				height: 100%;
				width: 80%;
				background-color: salmon;
				position: relative;
				float: right;
			}
			#div1{
				height: 100%;
				width: 100%;
				background-color: skyblue;
				position: absolute;
			}
			#div2{
				height: 100%;
				width: 100%;
				background-color: skyblue;
				position: absolute;
			}
			#div3{
				height: 100%;
				width: 100%;
				background-color: skyblue;
				position: absolute;
			}
			#div4{
				height: 100%;
				width: 100%;
				background-color: skyblue;
				position: absolute;
			}
			
		</style>
		
		<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript">
			
			function showedit(){
										
					$("#div1").fadeOut();
					$("#div2").fadeIn();
					$("#div3").fadeOut();
					$("#div4").fadeOut();
				
			}
			//显示学生信息
			function showdisplay(){
				
				 $.ajax({
					type:"post",
					url:"displayStudent.do",
					dataType:"json",
					data:{},
					success:function(stuList){
						$("#div1").fadeIn();
						$("#div2").fadeOut();
						$("#div3").fadeOut();
						$("#div4").fadeOut();
						var inf = "<br><br><br>";
						inf += "<table border='solid'>";
						inf += "<tr>";
						inf += "<th>number</th>";
						inf += "<th>name</th>";
						inf += "<th>sex</th>";
						inf += "<th>age</th>";
						inf += "<th>sclass</th>";
						inf += "<th>修改</th>";
						inf += "<th>删除</th>";
						inf += "</tr>";
						for (var i = 0; i < stuList.length; i++) {
							var stu = stuList[i];
							inf +="<tr>";
							inf +="<th>"+stu.id+"</th>";
							inf +="<th>"+stu.name+"</th>";
							inf +="<th>"+stu.sex+"</th>";
							inf +="<th>"+stu.age+"</th>";
							inf +="<th>"+stu.sclass+"</th>";
							inf +="<th><a  href='javascript:update("+stu.id+",\""+stu.name+"\"  ,\""+stu.sex+"\"  ,"+stu.age+" ,\""+stu.sclass+"\")'>修改</a></th>";
							inf +="<th><a  href='deleteStudent.do?id="+stu.id+"'>删除</a></th>";
							inf +="</tr>";						
						}
						inf +="</table>";
						$("#div1").html(inf);
					},
					error : function(err) {
						alert("失败");
					}

				})
			}
			function update(id,name,sex,age,sclass){
				$.ajax({
					type:"post",
					url:"changepage.do",
					dataType:"json",
					data:{
						"id":id, 
					 	"name":name,
					 	"sex":sex,
						"age":age,
						"sclass":sclass 
					},
					success:function(stu){
						$("#div1").fadeOut();
						$("#div2").fadeOut();
						$("#div3").fadeOut();
						$("#div4").fadeIn();
						var inf="<br><br><br><br>";
						
						inf+="当前修改学生信息id:"+stu.id;
						inf+="<br>";
						inf+="<form action='updateStudent.do' method='post'>";
						inf+="<input type='submit' value='修改'><br><br />";
						inf+="<input type='hidden' name='id' name='id' value='"+stu.id+"' />";
						inf+="姓名: <input type='text' name='name' id='name' value='"+stu.name+"' /> <br />";
						inf+="性别: <input type='text' name='sex' id='sex'  value='"+stu.sex+"' /> <br />";
						inf+="年龄: <input type='text' name='age' id='age'  value='"+stu.age+"' /> <br />";
						inf+="班级: <input type='text' name='sclass' id='sclass'  value='"+stu.sclass+"' /> <br />";
						inf+="</form>";
						
						$("#div4").html(inf);
						
					},
					error:function(msg){
						
					}
				})
			}
		</script>
</head>
<body>
<div id="outdiv">
			<div id="leftdiv">
				<form action="" method="get">
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<!-- displayStudent.do -->
					<a href="javascript:showdisplay()">显示学生信息</a> 
					
					<br />
					<br />
					<br />
					<br />
					<a href="javascript:showedit()">添加学生信息</a>
				</form>
				
			</div>
			<div id="rightdiv">
				<div id="div4">
				
				</div>			
				
				<div id="div2">
				<br />
				<br />
				<br />
				<br />
				<br />	
				<form action="addStudent.do" method="post">
					<input type="submit" value="添加"><br><br />
					姓名: <input type="text" name="name" id="name" value=""/> <br />
					性别: <input type="text" name="sex" id="sex"/> <br />
					年龄: <input type="text" name="age" id="age"/> <br />
					班级: <input type="text" name="sclass" id="sclass"/> <br />					
				</form> 				
				</div>
				
				<div id="div1">
					<%-- <c:if test="${stu!=null}">
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
					</c:if> --%>
				</div>
				<div id="div3">
					<br>
					<br>
					<br>
					<br>
	                <h1 style="font-size:24px">学生管理系统</h1>
	                <br>
					<br>
		
					${ref}
				</div>
			</div>
		</div>

</body>
</html>