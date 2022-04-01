/**
 * 
 */
package fr.eni.encheres.bll.enchere;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 16:53:49
 *
 */
public interface EnchereBLL {

public void addEnchere (Enchere enchere) throws BLLException;
	
	public void updateEnchere (Enchere enchere) throws BLLException;
	
	public List<Enchere> getAllEnchere() throws BLLException;
	
	public Enchere getByIDEnchere(Integer idEnchere) throws BLLException;
	
	public void removeEnchere (Enchere enchere) throws BLLException;
	
	public List<Enchere> getAllArticleFilterCategorie(Categorie categorie)throws BLLException;
}
