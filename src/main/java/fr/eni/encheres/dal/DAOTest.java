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
		ArticleVendu article1 = new ArticleVendu("Livre", "Description", LocalDateTime.now(),LocalDateTime.of(1998, 7, 4, 7, 0), 100, "En cours");
		ArticleVendu article2 = new ArticleVendu("BD", "Description", LocalDateTime.now(),LocalDateTime.of(1999, 7, 4, 7, 0), 100, "En cours");
		ArticleVendu article3 = new ArticleVendu("Couteau", "Description", LocalDateTime.now(),LocalDateTime.of(1900, 7, 4, 7, 0), 100, "En cours");
		Retrait retrait1 = new Retrait("256 rue de nantes", "35136", "Rennes");
		Enchere enchere1 = new Enchere(LocalDateTime.now(), 100, article1, utilisateur1);

//		Enchere enchere2 = new Enchere(LocalDateTime.now(), 120, article1, utilisateur1);
//		Enchere enchere3 = new Enchere(LocalDateTime.now(), 150, article1, utilisateur1);

		Enchere enchere2 = new Enchere(LocalDateTime.now(), 120, article1, utilisateur1);
		Enchere enchere3 = new Enchere(LocalDateTime.now(), 150, article1, utilisateur1);
		ArticleVendu article2 = new ArticleVendu("BD", "Description", LocalDateTime.now(),LocalDateTime.of(1999, 7, 4, 7, 0), 100, "En cours");
		ArticleVendu article3 = new ArticleVendu("Couteau", "Description", LocalDateTime.now(),LocalDateTime.of(1900, 7, 4, 7, 0), 100, "En cours");


		// Test d'insertion
		try {
			daoUtilisateur.insertUtilisateur(utilisateur1);

			//daoCategorie.insertCategorie(categorie1);

			article1.setUtilisateur(utilisateur1);
			article1.setCategorie(daoCategorie.selectByIdCategorie(1));

			daoArticleVendu.insertArticleVendu(article1);
			retrait1.setNoArticleVendu(article1.getNoArticle());
			daoArticleVendu.insertArticleVendu(article2);
			retrait1.setNoArticleVendu(article2.getNoArticle());
			daoArticleVendu.insertArticleVendu(article3);
			retrait1.setNoArticleVendu(article3.getNoArticle());

			daoRetrait.insertRetrait(retrait1);
			daoArticleVendu.insertArticleVendu(article2);
			retrait1.setNoArticleVendu(article2.getNoArticle());
			daoArticleVendu.insertArticleVendu(article3);
			retrait1.setNoArticleVendu(article3.getNoArticle());
			enchere1.setUtilisateur(utilisateur1);
			enchere1.setArticleVendu(article1);
			daoEnchere.insertEnchere(enchere1);
//			daoEnchere.insertEnchere(enchere2);
//			daoEnchere.insertEnchere(enchere3);

		} catch (DALException e) {
			throw new DALException("Erreur" + e.getMessage());
		}

		// Test SELECTALL

//		try {
//
//			daoUtilisateur.selectAllUtilisateur().stream().forEach(System.out::println);
//			daoCategorie.selectALLCategorie().stream().forEach(System.out::println);
			daoArticleVendu.selectAllArticleVendu().stream().forEach(System.out::println);
//			daoRetrait.selectALLRetrait().stream().forEach(System.out::println);
//			daoEnchere.selectAllEnchere().stream().forEach(System.out::println);
//
//		} catch (DALException e) {
//			throw new DALException("Erreur : " + e.getMessage());
//		}
//
//		System.out.println("######################");
//
//		// Test update
//
//		utilisateur1.setCodePostal("0");
//		categorie1.setLibelle("LibelleUPDATE");
//		article1.setDescription("DescriptionUPDATE");
//		retrait1.setCode_postal("0");
//		enchere1.setMontantEnchere(120);
//		
//		daoUtilisateur.updateUtilisateur(utilisateur1);
//		daoCategorie.updateCategorie(categorie1);
//		daoArticleVendu.updateArticleVendu(article1);
//		daoRetrait.updateRetrait(retrait1);
//		daoEnchere.updateEnchere(enchere1);
//
//		// Test SELECTALL
//
//		try {
//
//			daoUtilisateur.selectAllUtilisateur().stream().forEach(System.out::println);
//			daoCategorie.selectALLCategorie().stream().forEach(System.out::println);
//			daoArticleVendu.selectAllArticleVendu().stream().forEach(System.out::println);
//			daoRetrait.selectALLRetrait().stream().forEach(System.out::println);
//			daoEnchere.selectAllEnchere().stream().forEach(System.out::println);
//
//		} catch (DALException e) {
//			throw new DALException("Erreur" + e.getMessage());
//		}
		
			// Test SELECTBYID
//			System.out.println(daoUtilisateur.selectByIDUtilisateur(5));
//			System.out.println(daoCategorie.selectByIdCategorie(1));
//			System.out.println(daoArticleVendu.selectByIdArticleVendu(5));
//			System.out.println("selectRetraitByID");
//			System.out.println(daoArticleVendu.selectRetraitByIDArticleVendu(5));
//			System.out.println("selectByIdRetrait");
//			System.out.println(daoRetrait.selectByIdRetrait(2));
//			System.out.println("selectByIDEnchere");
//			System.out.println(daoEnchere.selectByIDEnchere(1));
//			System.out.println("selectAllEncheresByNoArticle");
//			System.out.println(daoEnchere.selectAllEncheresByNoArticle(article1.getNoArticle()));
		
		// Test DELETE
//		daoRetrait.deleteRetrait(retrait1);
//		daoEnchere.deleteEnchere(enchere1);
//		daoArticleVendu.deleteArticleVendu(article1);
//		daoCategorie.deleteCategorie(categorie1);
//		daoUtilisateur.deleteUtilisateur(utilisateur1);
	}

}
