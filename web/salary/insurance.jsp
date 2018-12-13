<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript" 

src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
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
				<td class="td_top"><b>当前位置:</b>&nbsp;工资管理>>保险设置

</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="insurance!update.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>保险设置：</legend>
			<table border="0" cellpadding="0" cellspacing="15">
           <tr>
                <td>养老保险：工资%<input type="text" size="1"  value="${insurance.id }"
                name="insurance.id" style="display: none"/></td>
                <td ><input type="text" size="1"  value="${insurance.old }"
                name="insurance.old"/></td>
                   <td>失业保险：工资%</td>
                <td ><input type="text" size="1"  value="${insurance.unemployment }"
                name="insurance.unemployment"/></td>
            </tr>
                   
            <tr>
                <td>工伤保险：工资%</td>
                <td ><input type="text" size="1"  value="${insurance.injury }"
                name="insurance.injury"/></td>
                  <td>生育保险：工资%</td>
                <td ><input type="text" size="1"  value="${insurance.bear }"
                name="insurance.bear"/></td>
            </tr>
             <tr>
                <td>医疗保险：工资%</td>
                <td ><input type="text" size="1"  value="${insurance.medical }"
                name="insurance.medical"/></td>
                    <td>公积金：&nbsp;&nbsp;&nbsp;工资%</td>
                <td ><input type="text" size="1"  value="${insurance.house }"
                name="insurance.house"/></td>
            </tr>
            
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="3">&nbsp;</td>
                <td align="left">
                 	<s:submit cssClass="buttonBack" value="修改" onclick="return confirm('确定修改?');"/>
   					<span id="msg" style="color:red">${message}</span>
                 	&nbsp;&nbsp;&nbsp;
                 	<!--  <s:submit cssClass="buttonBack" value="返  回"  onclick="location='empList.action'"/>
                	-->
                </td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>