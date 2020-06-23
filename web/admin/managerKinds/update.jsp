<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a
				href="${pageContext.request.contextPath}/admin/welcome.jsp">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/managerKinds/update.jsp"
				target="_parent">编辑标签</a></li>
		</ul>
	</div>


	<form action="${pageContext.request.contextPath }/adminKindsUpdateAction"
		method="post">
		<div class="formbody">
				
				<input type="hidden" name="kid" value="${kinds.kid }"/>
			<div class="formtitle">
				<span>编辑标签</span>
			</div>

			<ul class="forminfo">
			
				
				<li><label>标签:</label><input name="ktext" type="text" value="${kinds.ktext}"
					class="dfinput" /><i></i></li>
				<li><label> </label><input name="sub" type="submit" class="btn" 
					value="确认保存" /></li>
			</ul>


		</div>
	</form>
</body>
</html>