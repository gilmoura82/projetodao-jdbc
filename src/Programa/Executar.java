package Programa;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Executar {
	
	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = DaoFactory.createVendedorDao();
		
		System.out.println("=== TESTE 1: vendedor findById ===");
		Vendedor vendedor = vendedorDAO.findById(8);
		System.out.println(vendedor);
		
		System.out.println("\n=== TESTE 2: vendedor findByDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDAO.findByDepartamento(departamento);	
		
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3: vendedor findAll ===");
		list = vendedorDAO.findAll();	
		
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 4: vendedor insert ===");
		Vendedor novoVendedor = new Vendedor(null, "Carlos Eduardo", "carlosedu@email.com", new Date(), 4000.0, departamento);
		vendedorDAO.insert(novoVendedor);
		System.out.println("Novo Id inserido: " + novoVendedor.getId() + "\n" + "Vendedor: " + novoVendedor.getNome());
	}

}
