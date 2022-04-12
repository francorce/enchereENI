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
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Enchere;
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
		
		Article article = articleManager.getById(numArticle);
		request.setAttribute("article", article);
		int enchereLaPlusHaute = article.getPrixInitial();
		List<Enchere> encheres = enchereManager.getByArticleId(article.getNoArticle());
		
		for(Enchere enchere : encheres) {
			if(enchere.getMontantEnchere()>enchereLaPlusHaute) {
				enchereLaPlusHaute = (int) enchere.getMontantEnchere();
			}
		}
		request.setAttribute("prix", enchereLaPlusHaute);
		this.getServletContext().getRequestDispatcher("/WEB-INF/encherir.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String montantEnchereString = request.getParameter("montantEnchere");
		int montantEnchere = 0;
		if(montantEnchereString != null) {
			montantEnchere = Integer.parseInt(montantEnchereString);
		}
		ArticleManager articleManager = new ArticleManager();
		
		String numArticleString = request.getParameter("noArticle");
		int numArticle = 0;
		if(numArticleString != null) {
			numArticle = Integer.parseInt(numArticleString);
		}
		
		Article article = articleManager.getById(numArticle);

		Enchere enchere = new Enchere();
		LocalDateTime now = LocalDateTime.now();  
		HttpSession session = request.getSession();

		enchere.setArticles(article);
		enchere.setDateEnchere(now);
		enchere.setEncherisseur((User)session.getAttribute("user"));
		enchere.setMontantEnchere(montantEnchere);
		
		
		EnchereDao enchereDao = DaoFactory.getEnchereDao();
		try {
			enchereDao.save(enchere);
			request.getSession().setAttribute("succes", true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/AccueilConnecter");

	}

}
