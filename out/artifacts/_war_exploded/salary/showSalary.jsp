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
<script language="javascript" type="text/javascript" 
src="${pageContext.request.contextPath}/user/js/jquery-1.4.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//获取年度下拉框值
        var date = new Date(); 
        var year = date.getFullYear() - 2;
        for(var i = 0;i < 5 ; i++){
           if(year + i == date.getFullYear()){
             var option= $("<option></option>").val(year+i).text(year+i).attr("selected",true).appendTo($("#year"));
           }else{
             $("<option></option>").val(year+i).text(year+i).appendTo($("#year"));
           }
       	}
    });
   function getDate(){	
	var year=document.getElementById("year").value;	
	var year2=document.getElementById("year2");	
	year2.value=year;	
	var month=document.getElementById("month").value;	
	var month2=document.getElementById("month2");	
	month2.value=month;	
  }
</script>
</head>
<body>
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;薪资管理>>查询所有薪资</td>
				<td align="right">
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
		<s:form action="findSalary.action" method="post" theme="simple">
			工号：<s:textfield name="salary.empId" cssClass="input"/>&nbsp;&nbsp;
			姓名：<s:textfield name="salary.trueName" cssClass="input"/>&nbsp;&nbsp;
			年份：<select id="year" name="salary.year" cssClass="input">&nbsp;&nbsp;</select>
			月份：&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
			<select name="salary.month" id="month">
				<c:forEach var="everyMonth" items="${monthList}"> 
	           		 <c:choose>
	           			  	<c:when test="${everyMonth==month}">
	           			  		<option  value="${everyMonth}" selected>${everyMonth}</option>
	           			  	</c:when>
	           			  	<c:otherwise>
	           			  		<option value="${everyMonth}">${everyMonth}</option>
	           			  	</c:otherwise>
	           			  </c:choose>
				</c:forEach>
			</select>&nbsp;&nbsp;
			<s:submit cssClass="buttonBack" value="查询"/>
			<!--  
			<input type="button" value="生成" 
			onclick="location='/EmpManageSys/salary/addSalarys.action?'" class="buttonBack"/>
			-->
		</s:form></div>
		
		<div >
			<s:form action="addSalarys.action" method="post" theme="simple">
			<input id="year2" name="salary.year"/ style="display: none">&nbsp;&nbsp;
			<input id="month2" name="salary.month" style="display: none"/>
				<s:submit cssClass="buttonBack" value="生成" onclick="getDate();"/>
			</s:form>
		</div>
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>工号</td>
				<td>姓名</td>
				<td>年份</td>
				<td>月份</td>
				<td>基本工资</td>
				<td>迟到罚款</td>
				<td>早退罚款</td>
				<td>最终工资</td>
				<td>基本操作</td>
			</tr>
		  <c:forEach items="${salarys}" var="salary" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td><a href="salary!load.action?salary.id=${salary.id}">
					${salary.empId}</a></td>		
				<td>${salary.trueName}</td>
				<td>${salary.year}</td>
				<td>${salary.month}</td>
				<td>${salary.baseSalary}</td>
				<td>${salary.lateCome}</td>
				<td>${salary.earlyLeave}</td>
				<td>${salary.finalSalary}</td>
				<td>
				<a href="salary!load.action?salary.id=${salary.id}" >
					<img src="skin/edt.gif"/>查看</a>
				<!--  
					<a href="salary!load.action?salary.id=${salary.id}" >
					<img src="skin/edt.gif"/>修改</a>
					<a href="salary!delete.action?salary.id=${salary.id}">
					<img src="skin/del.gif"/>删除</a>
				-->
				</td>
			</tr>  
		  </c:forEach>		
		</table>
	</div>
</div>
</body>
</html>