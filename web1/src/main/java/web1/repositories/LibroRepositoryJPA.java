package web1.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import web1.models.Libro;

public class LibroRepositoryJPA implements ILibroRepository{
	
	EntityManager em;
	
	public LibroRepositoryJPA() {
		EntityManagerFactory entityManagerFactory 
		= Persistence.createEntityManagerFactory("biblioteca");
		em = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<String> buscarTodasLasCategorias() {
		return em.createQuery("SELECT DISTINCT(l.categoria) FROM Libro l", String.class).getResultList();
	}

	@Override
	public void insertar(Libro libro) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.persist(libro);
		entityTransaction.commit();
	}

	@Override
	public List<Libro> buscarTodos() {
		return em.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria", Libro.class).getResultList();
	}

	@Override
	public List<Libro> buscarTodosPorCategoria(Integer categoria) {
		TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.categoria.id=:categoria", Libro.class);
		query.setParameter("categoria", categoria);
		return query.getResultList();
	}

	@Override
	public void borrar(String isbn) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.remove(em.merge(new Libro(isbn)));
		entityTransaction.commit();
	}

}
