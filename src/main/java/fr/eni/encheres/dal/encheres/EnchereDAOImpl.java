/**
 * 
 */
package fr.eni.encheres.dal.encheres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since  30 mars 2022 - 09:14:17
 *
 */
public class EnchereDAOImpl implements EnchereDAO{

	private final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere) VALUES (?,?)";
	private final String SELECT = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES";
	private final String UPDATE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=?";
	/**
	*{@inheritedDoc}
	*/
	
	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(1, enchere.getMontantEnchere());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					enchere.setNoEnchere(1);
				}
			}
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction insertEnchere : " + e.getMessage());
		}
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public void updateEnchere(Enchere enchere) throws DALException {
		
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public List<Enchere> selectAllEnchere() throws DALException {
		return null;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public Enchere selectByIDEnchere(Integer idEnchere) throws DALException {
		return null;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public void deleteEnchere(Enchere enchere) throws DALException {
		
	}

}
