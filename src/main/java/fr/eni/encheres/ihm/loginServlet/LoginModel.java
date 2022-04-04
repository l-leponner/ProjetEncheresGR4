/**
 * 
 */
package fr.eni.encheres.ihm.loginServlet;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * 
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since 31 mars 2022 - 16:16:46
 *
 */
public class LoginModel {

	

	private String message;
	private String identifiant;
	
	private Utilisateur current;
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginModel() {
		super();
	}

	public LoginModel(Utilisateur current) {
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
		builder.append("LoginModel [");
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
