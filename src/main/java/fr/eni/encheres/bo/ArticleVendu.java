/**
 * 
 */
package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de
 * 
 * @author ggastine2022
 * @date 29 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since 29 mars 2022 - 11:48:47
 *
 */
public class ArticleVendu {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	private List<Enchere> lstEncheres = new ArrayList<Enchere>();
	private Retrait retrait;

	public ArticleVendu() {
		super();
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate finDebutEncheres,
			Integer miseAPrix, Integer prixvente, String etatVente, List<Enchere> lstEncheres, Retrait retrait) {
		super();

		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = finDebutEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixvente;
		this.etatVente = etatVente;
		this.lstEncheres = lstEncheres;
		this.retrait = retrait;
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate finDebutEncheres,
			Integer miseAPrix, Integer prixvente, String etatVente, List<Enchere> lstEncheres) {
		super();

		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = finDebutEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixvente;
		this.etatVente = etatVente;
		this.lstEncheres = lstEncheres;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setFinDebutEncheres(LocalDate finDebutEncheres) {
		this.dateFinEncheres = finDebutEncheres;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAprix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixvente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [");
		if (noArticle != null) {
			builder.append("noArticle=");
			builder.append(noArticle);
			builder.append(", ");
		}
		if (nomArticle != null) {
			builder.append("nomArticle=");
			builder.append(nomArticle);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		if (dateDebutEncheres != null) {
			builder.append("dateDebutEncheres=");
			builder.append(dateDebutEncheres);
			builder.append(", ");
		}
		if (dateFinEncheres != null) {
			builder.append("dateFinEncheres=");
			builder.append(dateFinEncheres);
			builder.append(", ");
		}
		if (miseAPrix != null) {
			builder.append("miseAPrix=");
			builder.append(miseAPrix);
			builder.append(", ");
		}
		if (prixVente != null) {
			builder.append("prixVente=");
			builder.append(prixVente);
			builder.append(", ");
		}
		if (etatVente != null) {
			builder.append("etatVente=");
			builder.append(etatVente);
			builder.append(", ");
		}
		if (lstEncheres != null) {
			builder.append("lstEncheres=");
			builder.append(lstEncheres);
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
