package com.backend.clinica.service.impl;


import com.backend.clinica.dto.entrada.modificacion.odontologoModificacionEntradaDto;
import com.backend.clinica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica.entity.Odontologo;
import com.backend.clinica.exceptions.ResourceNotFoundException;

import javax.annotation.Resource;
import java.util.List;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();


    Odontologo registrarOdontologo(Odontologo odontologo);

    Odontologo buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;

    OdontologoSalidaDto actualizarOdontologo(odontologoModificacionEntradaDto odontologoModificacionEntradaDto);
}
