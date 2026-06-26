package com.gimnasio.fitness.controllers;

import com.gimnasio.fitness.domain.Reserva;
import com.gimnasio.fitness.service.ReservaService;
import com.gimnasio.fitness.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/reservas")
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarReservas());
        return "reserva/listado";
    }

    @GetMapping("/reservas/nueva")
    public String nueva(Reserva reserva, Model model) {
        model.addAttribute("servicios", servicioService.listarServicios());
        return "reserva/formulario";
    }

    @PostMapping("/reservas/guardar")
    public String guardar(Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/editar/{id}")
    public String editar(Reserva reserva, Model model) {
        reserva = reservaService.buscarReserva(reserva.getId());
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicioService.listarServicios());
        return "reserva/formulario";
    }

    @GetMapping("/reservas/eliminar/{id}")
    public String eliminar(Reserva reserva) {
        reservaService.eliminarReserva(reserva.getId());
        return "redirect:/reservas";
    }
}