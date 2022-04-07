/**
 * 
 */
package fr.eni.encheres.ihm.indexServlet;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 4 avr. 2022
 */
public class ConnecterIndexModel {

	private String message;
	private String filterArticle;
	private String filtreCategorie;
	private String filtreRadio;
	private String filtreCheckbox;
	private Utilisateur currentUser;
	private Utilisateur vendeur;
	private List<ArticleVendu> lstArticlesVendus = new ArrayList<ArticleVendu>();
	private List<ArticleVendu> lstAchatsEnchOuvertes = new ArrayList<ArticleVendu>();
	private List<ArticleVendu> lstAchatsMesEnch = new ArrayList<ArticleVendu>();
	private List<ArticleVendu> lstAchatsMesEnchRemportees = new ArrayList<ArticleVendu>();
	private List<ArticleVendu> lstMesVentesTerminees = new ArrayList<ArticleVendu>();
	private List<ArticleVendu> lstMesVentesNonDebutees = new ArrayList<ArticleVendu>();
	private List<ArticleVendu> lstMesVentesEnCours = new ArrayList<ArticleVendu>();
	private List<Categorie> lstCategories = new ArrayList<Categorie>();

	public ConnecterIndexModel() {
		super();
	}

	/**
	 * Constructeur.
	 * @param message
	 * @param filterArticle
	 * @param filtreCategorie
	 * @param filtreRadio
	 * @param filtreCheckbox
	 * @param currentUser
	 * @param vendeur
	 * @param lstArticlesVendus
	 * @param lstAchatsEnchOuvertes
	 * @param lstAchatsMesEnch
	 * @param lstAchatsMesEnchRemportees
	 * @param lstMesVentesTerminees
	 * @param lstMesVentesNonDebutees
	 * @param lstMesVentesEnCours
	 * @param lstCategories
	 */
	public ConnecterIndexModel(String message, String filterArticle, String filtreCategorie, String filtreRadio,
			String filtreCheckbox, Utilisateur currentUser, Utilisateur vendeur, List<ArticleVendu> lstArticlesVendus,
			List<ArticleVendu> lstAchatsEnchOuvertes, List<ArticleVendu> lstAchatsMesEnch,
			List<ArticleVendu> lstAchatsMesEnchRemportees, List<ArticleVendu> lstMesVentesTerminees,
			List<ArticleVendu> lstMesVentesNonDebutees, List<ArticleVendu> lstMesVentesEnCours,
			List<Categorie> lstCategories) {
		this.message = message;
		this.filterArticle = filterArticle;
		this.filtreCategorie = filtreCategorie;
		this.filtreRadio = filtreRadio;
		this.filtreCheckbox = filtreCheckbox;
		this.currentUser = currentUser;
		this.vendeur = vendeur;
		this.lstArticlesVendus = lstArticlesVendus;
		this.lstAchatsEnchOuvertes = lstAchatsEnchOuvertes;
		this.lstAchatsMesEnch = lstAchatsMesEnch;
		this.lstAchatsMesEnchRemportees = lstAchatsMesEnchRemportees;
		this.lstMesVentesTerminees = lstMesVentesTerminees;
		this.lstMesVentesNonDebutees = lstMesVentesNonDebutees;
		this.lstMesVentesEnCours = lstMesVentesEnCours;
		this.lstCategories = lstCategories;
	}

	/**
	 * Getter pour message.
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter pour message.
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter pour filterArticle.
	 * @return the filterArticle
	 */
	public String getFilterArticle() {
		return filterArticle;
	}

	/**
	 * Setter pour filterArticle.
	 * @param filterArticle the filterArticle to set
	 */
	public void setFilterArticle(String filterArticle) {
		this.filterArticle = filterArticle;
	}

	/**
	 * Getter pour filtreCategorie.
	 * @return the filtreCategorie
	 */
	public String getFiltreCategorie() {
		return filtreCategorie;
	}

	/**
	 * Setter pour filtreCategorie.
	 * @param filtreCategorie the filtreCategorie to set
	 */
	public void setFiltreCategorie(String filtreCategorie) {
		this.filtreCategorie = filtreCategorie;
	}

	/**
	 * Getter pour filtreRadio.
	 * @return the filtreRadio
	 */
	public String getFiltreRadio() {
		return filtreRadio;
	}

	/**
	 * Setter pour filtreRadio.
	 * @param filtreRadio the filtreRadio to set
	 */
	public void setFiltreRadio(String filtreRadio) {
		this.filtreRadio = filtreRadio;
	}

	/**
	 * Getter pour filtreCheckbox.
	 * @return the filtreCheckbox
	 */
	public String getFiltreCheckbox() {
		return filtreCheckbox;
	}

	/**
	 * Setter pour filtreCheckbox.
	 * @param filtreCheckbox the filtreCheckbox to set
	 */
	public void setFiltreCheckbox(String filtreCheckbox) {
		this.filtreCheckbox = filtreCheckbox;
	}

	/**
	 * Getter pour currentUser.
	 * @return the currentUser
	 */
	public Utilisateur getCurrentUser() {
		return currentUser;
	}

	/**
	 * Setter pour currentUser.
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Utilisateur currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * Getter pour vendeur.
	 * @return the vendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}

	/**
	 * Setter pour vendeur.
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
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
	 * Getter pour lstAchatsEnchOuvertes.
	 * @return the lstAchatsEnchOuvertes
	 */
	public List<ArticleVendu> getLstAchatsEnchOuvertes() {
		return lstAchatsEnchOuvertes;
	}

