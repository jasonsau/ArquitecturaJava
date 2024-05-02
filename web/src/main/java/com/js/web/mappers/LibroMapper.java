package com.js.web.mappers;

import com.js.web.dto.LibroDto;
import com.js.web.models.Categoria;
import com.js.web.models.Libro;

public class LibroMapper {

    public static LibroDto toDto(Libro libro) {
        return new LibroDto(libro.getIsbn(), libro.getTitulo(), libro.getCategoria().getId());
    }

    public static Libro toEntity(LibroDto libroDto) {
        return new Libro(libroDto.getIsbn(), libroDto.getTitulo(), new Categoria(libroDto.getCategoria()));
    }
}
