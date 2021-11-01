package gr.aueb.elearn.movieapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.movieapp.daoimpl.IMovieDAO;
import gr.aueb.elearn.movieapp.dto.MovieDTO;
import gr.aueb.elearn.movieapp.model.Movie;
import gr.aueb.elearn.movieapp.service.exeptions.MovieIdAlreadyExistsException;
import gr.aueb.elearn.movieapp.service.exeptions.MovieNotFoundException;

public class MovieServiceImpl implements IMovieService{
	
	private final IMovieDAO movieDAO;
	
	public MovieServiceImpl(IMovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	@Override
	public void insertMovie(MovieDTO movieDTO) throws MovieIdAlreadyExistsException, SQLException {
		
		Movie newMovie = new Movie();
		newMovie.setMovieId(movieDTO.getMovieId());
		newMovie.setMovieTitle(movieDTO.getMovieTitle());
		newMovie.setMovieShortDescription(movieDTO.getMovieShortDescription());
		newMovie.setYeaRelease(movieDTO.getYeaRelease());
		
		movieDAO.insert(newMovie);
		
	}

	@Override
	public void deleteMovie(MovieDTO movieDTO) throws MovieNotFoundException, SQLException {
	
		Movie movieToDelete = new Movie();
		movieToDelete.setMovieId(movieDTO.getMovieId());
		
		/*if ((movieDAO.getMovieById(movieToDelete.getMovieId())) == null) 
			throw new MovieNotFoundException(movieToDelete); */
		
		movieDAO.delete(movieToDelete);
		
	}

	@Override
	public void updateMovie(MovieDTO oldMovieDTO, MovieDTO newMovieDTO)
			throws MovieNotFoundException, SQLException {
		
		Movie movieToUpdate = new Movie();
		movieToUpdate.setMovieId(oldMovieDTO.getMovieId());
		
		Movie newMovie = new Movie();
		newMovie.setMovieTitle(newMovieDTO.getMovieTitle());
		newMovie.setMovieShortDescription(newMovieDTO.getMovieShortDescription());
		//newMovie.setYeaRelease(null);
		
		/*if ((movieDAO.getMovieById(movieToUpdate.getMovieId())) == null) 
			throw new MovieNotFoundException(movieToUpdate); */
		
		movieDAO.update(movieToUpdate, newMovie);
		
	}

	@Override
	public List<Movie> getMoviesByTitle(String title) throws SQLException {
		// TODO Auto-generated method stub
		return movieDAO.getMoviesByTitle(title);
	}

	@Override
	public Movie getMovieById(int movieId) {
		Movie mdao = null;
		/*try {
			movieDAO.getMovieById(movieId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
		 mdao = movieDAO.getMovieById(movieId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return mdao;
	}

	
	@Override
	public List<Movie> getMoviesFullList() throws SQLException {
		// TODO Auto-generated method stub
		return movieDAO.getMoviesFullList();
	}

	@Override
	public List<Movie> getMoviesByDate(String date) throws SQLException {
		// TODO Auto-generated method stub
		return movieDAO.getMoviesByDate(date);
	}

		
}
