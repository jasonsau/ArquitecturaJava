package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarLibroAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String isbn = httpServletRequest.getParameter("isbn");
        String titulo = httpServletRequest.getParameter("titulo");
        String categoria = httpServletRequest.getParameter("categoria");

        Libros libro = new Libros(isbn, titulo, categoria);
        libro.updateLibro();
        return "MostrarLibros.do";
    }
}
