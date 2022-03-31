/**
 * 
 */
package fr.eni.encheres.dal.articlevendu;

import java.time.LocalDateTime;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;


/**
 * Classe en charge de
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  31 mars 2022 - 09:13:39
 *
 */
public class ArticleVenduDAOTest {
	
	private static ArticleVenduDAO dao = DAOFactory.getArticleVenduDAO();


	public static void main(String[] args) throws DALException {
		dao.insertArticleVendu(new ArticleVendu("beau tapis persan","couleur rose",(LocalDateTime.of(2022, 12, 15, 16, 30)), (LocalDateTime.of(2022, 12, 15, 16, 30)), 400, "en vente"));
		
		dao.selectAllArticleVendu().forEach(System.out::println);
	}

}
