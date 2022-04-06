package fr.eni.encheres.ihm.enchereRemporteeAcheteur;

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
import fr.eni.encheres.bll.enchere.EnchereBLL;
import fr.eni.encheres.bll.enchere.EnchereBLLSing;
import fr.eni.encheres.bll.retraits.RetraitManager;
import fr.eni.encheres.bll.retraits.RetraitManagerSing;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.ihm.enchereRemporteeMoi.EnchereRemporteeMoiModel;

/**
 * Servlet implementation class EnchereRemporteeAcheteur
 */
@WebServlet("/EnchereRemporteeAcheteur")
public class EnchereRemporteeAcheteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArticleVenduBLLManager aManager = ArticleVenduBLLSing.getInstance();
	private static UtilisateurBLL uManager = UtilisateurBLLSing.getInstance();
	private static RetraitManager rManager = RetraitManagerSing.getInstance();
	private static EnchereBLL eManager = EnchereBLLSing.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereRemporteeAcheteur() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();

		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("utilisateurConnecte");
		ArticleVendu articleClique = (ArticleVendu) session.getAttribute("articleClique");
		EnchereRemporteeAcheteurModel model = new EnchereRemporteeAcheteurModel();
		request.setAttribute("model", model);
		
		model.setCurrentArticle(articleClique);
		try {
			model.setAcheteur(aManager.getMeilleureEnchere(articleClique.getLstEncheres()).getUtilisateur());
		} catch (BLLException e1) {
			request.setAttribute("error", e1.getMessage());
		}
		try {
			model.setMeillereEnchere(aManager.getMeilleureEnchere(articleClique.getLstEncheres()));
		} catch (BLLException e1) {
			request.setAttribute("error", e1.getMessage());
		}
		
		if(request.getParameter("BTN_RETRAIT") != null) {
			utilisateurConnecte.setCredit(utilisateurConnecte.getCredit() + model.getMeillereEnchere().getMontantEnchere());
			try {
				uManager.updateUtilisateur(utilisateurConnecte);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			articleClique.setEtatVente("Retrait effectué");
			try {
				aManager.updateArticleVendu(articleClique);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/indexConnecter.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/WEB-INF/enchereRemporteeMoi.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
