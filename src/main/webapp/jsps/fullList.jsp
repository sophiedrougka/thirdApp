<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Full List</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/MoviesWebApp/static/css/index.css">

</head>

<body>

<%@page import="java.util.ArrayList"%>  
<%@page import="gr.aueb.elearn.movieapp.model.*"%>  
<%@page import="java.util.Iterator"%> 
<% ArrayList<Movie> moviesFullList = (ArrayList) request.getAttribute("moviesFullSList"); %>

<header class="site-header">
        <div class="site-logo">
            <table>
                <tr>
                    <td> <img src="/MoviesWebApp/static/img/movieLogo.jpg" style="width: 100px; height:80px;"></td>
                    <td class="title-font">Movies center</td>
                </tr>
            </table>
        </div>
        
        <div class="social-media">
            <a href="eventForm.html"><img src="/MoviesWebApp/static/img/instagram.jpg" alt="Fire" style="width: 50px; height: 50px;" title="Στείλτε Ενημέρωση Συμβάντος"></a>
            <a href=""><img src="/MoviesWebApp/static/img/facebook.jpg" alt="Protect" style="width: 50px; height: 60px;" title="Εισάγετε Πληροφορίες για την Πανίδα και Χλωρίδα"></a>
            <a href=""><img src="/MoviesWebApp/static/img/tweeter.jpg" alt="Facebook" style="width: 50px; height: 50px;" title="Tweeter"></a>
        </div>
        
        </header>
        
        <div>
        <ul>
            <li><a href="/MoviesWebApp/index.jsp" class="active"><i class="fa fa-fw fa-home"></i>Home</a></li>
            <li>
                <a href="/MoviesWebApp/jsps/insertMovie.jsp">Insert Movie </a>
             </li>
            <li>
                <a href="/MoviesWebApp/jsps/deleteMovie.jsp">Delete Movie</a>
                
            </li>
            <li>
                <a href="/MoviesWebApp/jsps/updateMovie.jsp">Update Movie </a>
                
            </li>
            
            <li>
                <a href="/MoviesWebApp/jsps/searchMovies.jsp">Search Movies </a>
                
            </li>

            <li><a href="#">Services &#9662;</a>
            
                <ul class="dropdown">
                    <li><a href="#">Full List</a></li>
                    <li><a href="#">Free API </a></li>
                    <li><a href="#">Best Movies</a></li>
                  
                </ul>
            
            </li>

            <li class="topnav-right"><a href="#"><i class="fa fa-fw fa-search"></i>Search</a></li>
            <li class="topnav-right"><a href="#"><i class="fa fa-fw fa-envelope"></i>Contact us</a></li>
            <li class="topnav-right"><a href="/MoviesWebApp/jsps/login.jsp"><i class="fa fa-fw fa-user"></i>Login</a></li>
        </ul>
    </div>               
	            
 <table class="table1">

<tr class="tr1"><th class = "th1">Movie ID</th><th class = "th1">Movie Title</th><th class = "th1">Movie Description</th></tr>

<%
// Iterating through subjectList

if(request.getAttribute("moviesFullSList") != null)  // Null check for the object
{
	Iterator<Movie> iterator = moviesFullList.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		Movie movie = iterator.next(); //assign individual employee record to the employee class object
	%>
	<tr class="tr1"><td class = "td1"><%=movie.getMovieId()%></td>
		<td class = "td1"><%=movie.getMovieTitle()%></td>
		<td class = "td1"><%=movie.getMovieShortDescription()%></td>
		
	</tr>
	<%
	}
}
%>
</table>

<br>

<div class="footer">
        <div class="grid-container">
            <div class="grid-item">
                <table>
                    <tr>
                        <td style="font-size: medium; color: black; font-family: fantasy; font-weight: 100; ">
                            follow us
                        </td>
                        <td>
                            <a href=""><img src="/MoviesWebApp/static/img/facebook.jpg" alt="Facebook" style="width: 50px; height: 50px;"></a>
                        </td>
                        <td>
                            <a href=""><img src="/MoviesWebApp/static/img/tweeter.jpg" alt="Facebook" style="width: 50px; height: 50px;"></a>
                        </td>
                        <td>
                            <a href=""><img src="/MoviesWebApp/static/img/instagram.jpg" alt="Instagram" style="width: 50px; height: 50px;"></a>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="grid-item" style="font-size: medium; color: black; font-family: fantasy; font-weight: 100; ">Phone number: <br>6974677596</div>
            <div class="grid-item" style="font-size: medium; color: black; font-family: fantasy; font-weight: 100; ">Email: <br>john_drougas@yahoo.com</div>
        </div>

    </div>
	           
</body>
</html>