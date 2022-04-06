package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.UserManager;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.UserDao;
import fr.eni.enchereENI.dao.UserDaoFactory;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasErrors = false;
		if (request.getAttribute("hasErrors") != null) {
			hasErrors = (Boolean) request.getAttribute("hasErrors");
		}

		if (hasErrors) {
			request.setAttribute("hasErrors", "Username ou password invalide");
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudoOuEmail = request.getParameter("username");
		String password = request.getParameter("password");
		User user = UserManager.connectUser(pseudoOuEmail, password);
		if (user == null) {
			request.setAttribute("hasErrors", true);
			doGet(request, response);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + "/Accueil");

//		
//		 MessageDigest md;
//			try {
//				md = MessageDigest.getInstance("MD5");
//				 md.update("toto".getBytes());
//				    byte[] digest = md.digest();
//				    String mp = new String(digest);
//				 System.out.println(mp);   
//			} catch (NoSuchAlgorithmException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		// TODO

	}



}