package com.js.web.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    private String isbn;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;


    public Libro() {
    }

    public Libro(String isbn ) {
        this.isbn = isbn;

    }
    public Libro(String isbn, String titulo, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
