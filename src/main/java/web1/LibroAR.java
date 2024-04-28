package web1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroAR {
	
	private String isbn;
	private String titulo;
	private String categoria;
	
	public LibroAR(String isbn, String titulo, String categoria) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;	
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public static List<String> buscarTodasLasCategorias() throws ClassNotFoundException, SQLException {
		String sql = "SELECT DISTINCT(categoria) FROM libros";
		ResultSet result = DataBaseHelper.executeQuery(sql);
		List<String> lista = new ArrayList<String>();
		while(result.next()) {
			lista.add(result.getString("categoria"));
		}
		return lista;
	}
	
	public void insertar() {
		String sql = "INSERT INTO libros(isbn, titulo, categoria) VALUES(?,?,?)";
		DataBaseHelper.executeUpdate(sql, getIsbn(), getTitulo(), getCategoria());
	}
	
	public static List<LibroAR> buscarTodos() {
		List<LibroAR> lista = new ArrayList<LibroAR>();
		String sql = "SELECT *FROM libros";
		ResultSet resultSet = null;
		resultSet = DataBaseHelper.executeQuery(sql);
		try {
			while(resultSet.next()) {
				lista.add(
						new LibroAR(
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
}
