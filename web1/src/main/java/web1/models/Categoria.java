package web1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

@Entity
@Table(name="categorias")
public class Categoria {

	@Id
	private Integer id;
	private String nombre;
	@OneToMany(mappedBy="categoria")
	private List<Libro> libros = new ArrayList<Libro>();
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Libro> getLibros() {
		return this.libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public Categoria() {
		
	}
	
	public Categoria(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Categoria(Integer id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		Categoria other = (Categoria) obj;
		return id == other.id;
	}
}
