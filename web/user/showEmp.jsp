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
<SCRIPT type="text/javascript">
   	   function go(){
	     var number=document.myf.num.value;
	     var num;
	     if(number.length==0){
	        alert("请先输入要查找的页数!");
	        return;
	     }else{
	       num=number-1;
	     }
	     location="emppageSelectEmp.action?pageNow="+num;
	   
	   }
	   
	   function getname(){
	      var ss=document.f.emp.empName.value;
	      alert(ss);
	   }
	   
	   
	   function dalAll(){	
        
        Window.open(strUrl,strWindowName,strWindowFeatures)
        
      return document.chform.submit();
        
	   }
	   
	 
	   
	   
</SCRIPT>

</head>
<body>

<div class="table_top" style="height:100%">
    
  	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;员工管理>>查询所有员工</td>
				<td align="right">
			
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">

   	<div style="margin-bottom:10px;">
		<s:form action="findEmp.action" method="post" theme="simple" name="f">
			工号：<s:textfield name="emp.empId" cssClass="input"/>&nbsp;&nbsp;
			员工名称：<s:textfield name="emp.trueName" cssClass="input"/>&nbsp;&nbsp;
			<s:submit cssClass="buttonBack" value="查询"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="showDept.action">
					<img src="skin/22.gif"/>&nbsp;&nbsp;新增</a>&nbsp;&nbsp;
		</s:form></div>
		<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>员工工号</td>
				<td>员工姓名</td>
				<td>员工年龄</td>
				<td>员工性别</td>
				<td>部门名称</td>
				<td>入职时间</td>
				<td>基本操作</td>
			</tr>
	
	    
 	   <form action="" name="chform"  method="post" >
		  <c:forEach items="${emps}" var="emp" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td><a href="emp!load.action?emp.id=${emp.id}">${emp.empId}</a></td>
				<td>${emp.trueName}</td>
				<td>${emp.age}</td>
				<td>${emp.sex}</td>
				<td>${emp.deptName}</td>
				<td>${emp.startDate}</td>
				<td>
					<a href="emp!load.action?emp.id=${emp.id}" >
					<img src="skin/edt.gif"/>修改</a>
					<a href="emp!delete.action?emp.id=${emp.id}" onclick="return confirm('确定删除?');">
					<img src="skin/del.gif"/>删除</a>
				</td>
			</tr>  
		  </c:forEach>
		</form>
		  </table>  
		<div style="margin-left: 200px; margin-top: 50px;">  
		<!--  
		  <form action="" method="post" name="myf" >    
               共<font color="red">${requestScope.number }</font>页&nbsp;&nbsp;当前第<font color="red">${requestScope.pageNow+1 }</font>页
           <a href="emppageSelectEmp.action?pageNow=${requestScope.pageNow-1}">上一页</a> &nbsp;&nbsp;    
           <a href="emppageSelectEmp.action?pageNow=${requestScope.pageNow+1}">下一页</a> 
                             第&nbsp;
          <a href="emppageSelectEmp.action?pageNow=0">1</a>&nbsp;
          <a href="emppageSelectEmp.action?pageNow=1">2</a>&nbsp;
          <a href="emppageSelectEmp.action?pageNow=2">3</a>
           <input type="text" size="1" name="num"/>&nbsp;页<a href="javascript:go()">&nbsp;GO&nbsp; </a>
      </form>
      -->
      </div>
	</div>
</div>

</body>
</html>