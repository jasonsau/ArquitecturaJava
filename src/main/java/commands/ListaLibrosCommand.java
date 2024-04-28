package commands;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.Libro;
import web1.LibroRepository;

public class ListaLibrosCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LibroRepository libroRepository = new LibroRepository();
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		List<Libro> listaLibros = libroRepository.buscarTodos();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("c", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
