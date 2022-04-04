/**
 * 
 */
package fr.eni.encheres.ihm.vente;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 4 avr. 2022
 * @version Encheres- V0.1
 * @since  4 avr. 2022 - 13:40:50
 *
 */
public class VenteModel {

	private ArticleVendu current;
	private List<Categorie> lstCategories = new ArrayList<Categorie>();

	/**
	 * Constructeur.
	 */
	public VenteModel() {
	}

	/**
	 * Constructeur.
	 * @param current
	 * @param lstCategories
	 */
	public VenteModel(ArticleVendu current, List<Categorie> lstCategories) {
		this.current = current;
		this.lstCategories = lstCategories;
	}

	/**
	 * Getter pour current.
	 * @return the current
	 */
	public ArticleVendu getCurrent() {
		return current;
	}

	/**
	 * Setter pour current.
	 * @param current the current to set
	 */
	public void setCurrent(ArticleVendu current) {
		this.current = current;
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
		if (current != null) {
			builder.append("current=");
			builder.append(current);
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
