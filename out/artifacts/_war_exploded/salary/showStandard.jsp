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
				<td class="td_top"><b>当前位置:</b>&nbsp;薪资管理>>设置基本工资</td>
				<td align="right">
				
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
		<s:form action="findStand.action" method="post" theme="simple">
			工号：<s:textfield name="salaryStandard.empId" cssClass="input"/>&nbsp;&nbsp;
			姓名：<s:textfield name="salaryStandard.trueName" cssClass="input"/>&nbsp;&nbsp;
			<s:submit cssClass="buttonBack" value="查询"/>
		</s:form></div>
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>工号</td>
				<td>姓名</td>
				<td>基本工资</td>
				<td>基本操作</td>
			</tr>
		  <c:forEach items="${salaryStandards}" var="salaryStandard" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td><a href="salaryStandard!load.action?salaryStandard.id=${salaryStandard.id}">
					${salaryStandard.empId}</a></td>
				<td>${salaryStandard.trueName}</td>	
				<td>${salaryStandard.baseSalary}</td>	
				<td>
					<a href="salaryStandard!load.action?salaryStandard.id=${salaryStandard.id}" >
					<img src="skin/edt.gif"/>修改</a>
				</td>
			</tr>  
		  </c:forEach>		
		</table>
	</div>
</div>
</body>
</html>