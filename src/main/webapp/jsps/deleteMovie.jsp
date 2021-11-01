<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Movie </title>
<link rel="stylesheet" href="/MoviesWebApp/static/css/moviesMenu.css">
</head>
<body>

<script>
function confirmDelete() {
	
    var agree=confirm("Are you sure you want to delete? You will be redirected to results page to confirm movie details");
	if (agree)
	 return true ;
	else
	 return false ;
}
</script>

 <div class="center">
 <br><br>
 
 <div class="search-wrapper">
	        
	            <span class="title">Movies Delete / By Id</span>  
	     		<br>
	           <form method="POST" action="/MoviesWebApp/MovieSearchController">
	                <input name="id" type="text" class="insert rounded" placeholder="Id" autofocus/><br><br>	               
	                <br>
	                <button class="submit-btn rounded color-btn" type="submit" onclick="return  confirmDelete()">Delete</button>
	            </form>
	        </div><br>
	        
	        <div class="search-wrapper">
	        
	            <span class="title">Movies Delete / By Title</span>  
	     		<br>
	           <form method="POST" action="/MoviesWebApp/MovieSearchController">	                
	                <input name="movieTitle" type="text" class="insert rounded" placeholder="Movie's Title" autofocus/><br><br>
	                <br>
	                <button class="submit-btn rounded color-btn" type="submit" onclick="return  confirmDelete()">Delete</button>
	            </form>
	        </div><br><br>
	        
	         <a href="/MoviesWebApp/index.jsp">Home</a>
	        
        </div>
 

</body>
</html>