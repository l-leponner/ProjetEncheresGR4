package fr.eni.encheres.ihm.UtilisateurServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurDeconnecteServlet
 */
@WebServlet("/UtilisateurDeconnecteServlet")
public class UtilisateurDeconnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurDeconnecteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		ServletContext context = request.getServletContext();
		
		Utilisateur utilisateur = new Utilisateur();
		

		UtilisateurModel model = new UtilisateurModel();
	
		model.setCurrent(utilisateur);	
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/UtilisateurDeconnecte.jsp").forward(request, response);
		
	
	
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
