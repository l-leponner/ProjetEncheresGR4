/**
 * 
 */
package fr.eni.encheres.bll.categories;

/**
 * Class en charge de 
 * @author alegeas2022
 * @date 30 mars 2022
 */
public class CategorieManagerSing {

	private static CategoriesManager instance;

	public static CategoriesManager getInstance() {
		if (instance == null) {
			instance = new CategorieManagerImpl();
		}
		return instance;
	}
	
}
