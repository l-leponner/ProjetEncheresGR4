/**
 * 
 */
package fr.eni.encheres.bll.articleVendu;



/**
 * Classe en charge de
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  31 mars 2022 - 13:59:17
 *
 */
public class ArticleVenduBLLSing {

private static ArticleVenduBLLManager instance;
	
	public static ArticleVenduBLLManager getInstance() {
		if(instance == null) {
			instance = new ArticleVenduBLLImpl();
		}
		return instance;
	}
	
}
