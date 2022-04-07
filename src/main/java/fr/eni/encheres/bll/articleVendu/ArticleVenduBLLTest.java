/**
 * 
 */
package fr.eni.encheres.bll.articleVendu;

import java.time.LocalDateTime;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.enchere.EnchereBLL;
import fr.eni.encheres.bll.enchere.EnchereBLLSing;
import fr.eni.encheres.bo.ArticleVendu;

/**
 * Classe en charge de
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  31 mars 2022 - 14:45:25
 *
 */
public class ArticleVenduBLLTest {
	private static ArticleVenduBLLManager managerA = ArticleVenduBLLSing.getInstance();
	private static EnchereBLL managerE = EnchereBLLSing.getInstance();
	

	/**
	 * @param args
	 * @throws BLLException
	 */
	public static void main(String[] args) throws BLLException {

//		ArticleVendu art1 = new ArticleVendu("Test", "Test",(LocalDateTime.of(2022, 12, 15, 16, 30)), (LocalDateTime.of(2022, 12, 15, 16, 30)), 400, "en vente");
//		ArticleVendu art2 = new ArticleVendu("Test2", "Test2",(LocalDateTime.of(2022, 12, 15, 16, 30)), (LocalDateTime.of(2022, 12, 15, 16, 30)), 400, "en vente");
//	
//
//		// Add
//		try {
//			manager.addArticleVendu(art1);
//			manager.addArticleVendu(art2);
//		} catch (BLLException e) {
//			throw new BLLException("Erreur :" + e.getMessage());
//		}
//
//		System.out.println("############");
//
//		// Update
//		art1.setNomArticle("Test3");
//		manager.updateArticleVendu(art1);
//		System.out.println(art1);
//
//		System.out.println("############");
//
//		// GetByID
//		System.out.println("Get ID");
//		System.out.println(manager.getByIdArticleVendu(art1.getNoArticle()));
//
//		System.out.println("############");
//
//		// Delete
//		manager.removeArticleVendu(art2);
//
//		// GetALL
//		try {
//			for (ArticleVendu string : manager.getAllArticleVendu()) {
//				System.out.println(string);
//			}
//
//		} catch (BLLException e) {
//			throw new BLLException("Erreur :" + e.getMessage());
//		}
		
		System.out.println(managerA.getByIdArticleVendu(29));
		
		System.out.println("##########");
		
		System.out.println(managerA.getByIdArticleVendu(29).getLstEncheres());
		
		System.out.println("##########");
		
		System.out.println(managerA.getMeilleureEnchere(managerA.getByIdArticleVendu(29).getLstEncheres()));

	}

}
