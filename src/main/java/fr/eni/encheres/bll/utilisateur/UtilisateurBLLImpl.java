/**
 * 
 */
package fr.eni.encheres.bll.utilisateur;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 14:41:24
 *
 */
public class UtilisateurBLLImpl implements UtilisateurBLL{

	UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
	
	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void addUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			uDAO.insertUtilisateur(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode addUtilisateur" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			uDAO.updateUtilisateur(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode updateUtilisateur" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public List<Utilisateur> getAllUtilisateur() throws BLLException {
		try {
			return uDAO.selectAllUtilisateur();
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getAllUtilisateur" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public Utilisateur getByIDUtilisateur(Integer idUtilisateur) throws BLLException {
		
		try {
			return uDAO.selectByIDUtilisateur(idUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode getByIDUtilisateur" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void removeUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			uDAO.deleteUtilisateur(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème dans la méthode removeUtilisateur" + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void controlMDP(String MDP, String confirmationMDP) throws BLLException {
		if (!confirmationMDP.equals(MDP)) {
			throw new BLLException("Mot de passe et confirmation de mot de passe différents svp");
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void inscriptionUtilisateur(Utilisateur utilisateur, String confirmationMDP) throws BLLException {
		try {
			controlMDP(utilisateur.getMotDePasse(), confirmationMDP);
			addUtilisateur(utilisateur);
		} catch (BLLException e) {
			throw new BLLException("Erreur dans la méthode inscriptionUtilisateur : " +e.getMessage());
		}
	}

}
