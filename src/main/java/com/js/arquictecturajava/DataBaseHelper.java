package com.js.arquictecturajava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://jstomcat.com:3003/arquitecturajava";


    public List<T> seleccionarRegistros(String sql, Class clase){
        System.out.println("Entra a los registros");
        List<T> listaDeObjetos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                T objeto = (T) Class.forName(clase.getName()).getConstructor().newInstance();
                Method[] methods = objeto.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getName().startsWith("set")) {
                        method.invoke(
                                objeto,
                                resultSet.getString(
                                        method.getName().substring(3)
                                )
                        );
                    }
                    if (objeto.getClass().getName().equals("java.lang.String")) {
                        objeto = (T) resultSet.getString(1);
                    }
                }
                listaDeObjetos.add(objeto);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new DatabaseException("Clase no encontrada",e);
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            System.out.println(e.getMessage());
            throw new DatabaseException("Error no se ha podido instanciar la clase", e);
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }
            }
        }
        return listaDeObjetos;

    }

    public int modificarRegistro(String consultaSql){
        Connection connection = null;
        Statement statement = null;
        int filasAfectadas = 0;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            filasAfectadas = statement.executeUpdate(consultaSql);
        } catch (SQLException sqlException){
            throw new DatabaseException("Error en el sql", sqlException);
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("Clase no encontrada", e);
        }
        return filasAfectadas;
    }

}
