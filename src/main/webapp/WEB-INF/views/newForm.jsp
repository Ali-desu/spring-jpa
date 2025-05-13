<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="/login">
    <label>Username: <input type="text" name="username"/></label><br/>
    <label>Password: <input type="password" name="password"/></label><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>