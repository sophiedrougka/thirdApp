/**
 * 
 */
 
 function fetchMoviesFromJSON() {
    let movieTitle = $('#searchInput').val().trim();
    
    let ajaxRequest = new XMLHttpRequest();
    ajaxRequest.open('GET', `/MoviesWebApp/MovieSearchJSONControler?searchInput=${movieTitle}`, true);
    ajaxRequest.send();

    ajaxRequest.onreadystatechange = function() {
        if (ajaxRequest.readyState == 4) {
            if (ajaxRequest.status == 200) {
                handleResults(JSON.parse(ajaxRequest.responseText));
            } else {
                alert('ERROR');
            }
        }
    }
}

function handleResults(response) {
    let moviesList = response;

    if (jQuery.isEmptyObject(response)) {
    	$(".movies-list").html("<h2>No movie is found</h2>");
    } else {   
	    let output = "<tr><th>Movie Id</th><th>Movie Title</th><th>Movie Story</th></tr>";
	
	    for (let movie of moviesList) {
	        output += "<tr><td>"
	        + movie.movieId
	        + "</td><td>"
	        + movie.movieTitle
	        + "</td><td>"
	        + movie.movieShortDescription
	        + "</td></tr>";
	    }
	
	    $(".movies-list").html(output);
    }
    

    
}