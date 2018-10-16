<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<form action="" method="post" >
	<div>
		<label for="name">名字</label>
		<input type="text" name="name"  id="name" value="${tests.name }">
	</div>
	<div>
		<label for="age">年龄</label>
		<input type="text" name="age"  id="age" value="${tests.age }">
	</div>
	<div>
		<button type="submit"> 提交</button>
	</div>
</form>	
</body>
</html>