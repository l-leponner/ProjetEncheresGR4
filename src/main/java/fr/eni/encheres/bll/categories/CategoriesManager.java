/**
 * 
 */
package fr.eni.encheres.bll.categories;

import java.util.List;

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
	
	public List<Categorie> getALLCategorie() throws BLLException;
	
	public Categorie getByIDCategorie(Integer idCategorie) throws BLLException;
	
	public Categorie getByLibelleCategorie(String libelle) throws BLLException;
	
	
}
