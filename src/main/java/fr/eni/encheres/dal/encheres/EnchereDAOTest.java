/**
 * 
 */
package fr.eni.encheres.dal.encheres;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
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

		EnchereDAO enchDAO = DAOFactory.getEnchereDAO();
		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
		ArticleVenduDAO avDAO = DAOFactory.getArticleVenduDAO();
		
		Utilisateur u1 = uDAO.selectByIDUtilisateur(1);
		Utilisateur u2 = uDAO.selectByIDUtilisateur(2);
		Utilisateur u3 = uDAO.selectByIDUtilisateur(3);
		ArticleVendu av1 = avDAO.selectByIdArticleVendu(1);
		ArticleVendu av2 = avDAO.selectByIdArticleVendu(2);
		ArticleVendu av3 = avDAO.selectByIdArticleVendu(3);
		
		Enchere e1 = new Enchere(LocalDateTime.now(), 100, av1, u1);
		Enchere e2 = new Enchere(LocalDateTime.now(), 200, av2, u2);
		Enchere e3 = new Enchere(LocalDateTime.now(), 300, av3, u3);
		
		enchDAO.insertEnchere(e1);
		
		System.out.println("selectAllEnchere");
		System.out.println(enchDAO.selectAllEnchere());
		
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		
		System.out.println("selectByIDEnchere");
		System.out.println(enchDAO.selectByIDEnchere(e1.getNoEnchere()));
		
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		
		System.out.println("selectByIDEnchere");
		e1.setMontantEnchere(120);
		enchDAO.updateEnchere(e1);
		System.out.println(enchDAO.selectByIDEnchere(e1.getNoEnchere()));
		
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		
		System.out.println("deleteEnchere");
		enchDAO.deleteEnchere(e1);
		System.out.println("affichage après suppression de e1");
		System.out.println(enchDAO.selectAllEnchere());
	}

}
