/**
 * 
 */
package fr.eni.encheres.dal.categories;

import java.util.Iterator;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Class en charge de
 * 
 * @author alegeas2022
 * @date 30 mars 2022
 */
public class CategorieDAOTest {

	/**
	 * @param args
	 * @throws DALException
	 */
	public static void main(String[] args) throws DALException {

		CategorieDAO dao = DAOFactory.getCategorieDAO();

		Categorie cat1 = new Categorie("Arthur");
		Categorie cat2 = new Categorie("Laurent");
		Categorie cat3 = new Categorie("Gabriel");

		// Insertion
		try {
			dao.insertCategorie(cat1);
			dao.insertCategorie(cat2);
			dao.insertCategorie(cat3);
		} catch (DALException e) {
			throw new DALException("Erreur : " + e.getMessage());
		}

		// SelectALL
		try {			
			for (Categorie string : dao.selectALLCategorie()) {
				System.out.println(string);
			}
			
		} catch (DALException e) {
			throw new DALException("Erreur : " + e.getMessage());
		}

		// Update
		cat1.setLibelle("MArthur");

		try {
			dao.updateCategorie(cat1);
		} catch (DALException e) {
			throw new DALException("Erreur : " + e.getMessage());
		}

		// SelectByID
		try {
			System.out.println(dao.selectByIdCategorie(cat1));
		} catch (DALException e) {
			throw new DALException("Erreur : " + e.getMessage());
		}

		// Delete
		try {
			dao.deleteCategorie(cat3);
		} catch (DALException e) {
			throw new DALException("Erreur : " + e.getMessage());
		}

		// SelectALL
		try {
			for (Categorie string : dao.selectALLCategorie()) {
				System.out.println(string);
			}
		} catch (DALException e) {
			throw new DALException("Erreur : " + e.getMessage());
		}
		
	}

}
