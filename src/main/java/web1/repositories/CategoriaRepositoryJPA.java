package web1.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import web1.models.Categoria;

public class CategoriaRepositoryJPA implements ICategoriaRepository {

	EntityManager em;

	public CategoriaRepositoryJPA() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
		em = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public List<Categoria> buscarTodasLasCategorias() {
		return em.createQuery("SELECT c from Categoria c", Categoria.class).getResultList();
	}

	@Override
	public Categoria buscarCategoriaId(Integer id) {
		TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE c.id = :id", Categoria.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	

}
