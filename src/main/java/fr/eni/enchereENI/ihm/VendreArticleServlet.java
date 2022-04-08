package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bll.CategorieManager;
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet("/VendreArticle")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VendreArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategorieManager categorieManager = new CategorieManager();
		List<Categorie> listeCategorie = categorieManager.getAll();
		request.setAttribute("listeCategorie", listeCategorie);
        this.getServletContext().getRequestDispatcher("/WEB-INF/VendreArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleManager articleManager = new ArticleManager();
		
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String prixDepart = request.getParameter("prixDepart");
		String debutEnchere = request.getParameter("debutEnchere");	
		String finEnchere = request.getParameter("finEnchere");
		
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");

		HttpSession session = request.getSession();
		User vendeur = (User) session.getAttribute("user");
		
		Boolean hasErrors = articleManager.addArticle(nomArticle, description, categorie, prixDepart, debutEnchere, finEnchere, vendeur, rue, cp, ville);
		if(!hasErrors) {
			response.sendRedirect(request.getContextPath() + "/AccueilConnecter");
			return;
		}
		
		
		doGet(request, response);
	}

}
