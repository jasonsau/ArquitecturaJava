package com.js.web.restcontroller;

import com.js.web.dto.LibroDto;
import com.js.web.mappers.LibroMapper;
import com.js.web.models.Categoria;
import com.js.web.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/libros")
public class LibroRestController {

    private final LibroService libroService;

    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroDto> buscarTodosLosLibros(){
        return libroService.buscarTodosLosLibros().stream().map(LibroMapper::toDto).toList();
    }

    @GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<LibroDto> buscarUnLibro(@PathVariable("isbn") String isbn){
        return libroService.buscarUnLibro(isbn).map(LibroMapper::toDto);
    }

    @DeleteMapping(value = "/{isbn}")
    public String borrarLibro(@PathVariable("isbn") String isbn){
        libroService.borraLibro(isbn);
        return "Libro borrado";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public LibroDto insertarLibro(@RequestBody LibroDto libro){
        libroService.insertarLibro(LibroMapper.toEntity(libro));
        return libro;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, params = "categoria")
    public List<LibroDto> buscarTodosLosLibrosPorCategoria(@RequestParam("categoria") Integer idCategoria){
        return libroService.buscarTodosLosLibrosPorCategoria(idCategoria).stream().map(LibroMapper::toDto).toList();
    }

    @GetMapping(value = "/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> buscarTodasLasCategorias(){
        return libroService.buscarTodasLasCategorias();
    }
}
