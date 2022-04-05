package fr.eni.encheres.ihm.indexServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JRadioButton;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLManager;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLSing;
import fr.eni.encheres.bll.categories.CategorieManagerSing;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ConnecterIndex
 */
@WebServlet("/ConnecterIndex")
public class ConnecterIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduBLLManager managerArticle = ArticleVenduBLLSing.getInstance();
	private CategoriesManager managerCategorie = CategorieManagerSing.getInstance();
	private UtilisateurBLL managerUtilisateur = UtilisateurBLLSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnecterIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConnecterIndexModel model = new ConnecterIndexModel();

		model.setFilterArticle(request.getParameter("filtreNomArticle"));
		model.setFiltreCategorie(request.getParameter("filtreCategorie"));
		model.setFiltreRadio(request.getParameter("radio"));
		model.setFiltreCheckbox(request.getParameter("checkbox"));

		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		model.setCurrentUser(utilisateur);

		// Récupération des catégories pour le filtre
		try {
			model.setLstCategories(managerCategorie.getALLCategorie());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		// Récupération des vendeurs pour les lien href des annonces
		if (request.getParameter("vendeur") != null) {
			try {
				model.setVendeur(managerUtilisateur.getByIdentifiant(request.getParameter("vendeur")));
				session.setAttribute("vendeur", model.getVendeur());
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		
		//Récupération de l'article en session
		if (request.getParameter("article") != null) {
			try {
				session.setAttribute("articleClique", managerArticle.getByIdArticleVendu(Integer.parseInt(request.getParameter("noArticle"))));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		
		// Gestion de la déconnexion
				if (request.getParameter("deconnexion") != null) {
					session.invalidate();
					model.setCurrentUser(null);
					request.getRequestDispatcher("/WEB-INF/indexDeconnecter.jsp").forward(request, response);
				}
		

		// Affichage standard (première affichage)
		if (model.getFilterArticle() == null && model.getFiltreCategorie() == null && model.getFiltreRadio() == null
				&& model.getFiltreCheckbox() == null) {
			try {
				model.setLstArticleVendus(managerArticle.getAllArticleVendu());
			} catch (BLLException e) {
				model.setMessage("Erreur : " + e.getMessage());
			}
		}

		// Affichage conditionné Achats
		if (request.getParameter("BT_RECHERCHER") != null) {
			System.out.println(request.getParameter("radio"));
			if (model.getFiltreRadio().equals("Achats") && model.getFiltreCheckbox() != null) {
				switch (model.getFiltreCheckbox()) {
				case "EncheresOuvertes":
					try {
						model.setLstArticleVendus(managerArticle.getAllArticleEncheresOuvertes());
						System.out.println("EncheresOuvertes");
					} catch (BLLException e) {
						e.printStackTrace();
					}
					break;

				case "MesEncheres":
					try {
						model.setLstArticleVendus(managerArticle.getAllArticleMesEncheres(utilisateur));
						System.out.println("MesEncheres");
					} catch (BLLException e) {
						e.printStackTrace();
					}
					break;

				case "MesEncheresRemportees":
					try {
						model.setLstArticleVendus(managerArticle.getAllArticleMesEncheresRemportees(utilisateur));
						System.out.println("MesEncheresRemportees");
					} catch (BLLException e) {
						e.printStackTrace();
					}

					break;

				default:
					break;
				}
			}
			
			if (model.getFiltreRadio().equals("MesVentes") && model.getFiltreCheckbox() != null) {
			
			}

		}

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/indexConnecter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
