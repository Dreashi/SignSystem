<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="sendPostHandler" method="post">
        <input type="hidden" name="sendUser" value="${sessionScope.loginUser}">
        <textarea cols="50" rows="50" name="postContent"></textarea>
        <input type="submit" value="发布">
        <input type="reset" value="取消">
    </form>
</body>
</html>
