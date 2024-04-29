package web1.commands;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.ILibroRepository;

public class FormularioNuevoLibroCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LLega hasta el command");
		ILibroRepository libroRepository = new LibroRepositoryJPA();
		List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formularionuevolibro.jsp");
		dispatcher.forward(request, response);		
	}

}
