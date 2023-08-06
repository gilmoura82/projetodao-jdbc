package Programa;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartamentoDAO;
import model.entities.Departamento;


public class Executar2 {

	public static void main(String[] args) {
		
		DepartamentoDAO departamentoDao = DaoFactory.createDepartamentoDao();
		
		System.out.println("\n=== TESTE 1: Departamento findAll ===");
		List<Departamento> list = departamentoDao.findAll();
		
		for (Departamento obj : list) {
			System.out.println(obj);
		}
		
		

	}

}
