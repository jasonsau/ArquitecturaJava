package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Acion{

    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String isbn = httpServletRequest.getParameter("isbn");
        List<String> categorias = Libro.seleccionarTodasLasCategorias();
        Libro libro = Libro.searchLibro(isbn);
        httpServletRequest.setAttribute("categorias", categorias);
        httpServletRequest.setAttribute("libro", libro);
        return "FormularioEditarLibro.jsp";
    }
}
