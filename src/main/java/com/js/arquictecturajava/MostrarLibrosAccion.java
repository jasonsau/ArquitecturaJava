package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MostrarLibrosAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Libros libro =new Libros();
        List<Libros> libros =  libro.seleccionarTodos();
        List<Categoria> categorias = Categoria.buscarTodas();
        httpServletRequest.setAttribute("libros", libros);
        httpServletRequest.setAttribute("categorias", categorias);
        return "MostrarLibros.jsp";
    }
}
