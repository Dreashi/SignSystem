<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#add").click(function(){
			location.href="save.view";
		});
		
		$("button[name='update']").click(function(){
			location.href="load/"+this.title;
		});
	});
</script>
</head>
<body>
	<form action="deleteHandler" method="post">
		<c:forEach items="${sessionScope.loadAllMap.get(b)}" var="usr">
			<c:out value="${usr.userId }"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${usr.userName }"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${usr.userPhone }"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${usr. groupleaderId }"/><br>
		</c:forEach>
	<div style="margin-left: 120px; width: 200px; height: 25px; margin-top:10px; text-align: right;">
		<button type="submit">删除</button>
		<button type="button" id="add">增加</button>
	</div>
	</form>
</body>
</html>