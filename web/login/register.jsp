<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>注册</title>





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
				<form action="${pageContext.request.contextPath }/registerAction" onsubmit="return clickform()" 
					method="post" class="fh5co-form animate-box"
					data-animate-effect="fadeIn"  id="register">
					<h2>注册</h2>
					<div class="form-group" >
						<div class="alert alert-success" id="err" role="alert">欢迎加入我们</div>
					</div>
					<div class="form-group">
						<label for="name" class="sr-only">昵称</label> <input 
							pattern="^[0-9a-zA-Z]{6,15}$" id="username" required type="text"
							name="username" class="form-control"  
							placeholder="昵称(字母和数字组成的6-15位字符)" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">邮箱</label> <input required
							type="email" name="uemail" class="form-control" id="email"
							placeholder="邮箱" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">密码</label> <input
							pattern="^.{6,15}$" required type="password" name="password"
							class="form-control" id="password" placeholder="密码(6-15位字符组成)"
							autocomplete="off">
					</div>
					<div class="form-group">
						<label for="re-password" class="sr-only">请再次输入密码</label> <input
							pattern="^.{6,15}$" required type="password" name="password1"
							class="form-control" id="password1" placeholder="请再次输入密码"
							autocomplete="off">
					</div>

					<div class="form-group">
						<p>
							已有账户？<a href="index.jsp">登录</a>
						</p>
						<p>
							<a href="${pageContext.request.contextPath }/index.jsp">主
								页&gt;&gt;</a>
						</p>
					</div>
					<div class="form-group">
						<input id="reg" type="submit" value="注册" class="btn btn-primary">
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

	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	<script>

	function clickform(){
		var pwd1=$("#password").val();
		var pwd2=$("#password1").val();
		if(pwd1==pwd2)
			return ture;
		else{
			alert('密码不一致,请确保两次输入一致');
			return false;
		}
	}	
		$(
		function(){
		$("#username").blur(
				function(){
		$.get("${pageContext.request.contextPath}/findNameAction", {
			"username" : $("#username").val()
		}, function(d) {
			if (d.flag == "1") {
				
				$("#err").html($("<span style='color:red'>用户名已经存在!!</span>"));
				$("#reg").attr("type","button");
				$("#reg").attr("value","不能用");
				$("#reg").attr("style","color:#fff;");
			}else if(d.flag == "0"){
			$("#err").text("欢迎加入我们");
			$("#reg").attr("type","submit");
			$("#reg").attr("value","注册");			
			}
		}, "json");
		}
					);
				}
		)
	</script>
</body>
</html>

