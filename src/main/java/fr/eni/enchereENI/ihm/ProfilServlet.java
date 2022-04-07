package fr.eni.enchereENI.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchereENI.bll.UserManager;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/Profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userProfil = null;
		String numUtil = request.getParameter("no_utilisateur");
		request.setAttribute("userProfil", userProfil);
		if(numUtil != null) {
			int no = Integer.parseInt(numUtil);
			userProfil = UserManager.getUser(no);
		}else {
			userProfil = (User) request.getSession().getAttribute("user");
		}
		request.setAttribute("userProfil", userProfil);
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
