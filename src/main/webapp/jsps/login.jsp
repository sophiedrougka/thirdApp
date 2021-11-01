<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    
    <link rel="stylesheet" href="/MoviesWebApp/static/css/login.css">
</head>
<body>
   <br><br><br>
<h2>Login</h2>
<div class="form-container" ><br>

<form  action="/MoviesWebApp/LoginController" method="post">

<label for="uname"><b>Username</b></label><br>
<input type="text" placeholder="Enter Username" name="uname" required><br>
<br>
<label for="psw"><b>Password</b></label>
<input type="password" placeholder="Enter Password" name="psw" required><br>
<br><br>
<button type="submit">Login</button>
<label>
  <input type="checkbox" checked="checked" name="remember"> Remember me
</label>

</form>
<br>
<a href="#" class="member">Lost your password?</a>
<a href="/MoviesWebApp/jsps/signup.jsp" class="member">Not a member? </a>  
<div  class="error-container" style="color: red"> <br> ${error} </div>    

</div>
 
</body>
</html>