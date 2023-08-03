package Programa;

import model.dao.DaoFactory;
import model.dao.VendedorDAO;
import model.entities.Vendedor;

public class Executar {
	
	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = DaoFactory.createVendedorDao();
		
		Vendedor vendedor = vendedorDAO.findById(8);
		
		System.out.println(vendedor);
		
	}

}
