package gr.aueb.elearn.movieapp.model;

/**
 * Movie POJO/Java Bean Class
 * 
 * @author user J. Drougas
 * @version 0.1
 */
import java.util.Date;

public class Movie {
	
	private int movieId;
	private String movieTitle;
	private String movieShortDescription;
	private String yeaRelease;
	
	public Movie() {}
	
	public Movie(int movieId, String movieTitle, String movieShortDescription, String yeaRelease) {
		//super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieShortDescription = movieShortDescription;
		this.yeaRelease = yeaRelease;
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
	public void setYeaRelease(String string) {
		this.yeaRelease = string;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieShortDescription="
				+ movieShortDescription + ", yeaRelease=" + yeaRelease + "]";
	}
		

}
