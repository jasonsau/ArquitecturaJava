package web1.repositories;

import java.util.List;

import web1.models.Libro;

public interface ILibroRepository {
	
	List<String> buscarTodasLasCategorias();
	void insertar(Libro libro);
	List<Libro> buscarTodos();
	List<Libro> buscarTodosPorCategoria(String categoria);
	void borrar(String isbn);

}
