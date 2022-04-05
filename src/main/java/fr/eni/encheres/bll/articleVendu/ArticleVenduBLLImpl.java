/**
 * 
 */
package fr.eni.encheres.bll.articleVendu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
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
			if (categorie.equalsIgnoreCase("toutes")) {
				for (ArticleVendu i : dao.selectAllArticleVendu()) {
					if (i.getNomArticle().equalsIgnoreCase(nomArticle)) {
						lstArticleVendus.add(i);
					}
				}
			}else {
				for (ArticleVendu i : dao.selectAllArticleVendu()) {
					if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie) && i.getNomArticle().equalsIgnoreCase(nomArticle)) {
						lstArticleVendus.add(i);
					}
				}
			}
			
			return lstArticleVendus;
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleFilterCategorieAndNomArticle" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void controlDateEnchere(LocalDateTime dateDebut, LocalDateTime dateFin) throws BLLException {

		if(dateFin.isBefore(dateDebut)) {
			throw new BLLException("La date de fin de l'enchère doit être postérieure à la date de début !");
		}
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterNomArticle(String nomArticle, List<ArticleVendu> lstArticleVendus) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		for (ArticleVendu i : lstArticleVendus) {
			if (i.getNomArticle().equalsIgnoreCase(nomArticle)) {
				returnlstArticleVendus.add(i);
			}
		}
		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterCategorie(String categorie, List<ArticleVendu> lstArticleVendus)
			throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		for (ArticleVendu i : lstArticleVendus) {
			if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie)) {
				returnlstArticleVendus.add(i);
			}
		}
		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterCategorieAndNomArticle(String nomArticle, String categorie,List<ArticleVendu> lstArticleVendus) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		if (categorie.equalsIgnoreCase("toutes")) {
			for (ArticleVendu i : lstArticleVendus) {
				if (i.getNomArticle().equalsIgnoreCase(nomArticle)) {
					returnlstArticleVendus.add(i);
				}
			}
		}else {
			for (ArticleVendu i : lstArticleVendus) {
				if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie) && i.getNomArticle().equalsIgnoreCase(nomArticle)) {
					returnlstArticleVendus.add(i);
				}
			}
		}
		
		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleEncheresOuvertes() throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		
		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getDateDebutEncheres().isBefore(articleVendu.getDateFinEncheres())) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleEncheresOuvertes" + e.getMessage());
		}
		
		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesEncheres(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		
		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getUtilisateur().getNoUtilisateur().equals(user.getNoUtilisateur())) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleMesEncheres" + e.getMessage());
		}
		
		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesEncheresRemportees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		
		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getUtilisateur().getNoUtilisateur() == user.getNoUtilisateur() && articleVendu.getDateDebutEncheres().isAfter(articleVendu.getDateFinEncheres())) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleMesEncheresRemportees" + e.getMessage());
		}
		
		return returnlstArticleVendus;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public Enchere getMeilleureEnchere(List<Enchere> lstEncheres) {
		Enchere result = lstEncheres.get(lstEncheres.size() -1);
		
		return result;
	}
}


