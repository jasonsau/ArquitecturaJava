package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MostrarLibrosAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Libro libro =new Libro();
        List<Libro> libros =  libro.seleccionarTodos();
        List<String> categorias = Libro.seleccionarTodasLasCategorias();

        httpServletRequest.setAttribute("libros", libros);
        httpServletRequest.setAttribute("categorias", categorias);
        return "MostrarLibros.jsp";
    }
}
