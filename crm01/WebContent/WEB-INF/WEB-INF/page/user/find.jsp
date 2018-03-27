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
<script type="text/javascript">
	function del(){
		if(confirm("确认删除")){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
<form action="user/find" method="post">
	<div>
		姓名：<input type="text" name="user.name">
	</div>
	<div>
		电话：<input type="text" name="user.phone">
	</div>
	<div>
		地址：<input type="text" name="user.address">
	</div>
	<div>
		邮箱：<input type="text" name="user.email">
	</div>
	<input type="submit" value="查询 ">
	
</form>
<a href="user/add">添加用户</a>
<table>
	<tr>
		<td>序号</td><td>姓名</td><td>电话</td><td>地址</td><td>邮箱</td><td>操作</td>
	</tr>
	<!-- for(User user:users) -->
	<c:forEach items="${users}" var="user" varStatus="u">
		<tr>
			<td>${u.count}</td>
			<td>${user.name }</td>
			<td>${user.phone }</td>
			<td>${user.address }</td>
			<td>${user.email }</td>
			<td>
				<a href="user/edit?id=${user.id}">编辑</a>|
				<a href="user/delete?id=${user.id}" onclick="if(confirm('确认删除')==false)return false;">删除</a> 
				<%-- <a href="user/delete?id=${user.id}" onclick="del();">删除</a> --%>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>