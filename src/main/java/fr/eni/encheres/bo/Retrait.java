/**
 * 
 */
package fr.eni.encheres.bo;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public class Retrait {

	private String rue;
	private String codePostal;
	private String ville;
	private Integer noArticleVendu;

	public Retrait() {
		super();
	}

	public Retrait(String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = code_postal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return codePostal;
	}

	public void setCode_postal(String code_postal) {
		this.codePostal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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
		builder.append("Retrait [");
		if (rue != null) {
			builder.append("rue=");
			builder.append(rue);
			builder.append(", ");
		}
		if (codePostal != null) {
			builder.append("code_postal=");
			builder.append(codePostal);
			builder.append(", ");
		}
		if (ville != null) {
			builder.append("ville=");
			builder.append(ville);
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
