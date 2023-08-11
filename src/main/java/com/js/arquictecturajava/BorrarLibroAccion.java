package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        String isbn = httpServletRequest.getParameter("isbn");
        Libro libro = new Libro(isbn);
        libro.deleteLibro();
        return "MostrarLibros.do";
    }
}
