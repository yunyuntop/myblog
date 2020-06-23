<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/admin/css/select.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>
<script>
	$(function() {
		$("#delKid").click(function() {
			if (confirm("真的要删除这些Tag吗")) {
				$("#listform").submit();
			}
		})
	})
</script>

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
				href="${pageContext.request.contextPath}/admin/managerKinds/list.jsp"  target="_parent">查看标签</a></li>
		</ul>
	</div>
	<div class="tools">
		<ul class="toolbar">
			<li class="click"><a href="${pageContext.request.contextPath}/admin/managerKinds/add.jsp"><span><img
					src="${pageContext.request.contextPath}/admin/images/t01.png" /></span>添加</a></li>
				<li id="delKid"><span><img
						src="${pageContext.request.contextPath }/admin/images/t03.png" /></span>删除</li>
		</ul>
	</div>
	<form action="${pageContext.request.contextPath }/adminKindsDeleteMuchAction"
		method="post" id="listform" name="listform">
	<table class="tablelist">
		<thead>
			<tr>
				<th> <input type="checkbox" onclick="checkmuch(this)"/> </th>
				
				<th width="25%">id</th>
				<th width="40%">标签名</th>
				<th colspan="2">管理</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${adminkindslist}" var="kinds">


			<tr>
				<td><input type="checkbox" name="checkKid" value="${kinds.kid }" /></td>
				<td>${kinds.kid}</td>
				<td>${kinds.ktext }</td>
				<td><a href="${pageContext.request.contextPath }/adminKindsShowAction?kid=${kinds.kid}">更改</a></td>
				<td><a href="${pageContext.request.contextPath }/adminKindsDeleteAction?kid=${kinds.kid}">删除</a></td>
			</tr>
			
		</c:forEach>


		</tbody>
	</table>
</form>






	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		 function checkmuch(input1){
	           var checkKid = document.listform.checkKid;
	           for(var i=0;i<checkKid.length;i++){
	               if(input1.checked == true){
	                   checkKid[i].checked = true;
	               }else{
	                   checkKid[i].checked = false;
	               }

	           }

	}
	</script>







</body>
</html>