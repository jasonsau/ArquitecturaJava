package web1.commands;

import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.models.Categoria;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.ILibroRepository;
import web1.repositories.CategoriaRepositoryJPA;
import web1.repositories.ICategoriaRepository;

public class BorrarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("isbn");

		ILibroRepository libroRepository = new LibroRepositoryJPA();
		ICategoriaRepository categoriaRepository = new CategoriaRepositoryJPA();
		Libro libro = new Libro(isbn);
		libroRepository.borrar(libro.getIsbn());
		
		List<Categoria> listaCategorias = categoriaRepository.buscarTodasLasCategorias();
		List<Libro> listaLibros = libroRepository.buscarTodos();
		request.setAttribute("c", "");
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
