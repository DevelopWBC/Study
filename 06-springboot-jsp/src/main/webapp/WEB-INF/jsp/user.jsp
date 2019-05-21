<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springboot整合jsp</title>
</head>
<body>
	<table align="center" cellpadding="0" border="1">
		<tr><td>年龄</td><td>姓名</td><td>性别</td></tr>
		<c:forEach items="${list }" var="user" >
			<tr>
			<td>${user.age }</td>
			<td>${user.name }</td>
			<td>${user.sex }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>