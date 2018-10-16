<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   	<link type="text/css"   href="${contextPath}/assets/css/app.css"  rel="stylesheet">
	<script src="${contextPath}/assets/vendr/jquery-1.8.3.min.js"></script>
	<script src="${contextPath}/assets/js/shopping-cart.js"></script>
</head>
<body>		
			
	<form action="${contextPath }/test/fin" method="get">			
			<input type="text" name="name"  id="name"  value="请输入名称...">
			<button type="submit">查找</button>			
		</form>
						
		<a href="${contextPath }/test/add">添加</a>		
		<a href="${contextPath}/user">注册登录</a>
	<br>	
	<div class="div1">
		<ul>
			<li>id#</li>
				<c:forEach items="${tests }" var="test">
					<li>${test.id}</li>	
				</c:forEach>
		</ul>
	</div>
	<div class="div2">
		<ul>
			<li>名字</li>
		    	<c:forEach items="${tests }" var="test">
			    	<li><a href="${contextPath}/test/${test.id}">${test.name}</a></li>
			    </c:forEach>	
		</ul>
	</div>
	<div class="div3">
		<ul>
		    <li>年龄</li>
		    <c:forEach items="${tests }" var="test">
		    	<li>${test.age }</li>
		    </c:forEach>	
		</ul>
	</div>
 	<div class="div4">
 		<ul>
 			<li>删除</li>
			<c:forEach items="${tests }" var="test">
				<li>		
					<form action="${contextPath}/test/delete/${test.id}" method="post"> 	
						<%-- <input type="checkbox" name="id" value="${test.id}"> --%>
						<button type="submit">删除</button>					
					</form>
				</li>	
			</c:forEach>
 		</ul>
 	</div>	
 	<div class="div5">
 		<ul>
 			<li>修改</li>
 			<c:forEach items="${tests }" var="test">
 				<li><a href="${contextPath}/test/update/${test.id}">编辑</a></li>
 			</c:forEach>
 		</ul>
 	</div>
 	<div>
	 	<a href="${contextPath}/pageDown/${rownum -1}">上一页</a>	 		
	 			&nbsp 第${rownum+1}页	 		 
	 	<a href="${contextPath}/pageDown/${rownum +1}">
	 	<sec:authentication property="${id }" var="id" />
	 	<c:if test=" ${rownum*4 < id } "> 首页 </c:if>下一页</a>	
 	</div><br>
<table>
    <tr>
        <th><input id="all" type="checkbox" /></th>
        <th>标准号</th>
        <th>中文名称</th>
        <th>版本</th>
        <th>发布日期</th>
        <th>实施日期</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${tests }" var="test">
        <tr>
            <td><input name="id" type="checkbox" value="${test.id }" /></td>
            <td>${test.name}</td>
            <td>${test.age}</td>
            <td><a href="${std.package_path }" target="_blank">下载</a>&nbsp;&nbsp;
            <a href="${contextPath}/test/update/${test.id}" >修改</a></td>
        </tr>
    </c:forEach>    
</table>
<button id="del">批量删除</button>

<form class="form-horizontal" >
    <label for="firstname" class="col-sm-2 control-label">用户ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="user_id" placeholder="请输入用户ID">
    </div>
    <div class="col-sm-offset-2 col-sm-10">
      <button type="button" id="select" class="btn btn-default">查找</button>
    </div>

</form>
<div class="panel-body">
    <h2 class="text-danger text-center">
        <!-- 用来显示查找结果 -->
        <span class="glyphicon" id="select-box"></span>
    </h2>
</div>
</body>
</html>