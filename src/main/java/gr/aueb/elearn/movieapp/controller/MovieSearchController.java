package gr.aueb.elearn.movieapp.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.aueb.elearn.movieapp.daoimpl.IMovieDAO;
import gr.aueb.elearn.movieapp.daoimpl.MovieDAOImpl;
import gr.aueb.elearn.movieapp.dto.MovieDTO;
import gr.aueb.elearn.movieapp.model.Movie;
import gr.aueb.elearn.movieapp.service.IMovieService;
import gr.aueb.elearn.movieapp.service.MovieServiceImpl;

import static gr.aueb.elearn.movieapp.dao.dbutil.DBUtil.openConnection;

/**
 * Servlet implementation class MovieSearchController
 */
public class MovieSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String movieId = request.getParameter("movieId");
		String movieTitle = request.getParameter("movieTitle");
		//String actorName = request.getParameter("actorName");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String next = request.getParameter("next");
		String prev = request.getParameter("prev");
		String fullList = request.getParameter("fullList");
		String yearRelease = request.getParameter("yearRelease");
		String movieId1 = request.getParameter("id");
		
		int id=0;
		Movie movie;
		List<Movie> movies = new ArrayList<>();
		int hitCounter=0;
		
		if(movieId!=null) {
		 id = Integer.parseInt(movieId);
		} 
		
		if( movieId1!=null) {
			 id = Integer.parseInt(movieId1);
			} 
						
		try {
			if(openConnection()!=null) {
				request.setAttribute("connection", "CONNECTED WITH DATABASE");					
			} else {
				request.setAttribute("connection", "CONNECTION WITH DATABASE FAILED");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MovieDTO movieDTO = new MovieDTO();
		IMovieDAO movieDAO = new MovieDAOImpl();
		IMovieService movieServ = new MovieServiceImpl(movieDAO);
		
	if(movieId!=null || movieId1!=null) {
		 movie = movieServ.getMovieById(id);
		
		if(movie!=null) {
		
		request.setAttribute("movieId", movie.getMovieId());	
		request.setAttribute("movieTitle", movie.getMovieTitle());
		request.setAttribute("shortDescr", movie.getMovieShortDescription());
		request.setAttribute("yearRelease", movie.getYeaRelease());
		movieId=null;
		
		} else {
			
			request.setAttribute("movieId", "no results");	
			request.setAttribute("movieTitle", "no results");
		}
	} else if(movieTitle!=null ) {
		
		try {
			movies = movieServ.getMoviesByTitle(movieTitle);
			if(movies !=null) {
			request.setAttribute("moviesList", movies);	
			request.setAttribute("movieId", movies.get(hitCounter).getMovieId());
			request.setAttribute("movieTitle", movies.get(hitCounter).getMovieTitle());
			request.setAttribute("shortDescr", movies.get(hitCounter).getMovieShortDescription());
			request.setAttribute("yearRelease", movies.get(hitCounter).getYeaRelease());
			
			HttpSession session=request.getSession();  
	        session.setAttribute("moviesList",movies);  
	        
	        session.setAttribute("hitCounter",hitCounter); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movieTitle=null;
		
	} else if (last!=null) { 
		
		HttpSession session=request.getSession();  
        @SuppressWarnings("unchecked")
		List<Movie> moviesList = (List<Movie>) session.getAttribute("moviesList");  
        
        if(moviesList != null) {
        int length = moviesList.size();
        System.out.println("SIZE==== " + length);
        hitCounter = length-1;
        request.setAttribute("movieId", moviesList.get(hitCounter).getMovieId());
		request.setAttribute("movieTitle", moviesList.get(hitCounter).getMovieTitle());
		request.setAttribute("shortDescr", moviesList.get(hitCounter).getMovieShortDescription());
        }
        
	} else if (first!=null) {
		
		HttpSession session=request.getSession();  
        @SuppressWarnings("unchecked")
		List<Movie> moviesList = (List<Movie>) session.getAttribute("moviesList");  
        
        if(moviesList!=null) {
        int length = moviesList.size();
        System.out.println("SIZE==== " + length);
       // hitCounter = length-1;
        request.setAttribute("movieId", moviesList.get(0).getMovieId());
		request.setAttribute("movieTitle", moviesList.get(0).getMovieTitle());
		request.setAttribute("shortDescr", moviesList.get(0).getMovieShortDescription());
		
        }
		
	} else if (next!=null) {
		
		HttpSession session=request.getSession();  
		@SuppressWarnings("unchecked")
		List<Movie> moviesList = (List<Movie>) session.getAttribute("moviesList");  		 
		
		if(moviesList!=null) {
			
		int index = (int) session.getAttribute("hitCounter");	
        int length = moviesList.size();
        index++;
		if(index>length-1) {
			index=0;
			
		}
		
        request.setAttribute("movieId", moviesList.get(index).getMovieId());
		request.setAttribute("movieTitle", moviesList.get(index).getMovieTitle());
		request.setAttribute("shortDescr", moviesList.get(index).getMovieShortDescription());
		
		session.setAttribute("hitCounter",index); 
		
		}
		
	} else if (prev!=null) {
		
		HttpSession session=request.getSession();  
		@SuppressWarnings("unchecked")
		List<Movie> moviesList = (List<Movie>) session.getAttribute("moviesList");  
		
		if(moviesList!=null) {
		int index = (int) session.getAttribute("hitCounter");  
             
        index--;
		if(index < 0) {
			index=0;
			
		}
		
        request.setAttribute("movieId", moviesList.get(index).getMovieId());
		request.setAttribute("movieTitle", moviesList.get(index).getMovieTitle());
		request.setAttribute("shortDescr", moviesList.get(index).getMovieShortDescription());
		
		session.setAttribute("hitCounter",index); 
		
		}
		
	}
	
	else if(yearRelease!=null) {
		
		try {
			movies = movieServ.getMoviesByDate(yearRelease);
			
			if(movies!=null) {
				request.setAttribute("moviesList", movies);	
				request.setAttribute("movieId", movies.get(hitCounter).getMovieId());
				request.setAttribute("movieTitle", movies.get(hitCounter).getMovieTitle());
				request.setAttribute("shortDescr", movies.get(hitCounter).getMovieShortDescription());
				
				HttpSession session=request.getSession();  
		        session.setAttribute("moviesList",movies);  
		        
		        session.setAttribute("hitCounter",hitCounter); 
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	if(fullList==null ) {
		
	request.getRequestDispatcher("/jsps/searchResults.jsp").forward(request, response);
	
	} else {
		
		try {
			movies = movieServ.getMoviesFullList();
			request.setAttribute("moviesFullSList", movies);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/jsps/fullList.jsp").forward(request, response);
			
		}
	
	}
}
