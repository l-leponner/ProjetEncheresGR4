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
				Utilisateur vendeur = managerUtilisateur.getByIdentifiant(request.getParameter("vendeur"));
				session.setAttribute("utilisateurClique", vendeur);
				//page="/UtilisateurDeconnecteServlet";
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		// Récupération de l'article en session
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

		// Gestion de la déconnexion
		if (request.getParameter("deconnexion") != null) {
			session.invalidate();
			model.setCurrentUser(null);
			page = "/DeConnecterIndex";
		}

		// Affichage standard (première affichage)
		if (model.getFilterArticle() == null && model.getFiltreCategorie() == null && model.getFiltreRadio() == null
				&& model.getFiltreCheckbox() == null) {
			try {
				model.setLstArticlesVendus(managerArticle.getAllArticleEncheresOuvertes());
			} catch (BLLException e) {
				model.setMessage("Erreur : " + e.getMessage());
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
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		
		// Affichage conditionné Achats
				if (request.getParameter("BT_RECHERCHER") != null) {
					if ("Achats".equals(model.getFiltreRadio())) {

						// If Check enchères ouvertes
						if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") == null && request.getParameter("checkboxMesEncheresRemportees") == null) {
							try {
								model.setLstAchatsEnchOuvertes(managerArticle.getAllArticleEncheresOuvertes());
								System.out.println("Check enchères ouvertes");
							} catch (BLLException e) {
								e.printStackTrace();
							}
						}
						
						// If Check Mes enchères
						if (request.getParameter("checkboxEncheresOuvertes") == null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") == null) {
							try {
								model.setLstAchatsMesEnch(managerArticle.getAllArticleMesEncheres(utilisateur));
								System.out.println("Check Mes enchères");
							} catch (BLLException e) {
								e.printStackTrace();
							}
						}
						
						// If Check Mes enchères remportées
						if (request.getParameter("checkboxEncheresOuvertes") == null && request.getParameter("checkboxMesEncheres") == null && request.getParameter("checkboxMesEncheresRemportees") != null) {
							try {
								model.setLstAchatsMesEnchRemportees(managerArticle.getAllArticleMesEncheresRemportees(utilisateur));
								System.out.println("Check Mes enchères remportées");
							} catch (BLLException e) {
								e.printStackTrace();
							}
						}
						
//						// If Check enchères ouvertes + mes enchères + mes enchères remportées
//						if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") != null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleEOuvertesMesEMesERemportees(utilisateur));
//								System.out.println("Check enchères ouvertes + mes enchères + mes enchères remportées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
//						
//						// If Check enchères ouvertes + mes enchères
//						if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") == null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleEOuvertesMesE(utilisateur));
//								System.out.println("Check enchères ouvertes + mes enchères");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//							
//						}
//						
//						// If Check enchères ouvertes + mes enchères remportées
//						if (request.getParameter("checkboxEncheresOuvertes") != null && request.getParameter("checkboxMesEncheres") == null && request.getParameter("checkboxMesEncheresRemportees") != null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleEOuvertesMesERemportees(utilisateur));
//								System.out.println("Check enchères ouvertes + mes enchères remportées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
//						
//						// If Check mes enchères + mes enchères remportées
//						if (request.getParameter("checkboxEncheresOuvertes") == null && request.getParameter("checkboxMesEncheres") != null && request.getParameter("checkboxMesEncheresRemportees") != null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleMesEMesERemportees(utilisateur));
//								System.out.println("Check mes enchères + mes enchères remportées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
						
					}

					if ("MesVentes".equals(model.getFiltreRadio())) {

						// IF Check Mes ventes terminées
						if (request.getParameter("checkboxVentesTerminees") != null) {
							try {
								model.setLstMesVentesTerminees(managerArticle.getAllArticleVentesTerminees(utilisateur));
								System.out.println("Check Mes ventes terminées");
							} catch (BLLException e) {
								e.printStackTrace();
							}
						}
						
						// IF Check Mes ventes non débutées
						if (request.getParameter("checkboxVentesNonDebutees") != null) {
							try {
								model.setLstMesVentesNonDebutees(managerArticle.getAllArticleVentesNonDebutees(utilisateur));
								System.out.println("Check Mes ventes non débutées");
							} catch (BLLException e) {
								e.printStackTrace();
							}
						}
						
						// IF Check Mes ventes en cours
						if (request.getParameter("checkboxMesVentesEnCours") != null) {
							try {
								model.setLstMesVentesEnCours(managerArticle.getAllArticleMesVentesEnCours(utilisateur));
								System.out.println("Check Mes ventes non débutées");
							} catch (BLLException e) {
								e.printStackTrace();
							}
						}
						
//						// If Check Mes ventes en cours + Ventes non débutées + Ventes terminées
//						if (request.getParameter("checkboxMesVentesEnCours") != null && request.getParameter("checkboxVentesNonDebutees") != null && request.getParameter("checkboxVentesTerminees") != null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleMesVEnCoursVNonDebuteesVTerminees(utilisateur));
//								System.out.println("Check Mes ventes en cours + Ventes non débutées + Ventes terminées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
//						
//						// If Check Mes ventes en cours + Ventes non débutées
//						if (request.getParameter("checkboxMesVentesEnCours") != null && request.getParameter("checkboxVentesNonDebutees") != null && request.getParameter("checkboxVentesTerminees") == null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleMesVEnCoursVNonDebutees(utilisateur));
//								System.out.println("Check Mes ventes en cours + Ventes non débutées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
//						
//						// If Check Mes ventes en cours + Ventes terminées
//						if (request.getParameter("checkboxMesVentesEnCours") != null && request.getParameter("checkboxVentesNonDebutees") == null && request.getParameter("checkboxVentesTerminees") != null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleMesVEnCoursVTerminees(utilisateur));
//								System.out.println("Check Mes ventes en cours + Ventes terminées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
//						
//						// If Check Ventes non débutées + Ventes terminées
//						if (request.getParameter("checkboxMesVentesEnCours") == null && request.getParameter("checkboxVentesNonDebutees") != null && request.getParameter("checkboxVentesTerminees") != null) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleVNonDebuteesVTerminees(utilisateur));
//								System.out.println("Check Ventes non débutées + Ventes terminées");
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
					}

					// Filtre nom Article et filtre catègorie
//					switch (model.getFiltreCategorie()) {
//					case "Toutes":
		//
//						if (!model.getFilterArticle().isBlank()) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
//										model.getFilterArticle(), model.getFiltreCategorie(), model.getLstArticleVendus()));
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						} else {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleEncheresOuvertes());
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
		//
//						break;
		//
//					default:
		//
//						if (!model.getFilterArticle().isBlank()) {
//							try {
//								model.setLstArticleVendus(managerArticle.getAllArticleFilterCategorieAndNomArticle(
//										model.getFilterArticle(), model.getFiltreCategorie(), model.getLstArticleVendus()));
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						} else {
//							try {
//								model.setLstArticleVendus(managerArticle
//										.getAllArticleFilterCategorie(model.getFiltreCategorie(), model.getLstArticleVendus()));
//							} catch (BLLException e) {
//								e.printStackTrace();
//							}
//						}
		//
//						break;
//					}
					
				}
				request.getRequestDispatcher(page).forward(request, response);	
	}
}
