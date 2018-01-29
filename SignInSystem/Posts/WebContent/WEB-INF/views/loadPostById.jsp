<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deletePostHandler" method="post">
	    <input type="checkbox" id="allSelect">全选<br />
	    <c:forEach items="${sessionScope.userPostList }" var="post">
	        <input type="checkbox" name="ids" value="${post.postId}">
	        <c:out value="${post.postId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postDatetime}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postOwner.userId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postOwner.userName }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postSupports }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postComments }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postContentFile }"/><br>
	    </c:forEach>
	    <div style="margin-left:120px; width:200px; height:25px;margin-top:10px; text-align:right;">
	        <button type="submit">删除</button>
	    </div>
	</form>
</body>
</html>