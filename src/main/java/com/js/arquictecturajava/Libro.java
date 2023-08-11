package com.js.arquictecturajava;

import java.util.List;
import java.util.ListResourceBundle;

public class Libro {

    private String isbn;
    private String titulo;
    private String categoria;


    public Libro() {}
    public Libro(String isbn, String titulo, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public Libro(String isbn) {
        this.isbn = isbn;
    }


    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Libro> seleccionarTodos(){
        String consultaSql = "SELECT isbn, titulo, categoria from Libros";
        System.out.println("****************************");
        System.out.println(consultaSql);
        DataBaseHelper<Libro> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.seleccionarRegistros(consultaSql, Libro.class);
    }

    public static List<String> seleccionarTodasLasCategorias(){
        String consultaSql = "SELECT distinct(categoria) from Libros";
        DataBaseHelper<String> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.seleccionarRegistros(consultaSql, String.class);
    }

    public int insertarLibro(){
        String consultaSql = "INSERT INTO Libros(isbn, titulo, categoria) VALUES ('" + this.isbn + "', '" + this.titulo + "', '" + this.categoria + "')";
        DataBaseHelper<Libro> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.modificarRegistro(consultaSql);
    }

    public int updateLibro() throws DatabaseException {
        String consultaSql = "UPDATE Libros set titulo = '" + this.titulo + "', categoria = '" + this.categoria + "' where isbn = '" + this.isbn + "'";
        DataBaseHelper<Libro> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.modificarRegistro(consultaSql);
    }

    public static Libro searchLibro(String isbn) {
        String consultaSql = "SELECT isbn, titulo, categoria from Libros where isbn = '" + isbn + "'";
        System.out.println(consultaSql);
        DataBaseHelper<Libro> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.seleccionarRegistros(consultaSql, Libro.class).get(0);
    }

    public int deleteLibro(){
        String consultaSql = "DELETE FROM Libros where isbn = '" + this.isbn + "'";
        DataBaseHelper<Libro> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.modificarRegistro(consultaSql);
    }

    public static List<Libro> searchLibroCategoria(String categoria) {
        String consultaSql = "SELECT isbn, titulo, categoria FROM Libros where categoria = '" + categoria + "'";
        DataBaseHelper<Libro> dataBaseHelper = new DataBaseHelper<>();
        return dataBaseHelper.seleccionarRegistros(consultaSql, Libro.class);
    }
}
