package model.dao;

import model.dao.impl.VendedorDAOJDBC;

public class DaoFactory {

	public static VendedorDAO createVendedorDao() {
		return new VendedorDAOJDBC();
	}
}
