package gr.aueb.elearn.movieapp.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import static gr.aueb.elearn.movieapp.dao.dbutil.DBUtil.openConnection;

import gr.aueb.elearn.movieapp.daoimpl.IMovieDAO;
import gr.aueb.elearn.movieapp.daoimpl.MovieDAOImpl;
import gr.aueb.elearn.movieapp.dto.*;
import gr.aueb.elearn.movieapp.service.IMovieService;
import gr.aueb.elearn.movieapp.service.MovieServiceImpl;
import gr.aueb.elearn.movieapp.service.exeptions.MovieIdAlreadyExistsException;

/**
 * Servlet implementation class MovieInsertController
 */
public class MovieInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String movieId = request.getParameter("id");
		String movieTitle = request.getParameter("movieTitle");
		String releaseDate = request.getParameter("releaseDate");
		String actor = request.getParameter("actor");
		String description = request.getParameter("sortDescription");
		
		int id = Integer.parseInt(movieId);
		
		/*String sql = "INSERT INTO MOVIES VALUES ('" + id 
		+ "', '" + movieTitle + "', '" + description + "' ,'" + releaseDate + "')";
		
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) openConnection().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int n = pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		MovieDTO movieDTO;
		IMovieDAO movieDAO = new MovieDAOImpl();
		IMovieService movieServ = new MovieServiceImpl(movieDAO);		
		movieDTO = new MovieDTO(id, movieTitle, description, "2000-05-06");
		
		try {
			movieServ.insertMovie(movieDTO);
		} catch (MovieIdAlreadyExistsException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("movieId", movieId);
		request.setAttribute("movieTitle", movieTitle);
		request.setAttribute("releaseDate", releaseDate);
		request.setAttribute("actor", actor);
		request.setAttribute("sortDescription", description);
		request.getRequestDispatcher("/jsps/movieInserted.jsp").forward(request, response);
	}

}
