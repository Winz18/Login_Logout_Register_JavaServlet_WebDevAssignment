<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Assignment_01</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="Login">
    <br>
    <a href="forgot-password">Forgot Password?</a>
</form>
</body>
</html>
