package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.enchereENI.*;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.*;
import fr.eni.enchereENI.dao.impl.*;


/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  request.setAttribute("utilisateurs", User.get());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if("Annuler".equals(request.getParameter("action"))) {
				response.sendRedirect("/enchereENI/");
				return;
			}
		 	User utilisateur = new User();
		 	utilisateur.setPseudo(request.getParameter("pseudo"));
	        utilisateur.setNom(request.getParameter("nom"));
	        utilisateur.setPrenom(request.getParameter("prenom"));
	        utilisateur.setEmail(request.getParameter("email"));
	        utilisateur.setTelephone(request.getParameter("telephone"));
	        utilisateur.setRue(request.getParameter("rue"));
	        utilisateur.setCp(request.getParameter("cp"));
	        utilisateur.setVille(request.getParameter("ville"));
	        utilisateur.setPassword(request.getParameter("password"));
	        //TODO Credit dans couche bll
	        utilisateur.setCredit(100);
	        utilisateur.setAdmin(false);
	     	        
	        UserDao userDao = DaoFactory.getUserDao();
	        try {
				userDao.save(utilisateur);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //TODO 
//	        User tableUser = new User();
//	        tableUser.save(utilisateur);
//	        
//	        request.setAttribute("utilisateurs", tableUser.recupererUtilisateurs());
	        
	        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

}
