package fr.eni.encheres.ihm.modificationProfil;

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
import fr.eni.encheres.ihm.inscription.InscriptionModel;

/**
 * Servlet implementation class ModificationProfilServlet
 */
@WebServlet("/ModificationProfilServlet")
public class ModificationProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurBLL uManager= UtilisateurBLLSing.getInstance();
	ModificationProfilModel model = new ModificationProfilModel();
	String page;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationProfilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		request.setAttribute("model", model);
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		
		model.setCurrent(utilisateur);
		
		page = "/WEB-INF/modificationProfil.jsp";
		
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		
		if(request.getParameter("BTN_ENREGISTRER") != null) {
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String actuelMDP = request.getParameter("actuelMDP");
			String nouveauMDP = request.getParameter("nouveauMDP");
			String confirmationMDP = request.getParameter("confirmationMDP");
			
			try{
				uManager.controlNouveauMDP(actuelMDP, nouveauMDP);
			} catch (BLLException e1) {
				request.setAttribute("error", e1.getMessage());
			}
			
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(nouveauMDP);
			try {
				uManager.controlMDP(nouveauMDP, confirmationMDP);
				
			} catch (BLLException e1) {
				request.setAttribute("error", "Mot de passe et confirmation de mot de passe différents svp");
				model.setMessage("Mot de passe et confirmation de mot de passe différents svp");
			}
			model.setCurrent(utilisateur);
			try {
				uManager.updateUtilisateur(utilisateur);
			} catch (BLLException e) {
				request.setAttribute("error", e.getMessage());
			}
			session.setAttribute("utilisateurConnecte", utilisateur);
			// Retour sur index
			page = "/ConnecterIndex";
			
		}
		if(request.getParameter("BTN_SUPPRIMER") != null){
			
			try {
				uManager.removeUtilisateur(utilisateur);
				
				// Retour sur index
				
			} catch (BLLException e) {
				request.setAttribute("error", e.getMessage());
			}
			page = "/DeConnecterIndex";
		}
		response.sendRedirect(request.getContextPath() + page);
	}

}
