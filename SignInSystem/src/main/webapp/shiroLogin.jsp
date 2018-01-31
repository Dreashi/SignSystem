<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>login page</h1>
<div style="border: 1px solid;height: 120px;width: 300px;margin: auto;margin-top: 150px;padding-top: 50px">
    <form action="/shiro/login" method="post">
        <table style="height: 100%;width: 100%">
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="userName">
                </td>
            </tr>
            <tr>
                <td align="right">密码:</td>
                <td>
                    <input type="password" name="userPwd">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交">
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>
    <br>

</div>
</body>
</html>
