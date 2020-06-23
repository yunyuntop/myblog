
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>留言</title>
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
	position: fixed;
	left: 0px;
	right: 0px;
	bottom: 0px;
}

.msgblock {
	border-color: #aaabbb;
	width: 611px;
	margin: auto;
	color: #667665;
	font-family: 幼圆;
	font-size: +6;
}

@media ( max-width :500px) {
	.msgblock {
		border-color: #aaabbb;
		width: 300px;
		margin: auto;
		color: #667665;
		font-family: 幼圆;
		font-size: +3;
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
					<a href="${pageContext.request.contextPath }/blog/contact.jsp">留言</a>
					<a href="${pageContext.request.contextPath }/findAllMessageAction">查看留言</a>
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
				<div class="col-md-6 col-md-offset-3 clean-superblock" id="contact">
					<c:forEach items="${bean.list}" var="m" varStatus="vs">

						<div style="margin-top: 20px;">
							<table class="msgblock" border="2">
								<tr>
									<td>时间： ${m.mtime }</td>
								</tr>
								<tr style="height: 120px; font-size: 30px;">
									<td>${m.message }</td>
								</tr>
							</table>
						</div>

					</c:forEach>
					

				</div>
				<a id="nextPage"
						style="display: block; width: 50px; margin: auto;margin-bottom:20px; color: #000; cursor: pointer;">更&nbsp;多</a>
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
		<div class="widewrapper copyright">
			<a>转载请注明 吴云的博客 | copyright:&copy;2018-2019</a> | <a target="_blank"
				href="http://www.miitbeian.gov.cn">备案号： 黑ICP备18003319号</a> | <a
				target="_blank" href="http://www.aliyun.com">托管于阿里云</a>
		</div>
	</footer>



	<script
		src="${pageContext.request.contextPath }/blog/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/blog/js/modernizr.js"></script>
	<script
		src="${pageContext.request.contextPath}/blog/js/jquery-1.11.3.min.js"></script>
	<script>
		var currpage="${bean.currPage+1}";
		
				
		 	 $("#nextPage").click(
		 			 
		 			 function(){
					$.get(
							"${pageContext.request.contextPath}/findMessageAction",
							{
								"currPage" : currpage
							},
							function(d) {
								if(d!=null&&d!=""){
								$(d).each(
										
								function(){
									
								$("#contact")
										.append($(
										'<div style="margin-top: 20px;">'
										+'<table '+
										'class="msgblock"'+
										' border="2">'
										+'<tr>'
											+'<td>时间：'+this.mtime+' </td>'
										+'</tr>'
										+'<tr style="height: 120px; font-size: 30px;">'
											+'<td>'+this.message+' </td>'
										+'</tr>'
									+'</table>'
								+'</div>'));
								}
										
								);}else{
									alert("没有啦")
								}
								currpage++;
							},"json"
							) 
		 			 }
				)
		$(
		function() {
			function footerPosition() {
				$("#footer").removeClass("absolute-footer");
				var contentHeight = document.body.scrollHeight, //网页正文全文高
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
</body>
</html>