package com.backend.clinica.dto.entrada.paciente;

import com.backend.clinica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class PacienteEntradaDto {

    @NotNull(message = "el nombre del paciente no puede ser nulo")
    @NotBlank(message = "debe especificarse el nombre del paciente")
    @Size(max = 50,message = "el nombre debe tener hasta 50 caracteres")
    private String nombre;


    @NotNull(message = "el apellido paciente no puede ser nulo")
    @NotBlank(message = "debe especificarse el apellido del paciente")
    @Size(max = 50,message = "el apellido debe tener hasta 50 caracteres")
    private String apellido;

    @NotNull(message = "el dni no puede ser nulo")
    @NotBlank(message = "debe especificarse el dni ")
    @Pattern(regexp = "\\d+", message = "el campo dni solo admite caracteres")
    private int dni;


    @NotNull(message = "el campo fecha  no puede ser nulo")
    @FutureOrPresent(message = "la fecha no puede ser anterior al dia de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "el campo domicilio del paciente  no puede ser nulo")
    private Domicilio domicilio;


    //contructor
    public PacienteEntradaDto(String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    //gys


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}



