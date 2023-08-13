package com.js.arquictecturajava;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Libros")
public class Libros {

    @Id
    private String isbn;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;



    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        String isbnLibro = ((Libros)obj).getIsbn();
        return isbnLibro.equals(isbn);
    }

    public Libros() {}
    public Libros(String isbn, String titulo, Categoria categoria) {
        super();
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public Libros(String isbn) {
        super();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Libros> seleccionarTodos(){
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Libros> listaDeLibros = session.createQuery(" from Libros libro right join fetch libro.categoria").list();
        session.close();
        return listaDeLibros;
    }

    public static List<String> seleccionarTodasLasCategorias(){
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        String consultaSql = "SELECT distinct libro.categoria from Libros libro";
        List<String> listaDeCategorias = session.createQuery(consultaSql).list();
        session.close();
        return listaDeCategorias;
    }

    public void insertarLibro(){
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
        session.close();
    }

    public void updateLibro() throws DatabaseException {
        System.out.println("Actualizara el objeto");
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
        session.close();
    }

    public static Libros searchLibro(String isbn) {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        Libros listaDeLibros = (Libros) session.get(Libros.class, isbn);
        session.close();
        return listaDeLibros;
    }

    public void deleteLibro(){
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Libros> searchLibroCategoria(String categoria) {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" from Libros libro where libro.categoria =:categoria");
        query.setString("categoria", categoria);
        List<Libros> listaDeLibros = query.list();
        session.close();
        return listaDeLibros;
    }
}
