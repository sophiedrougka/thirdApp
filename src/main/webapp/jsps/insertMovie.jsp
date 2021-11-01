<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Movie </title>
<link rel="stylesheet" href="/MoviesWebApp/static/css/moviesMenu.css">
</head>
<body>

 <div class="center">
 
 <div class="insert-wrapper">
	        
	            <span class="title">Movies Insert</span>  
	     
	            <form method="POST" action="/MoviesWebApp/MovieInsertController"><br>  
	                <input name="id" type="text" class="insert rounded" placeholder="Id" autofocus/><br> <br> 
	                <input name="movieTitle" type="text" class="insert rounded" placeholder="Movie's Title" autofocus/><br><br> 
	                <input name="releaseDate" type="text" class="insert rounded" placeholder="Movie's date release yyyy-mm-dd" autofocus/><br><br> 
	                <input name="actor" type="text" class="insert rounded" placeholder="star names" autofocus/><br><br>
	                <textarea class="textarea1 rounded" id="sortDescription" name="sortDescription" >
				     short description here.
				  </textarea>
	                <br><br>
	                <button class="submit-btn rounded color-btn" type="submit">Insert</button>
	            </form>
	            
	            <br><br>
	        
	         <a href="/MoviesWebApp/index.jsp">Home</a>      
	        </div>  
	        	         
        </div>
 
</body>
</html>