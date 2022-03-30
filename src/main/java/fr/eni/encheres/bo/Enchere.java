/**
 * 
 */
package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de
 * @author ggastine2022
 * @date 29 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  29 mars 2022 - 11:44:45
 *
 */
public class Enchere {
	
	private Integer noEnchere;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	
	private List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
	private List<ArticleVendu> lstArticlesVendus = new ArrayList<ArticleVendu>();
	
	
	public Enchere(LocalDate dateEncheres, Integer montantEnchere) {
		super();
		this.dateEnchere = dateEncheres;
		this.montantEnchere = montantEnchere;
		
		
	}
	public Enchere() {
		super();
	}
	/**
	 * Getter pour noEnchere.
	 * @return the noEnchere
	 */
	public Integer getNoEnchere() {
		return noEnchere;
	}
	/**
	 * Setter pour noEnchere.
	 * @param noEnchere the noEnchere to set
	 */
	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}
	/**
	 * Getter pour dateEnchere.
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * Setter pour dateEnchere.
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * Getter pour montantEnchere.
	 * @return the montantEnchere
	 */
	public Integer getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * Setter pour montantEnchere.
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	/**
	 * Getter pour lstUtilisateurs.
	 * @return the lstUtilisateurs
	 */
	public List<Utilisateur> getLstUtilisateurs() {
		return lstUtilisateurs;
	}
	/**
	 * Setter pour lstUtilisateurs.
	 * @param lstUtilisateurs the lstUtilisateurs to set
	 */
	public void setLstUtilisateurs(List<Utilisateur> lstUtilisateurs) {
		this.lstUtilisateurs = lstUtilisateurs;
	}
	/**
	 * Getter pour lstArticlesVendus.
	 * @return the lstArticlesVendus
	 */
	public List<ArticleVendu> getLstArticlesVendus() {
		return lstArticlesVendus;
	}
	/**
	 * Setter pour lstArticlesVendus.
	 * @param lstArticlesVendus the lstArticlesVendus to set
	 */
	public void setLstArticlesVendus(List<ArticleVendu> lstArticlesVendus) {
		this.lstArticlesVendus = lstArticlesVendus;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [");
		if (noEnchere != null) {
			builder.append("noEnchere=");
			builder.append(noEnchere);
			builder.append(", ");
		}
		if (dateEnchere != null) {
			builder.append("dateEnchere=");
			builder.append(dateEnchere);
			builder.append(", ");
		}
		if (montantEnchere != null) {
			builder.append("montantEnchere=");
			builder.append(montantEnchere);
			builder.append(", ");
		}
		if (lstUtilisateurs != null) {
			builder.append("lstUtilisateurs=");
			builder.append(lstUtilisateurs);
			builder.append(", ");
		}
		if (lstArticlesVendus != null) {
			builder.append("lstArticlesVendus=");
			builder.append(lstArticlesVendus);
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
