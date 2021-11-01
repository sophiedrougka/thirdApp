package gr.aueb.elearn.movieapp.daoimpl;

import java.util.List;
import java.sql.SQLException;

import gr.aueb.elearn.movieapp.model.Movie;

public interface IMovieDAO {
	
	void insert(Movie movie) throws SQLException;
	void delete(Movie movie) throws SQLException;
	void update(Movie oldMovie, Movie newMovie) throws SQLException;
	List<Movie> getMoviesByTitle(String title) throws SQLException;
	List<Movie> getMoviesFullList() throws SQLException;
	Movie getMovieById(int movieId)throws SQLException;
	public List<Movie> getMoviesByDate(String date) throws SQLException;

}
