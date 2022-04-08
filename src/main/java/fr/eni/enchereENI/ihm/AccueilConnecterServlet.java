package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bo.Article;

/**
 * Servlet implementation class AccueilConnecterServlet
 */
@WebServlet("/AccueilConnecter")
public class AccueilConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilConnecterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArticleManager articleManager = new ArticleManager();
		List<Article> listArticles = new ArrayList<Article>();

		listArticles = articleManager.getAll();
		request.getSession().setAttribute("listArticles", listArticles); // add to session
		this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
