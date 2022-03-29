/**
 * 
 */
package fr.eni.encheres.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.util.ConnectionProvider;


/**
 * Classe en charge de
 * @author lleponner2022
 * @date 29 mars 2022
 * @version Encheres- V0.1
 * @since  29 mars 2022 - 14:09:19
 *
 */
public class UtilisateurDAOImpl implements UtilisateurDAO{

	private final String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS";
	private final String UPDATE = "UPDATE UTILISATEURS SET pseudo=?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";
	
	
	/**
	*{@inheritedDoc}
	*/
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.isAdministrateur());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					utilisateur.setNoUtilisateur(1);
				}
			}
				
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction insertUtilisateur : " + e.getMessage());
		}
			
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.isAdministrateur());
			stmt.setInt(12, utilisateur.getNoUtilisateur());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction updateUtilisateur : " + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public List<Utilisateur> selectAllUtilisateur() {
		List<Utilisateur> results = new ArrayList<Utilisateur>();
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				results.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectAllUtilisateur : " + e.getMessage());
		}
		return results;
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public Utilisateur selectByIDutilisateur(Integer idUtilisateur) {
		Utilisateur result = null;
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE no_utilisateur=?");
			stmt.setInt(1, idUtilisateur);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = itemBuilder(rs);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectByIDutilisateur : " + e.getMessage());
		}
		return result;
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("DELETE UTILISATEURS WHERE no_utilisateur=?");
			stmt.setInt(1, utilisateur.getNoUtilisateur());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction deleteUtilisateur : " + e.getMessage());
		}	
	}

	private Utilisateur itemBuilder (ResultSet rs) throws SQLException {
		
		Integer noUtilisateur = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String codePostal = rs.getString("codePostal");
		String ville = rs.getString("ville");
		String motDePasse = rs.getString("motDePasse");
		Integer credit = rs.getInt("credit");
		boolean administrateur = rs.getBoolean("administrateur");
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNoUtilisateur(noUtilisateur);
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setAdministrateur(administrateur);
		return utilisateur;
	}
}
