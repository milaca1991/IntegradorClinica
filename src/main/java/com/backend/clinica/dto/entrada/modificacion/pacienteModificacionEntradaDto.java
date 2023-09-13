package com.backend.clinica.dto.entrada.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)


public class pacienteModificacionEntradaDto {


    @NotNull
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private int dni;

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
