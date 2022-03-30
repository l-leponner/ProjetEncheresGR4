/**
 * 
 */
package fr.eni.encheres.dal.retrait;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public class RetraitDAOTest {

	public static void main(String[] args) throws DALException {

		RetraitDAO dao = DAOFactory.getRetraitDAO();

		Retrait retrait1 = new Retrait(1, "Rue Arthur", "35136", "Ville Gabriel");
		Retrait retrait2 = new Retrait(1, "Rue Arthur2", "35136", "Ville Gabriel2");
		

		try {
			dao.insertRetrait(retrait1);
			dao.insertRetrait(retrait2);
		} catch (DALException e) {
			throw new DALException("Erreur" + e.getMessage());
		}
	}

}
