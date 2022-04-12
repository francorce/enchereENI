package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bll.EnchereManager;
import fr.eni.enchereENI.bll.RetraitManager;
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.EnchereDao;

/**
 * Servlet implementation class encherirServlet
 */
@WebServlet("/encherir")
public class encherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public encherirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String numArticleString = request.getParameter("no_article");
		int numArticle = 0;
		if(numArticleString != null) {
			numArticle = Integer.parseInt(numArticleString);
		}
			
		ArticleManager articleManager = new ArticleManager();
		EnchereManager enchereManager = new EnchereManager();
		RetraitManager retraitManager = new RetraitManager();
		
		Article article = articleManager.getById(numArticle);
		Retrait retrait = retraitManager.getByArticleId(numArticle);
		
		request.setAttribute("article", article);
		int enchereLaPlusHaute = article.getPrixInitial();
		List<Enchere> encheres = enchereManager.getByArticleId(article.getNoArticle());
		
		for(Enchere enchere : encheres) {
			if(enchere.getMontantEnchere()>enchereLaPlusHaute) {
				enchereLaPlusHaute = (int) enchere.getMontantEnchere();
			}
		}	
		request.setAttribute("prix", enchereLaPlusHaute);
		
		
		String retraitRue = retrait.getRue();
		String retraitCp = retrait.getCp();
		String retraitVille = retrait.getVille();
		
		request.setAttribute("rue", retraitRue);
		request.setAttribute("cp", retraitCp);
		request.setAttribute("ville", retraitVille);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/encherir.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String montantEnchereString = request.getParameter("montantEnchere");
		String numArticleString = request.getParameter("no_article");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		EnchereManager enchereManager = new EnchereManager();
		boolean isOK = enchereManager.encherir(montantEnchereString, numArticleString, user);
		
		if(isOK) {
			request.getSession().setAttribute("succes", true);
			response.sendRedirect(request.getContextPath() + "/AccueilConnecter");
		} else {
			request.setAttribute("no_article", numArticleString);
			doGet(request, response);
		}
	}

}
