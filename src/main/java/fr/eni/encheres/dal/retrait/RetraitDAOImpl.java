/**
 * 
 */
package fr.eni.encheres.dal.retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
import fr.eni.encheres.dal.util.ConnectionProvider;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 29 mars 2022
 */
public class RetraitDAOImpl implements RetraitDAO {

	private final String INSERT = "INSERT INTO RETRAITS (rue, code_postal, ville, no_article) VALUES (?,?,?,?)";
	private final String SELECTALL = "SELECT no_article, rue, code_postal, ville FROM RETRAITS";
	private final String UPDATE = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
	private final String SELECT_BY_ID = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article = ?";
	private final String DELETE = "DELETE FROM RETRAITS WHERE no_article = ?";

	@Override
	public void insertRetrait(Retrait retrait) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT);
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			stmt.setInt(4, retrait.getNoArticleVendu());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode insertRetrait" + e.getMessage());
		}

	}

	@Override
	public void updateRetrait(Retrait retrait) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			stmt.setInt(4, retrait.getNoArticleVendu());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction updateRetrait : " + e.getMessage());
		}

	}

	@Override
	public List<Retrait> selectALLRetrait() throws DALException {
		List<Retrait> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Retrait item = null;
				item = itemBuilder(rs);
				result.add(item);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectALLRetrait : " + e.getMessage());
		}
		return result;
	}

	@Override
	public Retrait selectByIdRetrait(Integer idRetrait) throws DALException {
		Retrait result = new Retrait();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, idRetrait);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = itemBuilder(rs);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectByIdRetrait : " + e.getMessage());
		}
		return result;
	}

	@Override
	public void deleteRetrait(Retrait retrait) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, retrait.getNoArticleVendu());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction deleteRetrait : " + e.getMessage());
		}

	}

	private Retrait itemBuilder(ResultSet rs) throws SQLException, DALException {

		ArticleVenduDAO dao = DAOFactory.getArticleVenduDAO();
		
		Integer noArticle = rs.getInt("no_article");
		String rue = rs.getString("rue").trim();
		String code_postal = rs.getString("code_postal").trim();
		String ville = rs.getString("ville").trim();

		
		Retrait retrait = new Retrait(rue, code_postal, ville);
		retrait.setNoArticleVendu(noArticle);;

		return retrait;
	}

}
