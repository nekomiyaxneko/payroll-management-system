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
		<TITLE>Ա������ϵͳ</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="images/public.css" type=text/css rel=stylesheet>
		<LINK href="images/login.css" type=text/css rel=stylesheet>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>

		<!-- ���� gt.js���ȿ���ʹ�������ṩ�� initGeetest ��ʼ������ -->
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
								$("#usernameMsg").html("�û�������Ϊ��");
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
								$("#passwordMsg").html("���벻��Ϊ��");
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
								$("#passwordMsg").html("���벻��Ϊ��");
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
						alert("�û�������Ϊ��");
						return;
					}
					if(!password_flag){
						alert("���벻��Ϊ��");
						return;
					}
					$("#login_form").submit();
				}
			});
			// ����֤��ӵ�idΪcaptcha��Ԫ���ͬʱ��������input��ֵ���ڱ��ύ
			captchaObj.appendTo("#captcha1");
			captchaObj.onReady(function () {
				$("#wait1").hide();
			});
			// ����ӿڲο���http://www.geetest.com/install/sections/idx-client-sdk.html
		};
        $.ajax({
            url: "gt/register1?t=" + (new Date()).getTime(), // ���������ֹ����
            type: "get",
            dataType: "json",
            success: function (data) {
                // ���� initGeetest ��ʼ������
                // ����1�����ò���
                // ����2���ص����ص��ĵ�һ��������֤�����֮�����ʹ����������Ӧ�Ľӿ�
                initGeetest({
                    gt: data.gt,
                    challenge: data.challenge,
                    new_captcha: data.new_captcha, // ����崻�ʱ��ʾ������֤���崻�
                    offline: !data.success, // ��ʾ�û���̨��⼫��������Ƿ�崻���һ�㲻��Ҫ��ע
                    product: "float", // ��Ʒ��ʽ��������float��popup
                    width: "100px"
                    // �������ò�����μ���http://www.geetest.com/install/sections/idx-client-sdk.html#config
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
											�û�����
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
											�� �룺
										</TD>
										<TD >
												<input class=textbox type="password" name="password" id="txtPassword" />
										</TD>
										<TD width=100>
											&nbsp;<span id="passwordMsg" style="color: #ff857e;">${password_error}</span>
										</TD>
									</TR>
									
									<TR height=44>

										<td colspan="2" id="captcha1"> <p id="wait1" class="show">���ڼ�����֤��...</p></td>
										<td><p id="notice1" class="hide">���������֤</p></td>
									</TR>
									<TR height=44>
										<TD></TD>
										<td style="text-align: center">
											<input type="button" id="loginbutton" value="�� ¼" />
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
