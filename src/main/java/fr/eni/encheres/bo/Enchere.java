/**
 * 
 */
package fr.eni.encheres.bo;

import java.time.LocalDate;

/**
 * Classe en charge de
 * @author ggastine2022
 * @date 29 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  29 mars 2022 - 11:44:45
 *
 */
public class Enchere {
	
	private LocalDate dateEncheres;
	private Integer montantEnchere;
	
	
	public Enchere(LocalDate dateEncheres, Integer montantEnchere) {
		super();
		this.dateEncheres = dateEncheres;
		this.montantEnchere = montantEnchere;
		
		
	}
	public Enchere() {
		super();
	}
	public LocalDate getDateEncheres() {
		return dateEncheres;
	}
	public void setDateEncheres(LocalDate dateEncheres) {
		this.dateEncheres = dateEncheres;
	}
	public Integer getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [");
		if (dateEncheres != null) {
			builder.append("dateEncheres=");
			builder.append(dateEncheres);
			builder.append(", ");
		}
		if (montantEnchere != null) {
			builder.append("montantEnchere=");
			builder.append(montantEnchere);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
