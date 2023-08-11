package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioInsertarLibroAccion extends Acion{


    @Override
    public String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<String> categorias = Libro.seleccionarTodasLasCategorias();
        httpServletRequest.setAttribute("categorias", categorias);
        return "FormularioInsertarLibro.jsp";
    }
}
