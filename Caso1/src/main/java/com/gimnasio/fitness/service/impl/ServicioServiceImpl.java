package com.gimnasio.fitness.service.impl;

import com.gimnasio.fitness.domain.Servicio;
import com.gimnasio.fitness.repository.ServicioRepository;
import com.gimnasio.fitness.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio buscarServicio(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}