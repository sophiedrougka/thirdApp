package gr.aueb.elearn.movieapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("psw");
		
		if (userName.equals("john64") && (password.contentEquals("123"))) {
			// redirect to search page
			request.getRequestDispatcher("/jsps/moviesMenu.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Login Error");
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
	}

}
