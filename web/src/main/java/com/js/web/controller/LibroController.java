package com.js.web.controller;

import com.js.web.models.Categoria;
import com.js.web.models.Libro;
import com.js.web.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/controlador")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    @GetMapping("/listalibros")
    public String listaLibros(Model model) {
        model.addAttribute("listaLibros", libroService.buscarTodosLosLibros());
        model.addAttribute("listaCategorias", libroService.buscarTodasLasCategorias());
        return "listalibros";
    }

    @GetMapping("/formularionuevolibro")
    public String formularioNuevoLibro(Model model) {
        model.addAttribute("listaCategorias", libroService.buscarTodasLasCategorias());
        return "formularionuevolibro";
    }

    @PostMapping("/guardarnuevolibro")
    public String guardarNuevoLibro(@ModelAttribute LibroDto libro) {
        Categoria categoria = libroService.buscarCategoriaPorId(libro.getCategoria());
        Libro newLibro = new Libro(libro.getIsbn(), libro.getTitulo(), categoria);
        libroService.insertarLibro(newLibro);
        return "redirect:/controlador/listalibros";
    }

    @GetMapping("/borrarlibro")
    public String eliminarLibro(@RequestParam String isbn) {
        libroService.borraLibro(isbn);
        return "redirect:/controlador/listalibros";
    }

    @PostMapping("/filtrocategoria")
    public String filtrarLibro(@RequestParam String categoria, Model model) {
        List<Libro> listaFiltrada = libroService.buscarTodosLosLibrosPorCategoria(Integer.parseInt(categoria));
        model.addAttribute("listaLibros", listaFiltrada);
        model.addAttribute("listaCategorias", libroService.buscarTodasLasCategorias());
        return "listalibros";
    }

    private class LibroDto {
        private String isbn;
        private String titulo;
        private Integer categoria;

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Integer getCategoria() {
            return categoria;
        }

        public void setCategoria(Integer categoria) {
            this.categoria = categoria;
        }
    }
}
