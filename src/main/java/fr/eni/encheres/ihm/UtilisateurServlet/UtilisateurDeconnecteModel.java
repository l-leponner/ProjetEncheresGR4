/**
 * 
 */
package fr.eni.encheres.ihm.UtilisateurServlet;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author ggastine2022
 * @date 5 avr. 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  5 avr. 2022 - 10:22:24
 *
 */
public class UtilisateurDeconnecteModel {
	

		private Utilisateur current;
		private String message;


		public UtilisateurDeconnecteModel() {
			super();
		}

		public UtilisateurDeconnecteModel(Utilisateur current) {
			super();
			this.current = current;
		}

		public Utilisateur getCurrent() {
			return current;
		}

		public void setCurrent(Utilisateur current) {
			this.current = current;
		}
		

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
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

