package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bll.CategorieManager;
import fr.eni.enchereENI.bll.RetraitManager;
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class ModifierArticleServlet
 */
@WebServlet("/ModifierArticle")
public class ModifierArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numArticleString = request.getParameter("no_article");
		int numArticle = 0;
		if(numArticleString != null) {
			numArticle = Integer.parseInt(numArticleString);
		};
		CategorieManager categorieManager = new CategorieManager();
		List<Categorie> listeCategorie = categorieManager.getAll();
		request.setAttribute("listeCategorie", listeCategorie);
		
		ArticleManager articleManager = new ArticleManager();
		Article article = articleManager.getById(numArticle);
		RetraitManager retraitManager = new RetraitManager();
		Retrait retrait = retraitManager.getByArticleId(numArticle);
		
		request.setAttribute("nomArticle", article.getNomArticle());
		request.setAttribute("description", article.getDescription());
		request.setAttribute("categorieLibelle", article.getCategorie().getLibelle());
		request.setAttribute("prixDepart", article.getPrixInitial());
		request.setAttribute("debutEnchere", article.getDebutEnchere());
		request.setAttribute("finEnchere", article.getFinEnchere());
		request.setAttribute("rue", retrait.getRue());
		request.setAttribute("cp", retrait.getCp());
		request.setAttribute("ville", retrait.getVille());
		request.setAttribute("no_article", numArticle);
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String numArticleString = request.getParameter("no_article");
		int numArticle = 0;
		if(numArticleString != null) {
			numArticle = Integer.parseInt(numArticleString);
		};
		
		Map<String, Boolean> hasErrors = articleManager.updateArticle(numArticle,nomArticle, description, categorie, prixDepart, debutEnchere, finEnchere, vendeur, rue, cp, ville);
		
		 Iterator it = hasErrors.entrySet().iterator();
		  while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(pair.getValue() == (Boolean)true) {
		    		request.setAttribute("hasErrors", hasErrors);
		    		doGet(request, response);
		        	return;
		        } 
		    }
		response.sendRedirect(request.getContextPath() + "/AccueilConnecter");	}

}
