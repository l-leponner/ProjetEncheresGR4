/**
 * 
 */
package fr.eni.encheres.bll.utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 14:41:43
 *
 */
public class UtilisateurBLLSing {

	private static UtilisateurBLL instance;
	
	public static UtilisateurBLL getInstance() {
		if(instance == null) {
			instance = new UtilisateurBLLImpl();
		}
		return instance;
	}
}
