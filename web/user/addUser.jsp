<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>账户添加</h1>
	<form action="user!add.action" method="post">
	用户名：<input type="text" name="user.username"><br/>
	密码：<input type="text" name="user.password"> <span id="passwordMsg" style="color:red">${password_error}</span><br/>
	密码确认：<input type="text" name="password2"><br/>
	员工姓名：<input type="text" name="user.trueName"><br/>
	员工工号：<input type="text" name="user.empId"><br/>
	<input type="submit" value="添加">
	</form>
	</body>
</html>
