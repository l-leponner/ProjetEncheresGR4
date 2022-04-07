/**
 * 
 */
package fr.eni.encheres.bll.retraits;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.retrait.RetraitDAO;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 31 mars 2022
 */
public class RetraitManagerImpl implements RetraitManager {

	RetraitDAO dao = DAOFactory.getRetraitDAO();

	@Override
	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException {
		retrait.setNoArticleVendu(articleVendu.getNoArticle());
		
		
		try {
			
			dao.insertRetrait(retrait);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode addRetrait" + e.getMessage());
		}

	}

	@Override
	public void updateRetrait(Retrait retrait) throws BLLException {
		try {
			dao.updateRetrait(retrait);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode updateRetrait" + e.getMessage());
		}

	}

	@Override
	public void removeRetrait(Retrait retrait) throws BLLException {
		try {
			dao.deleteRetrait(retrait);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode removeRetrait" + e.getMessage());
		}

	}

	@Override
	public List<Retrait> getALLRetrait() throws BLLException {
		List<Retrait> lstRetraits = null;
		try {
			lstRetraits = dao.selectALLRetrait();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode getALLRetrait" + e.getMessage());
		}
		return lstRetraits;
	}

	@Override
	public Retrait getByIDRetrait(Integer idRetrait) throws BLLException {
		Retrait retrait;

		try {
			retrait = dao.selectByIdRetrait(idRetrait);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode getByIDRetrait" + e.getMessage());
		}
		return retrait;
	}

}
