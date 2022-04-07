/**
 * 
 */
package fr.eni.encheres.bo;

import java.time.LocalDateTime;

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
	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	
	private Utilisateur utilisateur;
	private Integer noArticleVendu;
	
	
	public Enchere(LocalDateTime dateEnchere, Integer montantEnchere, Integer noArticleVendu, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticleVendu = noArticleVendu;
		
		
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
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * Setter pour dateEnchere.
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDateTime dateEnchere) {
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
	 * Getter pour utilisateur.
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * Setter pour utilisateur.
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	/**
	 * Getter pour noArticleVendu.
	 * @return the noArticleVendu
	 */
	public Integer getNoArticleVendu() {
		return noArticleVendu;
	}
	/**
	 * Setter pour noArticleVendu.
	 * @param noArticleVendu the noArticleVendu to set
	 */
	public void setNoArticleVendu(Integer noArticleVendu) {
		this.noArticleVendu = noArticleVendu;
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
		if (utilisateur != null) {
			builder.append("utilisateur=");
			builder.append(utilisateur);
			builder.append(", ");
		}
		if (noArticleVendu != null) {
			builder.append("noArticleVendu=");
			builder.append(noArticleVendu);
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
