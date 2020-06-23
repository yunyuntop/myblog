<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${pageContext.request.contextPath }/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>
<script>
$(function(){
	
	$("#delBid").click(function() {
			if (confirm("真的要删除这些博客吗")) {
				$("#listform").submit();
			}
		})

	})
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="${pageContext.request.contextPath }/welcome.jsp">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=1">博客列表</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click"><a href="${pageContext.request.contextPath}/admin/managerBlog/add.jsp"><span><img
						src="${pageContext.request.contextPath }/admin/images/t01.png" /></span>添加</a></li>
				<li id="delBid"><span><img
						src="${pageContext.request.contextPath }/admin/images/t03.png" /></span>删除</li>

			</ul>


			<ul class="toolbar1">

			</ul>

		</div>
<form action="${pageContext.request.contextPath }/adminBlogDeleteMuchAction" method="post" name="listform" id="listform">
		<table class="imgtable">
			<thead>
				<tr>
					<th> <input type="checkbox" onclick="checkmuch(this)"/> </th>
					<th width="100px;">bid</th>
					<th>博客标题</th>
					<th>缩略图</th>
					<th>时间</th>
					<th>浏览量</th>
					<th>赞总数</th>
					<th>评论数</th>
					<th>博主</th>
					<th colspan="2">管理</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bean.list }" var="blog">
					<tr>
						<td><input type="checkbox" name="checkBid" value="${blog.bid }" /></td>
						<td>${blog.bid}</td>
						<td>${blog.btitle}</td>
						<td class="imgtd"><img
							src="${pageContext.request.contextPath }/blog${blog.bimg}"
							width="50px" height="50px" /></td>
						<td>${blog.btime}</td>
						<td>${blog.totallook}</td>
						<td>${blog.greatecount}</td>
						<td>${blog.discusscount}</td>
						<td>${blog.author}</td>
						<td><a
							href="${pageContext.request.contextPath }/adminBlogShowAction?currPage=${bean.currPage}&bid=${blog.bid}">修改</a></td>

						<td><a
							href="${pageContext.request.contextPath }/adminBlogDeleteAction?currPage=${bean.currPage}&bid=${blog.bid}">刪除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table></form></div>
		<div class="pagin">
			<form
				action="${pageContext.request.contextPath }/adminBlogFindAction"
				method="post">
				<div class="message">
					<i class="blue">${bean.totalSize}</i>篇文章，当前显示的是第${bean.currPage}
					页，一共有${bean.totalPage  }页 Go--&gt;第 <input type="number"
						name="currPage" min="1" max="${bean.totalPage }"
						style="width: 56px;" value="${bean.currPage}"/><input name="sub"
						type="submit" value="  ok  "/>页 
				</div>
			</form>
			<ul class="paginList">
				<c:if test="${bean.currPage>1 }">
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=${bean.currPage-1}"><span
							class="pagepre"></span></a></li>
				</c:if>
				<c:if test="${bean.totalPage<7}">
					<c:forEach begin="1" end="${bean.totalPage }" var="n" varStatus="v">
						<c:if test="${n==bean.currPage }">
							<li class="paginItem current"><a href="javascript:;">${n}</a></li>
						</c:if>
						<c:if test="${n!=bean.currPage }">
							<li class="paginItem"><a
								href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=${n}">${n}</a></li>
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
									href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=${n}">${n}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${bean.currPage>=5}">
						<li class="paginItem"><a
							href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=1">1</a></li>
						<li class="paginItem"><a
							href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=2">2</a></li>
						<li class="paginItem"><a href="javascript:;">......</a></li>
						<c:if test="${bean.totalPage-bean.currPage>=2}">
							<c:forEach begin="${bean.currPage-2}" end="${bean.currPage+2}"
								var="n" varStatus="v">
								<c:if test="${n==bean.currPage }">
									<li class="paginItem current"><a href="javascript:;">${n}</a></li>
								</c:if>
								<c:if test="${n!=bean.currPage }">
									<li class="paginItem"><a
										href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=${n}">${n}</a></li>
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
										href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=${n}">${n}</a></li>
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
						href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=${bean.currPage+1}"><span
							class="pagenxt"></span></a></li>
				</c:if>


			</ul>

		</div>


		<script type="text/javascript">
			$('.imgtable tbody tr:odd').addClass('odd');
			 function checkmuch(input1){
		           var checkBid = document.listform.checkBid;
		           for(var i=0;i<checkBid.length;i++){
		               if(input1.checked == true){
		                   checkBid[i].checked = true;
		               }else{
		                   checkBid[i].checked = false;
		               }

		           }

		}
		</script>
</body>
</html>
