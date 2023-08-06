package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.DepartamentoDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class DepartamentoDAOJDBC implements DepartamentoDAO {
	
	private Connection conn;
	
	public DepartamentoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"insert into departamento "
					+ "(nome) "
					+ "values " 
					+ "(?)",
					Statement.RETURN_GENERATED_KEYS);		
					
			st.setString(1, obj.getNome());
			
					
			int linhasAfetadas = st.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado, nenhuma linha foi inserida");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"update departamento "
					+ " set nome = ? "
					+ " where id = ? ");		
					
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getId());
						
			st.executeUpdate();
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("delete from departamento where id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Departamento findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select departamento.* from departamento where departamento.id = ?");
					
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
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
