package web1.services;

import web1.repositories.ILibroRepository;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.ICategoriaRepository;
import web1.repositories.CategoriaRepositoryJPA;
import web1.models.Libro;
import web1.models.Categoria;
import java.util.List;

public class LibroService {
	
	private ILibroRepository libroRepository;
	private ICategoriaRepository categoriaRepository;
	
	public LibroService(
			ILibroRepository libroRepository,
			ICategoriaRepository categoriaRepository
			) {
		this.libroRepository = libroRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	public void insertarLibro(Libro libro) {
		libroRepository.insertar(libro);
	}
	
	public List<Libro> buscarTodosLosLibrosPorCategoria(Integer categoria) {
		return libroRepository.buscarTodosPorCategoria(categoria);
	}
	
	public List<Libro> buscarTodosLosLibros() {
		return libroRepository.buscarTodos();
	}
	
	public void borrarLibro(String isbn) {
		libroRepository.borrar(isbn);
	}
	
	public List<Categoria> buscarTodasLasCategoriasLibros() {
		return categoriaRepository.buscarTodasLasCategorias();
	}
	

}
