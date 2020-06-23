
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>修改资料</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<!-- Bootstrap styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/blog/css/bootstrap.min.css">


<!-- Font-Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/blog/css/font-awesome/css/font-awesome.min.css">

<style>
.absolute-footer {
	position: absolute;
	left: 0px;
	right: 0px;
	bottom: 0px;
}
.rowinfo-useremail{
    width: 500px;
	height:300px;
}
.rowinfo-useremail{
    width: 500px;
	height: 100px;
	font-size: 30px;
}
#valcode{
    position: relative;
    left: 6px; 
    bottom: 6px;
}
@media (max-width: 550px) {#valcode{
	   position: relative;
	   width:65px;
	   height:35px;
	   font-size:18px;
	   padding-left:0px;padding-right:0px;
       left: 3px; 
       bottom: 2px;float:right;
	}
.rowinfo-useremail{
    width: 250px;
	height:150px;
}
.rowinfo-useremail{
    width: 250px;
	height: 50px;
	font-size: 15px;
}
}

</style>
<!-- Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/blog/css/style.css"
	id="theme-styles">
<!--网页标题左侧显示-->
<link rel="icon"
	href="${pageContext.request.contextPath }/blog/img/logo.jpg"
	type="image/x-icon">
<script
	src="${pageContext.request.contextPath}/blog/js/jquery-1.11.3.min.js"></script>

</head>
<body>

	<header>
		<div class="widewrapper masthead">
			<div class="container">
				<a href="${pageContext.request.contextPath }/index.jsp" id="logo">
					<img src="${pageContext.request.contextPath }/blog/img/logo.jpg"
					alt="clean Blog">
				</a>

				<div id="mobile-nav-toggle" class="pull-right">
					<a href="#" data-toggle="collapse"
						data-target=".clean-nav .navbar-collapse"> <i
						class="fa fa-bars"></i>
					</a>
				</div>
				<div style="position: absolute; top: 20px; right: 30px;">
					<c:if test="${empty user }">
						<a href="${pageContext.request.contextPath }/login/index.jsp">请登录</a>
					</c:if>
					<c:if test="${not empty user }">
						<a href="${pageContext.request.contextPath }/blog/userinfo.jsp">${user.username }您好！</a>

						<a href="${pageContext.request.contextPath }/outAction">退出</a>
					</c:if>
				</div>
				<nav class="pull-right clean-nav">
					<div class="collapse navbar-collapse">
						<ul class="nav nav-pills navbar-nav">

							<li><a href="${pageContext.request.contextPath }/index.jsp">主页</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath }/blog/about.jsp">关于</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath }/blog/contact.jsp">留言</a>
							</li>

						</ul>
					</div>
				</nav>

			</div>
		</div>



		<div class="widewrapper subheader">
			<div class="container">
				<div class="clean-breadcrumb">
					<a href="${pageContext.request.contextPath }/blog/userinfo.jsp">个人信息</a>&nbsp;&nbsp;

					<a href="${pageContext.request.contextPath }/blog/editpwd.jsp">修改密码</a>&nbsp;&nbsp;

					<a href="${pageContext.request.contextPath }/blog/upload.jsp">上传头像</a>&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/blog/editemail.jsp">变更邮箱</a>
				</div>

				<div class="clean-searchbox">
					<form action="${pageContext.request.contextPath}/likeQueryAction"
						method="post" accept-charset="utf-8">
						<input class="searchfield" id="searchbox" type="text" name="name"
							placeholder="Search">
						<button class="searchbutton" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</header>
	<div class="widewrapper main">
		<div class="container">
			<div class="row">
				<div class="col-md-8 blog-main">
					<div class="row">
						<form
							action="${pageContext.request.contextPath }/editEmailAction  "
							method="post">
							

								

								<div class="right-user">
									<div class="rowinfo-useremail">
										<span style="font-family: 方正舒体; color: #111">新邮箱：&nbsp;
											<input type="email" id="email" name="uemail" autocomplete="off"/>
										</span>
										<span id="err"></span>
									</div>

									<div class="rowinfo-useremail">
										<span style="font-family: 方正舒体; color: #111">验证码：&nbsp;
											<input type="text" name="val" size=11 autocomplete="off"/>

											<button type="button" id="valcode"
												
												class="btn btn-xlarge btn-clean-one">获取</button>
										</span>
									</div>


								</div>
								

							
								<button type="submit" class="btn btn-xlarge btn-clean-one">确定修改</button>
							

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="absolute-footer" id="footer">
		<div class="widewrapper footer">
			<div class="container">
				<div class="row">
					<div class="col-md-4 footer-widget">
						<h3>
							<i class="fa fa-user"></i>关于
						</h3>

						<p>博主是一名96年的学生，15级软件工程专业。</p>
						<p>正在努力做Java后台，热爱钻研</p>
						<p>欢迎大家为我的博客提出意见，谢谢</p>
					</div>

					<div class="col-md-4 footer-widget">
						<h3>
							<i class="fa fa-pencil"></i> 最近文章
						</h3>
						<ul class="clean-list">
							<c:forEach items="${newbloglist }" var="bb" varStatus="vs">
								<c:if test="${vs.count<=3 }">
									<li><a target="_blank"
										href="${pageContext.request.contextPath }/sigleAction?bid=${bb.bid}">${bb.btitle}
									</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>

					<div class="col-md-4 footer-widget">
						<h3>
							<i class="fa fa-envelope"></i>联系博主
						</h3>

						<p>qq:2542488834</p>
						<p>微信：y18745621165</p>
						<p>手机：13244649729</p>
					</div>

				</div>
			</div>
		</div>
		<div class="widewrapper copyright"><a>转载请注明 吴云的博客 | copyright:&copy;2018-2019</a> | <a target="_blank" href="http://www.miitbeian.gov.cn">备案号： 黑ICP备18003319号</a> | <a target="_blank" href="http://www.aliyun.com">托管于阿里云</a> </div>
	</footer>



	<script
		src="${pageContext.request.contextPath }/blog/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/blog/js/modernizr.js"></script>

	<script>
		$(function() {
			function footerPosition() {
				$("#footer").removeClass("absolute-footer");
				var contentHeight = document.body.scrollHeight, //网页正文全文高度
				winHeight = window.innerHeight;//可视窗口高度，不包括浏览器顶部工具栏
				if (!(contentHeight > winHeight)) {

					$("#footer").addClass("absolute-footer");
				} else {
					$("#footer").removeClass("absolute-footer");
				}
			}
			footerPosition();
			$(window).resize(footerPosition);
		});
	</script>


	<script>
		$(function() {
			var flag = 0;

			$("#valcode")
					.click(
							function() {

								if (flag == 0) {
									if ($("#email").val() != null
											&& $("#email").val() != "") {
										flag = 1;
										$
												.get(
														"${pageContext.request.contextPath}/newEmailCheckAction",
														
														{"uemail" : $("#email").val()}
														,
														function(d) {
															if (d.name == "1") {
																alert("验证码已经发送了哦~请去邮箱查看");
																$("#email").attr("readonly","readonly");
															} else if (d.name == "0") {
																alert('验证码发送不成功');
																flag = 0;
															} else if (d.name == "none") {
																alert("邮箱已被注册！");
																flag = 0;
															}else if (d.name == "login") {
																
																alert("登录信息失效");
																location.href='${pageContext.request.contextPath}/login/index.jsp';
															}
														}, "json");
									} else {
										alert("邮箱您还没有填写呢");
									}
								} else {
									alert("验证码已发送啦！！");
								}

							});

		})
	</script>
</body>
</html>