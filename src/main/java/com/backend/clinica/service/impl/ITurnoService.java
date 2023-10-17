package com.backend.clinica.service.impl;

import com.backend.clinica.dto.entrada.modificacion.turnoModificacionEntradaDto;
import com.backend.clinica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinica.dto.salida.Turno.TurnoSalidaDto;
import com.backend.clinica.exceptions.BadRequestException;
import com.backend.clinica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto)  throws BadRequestException;
    List<TurnoSalidaDto> listarTurnos();
    TurnoSalidaDto buscarTurnoPorId(Long id);
    void eliminarTurno(Long id) throws ResourceNotFoundException;

    TurnoSalidaDto modificarTurno(turnoModificacionEntradaDto TurnoModificacionEntradaDto) throws ResourceNotFoundException;
}
