/**
 * 
 */
package fr.eni.encheres.dal.categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public class CategoriesDAOImpl implements CategoriesDAO {

	private final String INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	private final String SELECTALL = "SELECT no_categorie, libelle FROM CATEGORIES";
	private final String UPDATE = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?";
	private final String SELECT_BY_ID = "SELECT libelle FROM CATEGORIES WHERE no_categorie = ?";
	private final String DELETE = "DELETE FROM CATEGORIES WHERE no_categorie = ?";

	@Override
	public void insertCategorie(Categorie categorie) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode insertRetrait" + e.getMessage());
		}

	}

	@Override
	public void updateCategorie(Categorie categorie) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, categorie.getLibelle());
			stmt.setInt(2, categorie.getNoCategorie());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction UPDATE : " + e.getMessage());
		}

	}

	@Override
	public List<Categorie> selectALLCategorie() throws DALException {
		List<Categorie> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Categorie item = null;
				item = itemBuilder(rs);
				result.add(item);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction SELECTALL : " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Categorie> selectByIdCategorie(Categorie categorie) throws DALException {
		List<Categorie> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, categorie.getNoCategorie());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Categorie item = null;
				item = itemBuilder(rs);
				result.add(item);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction SELECT_BY_ID : " + e.getMessage());
		}
		return result;
	}

	@Override
	public void deleteCategorie(Categorie categorie) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, categorie.getNoCategorie());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction DELETE : " + e.getMessage());
		}

	}

	private Categorie itemBuilder(ResultSet rs) throws SQLException {

		int noCategorie = rs.getInt("no_categorie");
		String libelle = rs.getString("libelle");

		Categorie categorie = new Categorie(libelle);
		categorie.setNoCategorie(noCategorie);
		
		return categorie;
	}
	
}
