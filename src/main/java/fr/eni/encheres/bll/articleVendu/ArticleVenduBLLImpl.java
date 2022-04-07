/**
 * 
 */
package fr.eni.encheres.bll.articleVendu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.enchere.EnchereBLL;
import fr.eni.encheres.bll.enchere.EnchereBLLSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
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

			articlevendu.setEtatVente("Créé");
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
			autoUpdateEtatArticle();
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
			autoUpdateEtatArticle();
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
			autoUpdateEtatArticle();
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
			autoUpdateEtatArticle();
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
	public List<ArticleVendu> getAllArticleFilterCategorieAndNomArticle(String nomArticle, String categorie)
			throws BLLException {
		List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
		try {
			autoUpdateEtatArticle();
			if (categorie.equalsIgnoreCase("toutes")) {
				for (ArticleVendu i : dao.selectAllArticleVendu()) {
					if (i.getNomArticle().equalsIgnoreCase(nomArticle)) {
						lstArticleVendus.add(i);
					}
				}
			} else {
				for (ArticleVendu i : dao.selectAllArticleVendu()) {
					if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie)
							&& i.getNomArticle().equalsIgnoreCase(nomArticle)) {
						lstArticleVendus.add(i);
					}
				}
			}

			return lstArticleVendus;
		} catch (DALException e) {
			throw new BLLException(
					"Problème dans la méthode getAllArticleFilterCategorieAndNomArticle" + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 * 
	 * @throws BLLException
	 */
	@Override
	public void controlDateEnchere(LocalDateTime dateDebut, LocalDateTime dateFin) throws BLLException {

		if (dateFin.isBefore(dateDebut)) {
			throw new BLLException("La date de fin de l'enchère doit être postérieure à la date de début !");
		}
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterNomArticle(String nomArticle, List<ArticleVendu> lstArticleVendus)
			throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();
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
		autoUpdateEtatArticle();
		for (ArticleVendu i : lstArticleVendus) {
			if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie)) {
				returnlstArticleVendus.add(i);
			}
		}
		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleFilterCategorieAndNomArticle(String nomArticle, String categorie,
			List<ArticleVendu> lstArticleVendus) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();
		if (categorie.equalsIgnoreCase("toutes")) {
			for (ArticleVendu i : lstArticleVendus) {
				if (i.getNomArticle().equalsIgnoreCase(nomArticle)) {
					returnlstArticleVendus.add(i);
				}
			}
		} else {
			for (ArticleVendu i : lstArticleVendus) {
				if (i.getCategorie().getLibelle().equalsIgnoreCase(categorie)
						&& i.getNomArticle().equalsIgnoreCase(nomArticle)) {
					returnlstArticleVendus.add(i);
				}
			}
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleEncheresOuvertes() throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getEtatVente().equalsIgnoreCase("En cours")) {
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
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur().getNoUtilisateur()
						.equals(user.getNoUtilisateur()) && articleVendu.getEtatVente().equalsIgnoreCase("En cours")) {
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
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées")) {

					if (getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur().getNoUtilisateur()
							.equals(user.getNoUtilisateur())) {

						System.out.println(articleVendu.getLstEncheres());

						returnlstArticleVendus.add(articleVendu);
					}
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleMesEncheresRemportees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	/**
	 * {@inheritedDoc}
	 * 
	 * @throws BLLException
	 */
	@Override
	public Enchere getMeilleureEnchere(List<Enchere> lstEncheres) throws BLLException {
		Enchere result = null;
		if (lstEncheres != null && !lstEncheres.isEmpty()) {
			result = lstEncheres.get(lstEncheres.size() - 1);
		} else {
			throw new BLLException("Il n'y a pas d'enchères pour cette recherche.");
		}

		return result;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesVentesEnCours(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getEtatVente().equalsIgnoreCase("En cours")
						&& articleVendu.getUtilisateur().getNoUtilisateur() == user.getNoUtilisateur()) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleMesVentesEnCours" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleVentesNonDebutees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getEtatVente().equalsIgnoreCase("Créée")
						&& articleVendu.getUtilisateur().getNoUtilisateur().equals(user.getNoUtilisateur())) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleVentesNonDebutees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleVentesTerminees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {
				if (articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées")
						&& articleVendu.getUtilisateur().getNoUtilisateur().equals(user.getNoUtilisateur())) {
					returnlstArticleVendus.add(articleVendu);
					articleVendu.setEtatVente("Enchères terminées");
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleVentesTerminees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	// Méthode utiliser dans IndexServlet pour radio Achats checked et all checkbox
	// checked
	@Override
	public List<ArticleVendu> getAllArticleEOuvertesMesEMesERemportees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testMesE = getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur()
						.getNoUtilisateur().equals(user.getNoUtilisateur());

				Boolean testEOuvertes = articleVendu.getEtatVente().equalsIgnoreCase("En cours");

				Boolean testMesERemportees = (getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur()
						.getNoUtilisateur().equals(user.getNoUtilisateur())
						&& articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées"));

				if (testMesE || testEOuvertes || testMesERemportees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException(
					"Problème dans la méthode getAllArticleEOuvertesMesEMesERemportees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleEOuvertesMesE(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testMesE = getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur()
						.getNoUtilisateur().equals(user.getNoUtilisateur());

				Boolean testEOuvertes = articleVendu.getEtatVente().equalsIgnoreCase("En cours");

				if (testMesE || testEOuvertes) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleEOuvertesMesE" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesEMesERemportees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testMesE = getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur()
						.getNoUtilisateur().equals(user.getNoUtilisateur());

				Boolean testMesERemportees = (getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur()
						.getNoUtilisateur().equals(user.getNoUtilisateur())
						&& articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées"));

				if (testMesE || testMesERemportees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleEOuvertesMesE" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleEOuvertesMesERemportees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testEOuvertes = articleVendu.getEtatVente().equalsIgnoreCase("En cours");

				Boolean testMesERemportees = (getMeilleureEnchere(articleVendu.getLstEncheres()).getUtilisateur()
						.getNoUtilisateur().equals(user.getNoUtilisateur())
						&& articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées"));

				if (testEOuvertes || testMesERemportees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleEOuvertesMesERemportees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesVEnCoursVNonDebuteesVTerminees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testMesVEnCours = articleVendu.getUtilisateur().getNoUtilisateur()
						.equals(user.getNoUtilisateur()) && articleVendu.getEtatVente().equalsIgnoreCase("En cours");

				Boolean VNonDebutees = articleVendu.getEtatVente().equalsIgnoreCase("Créée");

				Boolean testVTerminees = articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées");

				if (testMesVEnCours || VNonDebutees || testVTerminees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException(
					"Problème dans la méthode getAllArticleMesVEnCoursVNonDebuteesVTerminees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesVEnCoursVNonDebutees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testMesVEnCours = articleVendu.getUtilisateur().getNoUtilisateur()
						.equals(user.getNoUtilisateur()) && articleVendu.getEtatVente().equalsIgnoreCase("En cours");

				Boolean VNonDebutees = articleVendu.getEtatVente().equalsIgnoreCase("Créée");

				if (testMesVEnCours || VNonDebutees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleMesVEnCoursVNonDebutees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleMesVEnCoursVTerminees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean testMesVEnCours = articleVendu.getUtilisateur().getNoUtilisateur()
						.equals(user.getNoUtilisateur()) && articleVendu.getEtatVente().equalsIgnoreCase("En cours");

				Boolean testVTerminees = articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées");

				if (testMesVEnCours || testVTerminees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleMesVEnCoursVTerminees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public List<ArticleVendu> getAllArticleVNonDebuteesVTerminees(Utilisateur user) throws BLLException {
		List<ArticleVendu> returnlstArticleVendus = new ArrayList<ArticleVendu>();
		autoUpdateEtatArticle();

		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				Boolean VNonDebutees = articleVendu.getEtatVente().equalsIgnoreCase("Créée");

				Boolean testVTerminees = articleVendu.getEtatVente().equalsIgnoreCase("Enchères terminées");

				if (VNonDebutees || testVTerminees) {
					returnlstArticleVendus.add(articleVendu);
				}
			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllArticleVNonDebuteesVTerminees" + e.getMessage());
		}

		return returnlstArticleVendus;
	}

	@Override
	public void autoUpdateEtatArticle() throws BLLException {
		try {
			for (ArticleVendu articleVendu : dao.selectAllArticleVendu()) {

				if (LocalDateTime.now().isAfter(articleVendu.getDateDebutEncheres())) {
					articleVendu.setEtatVente("En cours");
				}

				if (LocalDateTime.now().isAfter(articleVendu.getDateFinEncheres())) {
					articleVendu.setEtatVente("Enchères terminées");
				}

			}
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode autoUpdateEtatArticle" + e.getMessage());
		}

	}

	@Override
	public void setLstEncheres(ArticleVendu articlevendu) throws BLLException {
		EnchereBLL managerE = EnchereBLLSing.getInstance();
		List<Enchere> lstEncheres = new ArrayList<Enchere>();

		for (ArticleVendu a : getAllArticleVendu()) {
			for (Enchere e : managerE.getAllEnchere()) {
				if (e.getArticleVendu().getNoArticle().equals(a.getNoArticle())) {
					lstEncheres.add(e);
				}
				a.setLstEncheres(lstEncheres);
			}
		}

	}
}
