<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
<link href="${pageContext.request.contextPath }/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/admin/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录博客后台管理界面平台</span>    
    <ul>
    <li><a href="${pageConetx.request.contextPath }/myBlog/index.jsp">回首页</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
     <form action="${pageContext.request.contextPath }/adminLoginAction" method="post">  
    <div class="loginbox">
    
    <ul>
    <li><input name="aname" type="text" class="loginuser" required/></li>
    <li><input name="apwd" type="password" class="loginpwd" required/></li>
    <li><input name="subm" type="submit" class="loginbtn" value="登录" /></li></ul>
    
    
    </div>
    </form>
    </div>
    
<div class="loginbm"><a>转载请注明 吴云的博客</a> |<a> copyright:&copy;2018-2019</a> | <a href="http://www.miitbeian.gov.cn" target="_blank">备案号： 黑ICP备18003319号</a> | <a target="_blank" href="http://www.aliyun.com">托管于阿里云</a> </div>
    
    
   
</body>
</html>
