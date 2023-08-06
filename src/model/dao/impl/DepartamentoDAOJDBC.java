package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.DepartamentoDAO;
import model.entities.Departamento;

public class DepartamentoDAOJDBC implements DepartamentoDAO {
	
	private Connection conn;
	
	public DepartamentoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Departamento obj) {
		
	}

	@Override
	public void update(Departamento obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Departamento findById(Integer id) {
		// 
		return null;
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select departamento.* from departamento "
					+ "order by nome");
						
			rs = st.executeQuery();
			List<Departamento> list = new ArrayList<>();
			
			while (rs.next()) {
				
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
