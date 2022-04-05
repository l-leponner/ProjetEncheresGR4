package fr.eni.encheres.ihm.indexServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLManager;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLSing;
import fr.eni.encheres.bll.categories.CategorieManagerSing;
import fr.eni.encheres.bll.categories.CategoriesManager;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/DeConnecterIndex")
public class DeConnecterIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduBLLManager managerArticle = ArticleVenduBLLSing.getInstance();
	private CategoriesManager managerCategorie = CategorieManagerSing.getInstance();

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
		DeConnecterIndexModel model = new DeConnecterIndexModel();
		
		
		try {
			model.setLstCategories(managerCategorie.getALLCategorie());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		model.setFilterArticle(request.getParameter("filtreNomArticle"));
		model.setFiltreCategorie(request.getParameter("filtreCategorie"));

		request.setAttribute("FilterArticle", request.getParameter("filtreNomArticle"));
		request.setAttribute("FilterCategorie", request.getParameter("filtreCategorie"));

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

			case "Informatique":

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

				System.out.println("Informatique");

				break;

			case "Ameublement":

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

				System.out.println("Ameublement");

				break;

			case "VÃªtement":

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

				System.out.println("Vêtement");

				break;

			case "Sport&Loisirs":

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

				System.out.println("Sport&Loisirs");

				break;

			default:

				break;
			}

		}

		if (model.getFilterArticle() == null && model.getFiltreCategorie() == null) {
			try {
				model.setLstArticleVendus(managerArticle.getAllArticleVendu());
				System.out.println(
						"Je suis passé dans le premier filtre filtreCategorie = null et filtreNomArticle = null");
			} catch (BLLException e) {
				model.setMessage("Erreur !!!! : " + e.getMessage());
			}
		}
		


		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/indexDeconnecter.jsp").forward(request, response);
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
