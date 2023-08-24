package com.backend.clinica.dto.entrada.paciente;

import com.backend.clinica.entity.Domicilio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PacienteEntradaDto {

    @NotNull(message = "el paciente no puede ser nulo")
    @NotBlank(message = "debe especificarse el nombre del paciente")
    @Size(max = 50,message = "el nombre debe tener hasta 50 caracteres")
    private String nombre;



    private String apellido;
    private int dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;



}
