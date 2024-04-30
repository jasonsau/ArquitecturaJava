package com.js.web.repository;

import com.js.web.models.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepositoryJPA implements ICategoriaRepository{

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Categoria> buscarTodasLasCategorias() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return em.find(Categoria.class, id);
    }
}
