/**
 * 
 */
package fr.eni.encheres.bll.retraits;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 31 mars 2022
 */
public class RetraitManagerSing {

	private static RetraitManager instance;

	public static RetraitManager getInstance() {
		if (instance == null) {
			instance = new RetraitManagerImpl();
		}
		return instance;
	}

}
