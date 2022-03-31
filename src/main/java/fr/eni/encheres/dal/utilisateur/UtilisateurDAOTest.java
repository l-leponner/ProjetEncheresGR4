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
		Utilisateur u2 = new Utilisateur("ALeg", "Legeas", "Arthur", "alegeas@gmail.com", "02 99 88 77 66", "rue des Arthur", "35000", "Rennes", "arthurazerty");
		Utilisateur u3 = new Utilisateur("LLep", "Le Ponner", "Laurent", "llepo@gmail.com", "02 00 11 22 33", "rue des Laurent", "35740", "Pace", "loloazerty");
		Utilisateur u4 = new Utilisateur("GaGas", "Gastine", "Gabriel", "gagas@gmail.com", "02 44 55 66 77", "rue des Gabriel", "35000", "Rennes", "gagaazerty");
		
//		try {
//			dao.insertUtilisateur(u1);
//			dao.insertUtilisateur(u2);
//			dao.insertUtilisateur(u3);
//			dao.insertUtilisateur(u4);
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
		try {
			System.out.println("selectAllUtilisateur");
			dao.selectAllUtilisateur().stream().forEach(System.out::println);
		} catch (DALException e) {
			e.printStackTrace();
		}
		u1.setNoUtilisateur(1);
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		try {
			System.out.println("selectByIDutilisateur");
			System.out.println(dao.selectByIDUtilisateur(5));
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		u1.setAdministrateur(true);
		try {
			System.out.println("updateUtilisateur");
			dao.updateUtilisateur(u1);
			System.out.println(dao.selectByIDUtilisateur(5));
		} catch (DALException e) {
			e.printStackTrace();
		}
		
//		try {
//			dao.deleteUtilisateur(u1);
//		} catch (DALException e) {
//			e.printStackTrace();
//		}
	}

}
