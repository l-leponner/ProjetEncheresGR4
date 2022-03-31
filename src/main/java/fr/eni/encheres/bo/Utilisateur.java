/**
 * 
 */
package fr.eni.encheres.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 29 mars 2022
 * @version Encheres- V0.1
 * @since  29 mars 2022 - 11:44:22
 *
 */
public class Utilisateur {

	private final Integer NB_CREDIT_INIT = 100;
	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private Integer credit;
	private boolean administrateur;
	
	private List<ArticleVendu> lstArticlesVendus = new ArrayList<ArticleVendu>();
	private List<Enchere> lstEncheres = new ArrayList<Enchere>();
	/**
	 * Constructeur.
	 */
	public Utilisateur() {
	}
	/**
	 * Constructeur.
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		setCredit(NB_CREDIT_INIT);
		setAdministrateur(false);
	}
	/**
	 * Getter pour noUtilisateur.
	 * @return the noUtilisateur
	 */
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	/**
	 * Setter pour noUtilisateur.
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	/**
	 * Getter pour pseudo.
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * Setter pour pseudo.
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * Getter pour nom.
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter pour nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter pour prenom.
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Setter pour prenom.
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Getter pour email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter pour email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter pour telephone.
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * Setter pour telephone.
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * Getter pour motDePasse.
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * Setter pour motDePasse.
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/**
	 * Getter pour credit.
	 * @return the credit
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * Setter pour credit.
	 * @param credit the credit to set
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	/**
	 * Getter pour administrateur.
	 * @return the administrateur
	 */
	public boolean isAdministrateur() {
		return administrateur;
	}
	/**
	 * Setter pour administrateur.
	 * @param administrateur the administrateur to set
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
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
	 * Getter pour lstEncheres.
	 * @return the lstEncheres
	 */
	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}
	/**
	 * Setter pour lstEncheres.
	 * @param lstEncheres the lstEncheres to set
	 */
	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [");
		if (noUtilisateur != null) {
			builder.append("noUtilisateur=");
			builder.append(noUtilisateur);
			builder.append(", ");
		}
		if (pseudo != null) {
			builder.append("pseudo=");
			builder.append(pseudo);
			builder.append(", ");
		}
		if (nom != null) {
			builder.append("nom=");
			builder.append(nom);
			builder.append(", ");
		}
		if (prenom != null) {
			builder.append("prenom=");
			builder.append(prenom);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (telephone != null) {
			builder.append("telephone=");
			builder.append(telephone);
			builder.append(", ");
		}
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
		if (motDePasse != null) {
			builder.append("motDePasse=");
			builder.append(motDePasse);
			builder.append(", ");
		}
		if (credit != null) {
			builder.append("credit=");
			builder.append(credit);
			builder.append(", ");
		}
		builder.append("administrateur=");
		builder.append(administrateur);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
