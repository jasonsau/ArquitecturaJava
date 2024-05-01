package com.js.web.repository;

import com.js.web.models.Categoria;
import com.js.web.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {
    List<Libro> findByCategoria(Categoria idCategoria);
}
