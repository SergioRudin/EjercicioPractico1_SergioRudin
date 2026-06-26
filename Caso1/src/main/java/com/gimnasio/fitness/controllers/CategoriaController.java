package com.gimnasio.fitness.controllers;

import com.gimnasio.fitness.domain.Categoria;
import com.gimnasio.fitness.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "categoria/listado";
    }

    @GetMapping("/categorias/nueva")
    public String nueva(Categoria categoria) {
        return "categoria/formulario";
    }

    @PostMapping("/categorias/guardar")
    public String guardar(Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String editar(Categoria categoria, Model model) {
        categoria = categoriaService.buscarCategoria(categoria.getId());
        model.addAttribute("categoria", categoria);
        return "categoria/formulario";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String eliminar(Categoria categoria) {
        categoriaService.eliminarCategoria(categoria.getId());
        return "redirect:/categorias";
    }
}