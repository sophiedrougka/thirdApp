package gr.aueb.elearn.movieapp.daoimpl;

import static gr.aueb.elearn.movieapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.elearn.movieapp.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.elearn.movieapp.dao.dbutil.DBUtil.closeRS;
import static gr.aueb.elearn.movieapp.dao.dbutil.DBUtil.closeStmt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import gr.aueb.elearn.movieapp.model.Movie;

public class MovieDAOImpl implements IMovieDAO{

	@Override
	public void insert(Movie movie) throws SQLException {

		String sql = "INSERT INTO MOVIES VALUES ('" + movie.getMovieId()
		+ "', '" + movie.getMovieTitle() + "', '" + movie.getMovieShortDescription() + "',"
		+ "'" + movie.getYeaRelease() + "' )";
		
		PreparedStatement pst = (PreparedStatement) openConnection().prepareStatement(sql);
		int n = pst.executeUpdate(sql);
				
		closeStmt(pst);
		closeConnection();
		
	}

	@Override
	public void delete(Movie movie) throws SQLException {
				
		String sql = "DELETE FROM MOVIES WHERE MOVIE_ID = " + movie.getMovieId();
		PreparedStatement pst = (PreparedStatement) openConnection().prepareStatement(sql);
		int numberOfRowsAffected = pst.executeUpdate();
		
		/*dialogButton = JOptionPane.showConfirmDialog (null, "Είστε σίγουρος;", 
	      		  "Warning", JOptionPane.YES_NO_OPTION);
		
		 if (dialogButton == JOptionPane.YES_OPTION){
	      	  int numberOfRowsAffected = pst.executeUpdate();
	      	  JOptionPane.showMessageDialog (null, numberOfRowsAffected + " rows deleted successfully", 
	          		  "DELETE", JOptionPane.INFORMATION_MESSAGE);
	      } else {
	        	return;
	      }*/
		
		closeStmt(pst);
		closeConnection();
		
	}

	@Override
	public List<Movie> getMoviesByTitle(String title) throws SQLException {
		
		String sql = "SELECT MOVIE_ID, MOVIE_TITLE, MOVIE_DESCR, YEAR_RELEASE FROM MOVIES WHERE MOVIE_TITLE LIKE '" 
				+ title + "%'";
		
		 PreparedStatement pst =  (PreparedStatement) openConnection().prepareStatement(sql);
		 ResultSet rs = pst.executeQuery(sql);
		    
		    List<Movie> movies = new ArrayList<>();
		    
		    rs.beforeFirst();
		    while (rs.next()) {
		    	Movie movie = new Movie();
			    	
		    	movie.setMovieId(rs.getInt("MOVIE_ID"));
		    	movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
		    	movie.setMovieShortDescription(rs.getString("MOVIE_DESCR"));
		    	movie.setYeaRelease(rs.getString("YEAR_RELEASE"));
		    	movies.add(movie); 	
		    	
		    	System.out.println("MOVIE TITLE" + rs.getString("MOVIE_TITLE")+ "\n");
		    }
		    
		    closeRS(rs);
		    closeStmt(pst);
		    closeConnection();
		    
		    return (!movies.isEmpty()) ? movies : null;
		
		
	}

	@Override
	public Movie getMovieById(int movieId) throws SQLException {
		
		boolean movieFound = false;
		
		String sql = "SELECT * FROM MOVIES WHERE MOVIE_ID = " + movieId;
	    PreparedStatement pst =  (PreparedStatement) openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    //Movie movie = new Movie();
	    String mTitle = null;
	    int mId = 0;
	    String mDescr = null;
	    String movieDate = null;
	    
	    rs.beforeFirst();
	   while(rs.next()) {
		   
		    mId = rs.getInt("MOVIE_ID");
		    mTitle = rs.getString("MOVIE_TITLE");
		    mDescr = rs.getString("MOVIE_DESCR");
		    movieDate = rs.getString("YEAR_RELEASE");
	    	//movie.setMovieId(rs.getInt("MOVIE_ID"));
	    	//movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
	    	//movie.setMovieShortDescription(rs.getString("MOVIE_DESCR"));
	    	
	       	//return teacher;
	    	movieFound = true;
	    }
	   
	    System.out.println("AAAAAAAAAA" +mId + "\n");
   		System.out.println("BBBBBBBBBB" + mTitle + "\n");
   		System.out.println("cccccccccc" + mDescr + "\n");
   		
   		Movie movie = new Movie(mId, mTitle, mDescr, movieDate);   		 	
	    	    
	    closeRS(rs);
	    closeStmt(pst);
	    closeConnection();
	    
	    //return (movieFound) ? movie : null;	
	    return movie;
		
	}

	@Override
	public void update(Movie oldMovie, Movie newMovie) throws SQLException {
		
		String sql = "UPDATE MOVIES SET MOVIE_TITLE = '" + newMovie.getMovieTitle() + "', " + "MOVIE_DESCR = '" 
				+ newMovie.getMovieShortDescription() + "' WHERE MOVIE_ID = " + oldMovie.getMovieId();
		
		PreparedStatement pst = (PreparedStatement) openConnection().prepareStatement(sql);
		int numberOfRowsAffected = pst.executeUpdate();
		
		 closeStmt(pst);
		 closeConnection();
		
	}

	@Override
	public List<Movie> getMoviesFullList() throws SQLException {
		String sql = "SELECT * FROM MOVIES ";
	    PreparedStatement pst =  (PreparedStatement) openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    List<Movie> movies = new ArrayList<>();
	    
	    rs.beforeFirst();
	    while (rs.next()) {
	    	Movie movie = new Movie();
		    	
	    	movie.setMovieId(rs.getInt("MOVIE_ID"));
	    	movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
	    	movie.setMovieShortDescription(rs.getString("MOVIE_DESCR"));
	    	movie.setYeaRelease(rs.getString("YEAR_RELEASE"));
	    	movies.add(movie); 	
	    	
	    	//System.out.println("MOVIE TITLE" + rs.getString("MOVIE_TITLE")+ "\n");
	    }
	    
	    closeRS(rs);
	    closeStmt(pst);
	    closeConnection();
	    
	    return (!movies.isEmpty()) ? movies : null;
	    		
	}

	@Override
	public List<Movie> getMoviesByDate(String date) throws SQLException {
		
		String sql = "SELECT MOVIE_ID, MOVIE_TITLE, MOVIE_DESCR, YEAR_RELEASE FROM MOVIES WHERE YEAR_RELEASE LIKE '" 
					+ date +"%'";
		
		 PreparedStatement pst =  (PreparedStatement) openConnection().prepareStatement(sql);
		 ResultSet rs = pst.executeQuery(sql);
		    
		    List<Movie> movies = new ArrayList<>();
		    
		    rs.beforeFirst();
		    while (rs.next()) {
		    	Movie movie = new Movie();
			    	
		    	movie.setMovieId(rs.getInt("MOVIE_ID"));
		    	movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
		    	movie.setMovieShortDescription(rs.getString("MOVIE_DESCR"));
		    	movie.setYeaRelease(rs.getString("YEAR_RELEASE"));
		    	movies.add(movie); 	
		    	
		    	System.out.println("MOVIE TITLE" + rs.getString("MOVIE_TITLE")+ "\n");
		    }
		    
		    closeRS(rs);
		    closeStmt(pst);
		    closeConnection();
		    
		    return (!movies.isEmpty()) ? movies : null;
		
		
	}	

}
