<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="${pageContext.request.contextPath }/adminUserUpdateAction"
		method="post">
		<div class="formbody">
				
				<input type="hidden" name="uid" value="${user.uid }"/>
			<div class="formtitle">
				<span>修改用户信息</span>
			</div>

			<ul class="forminfo">
			
				
				<li><label>用户名：</label><input name="username" type="text" value="${user.username}"
					class="dfinput" /><i></i></li>
				<li><label>绑定邮箱：</label><input name="ueamil" type="email" value="${user.uemail }" class="dfinput" /><i></i></li>
				<li><label>手机号码：</label><input name="uphone" type="text" value="${user.uphone }" class="dfinput" /><i></i></li>
				<li><label>用户状态：</label><input name="ustate" type="text" value="${user.ustate }" class="dfinput" /><i></i></li>
				<li><label> </label><input name="sub" type="submit" class="btn" 
					value="确认保存" /></li>
			</ul>


		</div>
	</form>
	
</body>
</html>