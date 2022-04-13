package fr.eni.enchereENI.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.UserManager;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class DeconnexionServlet
 */
@WebServlet("/Deconnexion")
public class DeconnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeconnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserManager userManager = new UserManager();
		HttpSession session = request.getSession();
		
		User currentUser = null;
		
		if (session.getAttribute("user") != null) {
			currentUser = (User)session.getAttribute("user");
			session.removeAttribute("user");
		}
		Cookie[] cookies = request.getCookies(); // request is an instance of type
		// HttpServletRequest
		boolean foundCookie = false;

		for (int i = 0; i < cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("userid") ) {
				c.setMaxAge(0);
				userManager.setUUID(currentUser, "");
				response.addCookie(c);
			}
		}

		response.sendRedirect(request.getContextPath() + "/Accueil");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
