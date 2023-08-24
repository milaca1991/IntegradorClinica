package com.backend.clinica.service.impl;


import com.backend.clinica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();


    Odontologo registrarOdontologo(Odontologo odontologo);

    Odontologo buscarOdontologoPorId(int id);

    void eliminarOdontologo(int id);

}
