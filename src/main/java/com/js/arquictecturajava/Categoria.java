package com.js.arquictecturajava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    private String id;
    private String descripcion;
    @OneToMany
    @JoinColumn(name = "categoria")
    private List<Libros> listaDeLibros;

    public Categoria(String id) {
        super();
        this.id = id;
    }

    public Categoria(String id, String descripcion) {
        super();
        this.id = id;
        this.descripcion = descripcion;
    }

    public Categoria() {}

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        String categoriaId = ((Categoria)obj).getId();
        return id.equals(categoriaId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Libros> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Libros> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    public static List<Categoria> buscarTodas() {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Categoria> categorias = session.createQuery(" from Categoria categoria").list();
        session.close();
        return categorias;

    }
}
