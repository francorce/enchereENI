package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.EnchereDao;
import fr.eni.enchereENI.dao.impl.EnchereDaoImpl;

public class EnchereManager {
	public List<Enchere> getAll(){
		List <Enchere> listeEnchere = new ArrayList();
		EnchereDao enchereDao = DaoFactory.getEnchereDao();
		try {
			listeEnchere = enchereDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	}
	
	public List<Enchere> getByUserId(int userId){
		List <Enchere> listeEnchere = new ArrayList();
		EnchereDao enchereDao = DaoFactory.getEnchereDao();
		try {
			listeEnchere = enchereDao.getByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	}
	
	public List<Enchere> getByArticleId(int userId){
		List <Enchere> listeEnchere = new ArrayList();
		EnchereDao enchereDao = DaoFactory.getEnchereDao();
		try {
			listeEnchere = enchereDao.getByArticleId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	} 
	
	public void encherir() {
		
	}
	
	
}
