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
			controlUnicite(utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getMotDePasse());
			addUtilisateur(utilisateur);
		} catch (BLLException e) {
			throw new BLLException(e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void controlUnicite(String pseudo, String email, String motDePasse) throws BLLException {
		try {
			for (Utilisateur u : getAllUtilisateur()) {
				if(pseudo.equalsIgnoreCase(u.getPseudo())){
					throw new BLLException("Erreur : Pseudo déjà existant");
				}
				if(email.equalsIgnoreCase(u.getEmail())) {
					throw new BLLException("Erreur : Email déjà existant");
				}
				if(motDePasse.equalsIgnoreCase(u.getMotDePasse())) {
					throw new BLLException("Erreur : Mot de passe déjà existant");
				}
			}
		} catch (BLLException e) {
			throw new BLLException("Erreur dans la méthode controlUnicite : " +e.getMessage());
		}		
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void controlNouveauMDP(String actuelMDP, String nouveauMDP) throws BLLException {

		if(actuelMDP.equals(nouveauMDP)) {
			throw new BLLException("Erreur : Le nouveau mot de passe et l'ancien mot de passe doivent être différents svp !");
		}
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public Utilisateur getByIdentifiant(String sessionPseudo, String sessionEmail) throws BLLException {
		List<Utilisateur> lstUtilisateurs;
		Utilisateur utilisateur = null;
		try {
			lstUtilisateurs = uDAO.selectAllUtilisateur();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode getByIdentifiant : " +e.getMessage());
		}
		for (Utilisateur u : lstUtilisateurs) {
			if(u.getPseudo().equals(sessionPseudo) || u.getEmail().equals(sessionEmail)) {
				utilisateur = u;
			}
		}
		return utilisateur;
	}

	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public void controlUtilisateurExistant(String pseudo, String email, String motDePasse) throws BLLException {

		List<Utilisateur> lstUtilisateurs;
		Utilisateur utilisateur = null;
		try {
			lstUtilisateurs = uDAO.selectAllUtilisateur();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la méthode controlUtilisateurExistant : " +e.getMessage());
		}
		for (Utilisateur u : lstUtilisateurs) {
			if((!u.getPseudo().equals(pseudo) || !u.getEmail().equals(email))) {
				throw new BLLException("Identifiant inconnu");
			}
			if(!u.getMotDePasse().equals(motDePasse)) {
				throw new BLLException("Mot de passe inconnu");
			}
		}
	}
	
	

}
