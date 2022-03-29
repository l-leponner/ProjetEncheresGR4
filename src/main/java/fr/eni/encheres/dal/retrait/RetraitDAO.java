/**
 * 
 */
package fr.eni.encheres.dal.retrait;

import java.util.List;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public interface RetraitDAO {

	public void insertRetrait(Retrait retrait) throws DALException;

	public void updateRetrait(Retrait retrait) throws DALException;

	public List<Retrait> selectALLRetrait() throws DALException;

	public List<Retrait> selectByIdRetrait(Retrait retrait) throws DALException;

	public void deleteRetrait(Retrait retrait) throws DALException;


}
