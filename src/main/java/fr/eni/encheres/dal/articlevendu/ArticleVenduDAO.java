/**
 * 
 */
package fr.eni.encheres.dal.articlevendu;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

/**
 * Classe en charge de
 * 
 * @author ggastine2022
 * @date 29 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since 29 mars 2022 - 14:02:18
 *
 */
public interface ArticleVenduDAO {

	public void insertArticleVendu(ArticleVendu articlevendu) throws DALException;

	public void selectByIdArticleVendu(Integer IDArticleVendu) throws DALException;

	public List<ArticleVendu> selectAllArticleVendu() throws DALException;

	public void deleteArticleVendu(ArticleVendu articlevendu) throws DALException;

	public void updateArticleVendu(ArticleVendu articlevendu) throws DALException;

}
