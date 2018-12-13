<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	
	<h1>账号列表</h1>
		<s:if test="page<=1">
			<a>上一页</a>
		</s:if>
		<s:else>
			<a href="list.action?page=${page-1 }">上一页</a>
		</s:else>
	当前【
	<s:property value="page"/>
	/
	<s:property value="totalPages"/>
	】页

	<s:if test="page>=totalPages">
			<a>下一页</a>
	</s:if>
	<s:else>
			<a href="list.action?page=${page+1 }">下一页</a>
	</s:else>
		<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>工号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
	<!-- 在循环过程总，
	struts会将当前循环元素压入root栈顶，
	因此表达式直接写"id",访问的是元素的id属性值 
	stat是一个迭代状态对象，具有index,count,first,last,even,odd。
	-->
	<s:iterator value="users" status="stat">
		<tr>
			<td><s:property value="#stat.count"/> id:${id }</td>
			<td><s:property value="trueName"/></td>
			<td><s:property value="empId"/></td>
			<td><s:property value="username"/></td>
			<td><s:property value="password"/></td>
			<td>
			<a href="user!delete.action?id=${id }" onclick="return confirm('确定删除?');">删除</a>
			<a href="user!load.action?id=${id }">更新</a>
			</td>
		</tr>
	</s:iterator>
	</table>
	<a href="addUser.jsp">添加</a>
</html>
