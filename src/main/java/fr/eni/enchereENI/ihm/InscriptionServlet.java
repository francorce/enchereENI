package fr.eni.enchereENI.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.enchereENI.*;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User tableUtilisateurs = new User();
        //request.setAttribute("utilisateurs", tableUtilisateurs.recupererUser());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	User utilisateur = new User();
		 	//utilisateur.setNo_utilisateur(request.getParameter("no_utilisateur"));
		 	utilisateur.setPseudo(request.getParameter("pseudo"));
	        utilisateur.setNom(request.getParameter("nom"));
	        utilisateur.setPrenom(request.getParameter("prenom"));
	        utilisateur.setEmail(request.getParameter("email"));
	        utilisateur.setTelephone(request.getParameter("telephone"));
	        utilisateur.setRue(request.getParameter("rue"));
	        utilisateur.setCp(request.getParameter("cp"));
	        utilisateur.setVille(request.getParameter("ville"));
	        utilisateur.setPassword(request.getParameter("password"));
	        //utilisateur.setCredit(request.getParameter("credit"));
	        //utilisateur.setisAdmin(request.getParameter("isAdmin"));
	        
	        //TODO 
//	        User tableUser = new User();
//	        tableUser.ajouterUtilisateur(utilisateur);
//	        
//	        request.setAttribute("utilisateurs", tableUser.recupererUtilisateurs());
	        
	        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

}
