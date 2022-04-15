package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
		String rememberMe = request.getParameter("rememberMe");
		User user = UserManager.connectUser(pseudoOuEmail, password);
		UserManager userManager = new UserManager();
		if (user == null) {
			request.setAttribute("hasErrors", true);
			doGet(request, response);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		
	
		// si remember me est check on genere un identifiant, on le stock en bdd et dans un cookie
		if(rememberMe!=null && rememberMe.equals("on"))
		{
		    UUID uuid = UUID.randomUUID();
		    Cookie c = new Cookie("userid", String.valueOf(uuid));
		    c.setMaxAge(24*60*60);
		    userManager.setUUID(user, String.valueOf(uuid));
		    response.addCookie(c); 
		}
		
		response.sendRedirect(request.getContextPath() + "/AccueilConnecter");

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
