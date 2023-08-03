package model.dao;

import db.DB;
import model.dao.impl.VendedorDAOJDBC;

public class DaoFactory {

	public static VendedorDAO createVendedorDao() {
		return new VendedorDAOJDBC(DB.getConnection());
	}
}
