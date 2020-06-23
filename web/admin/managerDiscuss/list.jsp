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
<style>
.discusslist {
	width: 600px;
	margin: auto;
	border: 1px;
	border-color: aqua;
	margin-top:30px;
	background-color: #eee;
}

.discussrow {
	width: 600px;
	border-bottom: 1px;
	font-size: 20px;
	font-family: 宋体;
}

.discussfloatleft {
	width: 560;
	height: 20px;
	float: left
}

.discussfloatright {
	width: 40px;
	height: 20px;
	float: right;
}

.discusstext {
	width: 590px;
	height:30px;
	border-width:1px;
	color:blue;
	margin: auto;
	clear: both;
}

.discussimg {
	height: 100px;
	width: 100px;
	float: left;
}

.discusstitle {
	height: 100px;
	width: 500px;
	float: right;
}
</style>
</head>


<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a
				href="${pageContext.request.contextPath }/admin/welcome.jsp">首页</a></li>

			<li><a
				href="${pageContext.request.contextPath }/adminDiscussFindAction">我的评论</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<ul class="classlist" >
			<c:forEach items="${bean.list }" var="discuss">
				<li style="width: 800px; margin:auto;margin-top:12px;">
				<form
				action="${pageContext.request.contextPath }/adminReceiveAddAction"
				method="post" id="discussform">
				<input type="hidden" name="did" value="${discuss.did}" />
					<table border="1px" width="800px" height="" cellpadding="5">
						<tr><td colspan="2" width="650px">${discuss.dtime}&nbsp;&nbsp;<i><strong>${discuss.user.username}</strong></i>&nbsp;的评论</td><td width="150px"><a class="enter" href="${pageContext.request.contextPath }/adminDisscussDeleteAction?currPage=${bean.currPage}&did=${discuss.did}&bid=${discuss.blog.bid}">删除</a></td>
						</tr>
						<tr><td colspan="3"><div style="clear:both;color:blue;">${discuss.dtext}</div></td></tr>
						<tr><td width="97px"><a href="${pageContext.request.contextPath }/sigleAction?bid=${discuss.blog.bid}" target="_blank"><img src="${pageContext.request.contextPath }/blog${discuss.blog.bimg }" height="97px" width="97px"/></a></td><td colspan="2" width="703px;"><a href="${pageContext.request.contextPath }/sigleAction?bid=${discuss.blog.bid}" target="_blank"  >${discuss.blog.btitle}<br/>${discuss.blog.bheader}</a></td></tr>
						<c:if test="${not empty discuss.receive }">
						<tr><td colspan="2">${discuss.receive.rtime}回复了他：</td><td><a
								href="${pageContext.request.contextPath }/adminReceiveDeleteAction?currPage=${bean.currPage}&rid=${discuss.did}">删回复</a></td></tr>
						<tr><td colspan="3">${discuss.receive.rtext}</td></tr>
						</c:if>
						<c:if test="${empty discuss.receive }">
						<tr><td colspan="3"><textarea name="rtext" cols="122" rows="5"></textarea></td></tr>
						<tr><td colspan="2" width="700px"></td><td width="100px"><button type="submit" class="enter">回复评论</button></td></tr>
						</c:if>
					</table>
			    </form>
				</li>
			</c:forEach>
		</ul></div>
		<div class="clear"></div>

	
			

		




	



	<div class="pagin">
		<form
			action="${pageContext.request.contextPath }/adminDiscussFindAction"
			method="post" name="f">
			<div class="message">
				<i class="blue">${bean.totalSize}</i>条评论，当前显示的是第${bean.currPage}
				页，共${bean.totalPage}页 Go--&gt;第 <input type="number" name="currPage"
					min="1" max="${bean.totalPage }" style="width: 56px;"
					value="${bean.currPage}" /><input type="submit" value="  ok  " />页
			</div>
		</form>
		<ul class="paginList">
			<c:if test="${bean.currPage>1 }">
				<li class="paginItem"><a
					href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=${bean.currPage-1}"><span
						class="pagepre"></span></a></li>
			</c:if>
			<c:if test="${bean.totalPage<7}">
				<c:forEach begin="1" end="${bean.totalPage }" var="n" varStatus="v">
					<c:if test="${n==bean.currPage }">
						<li class="paginItem current"><a href="javascript:;">${n}</a></li>
					</c:if>
					<c:if test="${n!=bean.currPage }">
						<li class="paginItem"><a
							href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=${n}">${n}</a></li>
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
								href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=${n}">${n}</a></li>
						</c:if>
					</c:forEach>
				</c:if>
				<c:if test="${bean.currPage>=5}">
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=1">1</a></li>
					<li class="paginItem"><a
						href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=2">2</a></li>
					<li class="paginItem"><a href="javascript:;">......</a></li>
					<c:if test="${bean.totalPage-bean.currPage>=2}">
						<c:forEach begin="${bean.currPage-2}" end="${bean.currPage+2}"
							var="n" varStatus="v">
							<c:if test="${n==bean.currPage }">
								<li class="paginItem current"><a href="javascript:;">${n}</a></li>
							</c:if>
							<c:if test="${n!=bean.currPage }">
								<li class="paginItem"><a
									href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=${n}">${n}</a></li>
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
									href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=${n}">${n}</a></li>
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
					href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=${bean.currPage+1}"><span
						class="pagenxt"></span></a></li>
			</c:if>


		</ul>

	</div>
</body>
</html>
