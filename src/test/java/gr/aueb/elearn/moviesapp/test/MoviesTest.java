package gr.aueb.elearn.moviesapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import gr.aueb.elearn.movieapp.daoimpl.IMovieDAO;
import gr.aueb.elearn.movieapp.daoimpl.MovieDAOImpl;
import gr.aueb.elearn.movieapp.dto.MovieDTO;
import gr.aueb.elearn.movieapp.model.Movie;
import gr.aueb.elearn.movieapp.service.IMovieService;
import gr.aueb.elearn.movieapp.service.MovieServiceImpl;

public class MoviesTest {
	
	public MoviesTest(){}

	@Test
	public void test() {
		
		int movieId = 380;
		String testTitle="ANACONDA";
		String movieTitle;
		Movie movie;
		MovieDTO movieDTO = new MovieDTO();
		IMovieDAO movieDAO = new MovieDAOImpl();
		IMovieService movieServ = new MovieServiceImpl(movieDAO);
		
		movie = movieServ.getMovieById(movieId);
		movieTitle = movie.getMovieTitle();
		
		assertEquals(testTitle, movieTitle); 
		
		//fail("Not yet implemented");
	}

}
