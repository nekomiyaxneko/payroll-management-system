<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/table.css" type="text/css"></link>
<link rel="stylesheet" href="css/main.css" type="text/css"></link>


<style type="text/css">
	a:hover{ text-decoration:underline; color:#075B92;}
	.body{
		text-align:center;
	}
	.buttonBack{
		background: url(skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	.input{
		border:1px solid gray;
		height:22px;
	}
</style>
</head>
<body>
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;部门管理>>查询所有部门</td>
				<td align="right">
				<input type="checkbox"/>全选&nbsp;&nbsp;
				<a href="addDept.jsp">
					<img src="skin/22.gif"/>&nbsp;&nbsp;新增</a>&nbsp;&nbsp;
				<a href="dept.action?id=${dept.id}">
					<img src="skin/11.gif"/>&nbsp;&nbsp;删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
		<s:form action="findDept.action" method="post" theme="simple">
			部门名称（请输入关键字）：<s:textfield name="deptName" cssClass="input"/>&nbsp;&nbsp;
			负责人：<s:textfield name="manager" cssClass="input"/>&nbsp;&nbsp;
			<s:submit cssClass="buttonBack" value="高级查询"/>
		</s:form></div>
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td><input type="checkbox"/></td>
				<td>部门名称</td>
				<td>负责人名</td>
				<td>部门人数</td>
				<td>部门电话</td>
				<td>基本操作</td>
			</tr>
		  <c:forEach items="${depts}" var="dept">
			<tr bgcolor="#FFFFFF">
				<td><input type="checkbox"/></td>
				<td><a href="dept!load.action?dept.id=${dept.id}">${dept.name}</a></td>
				<td>${dept.manager}</td>
				<td>${dept.number}</td>
				<td>${dept.tel}</td>
				<td>
					<a href="dept!load.action?dept.id=${dept.id}" >
					<img src="skin/edt.gif"/>修改</a>
					<a href="dept!delete.action?dept.id=${dept.id}">
					<img src="skin/del.gif"/>删除</a>
				</td>
			</tr>  
		  </c:forEach>		
		</table>
	</div>
</div>
</body>
</html>