package com.backend.clinica.dto.entrada.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)


public class pacienteModificacionEntradaDto {


    @NotNull(message = "Debe proveerse el id del paciente que se desea modificar")
    private Long id;

    @Size(min = 2, max = 50, message = "El nombre debe tener hasta 50 caracteres")
    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del paciente")
    private String nombre;



    @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido del paciente no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del paciente")
    private String apellido;

    @NotNull(message = "Debe especificarse el dni del paciente")
    private int dni;

    @NotNull(message = "el campo fecha  no puede ser nulo")
    @FutureOrPresent(message = "la fecha no puede ser anterior al dia de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaIngreso;

    @NotNull
    private domicilioModificacionEntradaDto domicilio;

    public pacienteModificacionEntradaDto() {
    }

    public pacienteModificacionEntradaDto(Long id, String nombre, String apellido, int dni, LocalDate fechaIngreso, domicilioModificacionEntradaDto domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public domicilioModificacionEntradaDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(domicilioModificacionEntradaDto domicilio) {
        this.domicilio = domicilio;
    }
}
