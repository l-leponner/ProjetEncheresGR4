/**
 * 
 */
package fr.eni.encheres.ihm.modificationProfil;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 1 avr. 2022
 * @version Encheres- V0.1
 * @since  1 avr. 2022 - 14:51:16
 *
 */
public class ModificationProfilModel {

	private Utilisateur current;
	private String message;
	/**
	 * Constructeur.
	 */
	public ModificationProfilModel() {
	}
	/**
	 * Constructeur.
	 * @param current
	 */
	public ModificationProfilModel(Utilisateur current) {
		this.current = current;
	}
	/**
	 * Getter pour current.
	 * @return the current
	 */
	public Utilisateur getCurrent() {
		return current;
	}
	/**
	 * Setter pour current.
	 * @param current the current to set
	 */
	public void setCurrent(Utilisateur current) {
		this.current = current;
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
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModificationProfilModel [");
		if (current != null) {
			builder.append("current=");
			builder.append(current);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
