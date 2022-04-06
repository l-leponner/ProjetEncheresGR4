package fr.eni.encheres.ihm.inscription;

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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurBLL uManager= UtilisateurBLLSing.getInstance();
	private InscriptionModel inscriptionModel = new InscriptionModel();
	
	private String page = "/WEB-INF/inscription.jsp";

    /**
     * Default constructor. 
     */
    public InscriptionServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		request.setAttribute("model", inscriptionModel);
		
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String MDP = request.getParameter("MDP");
		String confirmationMDP = request.getParameter("confirmationMDP");
		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, MDP);
		
		if(MDP.equals(confirmationMDP)) {
			try {
				uManager.inscriptionUtilisateur(utilisateur, confirmationMDP);
			} catch (BLLException e1) {
				request.setAttribute("error", "Mot de passe et confirmation de mot de passe différents svp");
				inscriptionModel.setMessage("Mot de passe et confirmation de mot de passe différents svp");
			}
			inscriptionModel.setCurrent(utilisateur);
			
			session.setAttribute("utilisateurConnecte", utilisateur);
			
		} else {
			request.setAttribute("error", "Mot de passe et confirmation de mot de passe différents svp");
		}
		request.removeAttribute("model");
		page = "/WEB-INF/indexConnecter.jsp";
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
