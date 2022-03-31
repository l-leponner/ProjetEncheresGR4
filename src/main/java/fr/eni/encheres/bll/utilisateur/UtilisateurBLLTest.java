/**
 * 
 */
package fr.eni.encheres.bll.utilisateur;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 15:58:49
 *
 */
public class UtilisateurBLLTest {

	/**
	 * Méthode en charge de 
	 * @param args
	 */
	private static UtilisateurBLL uManager = UtilisateurBLLSing.getInstance();
	public static void main(String[] args) {
		
		Utilisateur u1 = new Utilisateur("LHommeLePlusClasseDuMonde", "Abitbol", "George", "lhommeleplusclassedumonde@gmail.com", "02 98 87 76 65", "rue de la Classe", "75000", "Paris", "georgeazerty");
		
//		try {
//			uManager.addUtilisateur(u1);
//		} catch (BLLException e) {
//			e.printStackTrace();
//		}
		try {
			System.out.println("getAllUtilisateur");
			uManager.getAllUtilisateur().stream().forEach(System.out::println);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");

		try {
			System.out.println("getByIDUtilisateur");
			System.out.println(uManager.getByIDUtilisateur(5));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		
		try {
			uManager.getByIDUtilisateur(5).setCredit(500);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		try {
			uManager.updateUtilisateur(uManager.getByIDUtilisateur(5));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("getByIDUtilisateur après updateUtilisateur des credits de " + uManager.getByIDUtilisateur(5));
			System.out.println(uManager.getByIDUtilisateur(5));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("");
		
//		try {
//			uManager.removeUtilisateur(uManager.getByIDUtilisateur(6));
//		} catch (BLLException e) {
//			e.printStackTrace();
//		}
//		try {
//			System.out.println("getAllUtilisateur après removeUtilisateur de " + uManager.getByIDUtilisateur(6));
//			uManager.getAllUtilisateur().stream().forEach(System.out::println);
//		} catch (BLLException e) {
//			e.printStackTrace();
//		}
	}

}
