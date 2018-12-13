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
				<td class="td_top"><b>当前位置:</b>&nbsp;考勤管理>>考勤设置

</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="attendenceSet!updateSet.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>考勤设置：</legend>
			<table border="0" cellpadding="0" cellspacing="15">
           <tr>
                <td>迟到罚款：<input type="text" size="1"  value="${attendenceSet.id }"
                name="attendenceSet.id" style="display: none"/></td>
                <td ><input type="text" size="1"  value="${attendenceSet.lateCome }"
                name="attendenceSet.lateCome"/>元/次</td>
                  
            </tr>
            <tr>
                <td>早退罚款：</td>
                <td ><input type="text" size="1"  value="${attendenceSet.earlyLeave }"
                name="attendenceSet.earlyLeave"/>元/次</td>
                  
            </tr>
            
            <tr>
                <td>请假罚款：</td>
                <td ><input type="text" size="1"  value="${attendenceSet.leave }"
                name="attendenceSet.leave"/>元/天</td>
                  
            </tr>
            <tr>
                <td>旷工罚款：</td>
                <td ><input type="text" size="1"  value="${attendenceSet.negletwork }"
                name="attendenceSet.negletwork"/>元/时</td>
                  
            </tr>
             <tr>
                <td>加班奖金：</td>
                <td ><input type="text" size="1"  value="${attendenceSet.overtime }"
                name="attendenceSet.overtime"/>元/时</td>
                  
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