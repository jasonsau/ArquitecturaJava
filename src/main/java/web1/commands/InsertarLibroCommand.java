package web1.commands;

import jakarta.servlet.RequestDispatcher;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.ILibroRepository;

import java.util.List;

public class InsertarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ILibroRepository libroRepository = new LibroRepositoryJPA();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Libro libro = new Libro(isbn, titulo, categoria);
		libroRepository.insertar(libro);
		
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		List<Libro> listaLibros = libroRepository.buscarTodos();
		
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("c", "");

		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}