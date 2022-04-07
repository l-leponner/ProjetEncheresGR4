package fr.eni.encheres.ihm.encherir;

import java.io.IOException;
import java.time.LocalDateTime;

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
import fr.eni.encheres.bll.enchere.EnchereBLL;
import fr.eni.encheres.bll.enchere.EnchereBLLSing;
import fr.eni.encheres.bll.retraits.RetraitManager;
import fr.eni.encheres.bll.retraits.RetraitManagerSing;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/EncherirServlet")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CategoriesManager cManager = CategorieManagerSing.getInstance();
	private static ArticleVenduBLLManager aManager = ArticleVenduBLLSing.getInstance();
	private static UtilisateurBLL uManager = UtilisateurBLLSing.getInstance();
	private static RetraitManager rManager = RetraitManagerSing.getInstance();
	private static EnchereBLL eManager = EnchereBLLSing.getInstance();
	EncherirModel model = new EncherirModel();
	String page;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncherirServlet() {
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

		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("utilisateurConnecte");
		ArticleVendu articleClique = (ArticleVendu) session.getAttribute("articleClique");
		request.setAttribute("model", model);

		model.setAcheteur(utilisateurConnecte);
		model.setCurrentArticle(articleClique);
		model.setVendeur(articleClique.getUtilisateur());

		model.setLstEncheres(articleClique.getLstEncheres());
		
		try {
			model.setMeillereEnchere(aManager.getMeilleureEnchere(articleClique.getLstEncheres()));
		} catch (BLLException e2) {
			request.setAttribute("error", e2.getMessage());
		}

		if(model.getMeillereEnchere() == null) {
			request.setAttribute("meilleureEnchere", model.getCurrentArticle().getMiseAPrix());
		} else {
			request.setAttribute("meilleureEnchere", model.getMeillereEnchere().getMontantEnchere());
		}
		
		page = "/WEB-INF/encherir.jsp";
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();

		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("utilisateurConnecte");
		ArticleVendu articleClique = (ArticleVendu) session.getAttribute("articleClique");
		
		if (request.getParameter("BTN_ENCHERIR") != null) {
			Integer montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));

			Enchere enchere = new Enchere(LocalDateTime.now(), montantEnchere, model.getCurrentArticle(),
					model.getAcheteur());
			try {
				uManager.peutEncherir(utilisateurConnecte.getCredit(), montantEnchere);
				utilisateurConnecte.setCredit(utilisateurConnecte.getCredit() - montantEnchere);
				uManager.updateUtilisateur(utilisateurConnecte);
				try {
					// Tester si doublon
					eManager.addEnchere(enchere);
					articleClique.getLstEncheres().add(enchere);
					aManager.updateArticleVendu(articleClique);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BLLException e1) {
				request.setAttribute("error", e1.getMessage());
			}
			page = "/ConnecterIndex";

		}
		response.sendRedirect(request.getContextPath() + page);
	}

}
