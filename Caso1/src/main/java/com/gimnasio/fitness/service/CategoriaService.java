package com.gimnasio.fitness.service;

import com.gimnasio.fitness.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> listarCategorias();

    Categoria buscarCategoria(Long id);

    void guardarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);

}