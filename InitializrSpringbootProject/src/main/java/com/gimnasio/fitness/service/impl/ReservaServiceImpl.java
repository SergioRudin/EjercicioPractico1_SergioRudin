package com.gimnasio.fitness.service.impl;

import com.gimnasio.fitness.domain.Reserva;
import com.gimnasio.fitness.repository.ReservaRepository;
import com.gimnasio.fitness.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}