	/**
	 * Setter pour lstAchatsEnchOuvertes.
	 * @param lstAchatsEnchOuvertes the lstAchatsEnchOuvertes to set
	 */
	public void setLstAchatsEnchOuvertes(List<ArticleVendu> lstAchatsEnchOuvertes) {
		this.lstAchatsEnchOuvertes = lstAchatsEnchOuvertes;
	}

	/**
	 * Getter pour lstAchatsMesEnch.
	 * @return the lstAchatsMesEnch
	 */
	public List<ArticleVendu> getLstAchatsMesEnch() {
		return lstAchatsMesEnch;
	}

	/**
	 * Setter pour lstAchatsMesEnch.
	 * @param lstAchatsMesEnch the lstAchatsMesEnch to set
	 */
	public void setLstAchatsMesEnch(List<ArticleVendu> lstAchatsMesEnch) {
		this.lstAchatsMesEnch = lstAchatsMesEnch;
	}

	/**
	 * Getter pour lstAchatsMesEnchRemportees.
	 * @return the lstAchatsMesEnchRemportees
	 */
	public List<ArticleVendu> getLstAchatsMesEnchRemportees() {
		return lstAchatsMesEnchRemportees;
	}

	/**
	 * Setter pour lstAchatsMesEnchRemportees.
	 * @param lstAchatsMesEnchRemportees the lstAchatsMesEnchRemportees to set
	 */
	public void setLstAchatsMesEnchRemportees(List<ArticleVendu> lstAchatsMesEnchRemportees) {
		this.lstAchatsMesEnchRemportees = lstAchatsMesEnchRemportees;
	}

	/**
	 * Getter pour lstMesVentesTerminees.
	 * @return the lstMesVentesTerminees
	 */
	public List<ArticleVendu> getLstMesVentesTerminees() {
		return lstMesVentesTerminees;
	}

	/**
	 * Setter pour lstMesVentesTerminees.
	 * @param lstMesVentesTerminees the lstMesVentesTerminees to set
	 */
	public void setLstMesVentesTerminees(List<ArticleVendu> lstMesVentesTerminees) {
		this.lstMesVentesTerminees = lstMesVentesTerminees;
	}

	/**
	 * Getter pour lstMesVentesNonDebutees.
	 * @return the lstMesVentesNonDebutees
	 */
	public List<ArticleVendu> getLstMesVentesNonDebutees() {
		return lstMesVentesNonDebutees;
	}

	/**
	 * Setter pour lstMesVentesNonDebutees.
	 * @param lstMesVentesNonDebutees the lstMesVentesNonDebutees to set
	 */
	public void setLstMesVentesNonDebutees(List<ArticleVendu> lstMesVentesNonDebutees) {
		this.lstMesVentesNonDebutees = lstMesVentesNonDebutees;
	}

	/**
	 * Getter pour lstMesVentesEnCours.
	 * @return the lstMesVentesEnCours
	 */
	public List<ArticleVendu> getLstMesVentesEnCours() {
		return lstMesVentesEnCours;
	}

	/**
	 * Setter pour lstMesVentesEnCours.
	 * @param lstMesVentesEnCours the lstMesVentesEnCours to set
	 */
	public void setLstMesVentesEnCours(List<ArticleVendu> lstMesVentesEnCours) {
		this.lstMesVentesEnCours = lstMesVentesEnCours;
	}

	/**
	 * Getter pour lstCategories.
	 * @return the lstCategories
	 */
	public List<Categorie> getLstCategories() {
		return lstCategories;
	}

	/**
	 * Setter pour lstCategories.
	 * @param lstCategories the lstCategories to set
	 */
	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConnecterIndexModel [");
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		if (filterArticle != null) {
			builder.append("filterArticle=");
			builder.append(filterArticle);
			builder.append(", ");
		}
		if (filtreCategorie != null) {
			builder.append("filtreCategorie=");
			builder.append(filtreCategorie);
			builder.append(", ");
		}
		if (filtreRadio != null) {
			builder.append("filtreRadio=");
			builder.append(filtreRadio);
			builder.append(", ");
		}
		if (filtreCheckbox != null) {
			builder.append("filtreCheckbox=");
			builder.append(filtreCheckbox);
			builder.append(", ");
		}
		if (currentUser != null) {
			builder.append("currentUser=");
			builder.append(currentUser);
			builder.append(", ");
		}
		if (vendeur != null) {
			builder.append("vendeur=");
			builder.append(vendeur);
			builder.append(", ");
		}
		if (lstArticlesVendus != null) {
			builder.append("lstArticlesVendus=");
			builder.append(lstArticlesVendus);
			builder.append(", ");
		}
		if (lstAchatsEnchOuvertes != null) {
			builder.append("lstAchatsEnchOuvertes=");
			builder.append(lstAchatsEnchOuvertes);
			builder.append(", ");
		}
		if (lstAchatsMesEnch != null) {
			builder.append("lstAchatsMesEnch=");
			builder.append(lstAchatsMesEnch);
			builder.append(", ");
		}
		if (lstAchatsMesEnchRemportees != null) {
			builder.append("lstAchatsMesEnchRemportees=");
			builder.append(lstAchatsMesEnchRemportees);
			builder.append(", ");
		}
		if (lstMesVentesTerminees != null) {
			builder.append("lstMesVentesTerminees=");
			builder.append(lstMesVentesTerminees);
			builder.append(", ");
		}
		if (lstMesVentesNonDebutees != null) {
			builder.append("lstMesVentesNonDebutees=");
			builder.append(lstMesVentesNonDebutees);
			builder.append(", ");
		}
		if (lstMesVentesEnCours != null) {
			builder.append("lstMesVentesEnCours=");
			builder.append(lstMesVentesEnCours);
			builder.append(", ");
		}
		if (lstCategories != null) {
			builder.append("lstCategories=");
			builder.append(lstCategories);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
