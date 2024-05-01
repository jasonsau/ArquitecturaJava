package com.js.web.service;

import com.js.web.models.Categoria;
import com.js.web.models.Libro;
import com.js.web.repository.CategoriaRepository;
import com.js.web.repository.ICategoriaRepository;
import com.js.web.repository.ILibroRepository;
import com.js.web.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final CategoriaRepository categoriaRepository;

    public LibroService(LibroRepository libroRepository, CategoriaRepository categoriaRepository) {
        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarCategoriaPorId(Integer id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public void insertarLibro(Libro libro){
        libroRepository.save(libro);
    }

    public List<Libro> buscarTodosLosLibros(){
        return libroRepository.findAll();
    }

    public List<Libro> buscarTodosLosLibrosPorCategoria(Integer idCategoria){
        return libroRepository.findByCategoria(new Categoria(idCategoria));
    }

    public void borraLibro(String isbn){
        libroRepository.deleteById(isbn);
    }

    public List<Categoria> buscarTodasLasCategorias(){
        return categoriaRepository.findAll();
    }

}
