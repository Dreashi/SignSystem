<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script>
        function selectUser() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("test").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("POST", "userCode/showUser.do", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("userPhone=182092955");
        }
	</script>
</head>
<body>
	<form action="/checkCode" method="post">
		输入验证码:<input type="text" name="number"/><br/>
	    输入sessionId:<input type="password" name="sessionId"/><br/>
		<p id="test">Hello World!</p>
		<button type="button" onclick="selectUser()">获取验证码</button></br>
		<input type="submit" value="确定">
		<input type="reset" value=" 取消">
	</form>
</body>
</html>