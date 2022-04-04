/**
 * 
 */
package fr.eni.encheres.bll.articleVendu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;

/**
 * Classe en charge de
 * 
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since 31 mars 2022 - 13:36:53
 *
 */
public class ArticleVenduBLLImpl implements ArticleVenduBLLManager {
	private ArticleVenduDAO dao = DAOFactory.getArticleVenduDAO();

	/**
	 * {@inheritedDoc}
	 * 
	 * @throws BLLException
	 */
	@Override
	public void addArticleVendu(ArticleVendu articlevendu) throws BLLException {
		try {
			articlevendu.setEtatVente("En cours");
			dao.insertArticleVendu(articlevendu);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode addArticleVendu" + e.getMessage());
		}

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public ArticleVendu getByIdArticleVendu(Integer IDArticleVendu) throws BLLException {
		try {
			return dao.selectByIdArticleVendu(IDArticleVendu);

		} catch (DALException e) {

			throw new BLLException("Problème dans la méthode getByIdArticleVendu" + e.getMessage());
		}

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<ArticleVendu> getAllArticleVendu() throws BLLException {

		try {
			return dao.selectAllArticleVendu();

		} catch (DALException e) {

			throw new BLLException("Problème dans la méthode getAllArticleVendu" + e.getMessage());
		}

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void removeArticleVendu(ArticleVendu articlevendu) throws BLLException {

		try {
			dao.deleteArticleVendu(articlevendu);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode removeArticleVendu" + e.getMessage());
		}

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void updateArticleVendu(ArticleVendu articlevendu) throws BLLException {

		try {
			dao.updateArticleVendu(articlevendu);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode updateArticleVendu" + e.getMessage());
		}

	}

	@Override
	public List<ArticleVendu> getAllArticleFilterNomArticle(String nomArticle) throws BLLException {
		List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
		try {
			for (ArticleVendu i : dao.selectAllArticleVendu()) {
				if (i.getNomArticle().equalsIgnoreCase(nomArticle)) {
					lstArticleVendus.add(i);
				}
			}
			return lstArticleVendus;
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleFilterNomArticle" + e.getMessage());
		}
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterCategorie(String categorie) throws BLLException {
		List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
		try {
			for (ArticleVendu i : dao.selectAllArticleVendu()) {
				if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie)) {
					lstArticleVendus.add(i);
				}
			}
			return lstArticleVendus;
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleFilterCategorie" + e.getMessage());
		}
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterCategorieAndNomArticle(String nomArticle, String categorie) throws BLLException {
		List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
		try {
			for (ArticleVendu i : dao.selectAllArticleVendu()) {
				if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie) && i.getNomArticle().equalsIgnoreCase(nomArticle)) {
					lstArticleVendus.add(i);
				}
			}
			return lstArticleVendus;
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleFilterCategorieAndNomArticle" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public void controlDateEnchere(LocalDateTime dateDebut, LocalDateTime dateFin) {

		//if(dateFin.) {
			
		}
	}

}
