package fr.eni.enchereENI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.BeepAction;

import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bll.CategorieManager;
import fr.eni.enchereENI.bll.EnchereManager;
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.dao.impl.ArticleDaoImpl;
import fr.eni.enchereENI.dao.impl.EnchereDaoImpl;
/**import fr.eni.enchereENI.service.BeeperControl;*/

/**
 * Servlet implementation class Accueil
 */
@WebServlet({"/Accueil",""})
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/**BeeperControl beeper = new BeeperControl();
		beeper.beepForAnHour();*/
		CategorieManager categorieManager = new CategorieManager();
		List<Categorie> listeCategorie = categorieManager.getAll();
		request.setAttribute("listeCategorie", listeCategorie);
		
		ArticleManager articleManager = new ArticleManager();
		List<Article> listArticles = new ArrayList<Article>();
		
		listArticles = articleManager.getAll();
		request.getSession().setAttribute("listArticles", listArticles); // add to session

		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
