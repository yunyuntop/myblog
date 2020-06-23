<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>找回密码</title>
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/style.css">
<!--网页标题左侧显示-->
<link rel="icon"
	href="${pageContext.request.contextPath }/blog/img/logo.jpg"
	type="image/x-icon">
<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">


				<!-- Start Sign In Form -->
				<form action="${pageContext.request.contextPath }/codeValAction"
					method="post" class="fh5co-form animate-box"
					data-animate-effect="fadeIn">
					<h2>找回密码</h2>
					<div class="form-group">
						<div class="alert alert-success" role="alert">通过注册时的Email找回密码</div>
					</div>
					<div class="form-group">
						<hr />
						<label for="email" class="sr-only">邮箱</label> <input name="uemail"
							type="email" class="form-control" id="uemail" placeholder="邮箱"
							autocomplete="off"> <br />
						<br />
						<input style="width: 301px; margin: auto;" type="button"
							value="发送验证码" class="btn btn-primary" id="sendemail"><br />
						<br />
						<br />
						<hr>
						<label for="email" class="sr-only">验证码</label> <input required
							name="val" type="text" class="form-control" id="val"
							placeholder="邮箱验证码" autocomplete="off">
					</div>
					<div class="form-group">
						<p>
							<a href="${pageContext.request.contextPath }/index.jsp">主
								页&gt;&gt;</a>
						</p>
						<input style="width: 300px; margin: auto;" type="submit"
							value="确认" class="btn btn-primary">
					</div>
				</form>
				<!-- END Sign In Form -->


			</div>
		</div>

	</div>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script>
		$(function() {
			var flag = 0;
			$("#sendemail").click(function() {

				if (flag == 0) {
					$.get("${pageContext.request.contextPath}/forgotAction", {
						"uemail" : $("#uemail").val()
					}, function(d) {
						flag = 1;
						if ("true" == d.name) {
							alert("验证码发送成功");
						} else if ("false" == d.name) {
							alert("验证码发送失败");
							flag = 0;
						} else if ("none" == d.name) {
							alert("该邮箱未注册");
							flag = 0;
						}else if ("fail" == d.name){
							alert("邮箱格式不正确");
							flag = 0;
						}
					}, "json"

					);

				}
			});
		})
	</script>
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
<div style="margin-top:30px;"><center><a>转载请注明 吴云的博客</a> |<a> copyright:&copy;2018-2019</a> | <a target="_blank" href="http://www.miitbeian.gov.cn">备案号： 黑ICP备18003319号</a> | <a target="_blank" href="http://www.aliyun.com">托管于阿里云</a> </center></div>

</body>
</html>

