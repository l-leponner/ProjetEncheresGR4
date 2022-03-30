/**
 * 
 */
package fr.eni.encheres.bll.categories;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.categories.CategorieDAO;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 30 mars 2022
 */
public class CategorieManagerImpl implements CategoriesManager {

	CategorieDAO dao = DAOFactory.getCategorieDAO();

	@Override
	public void addCategorie(Categorie categorie) throws BLLException {

		try {
			dao.insertCategorie(categorie);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode addCategorie" + e.getMessage());
		}

	}

	@Override
	public void updateCategorie(Categorie categorie) throws BLLException {

		try {
			dao.updateCategorie(categorie);
			;
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode addCategorie" + e.getMessage());
		}

	}

	@Override
	public void removeCategorie(Categorie categorie) throws BLLException {

		try {
			dao.deleteCategorie(categorie);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode addCategorie" + e.getMessage());
		}

	}

	@Override
	public List<Categorie> getALLCategorie() throws BLLException {
		List<Categorie> lstCategories = null;
		try {
			lstCategories = dao.selectALLCategorie();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode addCategorie" + e.getMessage());
		}
		return lstCategories;
	}

	@Override
	public Categorie getByIDCategorie(Integer idCategorie) throws BLLException {
		Categorie categorie ;
		
		try {
			categorie = dao.selectByIdCategorie(idCategorie);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode addCategorie" + e.getMessage());
		}
		return categorie;
		
	}

}
