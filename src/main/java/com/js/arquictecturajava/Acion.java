package com.js.arquictecturajava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public abstract class Acion {

    public abstract String ejecutar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    public static Acion getAction(String nameAction) throws ClassNotFoundException, RuntimeException {
        nameAction = Acion.getNameClass(nameAction);
        Acion acion;
        try {
            acion = (Acion) Class.forName(nameAction).getConstructor().newInstance();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new ClassNotFoundException("Clase no encontrada", classNotFoundException);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        return acion;
    }

    private static String getNameClass(String nameClass) {
        nameClass = nameClass.replaceAll("/", "");
        return "com.js.arquictecturajava."+nameClass.replaceAll(".do", "Accion");
    }
}
