<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String basePath=request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath+"/" %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user/update" method="post">
	<input type="hidden" name="user.id" value="${user.id }">
	<div>
		姓名：<input type="text" name="user.name" value="${user.name }">
	</div>
	<div>
		电话：<input type="text" name="user.phone" value="${user.phone }">
	</div>
	<div>
		地址：<input type="text" name="user.address" value="${user.address }">
	</div>
	<div>
		邮箱：<input type="text" name="user.email" value="${user.email }">
	</div>
	<input type="submit" value="保存 ">
	
</form>
</body>
</html>