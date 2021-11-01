<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movies Search</title>
    <link rel="stylesheet" href="/MoviesWebApp/static/css/moviesMenu.css">
</head>
<body>
	<h2 class="center">WELCOME TO MOVIES PAGE</h2>
    <div class="center">
        
        <div class="search-wrapper">
	        <div class="bot-gap">
	            <span class="title">Movies Search</span>
	        </div>
	        <div class="bot-gap">
	            <form method="GET" action="/MoviessWebApp/MovieSearchController">
	                <input name="searchInput" type="text" class="search rounded" placeholder="Insert movie's title" autofocus/>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Search</button>
	            </form>
	        </div>
        </div>
        
        <div class="insert-wrapper">
	        <div class="bot-gap">
	            <span class="title">Movies Insert</span>
	        </div>
	        <div class="bot-gap">
	            <form method="POST" action="/MoviessWebApp/MovieInsertController">
	                <input name="id" type="text" class="insert rounded" placeholder="Id" autofocus/><br> 
	                <input name="movieTitle" type="text" class="insert rounded" placeholder="Movie's Title" autofocus/><br>
	                <input name="yearRelease" type="text" class="insert rounded" placeholder="Movie's year release" autofocus/><br>
	                <input name="sortDescription" type="text" class="insert rounded" placeholder="Short description" autofocus/>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Insert</button>
	            </form>
	        </div>
        </div>
        
        <div class="delete-wrapper">
	        <div class="bot-gap">
	            <span class="title">Movies Delete</span>
	        </div>
	        <div class="bot-gap">
	            <form method="POST" action="/MoviessWebApp/MovieInsertController">
	                <input name="id" type="text" class="insert rounded" placeholder="Id" autofocus/><br> 
	                <input name="movieTitle" type="text" class="insert rounded" placeholder="Movie's Title" autofocus/><br>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Delete</button>
	            </form>
	        </div>
        </div>
        
    </div>
</body>
</html>
        
    