package com.js.web.repository;

import com.js.web.models.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepositoryJPA implements ILibroRepository{

    @PersistenceContext
    EntityManager em;
    @Override
    @Transactional
    public void insertar(Libro libro) {
        em.persist(libro);
    }

    @Override
    public List<Libro> buscarTodos() {
        return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }

    @Override
    public List<Libro> buscarTodosPorCategoria(Integer idCategoria) {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.categoria.id = :idCategoria", Libro.class);
        query.setParameter("idCategoria", idCategoria);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void borrar(String isbn) {
        em.remove(em.merge(new Libro(isbn)));
    }
}
