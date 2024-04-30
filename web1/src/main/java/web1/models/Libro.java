package web1.models;

import java.util.Objects;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="libros")
public class Libro {

	@Id
	private String isbn;
	private String titulo;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	public Libro() {}
	
	public Libro(String isbn, String titulo, Categoria categoria) {
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
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}
}
