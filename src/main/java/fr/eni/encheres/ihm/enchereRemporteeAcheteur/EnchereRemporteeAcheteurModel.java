/**
 * 
 */
package fr.eni.encheres.ihm.enchereRemporteeAcheteur;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 5 avr. 2022
 * @version Encheres- V0.1
 * @since  5 avr. 2022 - 15:58:26
 *
 */
public class EnchereRemporteeAcheteurModel {

	private ArticleVendu currentArticle;
	private Utilisateur acheteur;
	private Utilisateur vendeur;
	private List<Enchere> lstEncheres = new ArrayList<Enchere>();
	private Enchere meillereEnchere;
	/**
	 * Constructeur.
	 */
	public EnchereRemporteeAcheteurModel() {
	}
	/**
	 * Constructeur.
	 * @param currentArticle
	 * @param acheteur
	 * @param vendeur
	 * @param lstEncheres
	 * @param meillereEnchere
	 */
	public EnchereRemporteeAcheteurModel(ArticleVendu currentArticle, Utilisateur acheteur, Utilisateur vendeur,
			List<Enchere> lstEncheres, Enchere meillereEnchere) {
		this.currentArticle = currentArticle;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.lstEncheres = lstEncheres;
		this.meillereEnchere = meillereEnchere;
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
	 * Getter pour acheteur.
	 * @return the acheteur
	 */
	public Utilisateur getAcheteur() {
		return acheteur;
	}
	/**
	 * Setter pour acheteur.
	 * @param acheteur the acheteur to set
	 */
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}
	/**
	 * Getter pour vendeur.
	 * @return the vendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}
	/**
	 * Setter pour vendeur.
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	/**
	 * Getter pour lstEncheres.
	 * @return the lstEncheres
	 */
	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}
	/**
	 * Setter pour lstEncheres.
	 * @param lstEncheres the lstEncheres to set
	 */
	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}
	/**
	 * Getter pour meillereEnchere.
	 * @return the meillereEnchere
	 */
	public Enchere getMeillereEnchere() {
		return meillereEnchere;
	}
	/**
	 * Setter pour meillereEnchere.
	 * @param meillereEnchere the meillereEnchere to set
	 */
	public void setMeillereEnchere(Enchere meillereEnchere) {
		this.meillereEnchere = meillereEnchere;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnchereRemporteeAcheteurModel [");
		if (currentArticle != null) {
			builder.append("currentArticle=");
			builder.append(currentArticle);
			builder.append(", ");
		}
		if (acheteur != null) {
			builder.append("acheteur=");
			builder.append(acheteur);
			builder.append(", ");
		}
		if (vendeur != null) {
			builder.append("vendeur=");
			builder.append(vendeur);
			builder.append(", ");
		}
		if (lstEncheres != null) {
			builder.append("lstEncheres=");
			builder.append(lstEncheres);
			builder.append(", ");
		}
		if (meillereEnchere != null) {
			builder.append("meillereEnchere=");
			builder.append(meillereEnchere);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
