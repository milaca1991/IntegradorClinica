package com.backend.clinica.service.impl;


import com.backend.clinica.dto.entrada.modificacion.pacienteModificacionEntradaDto;
import com.backend.clinica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica.entity.Paciente;
import com.backend.clinica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    List<PacienteSalidaDto> listarPacientes();

    Paciente registrarPaciente(PacienteEntradaDto paciente);

    Paciente buscarPacientePorId(Long id);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(pacienteModificacionEntradaDto pacienteModificado) throws ResourceNotFoundException;



}
