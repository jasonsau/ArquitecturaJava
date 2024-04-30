package web1.repositories;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web1.helpers.DataBaseHelper;
import web1.models.Categoria;
import web1.models.Libro;

public class LibroRepositoryJDBC implements ILibroRepository {
	
	@Override
	public List<String> buscarTodasLasCategorias() {
		String sql = "SELECT DISTINCT(categoria) FROM libros";
		ResultSet result = DataBaseHelper.executeQuery(sql);
		List<String> lista = new ArrayList<String>();
		try {
			while(result.next()) {
				lista.add(result.getString("categoria"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public void insertar(Libro libro) {
		String sql = "INSERT INTO libros(isbn, titulo, categoria) VALUES(?,?,?)";
		DataBaseHelper.executeUpdate(sql, libro.getIsbn(), libro.getTitulo(), libro.getCategoria().getId());
	}
	
	@Override
	public List<Libro> buscarTodos() {
		List<Libro> lista = new ArrayList<Libro>();
		String sql = "SELECT *FROM libros l INNER JOIN categorias c ON l.categoria = c.id";
		ResultSet resultSet = null;
		resultSet = DataBaseHelper.executeQuery(sql);
		try {
			while(resultSet.next()) {
				lista.add(
						new Libro(
								resultSet.getString("isbn"), 
								resultSet.getString("titulo"),
								new Categoria(resultSet.getInt("categoria"), resultSet.getString("nombre"))
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

	@Override
	public List<Libro> buscarTodosPorCategoria(Integer categoria) {
		List<Libro> lista = new ArrayList<Libro>();
		String sql = "SELECT *FROM libros l INNER JOIN categorias c ON l.categoria = c.id WHERE c.id = ?";
		ResultSet resultSet = DataBaseHelper.executeQuery(sql, categoria);
		try {
			while(resultSet.next()) {
				lista.add(
						new Libro(
								resultSet.getString("isbn"),
								resultSet.getString("titulo"),
								new Categoria(resultSet.getInt("id"), resultSet.getString("nombre"))
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

	@Override
	public void borrar(String isbn) {
		String sql = "DELETE FROM libros WHERE isbn = ?";
		DataBaseHelper.executeUpdate(sql, isbn);
	}

}
