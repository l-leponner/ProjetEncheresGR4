/**
 * 
 */
package fr.eni.encheres.ihm.UtilisateurServlet;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * 
 * @author ggastine2022
 * @date 1 avr. 2022
 * @version ProjetEncheresGR4- V0.1
 * @since 1 avr. 2022 - 11:11:27
 *
 */
public class UtilisateurModel {

	private Utilisateur current;


	public UtilisateurModel() {
		super();
	}

	public UtilisateurModel(Utilisateur current) {
		super();
		this.current = current;
	}

	public Utilisateur getCurrent() {
		return current;
	}

	public void setCurrent(Utilisateur current) {
		this.current = current;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UtilisateurModel [");
		if (current != null) {
			builder.append("current=");
			builder.append(current);
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
