/**
 * 
 */
package fr.eni.encheres.bll.categories;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Categorie;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 30 mars 2022
 */
public class CategorieManagerTest {

	private static CategoriesManager manager = CategorieManagerSing.getInstance();

	/**
	 * @param args
	 * @throws BLLException
	 */
	public static void main(String[] args) throws BLLException {

		Categorie cat1 = new Categorie("Test");
		Categorie cat2 = new Categorie("Test2");

		// Add
		try {
			manager.addCategorie(cat1);
			manager.addCategorie(cat2);
		} catch (BLLException e) {
			throw new BLLException("Erreur :" + e.getMessage());
		}

		System.out.println("############");

		// Update
		cat1.setLibelle("Test3");
		manager.updateCategorie(cat1);
		System.out.println(cat1);

		System.out.println("############");

		// GetByID
		System.out.println("Get ID");
		System.out.println(manager.getByIDCategorie(cat1.getNoCategorie()));

		System.out.println("############");

		// Delete
		manager.removeCategorie(cat2);

		// GetALL
		try {
			for (Categorie string : manager.getALLCategorie()) {
				System.out.println(string);
			}

		} catch (BLLException e) {
			throw new BLLException("Erreur :" + e.getMessage());
		}

	}

}
