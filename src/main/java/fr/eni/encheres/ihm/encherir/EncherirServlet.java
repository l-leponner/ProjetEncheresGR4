package fr.eni.encheres.ihm.encherir;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLManager;
import fr.eni.encheres.bll.articleVendu.ArticleVenduBLLSing;
import fr.eni.encheres.bll.categories.CategorieManagerSing;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bll.retraits.RetraitManager;
import fr.eni.encheres.bll.retraits.RetraitManagerSing;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncherirServlet() {
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
		EncherirModel model = new EncherirModel();
		request.setAttribute("model", model);
		
		model.setAcheteur(utilisateurConnecte);
		model.setCurrentArticle(articleClique);
		model.setVendeur(articleClique.getUtilisateur());
		model.setLstEncheres(articleClique.getLstEncheres());
		model.setMeillereEnchere(aManager.getMeilleureEnchere(articleClique.getLstEncheres()));
		
		request.setAttribute("meilleureEnchere", model.getMeillereEnchere());
		
		if(request.getParameter("BTN_ENCHERIR") != null) {
			Integer montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
