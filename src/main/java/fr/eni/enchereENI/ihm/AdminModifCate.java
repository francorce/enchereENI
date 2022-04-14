package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bll.CategorieManager;
import fr.eni.enchereENI.bll.RetraitManager;
import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.dao.CategorieDao;
import fr.eni.enchereENI.dao.DaoFactory;

/**
 * Servlet implementation class AdminModifCate
 */
@WebServlet("/AdminModifCate")
public class AdminModifCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminModifCate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategorieManager categorieManager = new CategorieManager();
		
		int numCategorie = Integer.parseInt(request.getParameter("id"));
		System.out.println(numCategorie);
	
	

		CategorieDao categorieDao = DaoFactory.getCategorieDao();
		Categorie categorie = new Categorie();
		
		try {
			categorie = categorieDao.getById(numCategorie);
			categorieDao.update(categorie);

		
		} catch (SQLException e) {
			System.out.println("erreur suppression cate");
		throw new ServletException("Erreur suppression",e );
		
		}
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
