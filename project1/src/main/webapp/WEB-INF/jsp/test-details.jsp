<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	
	详情页
	<div>
		<ul>
			<li>id#${tests.id}</li>
			<li>名字：${tests.name}</li>
			<li>年龄：${tests.age}</li>
			<a href="${contextPath }/test/update/${tests.id}">编辑</a>	
		</ul>
	</div>
	
</body>
</html>