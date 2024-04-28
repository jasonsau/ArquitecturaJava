package web1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/controlador")
public class ServletLibroController extends HttpServlet {
	private static final long serialVersionUID = -7365467931192290363L;
	LibroRepository libroRepository = new LibroRepository();
	RequestDispatcher dispatcher = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			if(request.getParameter("accion") == null) {
				listaLibros(request, response);
			} else if(request.getParameter("accion").equals("formularionuevolibro")) {
				List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
				request.setAttribute("listaCategoria", listaCategorias);
				dispatcher = request.getRequestDispatcher("formularionuevolibro.jsp");
				dispatcher.forward(request, response);
			} else if(request.getParameter("accion").equals("insertarlibro")) {
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String categoria = request.getParameter("categoria");
				Libro libro = new Libro(isbn, titulo, categoria);
				libroRepository.insertar(libro);
				listaLibros(request, response);
			} else if(request.getParameter("accion").equals("borrarlibro")) {
				String isbn = request.getParameter("isbn");
				Libro libro = new Libro(isbn);
				libroRepository.borrar(libro);
				listaLibros(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	private void listaLibros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		List<Libro> listaLibros = libroRepository.buscarTodos();
		
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		dispatcher = request.getRequestDispatcher("listalibros.jsp");
		dispatcher.forward(request, response);
	}
	
}
