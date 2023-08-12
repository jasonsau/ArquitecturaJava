package com.js.arquictecturajava;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControladorLibros extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher despachador = null;
        Acion accion = null;
        String url = req.getServletPath();
        try {
            accion = Acion.getAction(url);
            despachador = req.getRequestDispatcher(accion.ejecutar(req, resp));
            despachador.forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
