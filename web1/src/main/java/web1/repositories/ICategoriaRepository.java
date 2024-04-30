package web1.repositories;

import java.util.List;

import web1.models.Categoria;

public interface ICategoriaRepository {

	List<Categoria> buscarTodasLasCategorias();
	
	Categoria buscarCategoriaId(Integer id);
}
