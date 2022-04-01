/**
 * 
 */
package fr.eni.encheres.dal;

import java.time.LocalDateTime;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
import fr.eni.encheres.dal.categories.CategorieDAO;
import fr.eni.encheres.dal.encheres.EnchereDAO;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 31 mars 2022
 */
public class DAOTest {

	private static UtilisateurDAO daoUtilisateur = DAOFactory.getUtilisateurDAO();
	private static CategorieDAO daoCategorie = DAOFactory.getCategorieDAO();
	private static ArticleVenduDAO daoArticleVendu = DAOFactory.getArticleVenduDAO();
	private static RetraitDAO daoRetrait = DAOFactory.getRetraitDAO();
	private static EnchereDAO daoEnchere = DAOFactory.getEnchereDAO();

	public static void main(String[] args) throws DALException {

		Utilisateur utilisateur1 = new Utilisateur("ArthurLegeas", "Legeas", "Arthur", "Legeas.arthur@gmail.com",
				"0685412490", "Rue Robert", "35136", "Rennes", "BillyMDP");
		Categorie categorie1 = new Categorie("LibelleTest");
		ArticleVendu article1 = new ArticleVendu("Livre", "Description", LocalDateTime.now(),
				LocalDateTime.of(1998, 7, 4, 7, 0), 100, "En cours");
		Retrait retrait1 = new Retrait("256 rue de nantes", "35136", "Rennes");
		Enchere enchere1 = new Enchere(LocalDateTime.now(), 100, article1, utilisateur1);

		// Test d'insertion
		try {
			daoUtilisateur.insertUtilisateur(utilisateur1);
			
			daoCategorie.insertCategorie(categorie1);
			
			article1.setUtilisateur(utilisateur1);
			article1.setCategorie(categorie1);
			retrait1.setArticleVendu(article1);
			daoArticleVendu.insertArticleVendu(article1);
			
			daoRetrait.insertRetrait(retrait1);
			
			enchere1.setUtilisateur(utilisateur1);
			enchere1.setArticleVendu(article1);
			daoEnchere.insertEnchere(enchere1);

		} catch (DALException e) {
			throw new DALException("Erreur" + e.getMessage());
		}

		// Test SELECTALL

		try {
			for (Utilisateur utilisateur : daoUtilisateur.selectAllUtilisateur()) {
				System.out.println(utilisateur);
			}
			for (Categorie categorie : daoCategorie.selectALLCategorie()) {
				System.out.println(categorie);
			}
			for (ArticleVendu article : daoArticleVendu.selectAllArticleVendu()) {
				System.out.println(article);
			}
			for (Retrait retrait : daoRetrait.selectALLRetrait()) {
				System.out.println(retrait);
			}
			for (Enchere enchere : daoEnchere.selectAllEnchere()) {
				System.out.println(enchere);
			}

		} catch (DALException e) {
			throw new DALException("Erreur" + e.getMessage());
		}

	}

}