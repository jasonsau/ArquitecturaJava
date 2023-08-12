package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertarLibroAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String isbn = httpServletRequest.getParameter("isbn");
        String nombre = httpServletRequest.getParameter("titulo");
        String categoria = httpServletRequest.getParameter("categoria");
        Libros libro = new Libros(isbn, nombre, categoria);
        libro.insertarLibro();
        return "MostrarLibros.do";
    }
}
