<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERTED MOVIES</title>

<style>

h2, h1 {
 background-color:grey;
 text-align:center;
}

.p1 {
 text-align:center;
}

.row {
   height:300px;
	margin: auto;
	border: 1px solid black;
	border-radius: 18px;
   backgound-color:yellow;
   width:500px;

}

.form1 {
  display: block;
  margin-left: 200px;
  backgound-color:yellow;	
}

</style>

</head>
<body>
<h1>Movie Saved</h1>
<h2>Movie Id: ${movieId}</h2>
<h2>Movie Title: ${movieTitle}</h2>
<h2>Release Date: ${releaseDate}</h2>
<h2>Actor: ${actor}</h2>
<h2>Short Description: ${sortDescription}</h2>
<br><br>

<div class="row">
 <h2>Poster Upload:</h2>
      <p  class="p1">Select a poster to upload: </p><br />
      <div class = "form1">
      <form  action = "UploadServlet" method = "post"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "100" />
         <br /><br>
         <input type = "submit" value = "Upload File" />
  	 </form>
  	 </div>
   </div>
   
   <br><br>

<p class="p1"><a href="/MoviesWebApp/index.jsp">Home</a></p>
</body>
</html>