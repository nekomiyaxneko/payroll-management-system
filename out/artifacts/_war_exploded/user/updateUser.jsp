<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>账户修改</h1>
	<s:form action="user!update.action" 
		method="post" theme="simple">
		<s:hidden name="user.id"></s:hidden>
		<br/>
		用户名：
		<s:textfield name="user.username"/>
		<br/>
		密码：
		<s:textfield name="user.password"/>
		<br/>
		员工姓名：
		<s:textfield name="user.trueName"/>
		<br/>
		员工工号：
		<s:textfield name="user.empId"/>
		<br/>
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>