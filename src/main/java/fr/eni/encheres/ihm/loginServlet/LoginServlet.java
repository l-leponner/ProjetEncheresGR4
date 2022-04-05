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
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL manager = UtilisateurBLLSing.getInstance();

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
		
		LoginModel model = new LoginModel();
	
	
	
	if (request.getParameter("BT_CONNEXION") != null){
		
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		
		try { manager.controlUtilisateurExistant (identifiant, motDePasse);
		
	
		
		Utilisateur utilisateur = null;
		try {
			utilisateur = manager.getByIdentifiantMDP((String) session.getAttribute("pseudo"), (String) session.getAttribute("email"));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		
		if(request.getParameter("BT_CONNEXION") != null) {
			 identifiant = request.getParameter("identifiant");
			String MDP = request.getParameter("MDP");
			
			try {
				manager.controlUtilisateurExistant(identifiant, MDP);
				model.setCurrent(manager.getByIdentifiantMDP(identifiant, MDP));
				session.setAttribute("utilisateurConnecte", model.getCurrent());
				request.getRequestDispatcher("/WEB-INF/indexConnecter.jsp").forward(request, response);
			} catch (BLLException e) {
				request.setAttribute("error", e.getMessage());
			}
			
		}
		//Mot de passe oublié
//		if(request.getParameter("oubli") != null) {
//			if (!request.getParameter("identifiant").isBlank()) {
//				try {
//					model.setCurrent(manager.getByIdentifiant("identifiant"));
//				} catch (BLLException e) {
//					request.setAttribute("error", e.getMessage());
//				}
//			}
//		}
		if(request.getParameter("BT_CREER_UN_COMPTE") != null) {
			request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}
	}
		
		
		request.setAttribute("model", model);

		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		
	}
//		//appelle methode pour loginer
//		
//		if (request.getParameter("BT_CONNEXION") != null){
//			
//			String identifiant = request.getParameter("identifiant");
//			String mDP = request.getParameter("motDePasse");
//			
//			try { manager.connexionUtilisateur (identifiant, mDP);
//			
//			if (connecte = true) {	
//			try {
//				 request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//			} catch (BLLException e) {
//				model.setMessage("Erreur dans le login : " + e.getMessage());
//			
//			}
//						
//			else {
//				try {
//					System.out.println("Username or Password incorrect");
//				  request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
//				} catch (BLLException e) {
//					model.setMessage("Erreur dans le login : " + e.getMessage());
//				}
//		
//			
//		request.setAttribute("model", model);
//
//		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
//	
//			}
//			}
//	}

//		public static Boolean ConnexionUtilisateur (String identifiant, String motDePasse) throw BLLException {
//			bolean connecte = false;
//		for (Utilisateur utilisateur : manager.getAllUtilisateur()) {
//			if(identifiant.equals((utilisateur.getEmail()) || (identifiant.equals(utilisateur.getPseudo())) && (mDP.equals(utilisateur.getMotDePasse())) { 
//			return connecte = true;	}
//		try {
//			 request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//		} catch (BLLException e) {
//			model.setMessage("Erreur dans le login : " + e.getMessage());
//		}	
//					
//		else {
//			try {
//				System.out.println("Username or Password incorrect");
//			  request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
//			} catch (BLLException e) {
//				model.setMessage("Erreur dans le login : " + e.getMessage());
//			}
//		}}}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
