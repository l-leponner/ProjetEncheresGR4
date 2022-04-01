/**
 * 
 */
package fr.eni.encheres.ihm.loginServlet;


/**
 * Classe en charge de
 * @author ggastine2022
 * @date 31 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since  31 mars 2022 - 16:16:46
 *
 */
public class LoginModel {
	
	
	private String identifiant;
	private Character MDP;
	
	
	public LoginModel() {
		super();
	}
	public LoginModel(String identifiant, Character mDP) {
		super();
		this.identifiant = identifiant;
		MDP = mDP;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public Character getMDP() {
		return MDP;
	}
	public void setMDP(Character mDP) {
		MDP = mDP;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginModel [");
		if (identifiant != null) {
			builder.append("identifiant=");
			builder.append(identifiant);
			builder.append(", ");
		}
		if (MDP != null) {
			builder.append("MDP=");
			builder.append(MDP);
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
