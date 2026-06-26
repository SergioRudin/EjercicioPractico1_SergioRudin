package com.gimnasio.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarContacto() {
        return "redirect:/";
    }
}