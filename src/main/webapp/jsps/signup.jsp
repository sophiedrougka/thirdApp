<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
<link rel="stylesheet" href="/MoviesWebApp/static/css/signup.css">
</head>

</head>
<body>

<form action="/action_page.php">
  <div class="container">
    <h1>Φόρμα Εγγραφής</h1>
    <p>Παρακαλούμε συμπληρώστε την φόρμα εγγραφής για να δημιουργήσετε λογαριασμό</p>
    <hr>

    <label for="email"><b>Email*</b></label>
    <input type="text" placeholder="Email" name="email" id="email" required>

	<label for="usn"><b>Username*</b></label>
    <input type="text" placeholder="Username" name="usn" id="usn" required>

    <label for="psw"><b>Password*</b></label>
    <input type="password" placeholder="Password" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Επαναλάβετε τον κωδικό του Password*</b></label>
    <input type="password" placeholder="Επανάληψη Password" name="psw-repeat" id="psw-repeat" required>
    <hr>
    <p>Με την δημιουργία του λογαριασμού συμφωνείτε με τους όρους και τις προϋποθέσεις μας <a href="#">Όροι & Προϋποθέσεις</a>.</p>

    <button type="submit" class="registerbtn">Εγγραφή</button>
  </div>
  
</form>

</body>
</html>
