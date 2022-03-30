/**
 * 
 */
package fr.eni.encheres.bll.enchere;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.encheres.EnchereDAO;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 16:56:06
 *
 */
public class EnchereBLLImpl implements EnchereBLL{

	EnchereDAO eDAO = DAOFactory.getEnchereDAO();
	/**
	*{@inheritedDoc}
	*/
	@Override
	public void addEnchere(Enchere enchere) throws BLLException {
		try {
			eDAO.insertEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode addEnchere" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public void updateEnchere(Enchere enchere) throws BLLException {
		try {
			eDAO.updateEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode updateEnchere" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public List<Enchere> getAllEnchere() throws BLLException {
		
		try {
			return eDAO.selectAllEnchere();
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllEnchere" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public Enchere getByIDEnchere(Integer idEnchere) throws BLLException {
		try {
			return eDAO.selectByIDEnchere(idEnchere);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getByIDEnchere" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public void removeEnchere(Enchere enchere) throws BLLException {
		try {
			eDAO.deleteEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode removeEnchere" + e.getMessage());
		}
	}

}
