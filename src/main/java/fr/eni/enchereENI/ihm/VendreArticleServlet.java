package fr.eni.enchereENI.ihm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import fr.eni.enchereENI.bll.ArticleManager;
import fr.eni.enchereENI.bll.CategorieManager;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;

/**
 * Servlet implementation class VendreArticleServlet
 */
@MultipartConfig
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
		
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String prixDepart = request.getParameter("prixDepart");
		String debutEnchere = request.getParameter("debutEnchere");	
		String finEnchere = request.getParameter("finEnchere");
		
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		request.setAttribute("nomArticle", nomArticle);
		request.setAttribute("description", description);
		request.setAttribute("categorieLibelle", categorie);
		request.setAttribute("prixDepart", prixDepart);
		request.setAttribute("debutEnchere", debutEnchere);
		request.setAttribute("finEnchere", finEnchere);
		request.setAttribute("rue", rue);
		request.setAttribute("cp", cp);
		request.setAttribute("ville", ville);

		
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
		
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
		
	    byte[] photoTab = fileContent.readAllBytes();

		String categorie = request.getParameter("categorie");
		String prixDepart = request.getParameter("prixDepart");
		String debutEnchere = request.getParameter("debutEnchere");	
		String finEnchere = request.getParameter("finEnchere");
		
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");

		HttpSession session = request.getSession();
		User vendeur = (User) session.getAttribute("user");
		
		Map<String, Boolean> hasErrors = articleManager.addArticle(nomArticle, description, photoTab, categorie, prixDepart, debutEnchere, finEnchere, vendeur, rue, cp, ville);
		
		 Iterator it = hasErrors.entrySet().iterator();
		  while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(pair.getValue() == (Boolean)true) {
		    		request.setAttribute("hasErrors", hasErrors);
		    		doGet(request, response);
		        	return;
		        } 
		    }
		response.sendRedirect(request.getContextPath() + "/AccueilConnecter");
	}

}
