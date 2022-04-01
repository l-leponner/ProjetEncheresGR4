/**
 * 
 */
package fr.eni.encheres.bll.categories;

import fr.eni.encheres.bll.BLLException;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 30 mars 2022
 */
public class CategorieManagerSing {

	private static CategoriesManager instance;

	public static CategoriesManager getInstance() {
		if (instance == null) {

			try {
				instance = new CategorieManagerImpl();
			} catch (BLLException e) {
				e.printStackTrace();
			}

		}
		return instance;
	}

}
