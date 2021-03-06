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
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
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
	
	ConnecterIndexModel model = new ConnecterIndexModel();
	
	String page;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnecterIndex() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		model.setFilterArticle(request.getParameter("filtreNomArticle"));
		model.setFiltreCategorie(request.getParameter("filtreCategorie"));
		model.setFiltreRadio(request.getParameter("radio"));

		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		model.setCurrentUser(utilisateur);

		// R??cup??ration des cat??gories pour le filtre
		try {
			model.setLstCategories(managerCategorie.getALLCategorie());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		// R??cup??ration des vendeurs pour les lien href des annonces
		if (request.getParameter("vendeur") != null) {
			try {
				model.setVendeur(managerUtilisateur.getByIdentifiant(request.getParameter("vendeur")));
				Utilisateur vendeur = managerUtilisateur.getByIdentifiant(request.getParameter("vendeur"));
				session.setAttribute("utilisateurClique", vendeur);
				//page="/UtilisateurDeconnecteServlet";
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
//		try {
//			context.setAttribute("LST_UTILISATEURS", managerUtilisateur.getAllUtilisateur());
//		} catch (BLLException e1) {
//			e1.printStackTrace();
//		}
//			try {
//				context.setAttribute("LST_ARTICLE", managerArticle.getAllArticleVendu());
//			} catch (BLLException e1) {
//				e1.printStackTrace();
//			}
		// R??cup??ration de l'article en session
		if (request.getParameter("article") != null) {
			
			Integer noArticle = Integer.parseInt(request.getParameter("article"));
			
				try {
					session.setAttribute("articleClique",
							managerArticle.getByIdArticleVendu(noArticle));
					//page = "/EncherirServlet";
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (BLLException e) {
					e.printStackTrace();
				}
		}

		// Gestion de la d??connexion
		if (request.getParameter("deconnexion") != null) {
			session.invalidate();
			model.setCurrentUser(null);
			page = "/DeConnecterIndex";
		}

		// Affichage standard (premi??re affichage)
		if (model.getFilterArticle() == null && model.getFiltreCategorie() == null && model.getFiltreRadio() == null
				&& model.getFiltreCheckbox() == null) {
			try {
				model.setLstArticlesVendus(managerArticle.getAllArticleEncheresOuvertes());
			} catch (BLLException e) {
				model.setMessage("Erreur : " + e.getMessage());
			}
		}
	
		// Affichage conditionn?? Achats
		if (request.getParameter("BT_RECHERCHER") != null) {
			if ("Achats".equals(model.getFiltreRadio())) {

				// If Check ench??res ouvertes
				if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") == null && request.getParameter("checkboxMesEncheresRemportees") == null) {
					try {
						model.setLstAchatsEnchOuvertes(managerArticle.getAllArticleEncheresOuvertes());
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
				
				// If Check Mes ench??res
				if (request.getParameter("checkboxEncheresOuvertes") == null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") == null) {
					try {
						model.setLstAchatsMesEnch(managerArticle.getAllArticleMesEncheres(utilisateur));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
				
				// If Check Mes ench??res remport??es
				if (request.getParameter("checkboxEncheresOuvertes") == null && request.getParameter("checkboxMesEncheres") == null && request.getParameter("checkboxMesEncheresRemportees") != null) {
					try {
						model.setLstAchatsMesEnchRemportees(managerArticle.getAllArticleMesEncheresRemportees(utilisateur));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
				
//				// If Check ench??res ouvertes + mes ench??res + mes ench??res remport??es
//				if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") != null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleEOuvertesMesEMesERemportees(utilisateur));
//						System.out.println("Check ench??res ouvertes + mes ench??res + mes ench??res remport??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
//				
//				// If Check ench??res ouvertes + mes ench??res
//				if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") == null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleEOuvertesMesE(utilisateur));
//						System.out.println("Check ench??res ouvertes + mes ench??res");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//					
//				}
//				
//				// If Check ench??res ouvertes + mes ench??res remport??es
//				if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") == null && request.getParameter("checkboxMesEncheresRemportees") != null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleEOuvertesMesERemportees(utilisateur));
//						System.out.println("Check ench??res ouvertes + mes ench??res remport??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
//				
//				// If Check mes ench??res + mes ench??res remport??es
//				if (request.getParameter("checkboxEncheresOuvertes") == null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") != null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleMesEMesERemportees(utilisateur));
//						System.out.println("Check mes ench??res + mes ench??res remport??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
				
			}

			if ("MesVentes".equals(model.getFiltreRadio())) {

				// IF Check Mes ventes termin??es
				if (request.getParameter("checkboxVentesTerminees") != null) {
					try {
						model.setLstMesVentesTerminees(managerArticle.getAllArticleVentesTerminees(utilisateur));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
				
				// IF Check Mes ventes non d??but??es
				if (request.getParameter("checkboxVentesNonDebutees") != null) {
					try {
						model.setLstMesVentesNonDebutees(managerArticle.getAllArticleVentesNonDebutees(utilisateur));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
				
				// IF Check Mes ventes en cours
				if (request.getParameter("checkboxMesVentesEnCours") != null) {
					try {
						model.setLstMesVentesEnCours(managerArticle.getAllArticleMesVentesEnCours(utilisateur));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
				
//				// If Check Mes ventes en cours + Ventes non d??but??es + Ventes termin??es
//				if (request.getParameter("checkboxMesVentesEnCours") != null && request.getParameter("checkboxVentesNonDebutees") != null && request.getParameter("checkboxVentesTerminees") != null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleMesVEnCoursVNonDebuteesVTerminees(utilisateur));
//						System.out.println("Check Mes ventes en cours + Ventes non d??but??es + Ventes termin??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
//				
//				// If Check Mes ventes en cours + Ventes non d??but??es
//				if (request.getParameter("checkboxMesVentesEnCours") != null && request.getParameter("checkboxVentesNonDebutees") != null && request.getParameter("checkboxVentesTerminees") == null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleMesVEnCoursVNonDebutees(utilisateur));
//						System.out.println("Check Mes ventes en cours + Ventes non d??but??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
//				
//				// If Check Mes ventes en cours + Ventes termin??es
//				if (request.getParameter("checkboxMesVentesEnCours") != null && request.getParameter("checkboxVentesNonDebutees") == null && request.getParameter("checkboxVentesTerminees") != null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleMesVEnCoursVTerminees(utilisateur));
//						System.out.println("Check Mes ventes en cours + Ventes termin??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
//				
//				// If Check Ventes non d??but??es + Ventes termin??es
//				if (request.getParameter("checkboxMesVentesEnCours") == null && request.getParameter("checkboxVentesNonDebutees") != null && request.getParameter("checkboxVentesTerminees") != null) {
//					try {
//						model.setLstArticleVendus(managerArticle.getAllArticleVNonDebuteesVTerminees(utilisateur));
//						System.out.println("Check Ventes non d??but??es + Ventes termin??es");
//					} catch (BLLException e) {
//						e.printStackTrace();
//					}
//				}
			}

			// Filtre nom Article et filtre cat??gorie
			switch (model.getFiltreCategorie()) {
			case "Toutes":

				if (!model.getFilterArticle().isBlank()) {
					try {
						model.setLstArticlesVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
								model.getFilterArticle(), model.getFiltreCategorie(), model.getLstArticlesVendus()));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						model.setLstArticlesVendus(managerArticle.getAllArticleEncheresOuvertes());
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}

				break;

			default:

				if (!model.getFilterArticle().isBlank()) {
					try {
						model.setLstArticlesVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
								model.getFilterArticle(), model.getFiltreCategorie(), model.getLstArticlesVendus()));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						model.setLstArticlesVendus(managerArticle
								.getAllArticleFilterCategorie(model.getFiltreCategorie(), model.getLstArticlesVendus()));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}

				break;
			}
			
		}


		request.setAttribute("model", model);
		
		page = "/WEB-INF/indexConnecter.jsp";
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
