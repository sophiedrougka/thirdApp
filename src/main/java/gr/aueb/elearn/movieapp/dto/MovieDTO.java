package gr.aueb.elearn.movieapp.dto;

import java.util.Date;

public class MovieDTO {
	
	private int movieId;
	private String movieTitle;
	private String movieShortDescription;
	private String yeaRelease;
	
	public MovieDTO() {
		
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieShortDescription() {
		return movieShortDescription;
	}

	public void setMovieShortDescription(String movieShortDescription) {
		this.movieShortDescription = movieShortDescription;
	}

	public String getYeaRelease() {
		return yeaRelease;
	}

	public void setYeaRelease(String yeaRelease) {
		this.yeaRelease = yeaRelease;
	}

	public MovieDTO(int movieId, String movieTitle, String movieShortDescription, String yeaRelease) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieShortDescription = movieShortDescription;
		this.yeaRelease = yeaRelease;
	}
	
	

}
