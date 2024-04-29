package web1.repositories;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web1.helpers.DataBaseHelper;
import web1.models.Libro;

public class LibroRepository {
	
	public List<String> buscarTodasLasCategorias() throws ClassNotFoundException, SQLException {
		String sql = "SELECT DISTINCT(categoria) FROM libros";
		ResultSet result = DataBaseHelper.executeQuery(sql);
		List<String> lista = new ArrayList<String>();
		while(result.next()) {
			lista.add(result.getString("categoria"));
		}
		return lista;
	}
	
	public void insertar(Libro libro) {
		String sql = "INSERT INTO libros(isbn, titulo, categoria) VALUES(?,?,?)";
		DataBaseHelper.executeUpdate(sql, libro.getIsbn(), libro.getTitulo(), libro.getCategoria());
	}
	
	public List<Libro> buscarTodos() {
		List<Libro> lista = new ArrayList<Libro>();
		String sql = "SELECT *FROM libros";
		ResultSet resultSet = null;
		resultSet = DataBaseHelper.executeQuery(sql);
		try {
			while(resultSet.next()) {
				lista.add(
						new Libro(
								resultSet.getString("isbn"), 
								resultSet.getString("titulo"),
								resultSet.getString("categoria")
								)
						);
			}			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
				DataBaseHelper.close(
						resultSet.getStatement().getConnection(),
						(PreparedStatement)resultSet.getStatement(),
						resultSet
						);
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return lista;
	}
	
	public List<Libro> buscarTodosPorCategoria(String categoria) throws SQLException {
		List<Libro> lista = new ArrayList<Libro>();
		String sql = "SELECT *FROM libros WHERE categoria=?";
		ResultSet resultSet = DataBaseHelper.executeQuery(sql, categoria);
		try {
			while(resultSet.next()) {
				lista.add(
						new Libro(
								resultSet.getString("isbn"),
								resultSet.getString("titulo"),
								resultSet.getString("categoria")
								)
						);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				DataBaseHelper.close(
						resultSet.getStatement().getConnection(),
						(PreparedStatement)resultSet.getStatement(),
						resultSet
						);
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return lista;
	}
	
	public void borrar(Libro libro) {
		String sql = "DELETE FROM libros WHERE isbn = ?";
		DataBaseHelper.executeUpdate(sql, libro.getIsbn());
	}

}
