/**
 * 
 */
package fr.eni.encheres.dal.utilisateur;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 29 mars 2022
 * @version Encheres- V0.1
 * @since  29 mars 2022 - 16:54:55
 *
 */
public class UtilisateurDAOTest {

	/**
	 * Méthode en charge de 
	 * @param args
	 */
	public static void main(String[] args) {

		UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
		
		Utilisateur u1 = new Utilisateur("JoJo", "Joestar", "Jonathan", "jojo@gmail.com", "02 50 40 60 70", "rue des Jojos", "35740", "Pace", "jojoazerty");
		u1.setCredit(null);
		try {
			dao.insertUtilisateur(u1);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
