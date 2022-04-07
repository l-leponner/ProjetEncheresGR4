package fr.eni.encheres.ihm.indexServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLManager;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLSing;
import fr.eni.encheres.bll.categories.CategorieManagerSing;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/DeConnecterIndex")
public class DeConnecterIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduBLLManager managerArticle = ArticleVenduBLLSing.getInstance();
	private CategoriesManager managerCategorie = CategorieManagerSing.getInstance();

	DeConnecterIndexModel model = new DeConnecterIndexModel();
	String page;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeConnecterIndex() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		
		request.setAttribute("model", model);

		try {
			model.setLstCategories(managerCategorie.getALLCategorie());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		model.setFiltreArticle(request.getParameter("filtreNomArticle"));
		model.setFiltreCategorie(request.getParameter("filtreCategorie"));

		request.setAttribute("FilterArticle", request.getParameter("filtreNomArticle"));
		request.setAttribute("FilterCategorie", request.getParameter("filtreCategorie"));
		
		if (model.getFilterArticle() == null && model.getFiltreCategorie() == null) {
			try {
				model.setLstArticleVendus(managerArticle.getAllArticleVendu());
				System.out.println(
						"Je suis passé dans le premier filtre filtreCategorie = null et filtreNomArticle = null");
			} catch (BLLException e) {
				model.setMessage("Erreur !!!! : " + e.getMessage());
			}
		}

		if (request.getParameter("BT_RECHERCHER") != null) {

			switch (model.getFiltreCategorie()) {
			case "Toutes":

				if (!model.getFilterArticle().isBlank()) {
					try {
						model.setLstArticleVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
								model.getFilterArticle(), model.getFiltreCategorie()));
						System.out.println("Je passe par la");
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						model.setLstArticleVendus(managerArticle.getAllArticleVendu());
						System.out.println("Je suis la ");
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}

				System.out.println("Toutes");

				break;

			default:

				if (!model.getFilterArticle().isBlank()) {
					try {
						model.setLstArticleVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
								model.getFilterArticle(), model.getFiltreCategorie()));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						model.setLstArticleVendus(
								managerArticle.getAllArticleFilterCategorie(model.getFiltreCategorie()));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}

				break;
			}

		}
		page = "/WEB-INF/indexDeconnecter.jsp";


		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
