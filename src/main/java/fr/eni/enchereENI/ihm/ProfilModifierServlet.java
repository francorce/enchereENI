package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.UserManager;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.UserDao;

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ProfilModifier")
public class ProfilModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilModifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User utilisateur = new User();
		
		utilisateur = (User) session.getAttribute("user");
		System.out.println(utilisateur);
		
		request.setAttribute("user", utilisateur);
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/ProfilModifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		


        
        this.getServletContext().getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request, response);
	}

}
