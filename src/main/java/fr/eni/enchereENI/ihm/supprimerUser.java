package fr.eni.enchereENI.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.UserManager;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class supprimerUser
 */
@WebServlet("/supprimerUser")
public class supprimerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public supprimerUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserManager userManager = new UserManager();
		HttpSession session = request.getSession();
		boolean isDeleted = userManager.supprimerUser((User) session.getAttribute("user"));

		if (isDeleted) {
			session.removeAttribute("user");
			response.sendRedirect(request.getContextPath() + "/Accueil");
			return;
		} else {
			request.getSession().setAttribute("isDeleted", isDeleted);
			request.getSession().setAttribute("fromDelete", true);
			response.sendRedirect(request.getContextPath() + "/ProfilModifier");
			return;
		} 

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
