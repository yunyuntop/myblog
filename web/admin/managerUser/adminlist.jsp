<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/admin/css/select.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a
				href="${pageContext.request.contextPath}/admin/welcome.jsp">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/managerUser/adminlist.jsp">查看管理员</a></li>
		</ul>
	</div>
<div class="itab">
		<ul>
			<li><a
				href="${pageContext.request.contextPath}/admin/managerUser/add.jsp"
				>添加管理员</a></li>
			<li><a class="selected"
				href="${pageContext.request.contextPath}/adminUserFindAdminAction">管理员列表</a></li>
		</ul>
	</div><div style="margin-top:10px;"></div>
	<table class="tablelist">
		<thead>
			<tr>
				


				<th>管理员</th>
				<th colspan="2">管理</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${adminlistadmin}" var="adm">


				<tr>
					
					<td>${adm.aname}</td>

					<td><a
						href="${pageContext.request.contextPath }/adminUserDeleteAdminAction?aid=${adm.aid}">删除</a></td>

				</tr>

			</c:forEach>


		</tbody>
	</table>






	
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>







</body>
</html>