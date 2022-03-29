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
 * @since  29 mars 2022 - 11:48:47
 *
 */
public class ArticleVendu {
	
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate finDebutEncheres;
	private Integer miseAprix;
	private Integer prixvente;
	private String etatVente;
	private List <Enchere> lstEncheres = new ArrayList<Enchere>();
	private Retrait retrait;
	
	public ArticleVendu() {
		super();
	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate finDebutEncheres, Integer miseAprix, Integer prixvente, String etatVente,
			List<Enchere> lstEncheres, Retrait retrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.finDebutEncheres = finDebutEncheres;
		this.miseAprix = miseAprix;
		this.prixvente = prixvente;
		this.etatVente = etatVente;
		this.lstEncheres = lstEncheres;
		this.retrait = retrait;
	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate finDebutEncheres, Integer miseAprix, Integer prixvente, String etatVente,
			List<Enchere> lstEncheres) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.finDebutEncheres = finDebutEncheres;
		this.miseAprix = miseAprix;
		this.prixvente = prixvente;
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

	public LocalDate getFinDebutEncheres() {
		return finDebutEncheres;
	}

	public void setFinDebutEncheres(LocalDate finDebutEncheres) {
		this.finDebutEncheres = finDebutEncheres;
	}

	public Integer getMiseAprix() {
		return miseAprix;
	}

	public void setMiseAprix(Integer miseAprix) {
		this.miseAprix = miseAprix;
	}

	public Integer getPrixvente() {
		return prixvente;
	}

	public void setPrixvente(Integer prixvente) {
		this.prixvente = prixvente;
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
		if (finDebutEncheres != null) {
			builder.append("finDebutEncheres=");
			builder.append(finDebutEncheres);
			builder.append(", ");
		}
		if (miseAprix != null) {
			builder.append("miseAprix=");
			builder.append(miseAprix);
			builder.append(", ");
		}
		if (prixvente != null) {
			builder.append("prixvente=");
			builder.append(prixvente);
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
