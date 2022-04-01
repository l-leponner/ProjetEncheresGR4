package fr.eni.encheres.ihm.loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginModel model = new LoginModel();
		
	
		request.setAttribute("model", model);

		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		;
		
	
		String email = request.getParameter("email");
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		
//		for (Utilisateur utilisateur : manager.getAllUtilisateur) {
//		if(email.equals((utilisateur.email) || pseudo.equals(utilisateur.pseudo) && motDePasse.equals(utilisateur.motDePasse) {
//		}
//		else {
//			  println("Username or Password incorrect");
//			  request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
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
