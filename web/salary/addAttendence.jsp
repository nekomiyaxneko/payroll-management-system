<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		border:0px solid gray;
		height:22px;
		border-bottom:1px solid gray;
	}
	a:hover{
	text-decoration: underline;
	}
</style>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
              
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;考勤管理>>添加考勤详细信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>填写考勤详情如下：</legend>
			
			<form action="attendence!add.action" method="post">
			

		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
                <td >
                    姓名：</td>
                <td>
                   <input type="text" name="attendence.trueName"  value="${attendence.trueName}"/></td>
                <td>
                    工号：</td>
                 <td >
                    <input type="text" name="attendence.empId" value="${attendence.empId}" /></td>
            </tr>
            <tr>
                <td>
                    年份：</td>
                <td>
                    <input type="text" name="attendence.year" value="${attendence.year}"/></td>
                <td>
                    月份：</td>
                 <td>
                     <input type="text" name="attendence.month"  value="${attendence.month}"/></td>
            </tr>
          <tr>
                <td>
                    工时：</td>
                <td>
                    <input type="text" name="attendence.workHour" value="${attendence.workHour}"/></td>
                <td>
                    迟到次数：</td>
                 <td>
                     <input type="text" name="attendence.lateCome" value="${attendence.lateCome}" /></td>
            </tr>
             <tr>
                <td>
                    早退次数：</td>
                <td>
                    <input type="text" name="attendence.earlyLeave" value="${attendence.earlyLeave}" /></td>
                <td>
                    请假天数：</td>
                 <td>
                     <input type="text" name="attendence.leaveDays" value="${attendence.leaveDays}" /></td>
            </tr>
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="添加" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;<input type="button" value="返  回" onclick="location='/attendenceList.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>