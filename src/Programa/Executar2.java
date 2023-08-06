package Programa;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDAO;
import model.entities.Departamento;


public class Executar2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartamentoDAO departamentoDao = DaoFactory.createDepartamentoDao();
		
		System.out.println("\n=== TESTE 1: Departamento findAll ===");
		List<Departamento> list = departamentoDao.findAll();
		
		for (Departamento obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 2: Departamento findById ===");
		Departamento departamento = departamentoDao.findById(1);
		System.out.println(departamento);
		
		System.out.println("\n=== TESTE 3: Departamento insert no banco de dados ===");
		Departamento novoDepartamento = new Departamento(null, "Utilidades Para O Lar");
		departamentoDao.insert(novoDepartamento);
		System.out.println("Novo Id inserido: " + novoDepartamento.getId() + "\n" + "Departamento: " + novoDepartamento.getNome());
		
		System.out.println("\n=== TESTE 4: Departamento update no banco de dados ===");
		departamento = departamentoDao.findById(1);
		departamento.setNome("Computadores & Celulares");
		departamentoDao.update(departamento);
		System.out.println("Departamento atualizado: " + departamento.getNome());
		System.out.println("Atualização concluída");
		
		System.out.println("\n=== TESTE 5: Departamento delete no banco de dados ===");
		System.out.println("Insira o código do departamento para excluir: ");
		int id = sc.nextInt();
		departamentoDao.deleteById(id);
		System.out.println("Exclusão concluída: " + "\n" + "Departamento: " +
		departamento.getNome() + "\n" + "ID: " + id);
		
		
		
		

	}

}
