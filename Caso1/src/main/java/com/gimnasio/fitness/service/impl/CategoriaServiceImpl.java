package com.gimnasio.fitness.service.impl;

import com.gimnasio.fitness.domain.Categoria;
import com.gimnasio.fitness.repository.CategoriaRepository;
import com.gimnasio.fitness.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}