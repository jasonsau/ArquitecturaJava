package web1.commands;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web1.repositories.ICategoriaRepository;
import web1.repositories.CategoriaRepositoryJPA;
import web1.models.Categoria;

public class FormularioNuevoLibroCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ICategoriaRepository categoriaRepository = new CategoriaRepositoryJPA();
		List<Categoria> listaCategorias = categoriaRepository.buscarTodasLasCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formularionuevolibro.jsp");
		dispatcher.forward(request, response);		
	}

}
