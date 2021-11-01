package gr.aueb.elearn.movieapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.movieapp.daoimpl.IMovieDAO;
import gr.aueb.elearn.movieapp.daoimpl.MovieDAOImpl;
import gr.aueb.elearn.movieapp.dto.MovieDTO;
import gr.aueb.elearn.movieapp.service.IMovieService;
import gr.aueb.elearn.movieapp.service.MovieServiceImpl;
import gr.aueb.elearn.movieapp.service.exeptions.MovieNotFoundException;

/**
 * Servlet implementation class MovieDeleteController
 */
public class MovieDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String movieId = request.getParameter("id").trim();
		System.out.println("MOVIEID " +movieId);
		String movieTitle = request.getParameter("movieTitle");
		//int id = 0;
		
		if(!movieId.equals("null")) {
			System.out.println("MOVIEID " +movieId);
	    int id = Integer.parseInt(movieId);
		//}
		
		MovieDTO movieDTO = new MovieDTO();
		IMovieDAO movieDAO = new MovieDAOImpl();
		IMovieService movieServ = new MovieServiceImpl(movieDAO);
		
		movieDTO.setMovieId(id);
		
	  // if(movieId!=null) {
		try {
			movieServ.deleteMovie(movieDTO);
		} catch (MovieNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("movieId", movieId);
		request.setAttribute("movieTitle", movieTitle);
		
	   } else if(movieId.equals("null") || movieId==null) {
		
		request.setAttribute("movieId", "NOT FOUND");
		request.setAttribute("movieTitle", "NOT FOUND");
		
	   }
		
		request.getRequestDispatcher("/jsps/movieDeleted.jsp").forward(request, response);
	}

}
