<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/27
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border: 1px solid;height: 120px;width: 300px;margin: auto;margin-top: 150px;padding-top: 50px">
    <form action="/shiro/login" method="post">
        <table style="height: 100%;width: 100%">
            <tr>
                <td align="right">电话号:</td>
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
</div>

</body>
</html>
