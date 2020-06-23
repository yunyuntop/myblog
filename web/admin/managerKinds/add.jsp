<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/admin/welcome.jsp">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/managerKinds/add.jsp" target="_parent">添加标签</a></li>
    </ul>
    </div>
    <form action="${pageContext.request.contextPath }/adminKindsAddAction" method="post">
    <div class="formbody">
    
    <div class="formtitle"><span>添加标签</span></div>
    
    <ul class="forminfo">
    <li><label>标签</label><input name="ktext" type="text" class="dfinput" /><i></i></li>
   
    <li><label> </label><input name="sub" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    
    
    </div>
    </form>
</body>
</html>
