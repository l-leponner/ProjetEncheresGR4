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

	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * Getter pour rue.
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter pour rue.
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter pour codePostal.
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter pour codePostal.
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter pour ville.
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour ville.
	 * @param ville the ville to set
	 */
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
			builder.append("codePostal=");
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
