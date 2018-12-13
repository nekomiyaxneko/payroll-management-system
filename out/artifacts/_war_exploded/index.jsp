<%--
  Created by IntelliJ IDEA.
  User: Bill
  Date: 2018/12/3
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN">
<HTML>
<HEAD>
    <TITLE>工资管理系统  首页</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <%
        response.addHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("Cache-Control", "pre-check=0, post-check=0");
        response.setDateHeader("Expires", 0);
    %>
    <style type="text/css">
        body{
            margin:0;
            padding:0;
        }
        #topFrame{
            width: 100%;
        }
        #leftFrame{
            width: 20%;
            height: 100%;
            padding: 0;
            float: left;
        }
        #mainFrame{
            width:79%;
            height: 100%;
            padding: 0;
        }
    </style>

</HEAD>
<body>
<div >
    <iframe id="topFrame" name="topFrame" src="index.files/Top.htm"  scrolling="no" frameborder="0"></iframe>
</div>
<div >
    <iframe id="leftFrame" name="leftFrame" src="index.files/Left.htm" frameborder="0"  scrolling="no"></iframe>
    <iframe id="mainFrame" name="mainFrame" src="index.files/EmployeeMgr.htm" frameborder="0"  scrolling="yes"></iframe>
</div>
</body>

</HTML>
