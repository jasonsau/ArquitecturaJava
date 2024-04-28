package commands;

import java.util.HashMap;
import java.util.Map;

public class Router {

	private static Map<String, Command> map = new HashMap<String, Command>();
	
	static {
		map.put("listalibro", new ListaLibrosCommand());
		map.put("formularionuevolibro", new FormularioNuevoLibroCommand());
		map.put("insertarlibro", new InsertarLibroCommand());
		map.put("borrarlibro", new BorrarLibroCommand());
		map.put("filtrocategorialibro", new FiltroLibroCategoriaCommand());
	}
	
	public static Command getCommand(String nombreCommand) {
		if(nombreCommand == null) {
			return map.get("listalibro");
		} else {
			return map.get(nombreCommand);
		}
	}
	
}
