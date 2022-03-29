/**
 * 
 */
package fr.eni.encheres.dal.utilisateur;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 29 mars 2022
 * @version Encheres- V0.1
 * @since  29 mars 2022 - 14:01:46
 *
 */
public interface UtilisateurDAO {

	public void insertUtilisateur (Utilisateur utilisateur);
	
	public void updateUtilisateur (Utilisateur utilisateur);
	
	public List<Utilisateur> selectAllUtilisateur();
	
	public Utilisateur selectByIDutilisateur(Integer idUtilisateur);
	
	public void deleteUtilisateur (Utilisateur utilisateur);
	
}
