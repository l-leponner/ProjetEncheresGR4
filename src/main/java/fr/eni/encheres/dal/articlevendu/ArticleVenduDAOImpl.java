/**
 * 
 */
package fr.eni.encheres.dal.articlevendu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * 
 * @author ggastine2022
 * @date 29 mars 2022
 * @version ProjetEncheresGR4- V0.1
 * @since 29 mars 2022 - 14:08:59
 *
 */
public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	private final String SELECT = "SELECT noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente FROM ARTICLE_VENDUS WHERE noArticle =?";
	private final String INSERT = "INSERT INTO ARTICLE_VENDUS (nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente FROM articlevendu) VALUES (?,?,?,?,?,?,?)";
	private final String SELECTALL = "SELECT noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente FROM ARTICLE_VENDUS";
	private final String UPDATE = "UPDATE ARTICLES_VENDUS set noArticle =?, nomArticle =?, description =?, dateDebutEncheres =?, dateFinEncheres =?, miseAPrix =?, prixVente =?, etatVente =? FROM ARTICLE_VENDUS WHERE noArticle =?";
	private final String DELETE = "DELETE FROM ARTICLE_VENDUS WHERE noArticle =?";

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void insertArticleVendu(ArticleVendu articlevendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articlevendu.getNomArticle());
			stmt.setString(2, articlevendu.getDescription());
			stmt.setDate(3, Date.valueOf(articlevendu.getDateDebutEncheres()));
			stmt.setDate(4, Date.valueOf(articlevendu.getDateFinEncheres()));
			stmt.setInt(5, articlevendu.getMiseAPrix());
			stmt.setInt(6, articlevendu.getPrixVente());
			stmt.setString(7, articlevendu.getEtatVente());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articlevendu.setNoArticle(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("pb lors de la méthode insertArticleVendu" + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void selectByIdArticleVendu(ArticleVendu articlevendu) throws DALException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<ArticleVendu> selectAllArticleVendu() throws DALException {
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu articlevendu = new ArticleVendu(rs.getString("nomArticle"), rs.getString("description"),
						rs.getDate("dateDebutEncheres").toLocalDate(), rs.getDate("dateFinEncheres").toLocalDate(),
						rs.getInt("miseAPrix"), rs.getInt("prixVente"), rs.getString("etatVente"));
				articlevendu.setNoArticle(rs.getInt("noArticle"));
				result.add(articlevendu);
			}

		} catch (SQLException e) {
			throw new DALException("pb lors de la méthode selectAllArticleVendu" + e.getMessage());
		}
		return result;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void deleteArticleVendu(ArticleVendu articlevendu) throws DALException {
		// TODO Auto-generated method stub

		try {

		} catch (SQLException e) {
			throw new DALException("pb lors de la méthode deleteArticleVendu" + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void updateArticleVendu(ArticleVendu articlevendu) throws DALException {
		try {

		} catch (SQLException e) {
			throw new DALException("pb lors de la méthode updateArticleVendu" + e.getMessage());
		}
		// TODO Auto-generated method stub

	}

}
