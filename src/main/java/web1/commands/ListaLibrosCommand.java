package web1.commands;

import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.models.Categoria;
import web1.repositories.ILibroRepository;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.ICategoriaRepository;
import web1.repositories.CategoriaRepositoryJPA;

public class ListaLibrosCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ILibroRepository libroRepository = new LibroRepositoryJPA();
		ICategoriaRepository categoriaRepository = new CategoriaRepositoryJPA();
		List<Categoria> listaCategorias = categoriaRepository.buscarTodasLasCategorias();
		List<Libro> listaLibros = libroRepository.buscarTodos();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("c", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
