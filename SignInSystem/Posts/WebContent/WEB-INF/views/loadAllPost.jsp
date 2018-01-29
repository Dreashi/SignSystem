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
	<form action="loadPostByIdHandler" method="post">
	    <c:forEach items="${sessionScope.allPostList }" var="post">
	        <c:out value="${post.postId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postDatetime}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postOwner.userId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postOwner.userName }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postSupports }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postComments }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:out value="${post.postContentFile }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <button type="button" id="sendComment" value="${post.postId} ">评论</button><br/>
	        <c:if test="${post.sonCommentList!=null}">
	        	<c:forEach items="${post.sonCommentList}" var="sonComment">
	        		<c:out value="${sonComment.commentId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<c:out value="${sonComment.postId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<c:out value="${sonComment.parentCommentId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<c:out value="${sonComment.commentDatetime }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<c:out value="${sonComment.commentContentFile }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<c:out value="${sonComment.commentOwner }"/>
	        		<button type="button" id="sendComment" value="${post.postId} ">回复</button><br/><br>

	        		<c:if test="${sonComment.sonCommentList!=null }">
	        			<c:forEach items="${sonComment.sonCommentList }" var="sonComment">
	        				<c:out value="${sonComment.commentId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        		<c:out value="${sonComment.postId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        		<c:out value="${sonComment.parentCommentId }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        		<c:out value="${sonComment.commentDatetime }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        		<c:out value="${sonComment.commentContentFile }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        		<c:out value="${sonComment.commentOwner }"/>
			        		<button type="button" id="sendComment" value="${post.postId} ">回复</button><br/><br>
	        			</c:forEach>
	        		</c:if><br><br>
	        	</c:forEach>
	        </c:if>
	    </c:forEach>
	    <div style="margin-left:120px; width:200px; height:25px;margin-top:10px; text-align:right;">
	        <button type="submit" id="loadPostById" >我的发帖</button>
	    </div>
	</form>
</body>
</html>
