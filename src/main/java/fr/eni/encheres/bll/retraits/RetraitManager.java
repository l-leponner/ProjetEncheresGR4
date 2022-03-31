/**
 * 
 */
package fr.eni.encheres.bll.retraits;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;

/**
 * Class en charge de 
 * @author alegeas2022
 * @date 31 mars 2022
 */
public interface RetraitManager {

public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException;
	
	public void updateRetrait(Retrait retrait) throws BLLException;
	
	public void removeRetrait(Retrait retrait) throws BLLException;
	
	public List<Retrait> getALLRetrait() throws BLLException;
	
	public Retrait getByIDRetrait(Integer idRetrait) throws BLLException;
	
}
