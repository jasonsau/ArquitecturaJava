package web1.commands;


import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.models.Categoria;
import web1.services.LibroService;

public class ListaLibrosCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LibroService libroService = new LibroService();
		List<Categoria> listaCategorias = libroService.buscarTodasLasCategoriasLibros();
		List<Libro> listaLibros = libroService.buscarTodosLosLibros();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("c", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
