package com.gimnasio.fitness.controllers;

import com.gimnasio.fitness.domain.Servicio;
import com.gimnasio.fitness.service.CategoriaService;
import com.gimnasio.fitness.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/servicios")
    public String listar(Model model) {
        model.addAttribute("servicios", servicioService.listarServicios());
        return "servicio/listado";
    }

    @GetMapping("/servicios/nuevo")
    public String nuevo(Servicio servicio, Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "servicio/formulario";
    }

    @PostMapping("/servicios/guardar")
    public String guardar(Servicio servicio) {
        servicioService.guardarServicio(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/editar/{id}")
    public String editar(Servicio servicio, Model model) {
        servicio = servicioService.buscarServicio(servicio.getId());
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "servicio/formulario";
    }

    @GetMapping("/servicios/eliminar/{id}")
    public String eliminar(Servicio servicio) {
        servicioService.eliminarServicio(servicio.getId());
        return "redirect:/servicios";
    }
}