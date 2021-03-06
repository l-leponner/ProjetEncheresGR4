/**
 * 
 */
package fr.eni.encheres.bll.utilisateur;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 14:41:09
 *
 */
public interface UtilisateurBLL {

	public void addUtilisateur (Utilisateur utilisateur) throws BLLException;
	
	public void updateUtilisateur (Utilisateur utilisateur) throws BLLException;
	
	public List<Utilisateur> getAllUtilisateur() throws BLLException;
	
	public Utilisateur getByIDUtilisateur(Integer idUtilisateur) throws BLLException;
	
	public Utilisateur getByIdentifiantMDP(String identifiant, String MDP) throws BLLException;
	
	public Utilisateur getByIdentifiant (String identifiant) throws BLLException;
	
	public void removeUtilisateur (Utilisateur utilisateur) throws BLLException;
	
	public void controlMDP(String MDP, String confirmationMDP) throws BLLException;
	
	public void inscriptionUtilisateur(Utilisateur utilisateur, String confirmationMDP) throws BLLException;
	
	public void controlUnicite(String pseudo, String email) throws BLLException;
	
	public void controlNouveauMDP (String actuelMDP, String nouveauMDP) throws BLLException;
	
	public void controlUtilisateurExistant (String identifiant, String motDePasse) throws BLLException;
	
	public void peutEncherir (Integer creditUtilisateur, Integer montantEnchere) throws BLLException;
}
