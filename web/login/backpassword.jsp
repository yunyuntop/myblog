
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form
					action="${pageContext.request.contextPath }/updatePasswordAction"
					method="post" class="fh5co-form animate-box"
					data-animate-effect="fadeIn" onsubmit="return clickform()">
					<input type="hidden" name="val" value="${validate }" /> <input
						type="hidden" name="uemail" value="${uemail }" />
					<h2>找回密码</h2>
					<div class="form-group">
						<div class="alert alert-success" role="alert">更新密码</div>
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">新密码</label> <input
							pattern="^.{6,15}$" name="password" type="password"
							class="form-control" id="password" placeholder="新密码(6-15位字符组成)"
							autocomplete="off" required> <label for="email"
							class="sr-only">再次输入新密码</label> <input pattern="^.{6,15}$"
							name="pwd" type="password" class="form-control" id="password1"
							placeholder="再次输入新密码(6-15位字符组成)" autocomplete="off" required>
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
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	<script>
		function clickform() {
			var pwd1 = $("#password").val();
			var pwd2 = $("#password1").val();
			if (pwd1 == pwd2)
				return ture;
			else {
				alert('密码不一致,请确保两次输入一致');
				return false;
			}
		}
	</script>
	<div style="margin-top: 30px;">
		<center>
			<a>转载请注明 吴云的博客</a> |<a> copyright:&copy;2018-2019</a> | <a target="_blank"
				href="http://www.miitbeian.gov.cn">备案号： 黑ICP备18003319号</a> | <a target="_blank"
				href="http://www.aliyun.com">托管于阿里云</a>
		</center>
	</div>

</body>
</html>

