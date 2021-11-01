package gr.aueb.elearn.movieapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.movieapp.dto.MovieDTO;
import gr.aueb.elearn.movieapp.model.Movie;
import gr.aueb.elearn.movieapp.service.exeptions.MovieIdAlreadyExistsException;
import gr.aueb.elearn.movieapp.service.exeptions.MovieNotFoundException;

public interface IMovieService {
	
	void insertMovie(MovieDTO moveDTO) 
			throws MovieIdAlreadyExistsException, SQLException;
	
	void deleteMovie(MovieDTO movieDTO)
			throws MovieNotFoundException, SQLException;
	
	void updateMovie(MovieDTO oldMovieDTO, MovieDTO newMovieDTO) 
			throws MovieNotFoundException, SQLException;
	
	List<Movie> getMoviesByTitle(String title) 
			throws SQLException;
	
	List<Movie> getMoviesFullList() 
			throws SQLException;	
	
	Movie getMovieById(int movieId);
	
	List<Movie> getMoviesByDate(String date) 
			throws SQLException;
	
	

}
