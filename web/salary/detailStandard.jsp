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
<body style="overflow-y:scroll">
              
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;薪资管理>>显示薪资详细信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>部门详情如下：</legend>
			
			<form action="salaryStandard!update.action" method="post">
			
			<input type="hidden" name="salaryStandard.id" value="${salaryStandard.id}"/>
		<table border="0" cellpadding="0" cellspacing="15">
             <tr>
                <td >
                    工号：</td>
                <td>
                   <input type="text" name="salaryStandard.empId"  value="${ salaryStandard.empId}"/></td>
                <td>
                    姓名：</td>
                 <td >
                    <input type="text" name="salaryStandard.trueName" value="${ salaryStandard.trueName}" /></td>
            </tr>

          <tr>
                   <td>
                    基本工资：</td>
                 <td >
                    <input type="text" name="salaryStandard.baseSalary" value="${ salaryStandard.baseSalary}" /></td>
          </tr>
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="修 改" class="buttonBack" onclick="return confirm('确定修改?');"/>
                 	&nbsp;&nbsp;&nbsp;<input type="button" value="返  回" onclick="location='../salary/salaryStandardList.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>