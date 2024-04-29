package web1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="libros")
public class Libro {

	@Id
	private String isbn;
	private String titulo;
	private String categoria;
	
	public Libro() {}
	
	public Libro(String isbn, String titulo, String categoria) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;	
	}
	
	public Libro(String isbn) {
		this.isbn = isbn;
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
}
