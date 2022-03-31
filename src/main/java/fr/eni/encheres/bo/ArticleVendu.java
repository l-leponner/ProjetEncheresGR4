/**
 * 
 */
package fr.eni.encheres.bo;

import java.time.LocalDateTime;
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
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	private List<Enchere> lstEncheres = new ArrayList<Enchere>();
	private Retrait lieuRetrait;
	private Categorie categorie;
	private Utilisateur utilisateur;

	public ArticleVendu() {
		super();
	}

	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer miseAPrix, String etatVente, Categorie categorie,
			Utilisateur utilisateur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}

	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer miseAPrix, String etatVente, Retrait lieuRetrait,
			Categorie categorie, Utilisateur utilisateur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
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

	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setFinDebutEncheres(LocalDateTime finDebutEncheres) {
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
		return lieuRetrait;
	}

	public void setRetrait(Retrait retrait) {
		this.lieuRetrait = retrait;
	}

	/**
	 * Getter pour utilisateur.
	 * 
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Setter pour utilisateur.
	 * 
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * Getter pour categorie.
	 * 
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Setter pour categorie.
	 * 
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * Getter pour lieuRetrait.
	 * 
	 * @return the lieuRetrait
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	/**
	 * Setter pour lieuRetrait.
	 * 
	 * @param lieuRetrait the lieuRetrait to set
	 */
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
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
		if (lieuRetrait != null) {
			builder.append("lieuRetrait=");
			builder.append(lieuRetrait);
			builder.append(", ");
		}
		if (categorie != null) {
			builder.append("categorie=");
			builder.append(categorie);
			builder.append(", ");
		}
		if (utilisateur != null) {
			builder.append("utilisateur=");
			builder.append(utilisateur);
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
