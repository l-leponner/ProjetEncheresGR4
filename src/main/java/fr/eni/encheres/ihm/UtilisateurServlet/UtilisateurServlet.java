package fr.eni.encheres.ihm.UtilisateurServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.utilisateur.UtilisateurBLL;
import fr.eni.encheres.bll.utilisateur.UtilisateurBLLSing;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL manager = UtilisateurBLLSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (User == log) {
		UtilisateurModel model = new UtilisateurModel();
		if (request.getParameter("BT_MODIFIER")!=null) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo(request.getParameter("pseudo")); 
			utilisateur.setNom(request.getParameter("nom")); 
			utilisateur.setPrenom(request.getParameter("prenom")); 
			utilisateur.setEmail(request.getParameter("email")); 
			utilisateur.setTelephone(request.getParameter("telephone")); 
			utilisateur.setRue(request.getParameter("rue")); 
			utilisateur.setCodePostal(request.getParameter("codePostal")); 
			utilisateur.setVille(request.getParameter("ville")); 
		
			model.setCurrent(utilisateur);
			
		}
		model.setCurrent(manager.updateUtilisateur());
		}
		else {
		
			
		}
		
		request.setAttribute("model", model);

		request.getRequestDispatcher("/WEB-INF/Utilisateur.jsp").forward(request, response);
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
