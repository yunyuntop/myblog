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
<script>
	$(function() {
		$("#delUid").click(function() {
			if (confirm("真的要删除这些用户吗")) {
				$("#listform").submit();
			}
		})
	})
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a
				href="${pageContext.request.contextPath}/admin/welcome.jsp">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/adminUserFindAction?currPage=1">用户列表</a></li>
		</ul>
	</div>
	<div class="tools">
		<ul class="toolbar">
			<li class="click"><a
				href="${pageContext.request.contextPath}/admin/managerUser/add.jsp"><span><img
						src="${pageContext.request.contextPath}/admin/images/t01.png" /></span>添加</a></li>
			<li id="delUid"><span><img
					src="${pageContext.request.contextPath }/admin/images/t03.png" /></span>删除</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath }/adminUserDeleteMuchAction"
		method="post" id="listform" name="listform">
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" onclick="checkmuch(this)" /></th>

					<th>用户编号</th>
					<th>用户照片</th>
					<th>用户名</th>
					<th>邮箱</th>

					<th>电话</th>
					<th>状态</th>
					<th>注册时间</th>
					<th colspan="2">管理用户</th>
				</tr>
			</thead>
			<tbody>



				<c:forEach items="${bean.list }" var="user" varStatus="vs">
					<tr>
						<td><input type="checkbox" name="checkUid"
							value="${user.uid }" /></td>

						<td>${user.uid }</td>
						<td><img
							src="${pageContext.request.contextPath }/blog${user.uimg}"
							height="70" width="70px" /></td>
						<td>${user.username}</td>
						<td>${user.uemail}</td>

						<td>${user.uphone }</td>
						<td>${user.ustate }</td>
						<td>${user.utime }</td>
						<td><a
							href="${pageContext.request.contextPath }/adminUserShowAction?uid=${user.uid}&currPage=${bean.currPage}">所有</a></td>
						<td><a
							href="${pageContext.request.contextPath }/adminUserDeleteAction?uid=${user.uid}&currPage=${bean.currPage}">删除</a></td>

					</tr>
				</c:forEach>


			</tbody>
		</table>
	</form>
	<div class="pagin">
		<form action="${pageContext.request.contextPath }/adminUserFindAction"
			method="post">
			<div class="message">
				<i class="blue">${bean.totalSize}</i>位用户，当前显示的是第${bean.currPage}
				页，一共有${bean.totalPage  }页 Go--&gt;第 <input type="number"
					name="currPage" min="1" max="${bean.totalPage }"
					style="width: 56px;" value="${bean.currPage}"><input
					type="submit" value="  ok  ">页
			</div>
		</form>
		<ul class="paginList">
			<c:if test="${bean.currPage>1 }">
				<li class="paginItem"><a
					href="${pageContext.request.contextPath }/adminUserFindAction?currPage=${bean.currPage-1}"><span
						class="pagepre"></span></a></li>
			</c:if>
			<c:if test="${bean.totalPage<7}">
				<c:forEach begin="1" end="${bean.totalPage }" var="n" varStatus="v">
					<c:if test="${n==bean.currPage }">
						<li class="paginItem current"><a href="javascript:;">${n}</a></li>
					</c:if>
					<c:if test="${n!=bean.currPage }">
						<li class="paginItem"><a
							href="${pageContext.request.contextPath }/adminUserFindAction?currPage=${n}">${n}</a></li>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${bean.totalPage>7 }">
				<c:if test="${bean.currPage<5}">
					<c:forEach begin="${1}" end="${5}" var="n" varStatus="v">
						<c:if test="${n==bean.currPage }">
							<li class="paginItem current"><a href="javascript:;">${n}</a></li>
						</c:if>
						<c:if test="${n!=bean.currPage }">
							<li class="paginItem"><a
								href="${pageContext.request.contextPath }/adminUserFindAction?currPage=${n}">${n}</a></li>
						</c:if>
					</c:forEach>
				</c:if>
				<c:if test="${bean.currPage>=5}">
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminUserFindAction?currPage=1">1</a></li>
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminUserFindAction?currPage=2">2</a></li>
					<li class="paginItem"><a href="javascript:;">......</a></li>
					<c:if test="${bean.totalPage-bean.currPage>=2}">
						<c:forEach begin="${bean.currPage-2}" end="${bean.currPage+2}"
							var="n" varStatus="v">
							<c:if test="${n==bean.currPage }">
								<li class="paginItem current"><a href="javascript:;">${n}</a></li>
							</c:if>
							<c:if test="${n!=bean.currPage }">
								<li class="paginItem"><a
									href="${pageContext.request.contextPath }/adminUserFindAction?currPage=${n}">${n}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${bean.totalPage-bean.currPage<2}">
						<c:forEach begin="${bean.currPage-2}" end="${bean.totalPage}"
							var="n" varStatus="v">
							<c:if test="${n==bean.currPage }">
								<li class="paginItem current"><a href="javascript:;">${n}</a></li>
							</c:if>
							<c:if test="${n!=bean.currPage }">
								<li class="paginItem"><a
									href="${pageContext.request.contextPath }/adminUserFindAction?currPage=${n}">${n}</a></li>
							</c:if>

						</c:forEach>
					</c:if>
				</c:if>

			</c:if>
			<c:if test="${bean.currPage!=bean.totalPage}">
				<c:if test="${bean.totalPage>5&&bean.totalPage-bean.currPage>2}">
					<li class="paginItem"><a href="javascript:;">......</a></li>
				</c:if>
				<li class="paginItem"><a
					href="${pageContext.request.contextPath }/adminUserFindAction?currPage=${bean.currPage+1}"><span
						class="pagenxt"></span></a></li>
			</c:if>


		</ul>

	</div>









	<script type="text/javascript">
		$('.imgtable tbody tr:odd').addClass('odd');
		function checkmuch(input1) {
			var checkUid = document.listform.checkUid;
			for (var i = 0; i < checkUid.length; i++) {
				if (input1.checked == true) {
					checkUid[i].checked = true;
				} else {
					checkUid[i].checked = false;
				}

			}

		}
	</script>







</body>
</html>