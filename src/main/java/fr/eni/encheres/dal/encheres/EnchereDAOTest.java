/**
 * 
 */
package fr.eni.encheres.dal.encheres;

import java.time.LocalDateTime;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
import fr.eni.encheres.dal.categories.CategorieDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 13:33:47
 *
 */
public class EnchereDAOTest {

	/**
	 * Méthode en charge de 
	 * @param args
	 */
	public static void main(String[] args) {

////		public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEncheres,
////		LocalDateTime dateFinEncheres, Integer miseAPrix, String etatVente, Retrait lieuRetrait,
////		Categorie categorie, Utilisateur utilisateur)
//		EnchereDAO enchDAO = DAOFactory.getEnchereDAO();
//		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
//		ArticleVenduDAO avDAO = DAOFactory.getArticleVenduDAO();
//		CategorieDAO cDAO = DAOFactory.getCategorieDAO();
//		
//		Categorie c1 = new Categorie("");
//		Utilisateur u1 = null;
//		Utilisateur u2 = null;
//		Utilisateur u3 = null;
//		//ArticleVendu av1 = new ArticleVendu("poupee gonflable", "besoin d'une description ?", LocalDateTime.now(), LocalDateTime.now().plusDays(15), 100, "en cours", );
//		ArticleVendu av2 = new ArticleVendu();
//		ArticleVendu av3 = new ArticleVendu();
//		
//
//		// avDAO.insertArticleVendu(av1);
//
//		try {
//			//avDAO.insertArticleVendu(av1);
//			avDAO.insertArticleVendu(av2);
//			avDAO.insertArticleVendu(av3);
//		} catch (DALException e4) {
//			e4.printStackTrace();
//		}
//
//		
//		try {
//			u1 = uDAO.selectByIDUtilisateur(1);
//			u2 = uDAO.selectByIDUtilisateur(2);
//			u3 = uDAO.selectByIDUtilisateur(3);
//			//av1 = avDAO.selectByIdArticleVendu(1);
//			av2 = avDAO.selectByIdArticleVendu(2);
//			av3 = avDAO.selectByIdArticleVendu(3);
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		
//		//Enchere e1 = new Enchere(LocalDateTime.now(), 100, av1, u1);
//		Enchere e2 = new Enchere(LocalDateTime.now(), 200, av2, u2);
//		Enchere e3 = new Enchere(LocalDateTime.now(), 300, av3, u3);
//		
//		try {
//			//enchDAO.insertEnchere(e1);
//			enchDAO.insertEnchere(e2);
//			enchDAO.insertEnchere(e3);
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("selectAllEnchere");
//		try {
//			System.out.println(enchDAO.selectAllEnchere());
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("");
//		System.out.println("-----------------");
//		System.out.println("");
//		
//		System.out.println("selectByIDEnchere");
//		try {
//			System.out.println(enchDAO.selectByIDEnchere(e1.getNoEnchere()));
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("");
//		System.out.println("-----------------");
//		System.out.println("");
//		
//		System.out.println("selectByIDEnchere");
//		e1.setMontantEnchere(120);
//		try {
//			enchDAO.updateEnchere(e1);
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(enchDAO.selectByIDEnchere(e1.getNoEnchere()));
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("");
//		System.out.println("-----------------");
//		System.out.println("");
//		
//		System.out.println("deleteEnchere");
//		try {
//			enchDAO.deleteEnchere(e1);
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//		System.out.println("affichage après suppression de e1");
//		try {
//			System.out.println(enchDAO.selectAllEnchere());
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
	}

}
