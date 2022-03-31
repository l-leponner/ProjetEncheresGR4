/**
 * 
 */
package fr.eni.encheres.dal.encheres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
import fr.eni.encheres.dal.categories.CategorieDAO;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

/**
 * Classe en charge de
 * 
 * @author lleponner2022
 * @date 30 mars 2022
 * @version Encheres- V0.1
 * @since 30 mars 2022 - 09:14:17
 *
 */
public class EnchereDAOImpl implements EnchereDAO {

	private final ArticleVenduDAO avDAO = DAOFactory.getArticleVenduDAO();
	private final UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();

	private final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?)";
	private final String SELECT = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES";
	private final String SELECTBYID = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES ";
	private final String UPDATE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=?";
	private final String SELECT_BY_NOARTICLE = "SELECT no_enchere, date_enchere, montant_enchere, "
			+ "a.no_article, a.no_utilisateur, a.nom_article, a.description, a.date_debut_enchere, a.date_fin_enchere, a.prix_initial, a.prix_vente, a.no_categorie, a.etat_vente "
			+ "FROM ENCHERES AS e "
			+ "INNER JOIN ARTICLES_VENDUS AS a ON e.no_article = a.no_article "
			+ "WHERE a.no_article = ?";

	/**
	 * {@inheritedDoc}
	 */

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
			stmt.setInt(2, enchere.getMontantEnchere());
			stmt.setInt(3, enchere.getArticleVendu().getNoArticle());
			stmt.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
			
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
	 * {@inheritedDoc}
	 */
	@Override
	public void updateEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
			stmt.setInt(2, enchere.getMontantEnchere());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction updateEnchere : " + e.getMessage());
		}

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<Enchere> selectAllEnchere() throws DALException {
		List<Enchere> results = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				results.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectAllEnchere : " + e.getMessage());
		}

		return results;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public Enchere selectByIDEnchere(Integer idEnchere) throws DALException {
		Enchere result = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			stmt.setInt(1, idEnchere);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = itemBuilder(rs);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectByIDEnchere : " + e.getMessage());
		}

		return result;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void deleteEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("DELETE ENCHERES WHERE no_enchere=?");
			stmt.setInt(1, enchere.getNoEnchere());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction deleteEnchere : " + e.getMessage());
		}
	}

	@Override
	public List<Enchere> selectAllEncheresByNoArticle(Integer noArticle) throws DALException {
		List<Enchere> results = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NOARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				results.add(itemBuilderByNoArticle(rs));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction selectByNoArticle : " + e.getMessage());
		}
	
		return results;
	}

	private Enchere itemBuilder(ResultSet rs) throws SQLException, DALException {

		Integer noEnchere = rs.getInt("no_enchere");
		LocalDateTime dateEnchere = rs.getTimestamp("date_enchere").toLocalDateTime();
		Integer montantEnchere = rs.getInt("montant_enchere");
		Integer noArticle = rs.getInt("no_article");
		Integer noUtilisateur = rs.getInt("no_utilisateur");

		Enchere enchere = new Enchere();
		enchere.setNoEnchere(noEnchere);
		enchere.setDateEnchere(dateEnchere);
		enchere.setMontantEnchere(montantEnchere);
		try {
			enchere.setArticleVendu(avDAO.selectByIdArticleVendu(noArticle));
		} catch (DALException e) {
			throw new DALException("Erreur dans itembuilder EnchereDAOImpl : " + e.getMessage());
		}
		try {
			enchere.setUtilisateur(uDAO.selectByIDUtilisateur(noUtilisateur));
		} catch (DALException e) {
			throw new DALException("Erreur dans itembuilder EnchereDAOImpl : " + e.getMessage());
		}

		return enchere;
	}
	private Enchere itemBuilderByNoArticle(ResultSet rs) throws SQLException, DALException {

		CategorieDAO daoCategorie = DAOFactory.getCategorieDAO();
		
		Integer noEnchere = rs.getInt("no_enchere");
		LocalDateTime dateEnchere = rs.getTimestamp("date_enchere").toLocalDateTime();
		Integer montantEnchere = rs.getInt("montant_enchere");
		Integer noArticle = rs.getInt("no_article");
		Integer noUtilisateur = rs.getInt("no_utilisateur");
		
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDateTime dateDebutEncheres = rs.getTimestamp("date_debut_enchere").toLocalDateTime();
		LocalDateTime dateFinEncheres = rs.getTimestamp("date_fin_enchere").toLocalDateTime();
		Integer miseAPrix = rs.getInt("prix_initial");
		Integer prixVente = rs.getInt("prix_vente");
		String etatVente = rs.getString("etat_vente");

		Enchere enchere = new Enchere();
		enchere.setNoEnchere(noEnchere);
		enchere.setDateEnchere(dateEnchere);
		enchere.setMontantEnchere(montantEnchere);
		
		ArticleVendu article = new ArticleVendu();
		article.setCategorie(daoCategorie.selectByIdCategorie(rs.getInt("no_categorie")));
		article.setDateDebutEncheres(dateDebutEncheres);
		article.setDateFinEncheres(dateFinEncheres);
		article.setDescription(description);
		article.setEtatVente(etatVente);
		article.setMiseAPrix(miseAPrix);
		article.setNomArticle(nomArticle);
		enchere.setArticleVendu(article);
		try {
			enchere.setUtilisateur(uDAO.selectByIDUtilisateur(noUtilisateur));
		} catch (DALException e) {
			throw new DALException("Erreur dans itembuilder EnchereDAOImpl : " + e.getMessage());
		}

		return enchere;
	}

}
