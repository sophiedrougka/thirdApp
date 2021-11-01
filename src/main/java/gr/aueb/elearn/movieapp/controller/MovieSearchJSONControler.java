package gr.aueb.elearn.movieapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gr.aueb.elearn.movieapp.daoimpl.IMovieDAO;
import gr.aueb.elearn.movieapp.daoimpl.MovieDAOImpl;
import gr.aueb.elearn.movieapp.model.Movie;
import gr.aueb.elearn.movieapp.service.IMovieService;
import gr.aueb.elearn.movieapp.service.MovieServiceImpl;


/**
 * Servlet implementation class MovieSearchJSONControler
 */

@WebServlet("/MovieSearchJSONControler")
public class MovieSearchJSONControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMovieDAO movieDAO = new MovieDAOImpl();
		IMovieService movieServ = new MovieServiceImpl(movieDAO);
		List<Movie> movies = new ArrayList<>();
		
		Gson gson = new Gson();
		String gsonResponse;
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		String movieTitle = request.getParameter("searchInput");
		
		try {
			movies = movieServ.getMoviesByTitle(movieTitle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (movies != null) {
			gsonResponse = gson.toJson(movies);
			response.getWriter().write(gsonResponse);
			System.out.println(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
		

	}

}
