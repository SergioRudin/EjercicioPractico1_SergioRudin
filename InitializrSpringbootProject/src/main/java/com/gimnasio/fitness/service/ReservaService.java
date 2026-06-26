package com.gimnasio.fitness.service;

import com.gimnasio.fitness.domain.Reserva;
import java.util.List;

public interface ReservaService {

    List<Reserva> listarReservas();

    Reserva buscarReserva(Long id);

    void guardarReserva(Reserva reserva);

    void eliminarReserva(Long id);

}