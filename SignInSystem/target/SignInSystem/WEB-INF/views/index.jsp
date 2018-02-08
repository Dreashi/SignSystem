<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>

        function selectById() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("test").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("POST", "../personCenter/getUserInf", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("userPhone=18392562675");
        }

        function selectSignById() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("testSignSelectById").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("POST","../signIn/selectSignInByGroupIdAndDate.do",true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("userId=1");
        }

        function insertInToSignIn() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("testinsertInToSignIn").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("POST","../signIn/updateSignInStatusByAdmin.do",true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("signInTime=08:30:00");
        }


        function selectSignByDate() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if(xmlhtpp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("testSignSelectById").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("POST","../SignIn/selectById",true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("Date=2018-01-27");
        }
    </script>
</head>
<body>

<p id="test"> asd </p></br>
<p id="testSignSelectById"></p></br>
<p id="testSignSelectByDate"></p></br>
<p id="testinsertInToSignIn"></p>
<button type="button" onclick="selectById()">onclick test</button>
<button type="button" onclick="selectSignById()">sign_id test</button>
<button id="testbutton" type="button" onclick="insertInToSignIn()">insert test</button>
</body>
</html>
