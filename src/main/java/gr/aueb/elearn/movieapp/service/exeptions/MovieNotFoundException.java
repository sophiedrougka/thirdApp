package gr.aueb.elearn.movieapp.service.exeptions;

import gr.aueb.elearn.movieapp.model.Movie;

public class MovieNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovieNotFoundException(Movie movie) {
		super("Movie with id = " + movie.getMovieId() + " does no exist");
	}

}
