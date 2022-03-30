/**
 * 
 */
package fr.eni.encheres.bll.enchere;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 17:02:32
 *
 */
public class EnchereBLLSing {
private static EnchereBLL instance;
	
	public static EnchereBLL getInstance() {
		if(instance == null) {
			instance = new EnchereBLLImpl();
		}
		return instance;
	}
}
