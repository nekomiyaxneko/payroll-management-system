<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<%
			if(session.getAttribute("userInfo")!=null){
			    response.sendRedirect("/index.jsp");
			}
		%>
		<TITLE>员工管理系统</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="images/public.css" type=text/css rel=stylesheet>
		<LINK href="images/login.css" type=text/css rel=stylesheet>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>

		<!-- 引入 gt.js，既可以使用其中提供的 initGeetest 初始化函数 -->
		<script src="gt.js"></script>
		<script language="javascript">
			var username_flag=false;
			var password_flag=false;
			$(function (){
				$("#txtUsername").blur(function (){
					username_flag=false;
					$("#usernameMsg").html("");
					var username = $("#txtUsername").val();
					if (username == "") {
								$("#usernameMsg").html("用户名不能为空");
								return;
					}
					username_flag=true;
				});
			});
			$(function (){
				$("#txtPassword").blur(function (){
					password_flag=false;
					$("#passwordMsg").html("");
					var password = $("#txtPassword").val();
					if (password == "") {
								$("#passwordMsg").html("密码不能为空");
								return;
					}
					password_flag=true;
				});

			});

			$(function(){
			$("#imageCode").blur(function(){
			password_flag=false;
					$("#passwordMsg").html("");
					var password = $("#txtPassword").val();
					if (password == "") {
								$("#passwordMsg").html("密码不能为空");
								return;
					}
					password_flag=true;

			});
			});
			var handler1 = function (captchaObj) {
			$("#loginbutton").click(function(e){
				var result = captchaObj.getValidate();
				if (!result) {
					$("#notice1").show();
					setTimeout(function () {
						$("#notice1").hide();
					}, 2000);
					e.preventDefault();
				}
				else{
					if(!username_flag){
						alert("用户名不能为空");
						return;
					}
					if(!password_flag){
						alert("密码不能为空");
						return;
					}
					$("#login_form").submit();
				}
			});
			// 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
			captchaObj.appendTo("#captcha1");
			captchaObj.onReady(function () {
				$("#wait1").hide();
			});
			// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
		};
        $.ajax({
            url: "gt/register1?t=" + (new Date()).getTime(), // 加随机数防止缓存
            type: "get",
            dataType: "json",
            success: function (data) {
                // 调用 initGeetest 初始化参数
                // 参数1：配置参数
                // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
                initGeetest({
                    gt: data.gt,
                    challenge: data.challenge,
                    new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                    offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                    product: "float", // 产品形式，包括：float，popup
                    width: "100px"
                    // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
                }, handler1);
            }
        });
 </script>
		<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
	</HEAD>
	<BODY>
		<DIV id=div1>
		<form name="login" method="POST" action="login.action" id="login_form">
			<TABLE id="login" height="400px" cellSpacing=0 cellPadding=0 width="800px"
				align=center>
				<TBODY>
					<TR id="main">
						<TD>
							<TABLE height="400px" cellSpacing=0 cellPadding=0 width="100%">
								<TBODY>
									<TR>
										<TD colSpan=4>
											&nbsp;
										</TD>
									</TR>
									<TR height="200px;">
										<TD width="300px">
											&nbsp;
										</TD>
										<TD>
											&nbsp;
										</TD>
										<TD>
											&nbsp;
										</TD>
										<TD>
											&nbsp;
										</TD>
									</TR>
									<TR height=40>
										<TD rowSpan=4>
											&nbsp;
										</TD>
										<TD width="50px">
											用户名：
										</TD>
										<TD style="width: 190px;">
											<input class=textbox type="text" name="username" id="txtUsername"  />
										</TD>
										<TD width=100>
											<span  id="usernameMsg" style="color: #ff857e;">${username_error}</span>
										</TD>
										
									</TR>
									<TR height=40>
										<TD>
											密 码：
										</TD>
										<TD >
												<input class=textbox type="password" name="password" id="txtPassword" />
										</TD>
										<TD width=100>
											&nbsp;<span id="passwordMsg" style="color: #ff857e;">${password_error}</span>
										</TD>
									</TR>
									
									<TR height=44>

										<td colspan="2" id="captcha1"> <p id="wait1" class="show">正在加载验证码...</p></td>
										<td><p id="notice1" class="hide">请先完成验证</p></td>
									</TR>
									<TR height=44>
										<TD></TD>
										<td style="text-align: center">
											<input type="button" id="loginbutton" value="登 录" />
										</td>
										<TD align=center style="width: 60px	">
										</TD>
										<TD width=60>
											&nbsp;
										</TD>
									</TR>
									<TR height=110>
										<td style="height: 25px;" colspan="3"></td>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
					<TR id=root height=104>
						<TD>
							&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			
			</form>
		</DIV>
		<DIV id=div2 style="DISPLAY: none"></DIV>
		</CONTENTTEMPLATE>
	</BODY>
</HTML>
