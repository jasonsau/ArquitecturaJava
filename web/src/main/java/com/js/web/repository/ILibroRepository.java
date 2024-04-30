package com.js.web.repository;

import com.js.web.models.Libro;

import java.util.List;

public interface ILibroRepository {
    void insertar(Libro libro);
    List<Libro> buscarTodos();

    List<Libro> buscarTodosPorCategoria(Integer idCategoria);

    void borrar(String isbn);

}
