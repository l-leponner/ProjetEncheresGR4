package fr.eni.encheres.ihm.vente;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletContext;
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
import fr.eni.encheres.bll.retraits.RetraitManager;
import fr.eni.encheres.bll.retraits.RetraitManagerSing;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class VenteServlet
 */
@WebServlet("/VenteServlet")
public class VenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CategoriesManager cManager = CategorieManagerSing.getInstance();
	private static ArticleVenduBLLManager aManager = ArticleVenduBLLSing.getInstance();
	private static UtilisateurBLL uManager = UtilisateurBLLSing.getInstance();
	private static RetraitManager rManager = RetraitManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("utilisateurConnecte");
		VenteModel model = new VenteModel();
		request.setAttribute("model", model);
		try {
			model.setLstCategories(cManager.getALLCategorie());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		Utilisateur utilisateur = utilisateurConnecte;
		model.setCurrentUtilisateur(utilisateur);
		
		if(request.getParameter("BTN_ENREGISTRER") != null) {
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String categorieLibelle = request.getParameter("categorie");
			Categorie categorie = null;
			try {
				categorie = cManager.getByLibelleCategorie(categorieLibelle);
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
			LocalDateTime dateDebut = LocalDateTime.parse(request.getParameter("dateDebut"));
			LocalDateTime dateFin = LocalDateTime.parse(request.getParameter("dateFin"));
			
			Retrait retrait = new Retrait();
			if(request.getParameter("rue").isBlank() && request.getParameter("codePostal").isBlank() && request.getParameter("ville").isBlank()) {
				retrait.setRue(utilisateur.getRue());
				retrait.setCode_postal(utilisateur.getCodePostal());
				retrait.setVille(utilisateur.getVille());
			} else {
				retrait.setRue(request.getParameter("rue"));
				retrait.setCode_postal(request.getParameter("codePostal"));
				retrait.setVille(request.getParameter("ville"));
			}
			
			ArticleVendu article = new ArticleVendu();
			article.setNomArticle(nom);
			article.setDescription(description);
			article.setCategorie(categorie);
			article.setMiseAPrix(miseAPrix);
			article.setDateDebutEncheres(dateDebut);
			article.setDateFinEncheres(dateFin);
			try {
				aManager.controlDateEnchere(dateDebut, dateFin);
			} catch (BLLException e1) {
				request.setAttribute("error", e1.getMessage());
			}
			article.setLieuRetrait(retrait);
			article.setUtilisateur(utilisateur);
			try {
				aManager.addArticleVendu(article);
				rManager.addRetrait(retrait, article);
				
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			model.setCurrentArticle(article);
			
			request.getRequestDispatcher("/WEB-INF/indexConnecter.jsp").forward(request, response);
			
		}
		
		
		
		if(request.getParameter("BTN_ANNULER") != null) {
			request.getRequestDispatcher("/WEB-INF/indexConnecter.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/WEB-INF/vente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
