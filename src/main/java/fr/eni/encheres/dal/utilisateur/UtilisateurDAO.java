/**
 * 
 */
package fr.eni.encheres.dal.utilisateur;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 29 mars 2022
 * @version Encheres- V0.1
 * @since  29 mars 2022 - 14:01:46
 *
 */
public interface UtilisateurDAO {

	public void insertUtilisateur (Utilisateur utilisateur) throws DALException;
	
	public void updateUtilisateur (Utilisateur utilisateur) throws DALException;
	
	public List<Utilisateur> selectAllUtilisateur() throws DALException;
	
	public Utilisateur selectByIDutilisateur(Integer idUtilisateur) throws DALException;
	
	public void deleteUtilisateur (Utilisateur utilisateur) throws DALException;
	
}
