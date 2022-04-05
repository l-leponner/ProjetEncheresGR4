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
		
		InscriptionModel model = new InscriptionModel();
		
		String sessionPseudo = (String) session.getAttribute("pseudo");
		String sessionEmail = (String) session.getAttribute("email");
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		
		model.setCurrent(utilisateur);
		session.setAttribute("credit", utilisateur.getCredit());
		
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
			
			utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, nouveauMDP);
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
			session.setAttribute("current", utilisateur);
			// Retour sur index
//			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			
			
		}
		if(request.getParameter("BTN_SUPPRIMER") != null){
			
			
			try {
				uManager.removeUtilisateur(utilisateur);
				// Retour sur index
//				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		request.getRequestDispatcher("/WEB-INF/modificationProfil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
