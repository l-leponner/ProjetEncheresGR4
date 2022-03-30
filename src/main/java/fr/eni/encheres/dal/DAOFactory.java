package fr.eni.encheres.dal;

import fr.eni.encheres.dal.encheres.EnchereDAO;
import fr.eni.encheres.dal.encheres.EnchereDAOImpl;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.retrait.RetraitDAOImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAOImpl;

/**
 * Classe en charge de 
 * @author lleponner2022
 * @date 28 mars 2022
 */
public class DAOFactory {

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
