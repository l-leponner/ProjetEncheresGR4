/**
 * 
 */
package fr.eni.encheres.bll.articleVendu;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Enchere;

/**
 * Classe en charge de
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  31 mars 2022 - 13:29:51
 *
 */
public interface ArticleVenduBLLManager {
	
	public void addArticleVendu(ArticleVendu articlevendu) throws BLLException;

	public ArticleVendu getByIdArticleVendu(Integer IDArticleVendu) throws BLLException;

	public List<ArticleVendu> getAllArticleVendu() throws BLLException;
	
	public List<ArticleVendu> getAllArticleFilterNomArticle(String nomArticle) throws BLLException;
	
	public List<ArticleVendu> getAllArticleFilterCategorie(String categorie) throws BLLException;
	
	public List<ArticleVendu> getAllArticleFilterCategorieAndNomArticle(String nomArticle, String categorie) throws BLLException;

	public List<ArticleVendu> getAllArticleFilterNomArticle(String nomArticle, List<ArticleVendu> lstArticleVendus) throws BLLException;
	
	public List<ArticleVendu> getAllArticleFilterCategorie(String categorie, List<ArticleVendu> lstArticleVendus) throws BLLException;
	
	public List<ArticleVendu> getAllArticleFilterCategorieAndNomArticle(String nomArticle, String categorie, List<ArticleVendu> lstArticleVendus) throws BLLException;
	
	public List<ArticleVendu> getAllArticleEncheresOuvertes() throws BLLException;
	
	public List<ArticleVendu> getAllArticleMesEncheres(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleMesEncheresRemportees(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleMesVentesEnCours(Utilisateur user) throws BLLException;

	public List<ArticleVendu> getAllArticleVentesNonDebutees(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleVentesTerminees(Utilisateur user) throws BLLException;
	
	// méthode pour radio Achats
	public List<ArticleVendu> getAllArticleEOuvertesMesEMesERemportees(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleEOuvertesMesE(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleEOuvertesMesERemportees(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleMesEMesERemportees(Utilisateur user) throws BLLException;
	
	// méthode pour radio Mes Ventes
	public List<ArticleVendu> getAllArticleMesVEnCoursVNonDebuteesVTerminees(Utilisateur user) throws BLLException;

	public List<ArticleVendu> getAllArticleMesVEnCoursVNonDebutees(Utilisateur user) throws BLLException;

	public List<ArticleVendu> getAllArticleMesVEnCoursVTerminees(Utilisateur user) throws BLLException;
	
	public List<ArticleVendu> getAllArticleVNonDebuteesVTerminees(Utilisateur user) throws BLLException;
	
	public void autoUpdateEtatArticle() throws BLLException;
	
	public void removeArticleVendu(ArticleVendu articlevendu) throws BLLException;

	public void updateArticleVendu(ArticleVendu articlevendu) throws BLLException;
	
	public void controlDateEnchere (LocalDateTime dateDebut, LocalDateTime dateFin) throws BLLException;
	
	public Enchere getMeilleureEnchere(List<Enchere> lstEnchere) throws BLLException;
	
	public void setLstEncheres (ArticleVendu articlevendu) throws BLLException;

}
