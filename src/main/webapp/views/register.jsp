<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assignment_01</title>
</head>
<body>
<h2>Register</h2>
<form action="${pageContext.request.contextPath}/register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="confirmPassword">Confirm Password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
    <label for="secretQuestion">Secret Question:</label>
    <input type="text" id="secretQuestion" name="secretQuestion" required><br><br>
    <label for="secretAnswer">Secret Answer:</label>
    <input type="text" id="secretAnswer" name="secretAnswer" required><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>