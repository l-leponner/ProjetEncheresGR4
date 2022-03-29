/**
 * 
 */
package fr.eni.encheres.dal.categories;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;

/**
 * Class en charge de 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public interface CategoriesDAO {

	public void insertCategorie(Categorie categorie) throws DALException;

	public void updateCategorie(Categorie categorie) throws DALException;

	public List<Retrait> selectALLCategorie() throws DALException;

	public List<Retrait> selectByIdCategorie(Categorie categorie) throws DALException;

	public void deleteCategorie(Categorie categorie) throws DALException;
	
}
