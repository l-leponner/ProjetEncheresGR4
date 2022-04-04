package fr.eni.encheres.ihm.UtilisateurServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
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

		UtilisateurModel model = new UtilisateurModel();
		if (request.getParameter("BT_MODIFIER") == null) {
				try {
					model.setCurrent(manager.getByIDUtilisateur((Integer) request.getSession().getAttribute("idUtilsateur")));
				} catch (BLLException e) {
					model.setMessage("Erreur dans l'affichage utilisateur: " + e.getMessage());
				}

			request.setAttribute("model", model);

			request.getRequestDispatcher("/WEB-INF/Utilisateur.jsp").forward(request, response);
		}

		else {
			request.getRequestDispatcher("/WEB-INF/Utilisateur.jsp").forward(request, response);

		}
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
