<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Movie </title>
<link rel="stylesheet" href="/MoviesWebApp/static/css/moviesMenu.css">
</head>
<body>

<script>
function confirmUpdate() {
	
    var agree=confirm("Are you sure you want to update? You will be redirected to results page to confirm movie details");
	if (agree)
	 return true ;
	else
	 return false ;
}
</script>

 <div class="center">
  <br><br>
 
 <div class="search-wrapper">
	        
	            <span class="title">Movies Update / By Id</span>  
	            <br>
	     
	           <form method="POST" action="/MoviesWebApp/MovieSearchController"><br>
	                <input name="movieId" type="text" class="insert rounded" placeholder="Id" autofocus/><br><br>
	              
	                <br><br>
	                <button class="submit-btn rounded color-btn" type="submit" onclick="return  confirmUpdate()">Update</button>
	            </form>
	        </div>
	        <br>
	        
	        <div class="search-wrapper">
	        <br>
	        
	            <span class="title">Movies Update By Title</span>  
	     
	           <form method="POST" action="/MoviesWebApp/MovieSearchController"><br>
	               
	                <input name="movieTitle" type="text" class="insert rounded" placeholder="Movie's Title" autofocus/><br><br>
	                <br><br>
	                <button class="submit-btn rounded color-btn" type="submit" onclick="return  confirmUpdate()">Update</button>
	            </form>
	        </div>
	        
	        <br><br>
	        
	         <a href="/MoviesWebApp/index.jsp">Home</a>     
        </div>
 

</body>
</html>