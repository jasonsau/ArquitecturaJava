package com.js.web.forms;

public class LibroForm {
        private String isbn;
        private String titulo;
        private Integer categoria;

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

        public Integer getCategoria() {
            return categoria;
        }

        public void setCategoria(Integer categoria) {
            this.categoria = categoria;
        }
}
