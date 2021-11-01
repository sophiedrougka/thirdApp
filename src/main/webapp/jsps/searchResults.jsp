<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
<link rel="stylesheet" href="/MoviesWebApp/static/css/moviesMenu.css">
</head>
<body>

<h1 style="text-align:center">Search Results</h1>
<h3 style="text-align:left"> <%= request.getAttribute("connection")%></h3>
<br>

<script>
function confirmDelete() {
	
    var agree=confirm("Are you sure you want to delete?");
	if (agree)
	 return true ;
	else
	 return false ;
}
</script>

<script>
function confirmUpdate() {
	
    var agree=confirm("Are you sure you want to update?");
	if (agree)
	 return true ;
	else
	 return false ;
}
</script>

<div class="center">
 
 <div class="update-wrapper">
	        
	            <span class="title"> Delete / Update</span>  
	     
	           <form method="POST" action="/MoviesWebApp/MovieUpdateController">
	           		
	                <input name="id" type="text" value="<%= request.getAttribute("movieId")%>" class="insert1 rounded" placeholder="Movie's Id" autofocus/>
	                <br><br>
	                
	                <input name="movieTitle" type="text" value="<%= request.getAttribute("movieTitle")%>" class="insert1 rounded" placeholder="Movie's title" autofocus/>
	                <br><br>
	                
	                <input name="actorName" type="text" value="<%= request.getAttribute("actorName")%>" class="insert1 rounded" placeholder="Movie's actor" autofocus/>
	                <br><br>
	               
	                <input name="yearRelease" type="text" value="<%= request.getAttribute("yearRelease")%>" class="insert1 rounded" placeholder="ReleaseDate" autofocus/>
	               <br><br>
	               
	                <textarea class="textarea2 rounded" id="sortDescription" name="sortDescription" >
				     <%= request.getAttribute("shortDescr")%>
				   </textarea><br>
				   <br>
				  
	              <button class="submit-btn1 rounded color-btn" type="submit" onclick="return  confirmUpdate()">Update</button>
	            </form><br>
	            	            	           	           
	            <form method="POST" action="/MoviesWebApp/MovieDeleteController">
	              <input type="hidden"  name="id" value="<%= request.getAttribute("movieId")%>" />
	              <button class="submit-btn1 rounded color-btn" type="submit" onclick="return  confirmDelete()">Delete</button>
	            </form><br>
	            
	             <div class="row">
	             
	             <form method="POST" action="/MoviesWebApp/MovieSearchController">	
	               <input type="hidden"  name="first" value="first" />		   
				   <button class="prev-btn rounded color-btn" type="submit">&laquo; First</button>
				   </form>
	             
	              <form method="POST" action="/MoviesWebApp/MovieSearchController">	
	               <input type="hidden"  name="prev" value="prev" />		   
				   <button class="prev-btn rounded color-btn" type="submit">&laquo; Previous</button>
				   </form>
				   			   
				   <form method="POST" action="/MoviesWebApp/MovieSearchController">	
	               <input type="hidden"  name="last" value="last" />		   
				   <button class="next-btn rounded color-btn" type="submit">Last &raquo;</button>
				   </form>
				   
				   <form method="POST" action="/MoviesWebApp/MovieSearchController">
				    <input type="hidden"  name="next" value="next" />		
				   <button class="next-btn rounded color-btn" type="submit">Next &raquo;</button>
				   </form>
				   
				   </div><br><br>
	            
	             <a href="/MoviesWebApp/index.jsp">Home</a>
	            
	        </div>
	       
        </div>

<br><br>

</body>
</html>