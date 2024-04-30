package web1.commands;

import jakarta.servlet.RequestDispatcher;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.factory.WebFactory;
import web1.models.Categoria;
import web1.models.Libro;
import web1.repositories.ICategoriaRepository;
import web1.repositories.CategoriaRepositoryJPA;
import web1.services.LibroService;

import java.util.List;

public class InsertarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LibroService libroService = WebFactory.getService();
		ICategoriaRepository categoriaRepository = new CategoriaRepositoryJPA();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Categoria c = categoriaRepository.buscarCategoriaId(Integer.parseInt(categoria));
		Libro libro = new Libro(isbn, titulo, c);
		libroService.insertarLibro(libro);
		List<Categoria> listaCategorias = libroService.buscarTodasLasCategoriasLibros();
		List<Libro> listaLibros = libroService.buscarTodosLosLibros();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("c", "");

		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
