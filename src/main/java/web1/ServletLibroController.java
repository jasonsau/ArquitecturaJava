package web1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/controlador")
public class ServletLibroController extends HttpServlet {
	private static final long serialVersionUID = -7365467931192290363L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = null;
		try {
			if(request.getParameter("accion") == null) {
				List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
				List<LibroAR> listaLibros = LibroAR.buscarTodos();
				
				request.setAttribute("listaCategorias", listaCategorias);
				request.setAttribute("listaLibros", listaLibros);
				dispatcher = request.getRequestDispatcher("listalibros.jsp");
				dispatcher.forward(request, response);
			} else if(request.getParameter("accion").equals("formularionuevolibro")) {
				List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
				request.setAttribute("listaCategoria", listaCategorias);
				dispatcher = request.getRequestDispatcher("formularionuevolibro.jsp");
				dispatcher.forward(request, response);
			} else if(request.getParameter("accion").equals("insertarlibro")) {
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String categoria = request.getParameter("categoria");
				LibroAR libroAR = new LibroAR(isbn, titulo, categoria);
				libroAR.insertar();
				
				List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
				List<LibroAR> listaLibros = LibroAR.buscarTodos();
				request.setAttribute("listaCategorias", listaCategorias);
				request.setAttribute("listaLibros", listaLibros);
				dispatcher = request.getRequestDispatcher("listalibros.jsp");
				dispatcher.forward(request, response);	
			} else if(request.getParameter("accion").equals("borrarlibro")) {
				String isbn = request.getParameter("isbn");
				LibroAR libro = new LibroAR(isbn);
				libro.borrar();
				List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
				List<LibroAR> listaLibros = LibroAR.buscarTodos();
				request.setAttribute("listaCategorias", listaCategorias);
				request.setAttribute("listaLibros", listaLibros);
				dispatcher = request.getRequestDispatcher("listalibros.jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	
}
