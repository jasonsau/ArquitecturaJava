package web1.commands;

import java.util.List;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.factory.WebFactory;
import web1.models.Categoria;
import web1.services.LibroService;

public class FiltroLibroCategoriaCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LibroService libroService = WebFactory.getService();
		String categoria = request.getParameter("categoria");
		List<Libro> listaLibros = libroService.buscarTodosLosLibrosPorCategoria(Integer.parseInt(categoria));
		List<Categoria> listaCategorias = libroService.buscarTodasLasCategoriasLibros();
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("c", categoria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
