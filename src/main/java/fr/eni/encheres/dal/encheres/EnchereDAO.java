/**
 * 
 */
package fr.eni.encheres.dal.encheres;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 09:10:06
 *
 */
public interface EnchereDAO {

public void insertEnchere (Enchere enchere) throws DALException;
	
	public void updateEnchere (Enchere enchere) throws DALException;
	
	public List<Enchere> selectAllEnchere() throws DALException;
	
	public Enchere selectByIDEnchere(Integer idEnchere) throws DALException;
	
	public void deleteEnchere (Enchere enchere) throws DALException;
	
	public List<Enchere> selectAllEncheresByNoArticle(Integer noArticle) throws DALException;

	
}
