<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" type="text/css"></link>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	body{
		text-align:center;
	}
	.buttonBack{
		background: url(skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	input{
		border:1px solid gray;
		height:22px;
	}
	a:hover{
		text-decoration: underline;
	}
</style>

</head>
<body style="overflow-y:scroll">

   
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;用户管理>>个人信息员工</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="emp!update.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>填写员工信息如下：</legend>
			<input type="hidden" name="emp.id" value="${emp.id }"/>
			
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            	<td>员工工号：</td>
                <td>${emp.empId }
                   </td>
                <td>员工姓名：</td>
                <td >${emp.trueName }
                   </td>
            </tr>
            <tr>
            	<td>员工性别：</td>
                <td>
                     ${emp.sex}
                </td>
                   </td>
                <td>出生年月：</td>
                <td >${emp.birthday }
 					 </td>
                   
            </tr>
            <tr>
          	   <td>年龄：</td>
                <td >${emp.age }
                   </td>
            	<td>身份证号：</td>
                <td>${emp.idNum }
                   </td>
               
            </tr>
            <tr>
            	<td>婚姻情况：</td>
                <td>${emp.marry }
                   </td>
                <td>政治面貌：</td>
                <td >${emp.polity }
                   </td>
            </tr>
            <tr>
            	<td>籍贯：</td>
                <td>${emp.city }
                   </td>
                <td>手机号：</td>
                <td >${emp.telNum }
                   </td>
            </tr>
            <tr>
            	<td>毕业院校：</td>
                <td>${emp.school }
                   </td>
                <td>学历：</td>
                <td >${emp.degree }
                   </td>
            </tr>
            <tr>
                <td>入职时间：</td>
                <td>${emp.startDate }
 					
  				</td>
                <td>部门名称：
                <td>	           			 
                  ${emp.deptName}
                </td>
               
            </tr>
            <tr>
            	<td>住址：</td>
                <td>${emp.address }
                   </td>
        
            </tr>
        
            <tr>
                <td>备注信息：</td>
                <td colspan="3" style="height: 42px">
                ${emp.remark }
                    <br></td>
            </tr>
          
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>