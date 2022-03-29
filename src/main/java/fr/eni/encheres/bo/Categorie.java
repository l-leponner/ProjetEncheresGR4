/**
 * 
 */
package fr.eni.encheres.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public class Categorie {

	private Integer noCategorie;
	private String libelle;
	private List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();

	public Categorie() {
		super();
	}

	public Categorie(String libelle, List<ArticleVendu> lstArticleVendus) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.lstArticleVendus = lstArticleVendus;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleVendu> getLstArticleVendus() {
		return lstArticleVendus;
	}

	public void setLstArticleVendus(List<ArticleVendu> lstArticleVendus) {
		this.lstArticleVendus = lstArticleVendus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [");
		if (noCategorie != null) {
			builder.append("noCategorie=");
			builder.append(noCategorie);
			builder.append(", ");
		}
		if (libelle != null) {
			builder.append("libelle=");
			builder.append(libelle);
		}
		builder.append("]");
		return builder.toString();
	}

}
