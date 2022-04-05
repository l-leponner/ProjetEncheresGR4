/**
 * 
 */
package fr.eni.encheres.ihm.indexServlet;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 4 avr. 2022
 */
public class ConnecterIndexModel {

	private String message;
	private String filterArticle;
	private String filtreCategorie;
	private String filtreRadio;
	private String filtreCheckbox;
	private Utilisateur currentUser;
	private Utilisateur vendeur;
	private List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
	private List<Categorie> lstCategories = new ArrayList<Categorie>();

	public ConnecterIndexModel() {
		super();
	}

	public ConnecterIndexModel(String message, String filterArticle, String filtreCategorie, String filtreRadio,
			String filtreCheckbox, Utilisateur currentUser, Utilisateur vendeur, List<ArticleVendu> lstArticleVendus,
			List<Categorie> lstCategories) {
		super();
		this.message = message;
		this.filterArticle = filterArticle;
		this.filtreCategorie = filtreCategorie;
		this.filtreRadio = filtreRadio;
		this.filtreCheckbox = filtreCheckbox;
		this.currentUser = currentUser;
		this.vendeur = vendeur;
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
	 * Getter pour filterArticle
	 * 
	 * @return the filterArticle
	 */
	public String getFilterArticle() {
		return filterArticle;
	}

	/**
	 * Setter pour filterArticle
	 * 
	 * @param filterArticle the filterArticle to set
	 */
	public void setFilterArticle(String filterArticle) {
		this.filterArticle = filterArticle;
	}

	/**
	 * Getter pour filtreCategorie
	 * 
	 * @return the filtreCategorie
	 */
	public String getFiltreCategorie() {
		return filtreCategorie;
	}

	/**
	 * Setter pour filtreCategorie
	 * 
	 * @param filtreCategorie the filtreCategorie to set
	 */
	public void setFiltreCategorie(String filtreCategorie) {
		this.filtreCategorie = filtreCategorie;
	}

	/**
	 * Getter pour filtreRadio
	 * 
	 * @return the filtreRadio
	 */
	public String getFiltreRadio() {
		return filtreRadio;
	}

	/**
	 * Setter pour filtreRadio
	 * 
	 * @param filtreRadio the filtreRadio to set
	 */
	public void setFiltreRadio(String filtreRadio) {
		this.filtreRadio = filtreRadio;
	}

	/**
	 * Getter pour filtreCheckbox
	 * 
	 * @return the filtreCheckbox
	 */
	public String getFiltreCheckbox() {
		return filtreCheckbox;
	}

	/**
	 * Setter pour filtreCheckbox
	 * 
	 * @param filtreCheckbox the filtreCheckbox to set
	 */
	public void setFiltreCheckbox(String filtreCheckbox) {
		this.filtreCheckbox = filtreCheckbox;
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
	 * Getter pour vendeur
	 * 
	 * @return the vendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}

	/**
	 * Setter pour vendeur
	 * 
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
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
	 */
	public List<Categorie> getLstCategories() {
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
		builder.append("ConnecterIndexModel [");
		if (message != null) {
			builder.append("message=");
			builder.append(message);
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
		if (filtreRadio != null) {
			builder.append("filtreRadio=");
			builder.append(filtreRadio);
			builder.append(", ");
		}
		if (filtreCheckbox != null) {
			builder.append("filtreCheckbox=");
			builder.append(filtreCheckbox);
			builder.append(", ");
		}
		if (currentUser != null) {
			builder.append("currentUser=");
			builder.append(currentUser);
			builder.append(", ");
		}
		if (vendeur != null) {
			builder.append("vendeur=");
			builder.append(vendeur);
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
