package commands;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.LibroRepository;

public class FormularioNuevoLibroCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LLega hasta el command");
		LibroRepository libroRepository = new LibroRepository();
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formularionuevolibro.jsp");
		dispatcher.forward(request, response);		
	}

}
