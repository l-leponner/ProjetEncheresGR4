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
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduBLLManager managerArticle = ArticleVenduBLLSing.getInstance();
	private CategoriesManager managerCategorie = CategorieManagerSing.getInstance();
	private UtilisateurBLL managerUtilisateur = UtilisateurBLLSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelIndexServlet model = new ModelIndexServlet();

		model.setFilterArticle(request.getParameter("filtreNomArticle"));
		model.setFiltreCategorie(request.getParameter("filtreCategorie"));

		if (request.getParameter("BT_RECHERCHER") != null) {
			if (model.getFilterArticle() != null && model.getFiltreCategorie().equalsIgnoreCase("Toutes")) {
				try {
					model.setLstArticleVendus(managerArticle.getAllArticleFilterNomArticle(model.getFilterArticle()));
					System.out.println("Je suis passé dans le premier filtre filtreNomArticle != null");
				} catch (BLLException e) {
					model.setMessage("Erreur !!!! : " + e.getMessage());
				}
			}
			if (model.getFilterArticle() == null && !model.getFiltreCategorie().equalsIgnoreCase("Toutes")) {
				try {
					model.setLstArticleVendus(
							managerArticle.getAllArticleFilterCategorie(model.getFiltreCategorie()));
					System.out.println("Je suis passé dans le premier filtre filtreCategorie != null");
				} catch (BLLException e) {
					model.setMessage("Erreur !!!! : " + e.getMessage());
				}
			}
			if (model.getFilterArticle() != null && !model.getFiltreCategorie().equalsIgnoreCase("Toutes")) {
				try {
					model.setLstArticleVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
							model.getFilterArticle(), model.getFiltreCategorie()));
					System.out.println(
							"Je suis passé dans le premier filtre filtreCategorie != null et filtreNomArticle != null");
				} catch (BLLException e) {
					model.setMessage("Erreur !!!! : " + e.getMessage());
				}
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

		System.out.println("#######");
		System.out.println(model.getLstArticleVendus());
		System.out.println(request.getParameter("filtreNomArticle"));

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
