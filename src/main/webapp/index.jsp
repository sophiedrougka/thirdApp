<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/MoviesWebApp/static/css/index.css">
</head>

<body>

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
            <a href="eventForm.html"><img src="/MoviesWebApp/static/img/instagram.jpg" alt="Fire" style="width: 50px; height: 50px;" title="Instagram"></a>
            <a href=""><img src="/MoviesWebApp/static/img/facebook.jpg" alt="Protect" style="width: 50px; height: 60px;" title="Facebook"></a>
            <a href=""><img src="/MoviesWebApp/static/img/tweeter.jpg" alt="Facebook" style="width: 50px; height: 50px;" title="Tweeter"></a>
        </div>

    </header>
    <div>
        <ul>
            <li><a href="#" class="active"><i class="fa fa-fw fa-home"></i>Home</a></li>
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
                <a href="/MoviesWebApp/jsps/searchMovies.jsp">Search Movies &#9662;</a>
                
                <ul class="dropdown">
                    <li><a href="/MoviesWebApp/moviesList.html">Ajax Search</a></li>
                </ul>    
                
            </li>

            <li><a href="#">Services &#9662;</a>
            
                <ul class="dropdown">
                    <li><a href="/MoviesWebApp/jsps/fullList.jsp">Latest Releases</a></li>
                    <li><a href="#">Free API </a></li>
                    <li><a href="#">Best Movies</a></li>
                    <li>
                    
                   <form method="POST" action="/MoviesWebApp/MovieSearchController">
	              	<input type="hidden"  name="fullList" value="fullList" />
	             	<button class="submit-btn1 rounded color-btn" type="submit"> FULL LIST</button>
	               </form>
                    
                   </li>
                </ul>
            
            </li>

            <li class="topnav-right"><a href="#"><i class="fa fa-fw fa-search"></i>Search</a></li>
            <li class="topnav-right"><a href="#"><i class="fa fa-fw fa-envelope"></i>Contact us</a></li>
            <li class="topnav-right"><a href="/MoviesWebApp/jsps/login.jsp"><i class="fa fa-fw fa-user"></i>Login</a></li>
        </ul>
    </div>
    
    <div>
        <img src="/MoviesWebApp/static/img/poster.jpg" alt="BATMAN" style="width:100%; height:750px;">

    </div>
   
    <div class="site-info">
        <h3 style="color: red;">More Information</h3>
        <div class="emergency-info-text">
           ‘Enter the Dragon’ (1973)

After headlining several influential kung fu movies in Hong Kong, Bruce Lee made his big breakthrough to American audiences with 
this high-profile Warner Bros. production. Lee stars as a martial arts instructor who is hired by British spies to gather 
intelligence against a crime lord at a fighting competition — a silly plot, but one sturdy enough to hang several genuinely 
jaw-dropping fight sequences on. “Enter the Dragon” became one of the highest-grossing action movies of all time, but Lee 
never saw its success; he died less than a month before its premiere.
        </div>

        <div class="site-map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3145.9066293523138!2d23.685668815322817!3d37.95596607972678!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14a1bc66e994f9df%3A0xdb2d4857292c07e5!2sEmmanouil%20Kampouri%2C%20Moschato%20183%2045!5e0!3m2!1sen!2sgr!4v1622013804664!5m2!1sen!2sgr" 
            width="800" height="350" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
        </div>
    </div>

    <br>
    <button class="info-button">See More...</button>
    <br><br>
    <hr>

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
    <hr>
</body>

</html>