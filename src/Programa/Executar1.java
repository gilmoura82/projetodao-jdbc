package Programa;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Executar1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n=== TESTE 5: vendedor update ===");
		vendedor = vendedorDAO.findById(1);
		vendedor.setNome("Carlos Moraes");
		vendedorDAO.update(vendedor);
		System.out.println("Vendedor atualizado: " + vendedor.getNome());
		System.out.println("Atualização concluída");
		
		System.out.println("\n=== TESTE 6: vendedor delete ===");
		System.out.println("Insira o código do vendedor para excluir: ");
		int id = sc.nextInt();
		vendedorDAO.deleteById(id);
		System.out.println("Exclusão concluída: " + "\n" + "Vendedor: " +
		vendedor.getNome() + "\n" + "ID: " + id);
		
	}

}
