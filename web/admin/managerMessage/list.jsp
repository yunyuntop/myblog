<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/admin/css/style.css"
	rel="stylesheet" type="text/css" />
	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>
<script language="javascript">
	$(function() {
		//导航切换
		$(".imglist li").click(function() {
			$(".imglist li.selected").removeClass("selected")
			$(this).addClass("selected");
		})
		
	
	})	
</script>

</head>


<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a
				href="${pageContext.request.contextPath }/admin/welcome.jsp">首页</a></li>

			<li><a
				href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=1">查看留言</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<ul class="classlist">
			<c:forEach items="${bean.list }" var="msg">
				<li style="float:left;margin-lefy:11px;">
					<div
						style="width: 650px; height: 350px; font-size: 25px; font-family: '仿宋';">
						时间：${msg.mtime }<br/> 姓名：${msg.realname} <br/> 邮箱：${msg.email}<br/>
						<div
							style="width: 650px; height: 230px; font-size: 16px; font-family: '新宋体';">${msg.message}

						</div>
						<a class="enter" 
						href="${pageContext.request.contextPath }/adminMessageDeleteAction?currPage=${bean.currPage}&mid=${msg.mid}"	  >删除</a>
					</div>
				</li>
			</c:forEach>
		</ul></div>
		<div class="clear"></div>
	<div class="pagin">
	<form action="${pageContext.request.contextPath }/adminMessageFindAction"
			method="post" name="f">
		<div class="message">
			<i class="blue">${bean.totalSize}</i>条留言，当前显示的是第${bean.currPage} 页，共${bean.totalPage}页
			Go--&gt;第
			<input type="number" name="currPage" min="1" max="${bean.totalPage }" style="width:56px;" value="${bean.currPage}"><input
				type="submit" value="  ok  ">页		
		</div>
		</form>
		<ul class="paginList">
			<c:if test="${bean.currPage>1 }">
				<li class="paginItem"><a
					href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=${bean.currPage-1}"><span
						class="pagepre"></span></a></li>
			</c:if>
			<c:if test="${bean.totalPage<7}">
				<c:forEach begin="1" end="${bean.totalPage }" var="n" varStatus="v">
					<c:if test="${n==bean.currPage }">
						<li class="paginItem current"><a href="javascript:;">${n}</a></li>
					</c:if>
					<c:if test="${n!=bean.currPage }">
						<li class="paginItem"><a
							href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=${n}">${n}</a></li>
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
								href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=${n}">${n}</a></li>
						</c:if>
					</c:forEach>
				</c:if>
				<c:if test="${bean.currPage>=5}">
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=1">1</a></li>
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=2">2</a></li>
					<li class="paginItem"><a href="javascript:;">......</a></li>
					<c:if test="${bean.totalPage-bean.currPage>=2}">
						<c:forEach begin="${bean.currPage-2}" end="${bean.currPage+2}"
							var="n" varStatus="v">
							<c:if test="${n==bean.currPage }">
								<li class="paginItem current"><a href="javascript:;">${n}</a></li>
							</c:if>
							<c:if test="${n!=bean.currPage }">
								<li class="paginItem"><a
									href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=${n}">${n}</a></li>
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
									href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=${n}">${n}</a></li>
							</c:if>

						</c:forEach>
					</c:if>
				</c:if>

			</c:if>
			<c:if test="${bean.currPage!=bean.totalPage}"   >
			<c:if test="${bean.totalPage>5&&bean.totalPage-bean.currPage>2}">
				<li class="paginItem"><a href="javascript:;">......</a></li>
			</c:if>
				<li class="paginItem"><a
					href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=${bean.currPage+1}"><span
						class="pagenxt"></span></a></li>
			</c:if>


		</ul>
		
	</div>
</body>
</html>
