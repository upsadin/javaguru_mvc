<%--
  Created by IntelliJ IDEA.
  User: pwk
  Date: 14.05.2024
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update details</title>
</head>
<body>
<h1>Update details: </h1>
<form action="/update" method="post">
    Enter your name: <input type="text" name="name" value="${user.name}" />
    <br><br>
    Enter your ages: <input type="text" name="age" value="${user.age}"/>
    <br><br>
    Enter your e-mail: <input type="text" name="email" value="${user.email}"/>
    <br><br>
    Enter your login: <input type="text" name="login" value="${user.login}"/>
    <br><br>
    Enter your password: <input type="password" name="pwd" value="${user.password}"/>
    <br><br>
    <input type="submit" value="confirm"/>
</form>
</body>
</html>
