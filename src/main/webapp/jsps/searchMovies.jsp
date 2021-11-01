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
function accessDenied() {
	
    alert("This function is under construction! will be available in a later version");
	
	 return false ;
}
</script>

 <div class="center">
 <br><br>
 
  <div class="search-wrapper">
	        
	            <span class="title">Movies Search</span>  
	     
	           <form method="POST" action="/MoviesWebApp/MovieSearchController"><br>
	                <input name="movieId" type="text" class="search rounded" placeholder="Search by movie's id" autofocus/>
	                <br><br>
	                <button class="submit-btn rounded color-btn" type="submit">Search</button>
	            </form>
	            	          	            
	        </div> <br>
 
 <div class="search-wrapper">
	        
	            <span class="title">Movies Search</span>  
	     
	           <form method="POST" action="/MoviesWebApp/MovieSearchController"><br>
	                <input name="movieTitle" type="text" class="search rounded" placeholder="Search by movie's title" autofocus/>
	                <br><br>
	                <button class="submit-btn rounded color-btn" type="submit">Search</button>
	            </form>
	            	          	            
	        </div> <br>
	        
	        <div class="search-wrapper">
	        
	            <span class="title">Movies Search</span>  
	     
	           <form method="POST" action="/MoviesWebApp/MovieSearchController"><br>
	                <input name="yearRelease" type="text" class="search rounded" placeholder="Search by year release" autofocus/>
	                <br><br>
	                <button class="submit-btn rounded color-btn" type="submit" onclick="return  accessDenied()">Search</button>
	            </form>
	            	          	            
	        </div>
	        
        </div>
 

</body>
</html>