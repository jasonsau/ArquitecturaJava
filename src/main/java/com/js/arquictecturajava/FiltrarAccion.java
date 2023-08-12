package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String categoria = httpServletRequest.getParameter("categoria");
        List<Libros> libros;
        if(categoria.equals("seleccionar")) {
            libros = new Libros().seleccionarTodos();
        } else {
            libros = Libros.searchLibroCategoria(httpServletRequest.getParameter("categoria"));
        }
        List<String> categorias = Libros.seleccionarTodasLasCategorias();
        httpServletRequest.setAttribute("libros", libros);
        httpServletRequest.setAttribute("categorias", categorias);
        return "MostrarLibros.jsp";
    }
}
