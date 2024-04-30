package com.js.web.service;

import com.js.web.models.Categoria;
import com.js.web.models.Libro;
import com.js.web.repository.ICategoriaRepository;
import com.js.web.repository.ILibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final ILibroRepository libroRepository;
    private final ICategoriaRepository categoriaRepository;

    public LibroService(ILibroRepository libroRepository, ICategoriaRepository categoriaRepository) {
        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarCategoriaPorId(Integer id){
        return categoriaRepository.buscarPorId(id);
    }

    public void insertarLibro(Libro libro){
        libroRepository.insertar(libro);
    }

    public List<Libro> buscarTodosLosLibros(){
        return libroRepository.buscarTodos();
    }

    public List<Libro> buscarTodosLosLibrosPorCategoria(Integer idCategoria){
        return libroRepository.buscarTodosPorCategoria(idCategoria);
    }

    public void borraLibro(String isbn){
        libroRepository.borrar(isbn);
    }

    public List<Categoria> buscarTodasLasCategorias(){
        return categoriaRepository.buscarTodasLasCategorias();
    }

}
