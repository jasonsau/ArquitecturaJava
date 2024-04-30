package com.js.web.repository;

import com.js.web.models.Categoria;

import java.util.List;

public interface ICategoriaRepository {

    List<Categoria> buscarTodasLasCategorias();
    Categoria buscarPorId(Integer id);
}
