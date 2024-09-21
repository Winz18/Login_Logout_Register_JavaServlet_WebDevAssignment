<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Reset Password</title>
</head>
<body>
<h1>Reset Password</h1>
<form action="forgot-password" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="secretQuestion">Secret Question:</label>
    <input type="text" id="secretQuestion" name="secretQuestion" required>
    <br>
    <label for="secretAnswer">Secret Answer:</label>
    <input type="text" id="secretAnswer" name="secretAnswer" required>
    <br>
    <label for="newPassword">New Password:</label>
    <input type="password" id="newPassword" name="newPassword" required>
    <br>
    <input type="submit" value="Forgot Password">
</form>
</body>
</html>