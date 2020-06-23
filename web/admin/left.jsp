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
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if(!($ul.is(':visible'))){
			$(this).next('ul').slideDown();
		}else{
			$(this).next('ul').slideUp();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>管理模块</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/admin/images/leftico01.png" /></span>博客管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/adminBlogFindAction?currPage=1" target="rightFrame">博客列表</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/managerBlog/add.jsp" target="rightFrame">写博客</a><i></i></li>
       
        </ul>    
    </dd>
        
     <dd><div class="title"><span><img src="${pageContext.request.contextPath }/admin/images/leftico03.png" /></span>标签管理</div>
    <ul class="menuson">
        <li><cite></cite><a target="rightFrame" href="${pageContext.request.contextPath }/admin/managerKinds/add.jsp">添加标签</a><i></i></li>
        <li><cite></cite><a target="rightFrame" href="${pageContext.request.contextPath}/adminKindsFindAction">查看标签</a><i></i></li>
        
        
    </ul>    
    </dd>  
    
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/admin/images/leftico02.png" /></span>用户管理
    </div> 
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/admin/managerUser/add.jsp" target="rightFrame">增加管理员</a><i></i></li>
        
        <li><cite></cite><a href="${pageContext.request.contextPath}/adminUserFindAction?currPage=1" target="rightFrame">用户查询</a><i></i></li>
        </ul>     
    </dd> 
    
    
   
    
    
      
    
    </dl>
</body>
</html>
