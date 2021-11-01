package gr.aueb.elearn.movieapp.service.exeptions;

import gr.aueb.elearn.movieapp.model.Movie;

public class MovieIdAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovieIdAlreadyExistsException(Movie movie) {
		super("Teacher with id = " + movie.getMovieId() + " already exist");
	}

}
