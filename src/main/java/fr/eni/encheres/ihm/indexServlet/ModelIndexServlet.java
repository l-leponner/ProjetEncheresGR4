/**
 * 
 */
package fr.eni.encheres.ihm.indexServlet;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.categories.CategorieManagerSing;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 1 avr. 2022
 */
public class ModelIndexServlet {

	private String message;
	private Utilisateur currentUser;
	private Utilisateur userVendeur;
	private ArticleVendu filterArticle;
	private Categorie filtreCategorie;
	private List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
	private List<Categorie> lstCategories = new ArrayList<Categorie>();
	
	public ModelIndexServlet() {
		super();
	}

	public ModelIndexServlet(String message, Utilisateur currentUser, Utilisateur userVendeur,
			ArticleVendu filterArticle, Categorie filtreCategorie, List<ArticleVendu> lstArticleVendus,
			List<Categorie> lstCategories) {
		super();
		this.message = message;
		this.currentUser = currentUser;
		this.userVendeur = userVendeur;
		this.filterArticle = filterArticle;
		this.filtreCategorie = filtreCategorie;
		this.lstArticleVendus = lstArticleVendus;
		this.lstCategories = lstCategories;
	}

	/**
	 * Getter pour message
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter pour message
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter pour currentUser
	 * 
	 * @return the currentUser
	 */
	public Utilisateur getCurrentUser() {
		return currentUser;
	}

	/**
	 * Setter pour currentUser
	 * 
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Utilisateur currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * Getter pour userVendeur
	 * 
	 * @return the userVendeur
	 */
	public Utilisateur getUserVendeur() {
		return userVendeur;
	}

	/**
	 * Setter pour userVendeur
	 * 
	 * @param userVendeur the userVendeur to set
	 */
	public void setUserVendeur(Utilisateur userVendeur) {
		this.userVendeur = userVendeur;
	}

	/**
	 * Getter pour filterArticle
	 * 
	 * @return the filterArticle
	 */
	public ArticleVendu getFilterArticle() {
		return filterArticle;
	}

	/**
	 * Setter pour filterArticle
	 * 
	 * @param filterArticle the filterArticle to set
	 */
	public void setFilterArticle(ArticleVendu filterArticle) {
		this.filterArticle = filterArticle;
	}

	/**
	 * Getter pour filtreCategorie
	 * 
	 * @return the filtreCategorie
	 */
	public Categorie getFiltreCategorie() {
		return filtreCategorie;
	}

	/**
	 * Setter pour filtreCategorie
	 * 
	 * @param filtreCategorie the filtreCategorie to set
	 */
	public void setFiltreCategorie(Categorie filtreCategorie) {
		this.filtreCategorie = filtreCategorie;
	}

	/**
	 * Getter pour lstArticleVendus
	 * 
	 * @return the lstArticleVendus
	 */
	public List<ArticleVendu> getLstArticleVendus() {
		return lstArticleVendus;
	}

	/**
	 * Setter pour lstArticleVendus
	 * 
	 * @param lstArticleVendus the lstArticleVendus to set
	 */
	public void setLstArticleVendus(List<ArticleVendu> lstArticleVendus) {
		this.lstArticleVendus = lstArticleVendus;
	}

	/**
	 * Getter pour lstCategories
	 * 
	 * @return the lstCategories
	 * @throws BLLException 
	 */
	public List<Categorie> getLstCategories() throws BLLException {
		return lstCategories;
	}

	/**
	 * Setter pour lstCategories
	 * 
	 * @param lstCategories the lstCategories to set
	 */
	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModelIndexServlet [");
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		if (currentUser != null) {
			builder.append("currentUser=");
			builder.append(currentUser);
			builder.append(", ");
		}
		if (userVendeur != null) {
			builder.append("userVendeur=");
			builder.append(userVendeur);
			builder.append(", ");
		}
		if (filterArticle != null) {
			builder.append("filterArticle=");
			builder.append(filterArticle);
			builder.append(", ");
		}
		if (filtreCategorie != null) {
			builder.append("filtreCategorie=");
			builder.append(filtreCategorie);
			builder.append(", ");
		}
		if (lstArticleVendus != null) {
			builder.append("lstArticleVendus=");
			builder.append(lstArticleVendus);
			builder.append(", ");
		}
		if (lstCategories != null) {
			builder.append("lstCategories=");
			builder.append(lstCategories);
		}
		builder.append("]");
		return builder.toString();
	}

}
