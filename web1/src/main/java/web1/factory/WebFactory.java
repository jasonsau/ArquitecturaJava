package web1.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import web1.services.LibroService;
import web1.repositories.CategoriaRepositoryJPA;
import web1.repositories.LibroRepositoryJPA;
import web1.repositories.LibroRepositoryJDBC;
import web1.repositories.CategoriaRepositoryJDBC;

public class WebFactory {
	
	public static LibroService getService() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("/database.properties");
		Properties properties = new Properties();
		properties.load(input);
		if(properties.get("persistencia").equals("JPA")) {
			return new LibroService(new LibroRepositoryJPA(), new CategoriaRepositoryJPA());
		} else {
			return new LibroService(new LibroRepositoryJDBC(), new CategoriaRepositoryJDBC());
		}	
	}

}
