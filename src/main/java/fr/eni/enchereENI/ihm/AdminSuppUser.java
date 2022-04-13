package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchereENI.bll.UserManager;
import fr.eni.enchereENI.dao.UserDao;
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.DaoFactory;

/**
 * Servlet implementation class AdminSuppUser
 */
@WebServlet("/AdminSuppUser")
public class AdminSuppUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSuppUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		

		
		UserManager userManager = new UserManager();
		
		int numUtilisateur = Integer.parseInt(request.getParameter("id"));
		System.out.println(numUtilisateur);
	
	

		UserDao userDao = DaoFactory.getUserDao();
		User utilisateur = new User();
		
		try {
			utilisateur = userDao.get(numUtilisateur);
			 userDao.delete(utilisateur);

		
		} catch (SQLException e) {
		throw new ServletException("Erreur suppression");
		}
		response.sendRedirect(request.getContextPath() + "/PageAdmin");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
