/**
 * 
 */
package fr.eni.encheres.ihm.vente;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 4 avr. 2022
 * @version Encheres- V0.1
 * @since  4 avr. 2022 - 13:40:50
 *
 */
public class VenteModel {

	private ArticleVendu currentArticle;
	private Utilisateur currentUtilisateur;
	private List<Categorie> lstCategories = new ArrayList<Categorie>();

	/**
	 * Constructeur.
	 */
	public VenteModel() {
	}

	/**
	 * Constructeur.
	 * @param currentArticle
	 * @param currentUtilisateur
	 * @param lstCategories
	 */
	public VenteModel(ArticleVendu currentArticle, Utilisateur currentUtilisateur, List<Categorie> lstCategories) {
		this.currentArticle = currentArticle;
		this.currentUtilisateur = currentUtilisateur;
		this.lstCategories = lstCategories;
	}

	/**
	 * Getter pour currentArticle.
	 * @return the currentArticle
	 */
	public ArticleVendu getCurrentArticle() {
		return currentArticle;
	}

	/**
	 * Setter pour currentArticle.
	 * @param currentArticle the currentArticle to set
	 */
	public void setCurrentArticle(ArticleVendu currentArticle) {
		this.currentArticle = currentArticle;
	}

	/**
	 * Getter pour currentUtilisateur.
	 * @return the currentUtilisateur
	 */
	public Utilisateur getCurrentUtilisateur() {
		return currentUtilisateur;
	}

	/**
	 * Setter pour currentUtilisateur.
	 * @param currentUtilisateur the currentUtilisateur to set
	 */
	public void setCurrentUtilisateur(Utilisateur currentUtilisateur) {
		this.currentUtilisateur = currentUtilisateur;
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
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VenteModel [");
		if (currentArticle != null) {
			builder.append("currentArticle=");
			builder.append(currentArticle);
			builder.append(", ");
		}
		if (currentUtilisateur != null) {
			builder.append("currentUtilisateur=");
			builder.append(currentUtilisateur);
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
