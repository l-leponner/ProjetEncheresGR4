/**
 * 
 */
package fr.eni.encheres.ihm.inscription;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 1 avr. 2022
 * @version Encheres- V0.1
 * @since  1 avr. 2022 - 11:11:34
 *
 */
public class InscriptionModel {

	private Utilisateur current;
	private String message;
	private List<Categorie> lstCategories = new ArrayList<Categorie>();
	private List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();
	
	/**
	 * Constructeur.
	 */
	public InscriptionModel() {
	}
	/**
	 * Constructeur.
	 * @param current
	 */
	public InscriptionModel(Utilisateur current) {
		this.current = current;
	}
	/**
	 * Getter pour current.
	 * @return the current
	 */
	public Utilisateur getCurrent() {
		return current;
	}
	/**
	 * Setter pour current.
	 * @param current the current to set
	 */
	public void setCurrent(Utilisateur current) {
		this.current = current;
	}
	/**
	 * Getter pour message.
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Setter pour message.
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Getter pour lstCategories.
	 * @return the lstCategories
	 */
	public List<Categorie> getLstCategories() {
		return lstCategories;
	}
	/**
	 * Setter pour lstCategories.
	 * @param lstCategories the lstCategories to set
	 */
	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}
	/**
	 * Getter pour lstArticleVendus.
	 * @return the lstArticleVendus
	 */
	public List<ArticleVendu> getLstArticleVendus() {
		return lstArticleVendus;
	}
	/**
	 * Setter pour lstArticleVendus.
	 * @param lstArticleVendus the lstArticleVendus to set
	 */
	public void setLstArticleVendus(List<ArticleVendu> lstArticleVendus) {
		this.lstArticleVendus = lstArticleVendus;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InscriptionModel [");
		if (current != null) {
			builder.append("current=");
			builder.append(current);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		if (lstCategories != null) {
			builder.append("lstCategories=");
			builder.append(lstCategories);
			builder.append(", ");
		}
		if (lstArticleVendus != null) {
			builder.append("lstArticleVendus=");
			builder.append(lstArticleVendus);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
