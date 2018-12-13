<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="css/main.css" type="text/css"></link>



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
	
   
<div class="table_top" style="height:100%" >
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;员工管理>>添加员工</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="emp!add.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>填写员工信息如下：</legend>
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            	<td>员工工号：</td>
                <td><input type="text" name="emp.empId"/></td>
                   </td>
                <td>员工姓名：</td>
                <td ><input type="text" name="emp.trueName"/></td>
                   </td>
            </tr>
            <tr>
            	<td>员工性别：</td>
                <td><input name="emp.sex" type="radio" value="男"  checked="checked"/>男
                <input name="emp.sex" type="radio" value="女" />女	</td>
                   </td>
                <td>出生年月：</td>
                <td ><input class="Wdate" type="text" name="emp.birthday" id="time"
 					 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
                   </td>
            </tr>
            <tr>
          	   <td>年龄：</td>
                <td ><input type="text" name="emp.age"/></td>
                   </td>
            	<td>身份证号：</td>
                <td><input type="text" name="emp.idNum"/></td>
                   </td>
               
            </tr>
            <tr>
            	<td>婚姻情况：</td>
                <td><input type="text" name="emp.marry"/></td>
                   </td>
                <td>政治面貌：</td>
                <td ><input type="text" name="emp.polity"/></td>
                   </td>
            </tr>
            <tr>
            	<td>籍贯：</td>
                <td><input type="text" name="emp.city"/></td>
                   </td>
                <td>手机号：</td>
                <td ><input type="text" name="emp.telNum"/></td>
                   </td>
            </tr>
            <tr>
            	<td>毕业院校：</td>
                <td><input type="text" name="emp.school"/></td>
                   </td>
                <td>学历：</td>
                <td ><input type="text" name="emp.degree"/></td>
                   </td>
            </tr>
            <tr>
                <td>入职时间：</td>
                <td><input class="Wdate" type="text" name="emp.startDate" id="time"
 					 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
  				</td>
                <td>部门名称：</td>
                <td>
                   <select name="emp.deptName" >
                   
                     <c:forEach items="${depts}" var="dp">
                       <option value="${dp.name}">${dp.name }</option> 
                       ${pd.name}            
                     </c:forEach>
                    </select>
                </td>
               
            </tr>
            <tr>
            	<td>住址：</td>
                <td><input type="text" name="emp.address"/></td>
                   </td>
        
            </tr>
        
            <tr>
                <td>备注信息：</td>
                <td colspan="3" style="height: 42px"><br>
                <textarea rows="5" cols="53" name="emp.remark"></textarea>
                    <br></td>
            </tr>
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="3">&nbsp;</td>
                <td align="left">
                 	<s:submit cssClass="buttonBack" value="保  存"/>
                 	&nbsp;&nbsp;&nbsp;
                 	<input type="button" value="返  回" 
                 	onclick="location='/user/empList.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>