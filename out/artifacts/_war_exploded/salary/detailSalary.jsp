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
			
			<form action="salary!update.action" method="post">
			
			<input type="hidden" name="salary.id" value="${salary.id}"/>
		<table border="0" cellpadding="0" cellspacing="15">
             <tr>
                <td >
                    姓名：</td>
                <td>
                   <input type="text" name="salary.trueName"  value="${salary.trueName}"/></td>
                <td>
                    工号：</td>
                 <td >
                    <input type="text" name="salary.empId" value="${salary.empId}" /></td>
            </tr>
            <tr>
                <td>
                    年份：</td>
                <td>
                    <input type="text" name="salary.year" value="${salary.year}"/></td>
                <td>
                    月份：</td>
                 <td>
                     <input type="text" name="salary.month"  value="${salary.month}"/></td>
            </tr>
          <tr>
          
               <tr>
                <td > 
                    基本工资：</td>
                <td>
                   <input type="text" name="salary.baseSalary"  value="${salary.baseSalary}"/></td>
                <td>
                    迟到罚金：</td>
                 <td >
                    <input type="text" name="salary.lateCome" value="${salary.lateCome}" /></td>
            </tr>
            <tr>
                <td>
                    早退罚金：</td>
                <td>
                    <input type="text" name="salary.earlyLeave" value="${salary.earlyLeave}"/></td>
                <td>
                    请假罚金：</td>
                 <td>
                     <input type="text" name="salary.leave"  value="${salary.leave}"/></td>
            </tr>
               <tr>
                <td>
                   加班奖金：</td>
                <td>
                    <input type="text" name="salary.overtime" value="${salary.overtime}"/></td>
                <td>
                    旷工罚金：</td>
                 <td>
                     <input type="text" name="salary.negletwork"  value="${salary.negletwork}"/></td>
            </tr>
           <tr>
                <td>
                   养老保险：</td>
                <td>
                    <input type="text" name="salary.old" value="${salary.old}"/></td>
                <td>
                    失业保险：</td>
                 <td>
                     <input type="text" name="salary.unemployment"  value="${salary.unemployment}"/></td>
            </tr>
                  <tr>
                <td>
                   工伤保险：</td>
                <td>
                    <input type="text" name="salary.injury" value="${salary.injury}"/></td>
                <td>
                    生育保险：</td>
                 <td>
                     <input type="text" name="salary.bear"  value="${salary.bear}"/></td>
            </tr>
            
                  <tr>
                <td>
                   医疗保险：</td>
                <td>
                    <input type="text" name="salary.medical" value="${salary.medical}"/></td>
                <td>
                    公积金：</td>
                 <td>
                     <input type="text" name="salary.house"  value="${salary.house}"/></td>
            </tr>
                <tr>
                <td>
                   最终工资：</td>
                <td>
                    <input type="text" name="salary.finalSalary" value="${salary.finalSalary}"/></td>
            </tr>
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                <!-- 
                 	<input type="submit" value="修 改" class="buttonBack"/>
                 -->
                 	&nbsp;&nbsp;&nbsp;<input type="button" value="返  回" onclick="location='../salary/salaryList.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>