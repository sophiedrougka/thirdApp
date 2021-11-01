package gr.aueb.elearn.movieapp.controller;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class MovieUpdateController
 */
public class MovieUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String movieId = request.getParameter("id");
		String movieTitle = request.getParameter("movieTitle");
		String movieDescr = request.getParameter("sortDescription");
		int id = Integer.parseInt(movieId);
		
		MovieDTO oldMovieDTO = new MovieDTO();
		MovieDTO newMovieDTO = new MovieDTO();
		IMovieDAO movieDAO = new MovieDAOImpl();
		IMovieService movieServ = new MovieServiceImpl(movieDAO);
		
		oldMovieDTO.setMovieId(id);
		newMovieDTO = new MovieDTO(id, movieTitle, movieDescr,  "2000-05-06");
		
		try {
			movieServ.updateMovie(oldMovieDTO, newMovieDTO);
		} catch (MovieNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("movieId", movieId);
		request.setAttribute("movieTitle", movieTitle);
		
		request.getRequestDispatcher("/jsps/movieUpdated.jsp").forward(request, response);
	}

}
