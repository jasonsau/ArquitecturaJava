package web1.commands;

import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.factory.WebFactory;
import web1.models.Categoria;
import web1.services.LibroService;

public class BorrarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("isbn");

		LibroService libroService = WebFactory.getService();
		Libro libro = new Libro(isbn);
		libroService.borrarLibro(libro.getIsbn());
		
		List<Categoria> listaCategorias = libroService.buscarTodasLasCategoriasLibros();
		List<Libro> listaLibros = libroService.buscarTodosLosLibros();
		request.setAttribute("c", "");
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
