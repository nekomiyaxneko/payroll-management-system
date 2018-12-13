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
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="deptList.action.action">部门管理</a>>>显示部门详细信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>部门详情如下：</legend>
			
			<form action="dept!update.action" method="post">
			
			<input type="hidden" name="dept.id" value="${dept.id}"/>
		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
                <td >
                    部门名称：</td>
                <td>
                   <input type="text" name="dept.name" value="${dept.name}" /></td>
                <td>
                    部门人数：</td>
                 <td >
                    <input type="text" name="dept.number" value="${dept.number}" /></td>
            </tr>
            <tr>
                <td>
                    部门电话：</td>
                <td>
                    <input type="text" name="dept.tel" value="${dept.tel}" /></td>
                <td>
                    部门负责人：</td>
                 <td>
                     <input type="text" name="dept.manager" value="${dept.manager}" /></td>
            </tr>
            <tr>
                <td>
                    部门简介：</td>
                <td colspan="3" style="height: 42px">
                    <textarea name="dept.remark" rows="5" cols="54" style="border:1px solid gray;overflow: hidden;" >${dept.remark}</textarea> </td>
            </tr>
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="修 改" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;<input type="button" value="返  回" onclick="location='/EmpManageSys/user/deptList.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>