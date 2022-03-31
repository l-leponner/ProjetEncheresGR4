/**
 * 
 */
package fr.eni.encheres.dal.articlevendu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.categories.CategorieDAO;
import fr.eni.encheres.dal.encheres.EnchereDAO;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

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

	private final String SELECTBYID = "SELECT no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM ARTICLES_VENDUS Where no_article = ?";

	private final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente) VALUES (?,?,?,?,?,?,?,?)";
	private final String SELECTALL = "SELECT no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM ARTICLES_VENDUS";

	private final String UPDATE = "UPDATE ARTICLES_VENDUS set nom_article =?, description =?, date_debut_enchere = ?, date_fin_enchere = ?, prix_initial = ?, prix_vente =?, etat_vente = ? FROM ARTICLES_VENDUS WHERE no_article = ?";
	private final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article =?";

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void insertArticleVendu(ArticleVendu articlevendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, articlevendu.getNomArticle());
			stmt.setString(2, articlevendu.getDescription());
			stmt.setTimestamp(3, Timestamp.valueOf(articlevendu.getDateDebutEncheres()));
			stmt.setTimestamp(4, Timestamp.valueOf(articlevendu.getDateFinEncheres()));
			stmt.setInt(5, articlevendu.getMiseAPrix());
			stmt.setInt(6, articlevendu.getUtilisateur().getNoUtilisateur());
			stmt.setInt(7, articlevendu.getCategorie().getNoCategorie());
			stmt.setString(8, articlevendu.getEtatVente());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articlevendu.setNoArticle(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode insertArticleVendu" + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public ArticleVendu selectByIdArticleVendu(Integer IDArticleVendu) throws DALException {
		ArticleVendu result = new ArticleVendu();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			stmt.setInt(1, IDArticleVendu);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {

				result = itemBuilder(rs);
			}
		}

		catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode selectByIdArticleVendu" + e.getMessage());
		}
		return result;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<ArticleVendu> selectAllArticleVendu() throws DALException {
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				ArticleVendu item = null;
				item = itemBuilder(rs);
				result.add(item);
			}
		}

		catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode selectAllArticleVendu" + e.getMessage());
		}
		return result;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void deleteArticleVendu(ArticleVendu articleVendu) throws DALException {
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE);

			stmt.setInt(1, articleVendu.getNoArticle());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode deleteArticleVendu" + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void updateArticleVendu(ArticleVendu articlevendu) throws DALException {

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);

			stmt.setString(1, articlevendu.getNomArticle());
			stmt.setString(2, articlevendu.getDescription());
			stmt.setTimestamp(3, Timestamp.valueOf(articlevendu.getDateDebutEncheres()));
			stmt.setTimestamp(4, Timestamp.valueOf(articlevendu.getDateFinEncheres()));
			stmt.setInt(5, articlevendu.getMiseAPrix());
			stmt.setInt(6, articlevendu.getPrixVente());
			stmt.setString(7, articlevendu.getEtatVente());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Probleme lors de la méthode updateArticleVendu" + e.getMessage());
		}

	}

	private ArticleVendu itemBuilder(ResultSet rs) throws SQLException, DALException {

		RetraitDAO daoRetrait = DAOFactory.getRetraitDAO();
		CategorieDAO daoCategorie = DAOFactory.getCategorieDAO();
		UtilisateurDAO daoUtilisateur = DAOFactory.getUtilisateurDAO();
		EnchereDAO daoEnchere = DAOFactory.getEnchereDAO();

		ArticleVendu result = null;

		Integer noArticle = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDateTime dateDebutEncheres = rs.getTimestamp("date_debut_enchere").toLocalDateTime();
		LocalDateTime dateFinEncheres = rs.getTimestamp("date_fin_enchere").toLocalDateTime();
		Integer miseAPrix = rs.getInt("prix_initial");
		Integer prixVente = rs.getInt("prix_vente");
		String etatVente = rs.getString("etat_vente");

		Retrait lieuRetrait;
		Categorie categorie;
		Utilisateur utilisateur;

		try {

			lieuRetrait = daoRetrait.selectByIdRetrait(rs.getInt("no_article"));
			categorie = daoCategorie.selectByIdCategorie(rs.getInt("no_categorie"));
			utilisateur = daoUtilisateur.selectByIDUtilisateur(rs.getInt("no_utilisateur"));

		} catch (DALException | SQLException e) {
			throw new DALException("Erreur dans l'itembuilder" + e.getMessage());
		}
		

			result = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, etatVente);	
			result.setNoArticle(noArticle);
			result.setLstEncheres(daoEnchere.selectByNoArticle(noArticle));
			result.setPrixVente(prixVente);
			result.setLieuRetrait(lieuRetrait);
			result.setCategorie(categorie);
			result.setUtilisateur(utilisateur);

		return result;
	}
}
