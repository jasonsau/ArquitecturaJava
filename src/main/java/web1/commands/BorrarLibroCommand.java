package web1.commands;

import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.models.Libro;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.ILibroRepository;

public class BorrarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("isbn");
		System.out.println("LLega al command");
		System.out.println("ISBN: " + isbn);
		ILibroRepository libroRepository = new LibroRepositoryJPA();
		Libro libro = new Libro(isbn);
		libroRepository.borrar(libro.getIsbn());
		
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		List<Libro> listaLibros = libroRepository.buscarTodos();
		request.setAttribute("c", "");
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}

}
