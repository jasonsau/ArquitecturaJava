package com.js.web.restcontroller;

import com.js.web.forms.LibroForm;
import com.js.web.models.Categoria;
import com.js.web.models.Libro;
import com.js.web.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/libros")
public class LibroRestController {

    private final LibroService libroService;

    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> buscarTodosLosLibros(){
        return libroService.buscarTodosLosLibros();
    }

    @GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Libro buscarUnLibro(@PathVariable("isbn") String isbn){
        return libroService.buscarUnLibro(isbn).orElse(null);
    }

    @DeleteMapping(value = "/{isbn}")
    public String borrarLibro(@PathVariable("isbn") String isbn){
        libroService.borraLibro(isbn);
        return "Libro borrado";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Libro insertarLibro(@RequestBody Libro libro){
        libroService.insertarLibro(libro);
        return libro;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, params = "categoria")
    public List<Libro> buscarTodosLosLibrosPorCategoria(@RequestParam("categoria") Integer idCategoria){
        return libroService.buscarTodosLosLibrosPorCategoria(idCategoria);
    }
}
