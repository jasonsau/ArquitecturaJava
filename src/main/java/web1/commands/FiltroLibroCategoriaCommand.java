package web1.commands;

import java.util.List;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.repositories.ILibroRepository;
import web1.repositories.LibroRepositoryJPA;

public class FiltroLibroCategoriaCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ILibroRepository libroRepository = new LibroRepositoryJPA();
		String categoria = request.getParameter("categoria");
		List<Libro> listaLibros = libroRepository.buscarTodosPorCategoria(categoria);
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("c", categoria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
