/**
 * 
 */
package fr.eni.encheres.bll.retraits;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 31 mars 2022
 */
public class RetraitManagerTest {

	private static RetraitManager manager = RetraitManagerSing.getInstance();

	/**
	 * @param args
	 * @throws BLLException 
	 */
	public static void main(String[] args) throws BLLException {

		Retrait retrait1 = new Retrait("15 rue du pape", "35136", "Rennes");
		Retrait retrait2 = new Retrait("15 rue du popo", "35000", "Rennes");

		// Add
//		try {
//			manager.addRetrait(retrait1);
//			manager.addRetrait(retrait2);
//		} catch (BLLException e) {
//			throw new BLLException("Erreur :" + e.getMessage());
//		}

		System.out.println("############");

		// Update
		retrait1.setCode_postal("0");
		manager.updateRetrait(retrait1);
		System.out.println(retrait1);

		System.out.println("############");

		// GetByID
		System.out.println("Get ID");
		//System.out.println(manager.getByIDRetrait(retrait1.getNoArticle()));

		System.out.println("############");

		// Delete
		manager.removeRetrait(retrait2);

		// GetALL
		try {
			for (Retrait string : manager.getALLRetrait()) {
				System.out.println(string);
			}

		} catch (BLLException e) {
			throw new BLLException("Erreur :" + e.getMessage());
		}

	}

}
