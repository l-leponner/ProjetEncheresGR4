package fr.eni.encheres.ihm.loginServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL uManager = UtilisateurBLLSing.getInstance();
	private LoginModel model = new LoginModel();
	
	String page;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		
		
		page = "/WEB-INF/Login.jsp";
		
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
		
		if(request.getParameter("BT_CONNEXION") != null) {
		
			String identifiant = request.getParameter("identifiant");
			String MDP = request.getParameter("MDP");
			
			try {
				uManager.controlUtilisateurExistant(identifiant, MDP);
				try {
					model.setCurrent(uManager.getByIdentifiantMDP(identifiant, MDP));
				} catch (BLLException e) {
					request.setAttribute("error", e.getMessage());
				}
				session.setAttribute("utilisateurConnecte", model.getCurrent());

				page = "/ConnecterIndex";
				
			} catch (BLLException e) {
				request.setAttribute("error", e.getMessage());
			}
			
		
		//Mot de passe oubli??
//		if(request.getParameter("oubli") != null) {
//			if (!request.getParameter("identifiant").isBlank()) {
//				try {
//					model.setCurrent(manager.getByIdentifiant("identifiant"));
//				} catch (BLLException e) {
//					request.setAttribute("error", e.getMessage());
//				}
//			}
//		}
			
		}
		
		if(request.getParameter("BT_CREER_UN_COMPTE") != null) {
			page = "/InscriptionServlet";
		}
			response.sendRedirect(request.getContextPath() + page);
	}
}
