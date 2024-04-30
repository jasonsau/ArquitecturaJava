package web1.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import web1.helpers.DataBaseHelper;
import web1.models.Categoria;

public class CategoriaRepositoryJDBC implements ICategoriaRepository{

	@Override
	public List<Categoria> buscarTodasLasCategorias() {
		String sql = "SELECT *FROM categorias";
		ResultSet result = DataBaseHelper.executeQuery(sql);
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			while(result.next()) {
				lista.add(
						new Categoria(
								result.getInt("id"),
								result.getString("nombre")
								)
						);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	@Override
	public Categoria buscarCategoriaId(Integer id) {
		String sql = "SELECT *FROM categorias WHERE id = ?";
		ResultSet result = DataBaseHelper.executeQuery(sql, id);
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			while(result.next()) {
				lista.add(
						new Categoria(
								result.getInt("id"),
								result.getString("nombre")
								)
						);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		if(lista.isEmpty()) return null;
		return lista.get(0);
	}

}
