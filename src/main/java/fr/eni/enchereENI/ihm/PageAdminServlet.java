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

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.CategorieDao;

import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.EnchereDao;
import fr.eni.enchereENI.dao.RetraitDao;
import fr.eni.enchereENI.dao.UserDao;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class PageAdminServlet
 */
@WebServlet("/PageAdmin")
public class PageAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List utilisateurs = new ArrayList<User>();
		List listeCategorie = new ArrayList<Categorie>();
		List listeArticles = new ArrayList<Article>();
		List enchereList = new ArrayList<Enchere>();
		List saveRetrait = new ArrayList<Retrait>();
		
	

		UserDao userDao = DaoFactory.getUserDao();
		CategorieDao categorieDao = DaoFactory.getCategorieDao();
		ArticleDao articleDao = DaoFactory.getArticleDao();
		EnchereDao enchereDao = DaoFactory.getEnchereDao();
		RetraitDao retraitDao = DaoFactory.getRetraitDao();
		
		try {
			utilisateurs = userDao.getAll();
			listeCategorie = categorieDao.getAll();
			listeArticles = articleDao.getAll();
			enchereList = enchereDao.getAll();
			saveRetrait = retraitDao.getAll();
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new ServletException("Erreur recup");
		}
		//DEBUG
		//System.out.println(utilisateur);

		request.setAttribute("utilisateurs", utilisateurs);
		request.setAttribute("categories", listeCategorie);
		request.setAttribute("articles", listeArticles);
		request.setAttribute("enchere", enchereList);
		request.setAttribute("retrait", saveRetrait);



		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
