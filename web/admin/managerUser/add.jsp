<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a
				href="${pageContext.request.contextPath}/admin/welcome.jsp">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/managerUser/add.jsp"
				target="_parent">添加管理员</a></li>
		</ul>
	</div>


	<form action="${pageContext.request.contextPath }/adminUserAddAdmin"
		method="post">
		<div class="itab">
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/admin/managerUser/add.jsp"
					class="selected">添加管理员</a></li>
				<li><a
					href="${pageContext.request.contextPath}/adminUserFindAdminAction">管理员列表</a></li>
			</ul>
		</div><div style="margin-top:10px;"></div>
		<ul class="forminfo">
			<li><label>账号</label><input name="aname" type="text"
				class="dfinput" /><i></i></li>
			<li><label>密码</label><input name="apwd" type="password"
				class="dfinput" /><i></i></li>
			<li><label> </label><input name="sub" type="submit" class="btn"
				value="确认保存" /></li>
		</ul>


		
	</form>
</body>
</html>