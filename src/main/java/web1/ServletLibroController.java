package web1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import commands.Command;
import commands.Router;

@WebServlet("/controlador")
public class ServletLibroController extends HttpServlet {
	private static final long serialVersionUID = -7365467931192290363L;
	Command command = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Router.getCommand(request.getParameter("accion")).execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
