<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/style.css">
<!--网页标题左侧显示-->
<link rel="icon"
	href="${pageContext.request.contextPath }/blog/img/logo.jpg"
	type="image/x-icon">
<script src="js/modernizr-2.6.2.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<!-- Start Sign In Form -->
				<form action="${pageContext.request.contextPath }/loginAction"
					method="post" class="fh5co-form animate-box"
					data-animate-effect="fadeIn">
					<h2>登录</h2>
					<input type="hidden" name="bid" value="${bid }">
					<div class="form-group">
						<label for="username" class="sr-only">昵称</label> <input required
							type="text" name="username" value="${cookie.username.value }"
							class="form-control" id="username" placeholder="用户名称"
							autocomplete="off">
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">密码</label> <input required
							type="password" name="password" class="form-control"
							id="password" placeholder="密码" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="remember"><input type="checkbox" id="remember"
							name="auto" value="auto"> 自动登录</label><label for="rememberme"><input
							type="checkbox" id="rememberme" name="rememberme"
							value="rememberme"> 记住昵称</label>
					</div>
					<div class="form-group">
						<p>
							没有账户?立即<a
								href="${pageContext.request.contextPath }/login/register.jsp">注册</a>
							| <a href="${pageContext.request.contextPath }/login/forgot.jsp">忘记密码？</a>
						</p>
						<p>
							<a href="${pageContext.request.contextPath }/index.jsp">主
								页&gt;&gt;</a>
						</p>
					</div>
					<div class="form-group">
						<input type="submit" value="登录" class="btn btn-primary">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>

	</div>
<div style="margin-top:30px;"><center><a>转载请注明 吴云的博客</a> |<a> copyright:&copy;2018-2019</a> | <a target="_blank" href="http://www.miitbeian.gov.cn">备案号： 黑ICP备18003319号</a> | <a target="_blank" href="http://www.aliyun.com">托管于阿里云</a> </center></div>
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


</body>
</html>

