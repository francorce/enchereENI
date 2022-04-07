package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.dao.CategorieDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class CategorieManager {
	public List<Categorie> getAll(){
		List <Categorie> listeCategorie = new ArrayList();
		CategorieDao categorieDao = DaoFactory.getCategorieDao();
		try {
			listeCategorie = categorieDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeCategorie;
	}
}
