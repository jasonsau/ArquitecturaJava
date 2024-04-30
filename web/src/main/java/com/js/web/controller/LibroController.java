package com.js.web.controller;

import com.js.web.models.Categoria;
import com.js.web.models.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/controlador")
public class LibroController {

    List<Libro> listaLibros = new ArrayList<>();
    List<Categoria> listaCategorias = new ArrayList<>();

    public LibroController() {
        listaLibros.add(new Libro("1234", "El Quijote", new Categoria(1, "Novela")));
        listaLibros.add(new Libro("5678", "El Aleph", new Categoria(2, "Cuento")));
        listaLibros.add(new Libro("9101", "El Principito", new Categoria(3, "Infantil")));
        listaCategorias.add(new Categoria(1, "Novela"));
        listaCategorias.add(new Categoria(2, "Cuento"));
        listaCategorias.add(new Categoria(3, "Infantil"));
    }

    @GetMapping("/listalibros")
    public String listaLibros(Model model) {
        model.addAttribute("listaLibros", listaLibros);
        model.addAttribute("listaCategorias", listaCategorias);
        return "listalibros";
    }

    @GetMapping("/formularionuevolibro")
    public String formularioNuevoLibro(Model model) {
        model.addAttribute("listaCategorias", listaCategorias);
        return "formularionuevolibro";
    }

    @PostMapping("/guardarnuevolibro")
    public String guardarNuevoLibro(@ModelAttribute LibroDto libro) {
        Categoria categoria = listaCategorias.stream()
                .filter(c -> c.getId().equals(libro.getCategoria())).findFirst().orElse(null);
        Libro newLibro = new Libro(libro.getIsbn(), libro.getTitulo(), categoria);
        listaLibros.add(newLibro);
        return "redirect:/controlador/listalibros";
    }

    @GetMapping("/borrarlibro")
    public String eliminarLibro(@RequestParam String isbn) {
        listaLibros.removeIf(l -> l.getIsbn().equals(isbn));
        return "redirect:/controlador/listalibros";
    }

    @PostMapping("/filtrocategoria")
    public String filtrarLibro(@RequestParam String categoria, Model model) {
        List<Libro> listaFiltrada = new ArrayList<>();
        listaLibros.stream().filter(l -> l.getCategoria().getId().equals(Integer.parseInt(categoria))).forEach(listaFiltrada::add);

        model.addAttribute("listaLibros", listaFiltrada);
        model.addAttribute("listaCategorias", listaCategorias);
        System.out.println("Filtrar por categoria: " + categoria);
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
