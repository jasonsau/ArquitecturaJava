package web1.commands;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.factory.WebFactory;
import web1.models.Categoria;
import web1.services.LibroService;

public class FormularioNuevoLibroCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LibroService libroService = WebFactory.getService();
		List<Categoria> listaCategorias = libroService.buscarTodasLasCategoriasLibros();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formularionuevolibro.jsp");
		dispatcher.forward(request, response);		
	}

}
