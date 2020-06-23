<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
		
	})	
	$(".msghref").click(function(){
		$("#msg").html("");
	})
	$(".likehref").click(function(){
		$("#like").html("");
	})
	$(".discusshref").click(function(){
		$("#discuss").html("");
	})
	
})	
</script>
<style>
a{
color:#eee;
}
a:HOVER{
color:#ffefff;;
}
a:visited {
	color:#eee;
}
</style>

</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="${pageContext.request.contextPath }/admin/main.jsp" target="_parent"><img src="${pageContext.request.contextPath }/admin/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="${pageContext.request.contextPath }/admin/managerBlog/add.jsp" target="rightFrame"><img src="${pageContext.request.contextPath }/admin/images/icon02.png" title="写博客" width="55"height="60"/><h2>写博客</h2></a></li>
       <li><a href="${pageContext.request.contextPath }/adminUserFindAction?currPage=1" target="rightFrame" ><img src="${pageContext.request.contextPath }/admin/images/icon03.png" title="查看用户" width="55"height="60" /><h2>查看用户</h2></a></li>
    <li><a href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=1" class="msghref"  target="rightFrame"><img src="${pageContext.request.contextPath }/admin/images/icon01.png" title="查看留言" width="55"height="60"/><h2>查看留言</h2></a></li>
    <li><a href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=1" class="discusshref"  target="rightFrame"><img src="${pageContext.request.contextPath }/admin/images/icon05.png" title="查看评论" width="55"height="60"/><h2>查看评论</h2></a></li>
    <li><a href="${pageContext.request.contextPath }/adminGreateFindAction?currPage=1" class="likehref"  target="rightFrame"><img src="${pageContext.request.contextPath }/admin/images/icon04.png" title="我的赞" width="55"height="60"/><h2>我的赞</h2></a></li>
   
    </ul>
            
    <div class="topright">    
    <ul>
   <li><a href="${pageContext.request.contextPath }/adminOutAction" target="_top">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${admin.aname }</span>
    <a href="${pageContext.request.contextPath }/adminMessageFindAction?currPage=1" class="msghref" target="rightFrame">留言&nbsp;&nbsp;&nbsp;</a>
    
    <c:if test="${info.messagecount!=0&&not empty info }">
    <i id="msg"><b>${info.messagecount }</b></i>
    </c:if>
    <a href="${pageContext.request.contextPath }/adminGreateFindAction?currPage=1" target="rightFrame" class="likehref">点赞&nbsp;&nbsp;&nbsp;</a>
    <c:if test="${ info.greatecount!=0&&not empty info }">
    <i id="like"><b>${info.greatecount}</b></i>
    </c:if>
    <a href="${pageContext.request.contextPath }/adminDiscussFindAction?currPage=1" target="rightFrame" class="discusshref">评论&nbsp;&nbsp;&nbsp;</a>
    <c:if test="${info.discusscount!=0&&not empty info }">
    <i id="discuss"><b>${info.discusscount }</b></i>
    </c:if>
    </div>    
    
    </div>
</body>
</html>
