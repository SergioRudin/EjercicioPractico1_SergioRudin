package com.gimnasio.fitness.service;

import com.gimnasio.fitness.domain.Servicio;
import java.util.List;

public interface ServicioService {

    List<Servicio> listarServicios();

    Servicio buscarServicio(Long id);

    void guardarServicio(Servicio servicio);

    void eliminarServicio(Long id);

}