<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border: 1px solid;height: 250px;width: 300px;margin: auto;margin-top: 150px;padding-top: 50px">
    <form action="/registerTest" method="post">
        <table style="height: 100%;width: 100%">
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="userName">
                </td>
            </tr>
            <tr>
                <td align="right">性别:</td>
                <td>
                    <input type="text" name="userSex">
                </td>
            </tr>
            <tr>
                <td align="right">用户生日:</td>
                <td>
                    <input type="text" name="userBirthday">
                </td>
            </tr>
            <tr>
                <td align="right">QQ:</td>
                <td>
                    <input type="text" name="userQQ">
                </td>
            </tr>
            <tr>
                <td align="right">Email:</td>
                <td>
                    <input type="text" name="userEmail">
                </td>
            </tr>
            <tr>
                <td align="right">Phone:</td>
                <td>
                    <input type="text" name="userPhone">
                </td>
            </tr>
            <tr>
                <td align="right">密码:</td>
                <td>
                    <input type="password" name="userPassword">
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
