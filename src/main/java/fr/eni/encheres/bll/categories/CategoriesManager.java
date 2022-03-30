/**
 * 
 */
package fr.eni.encheres.bll.categories;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Categorie;

/**
 * Class en charge de 
 * @author alegeas2022
 * @date 30 mars 2022
 */
public interface CategoriesManager {

	public void addCategorie(Categorie categorie) throws BLLException;
	
	public void updateCategorie(Categorie categorie) throws BLLException;
	
	public void removeCategorie(Categorie categorie) throws BLLException;
	
	public void getALLCategorie(Categorie categorie) throws BLLException;
	
	public void getByIDCategorie(Categorie categorie) throws BLLException;
	
	
}
