package com.backend.clinica.dto.entrada.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)


public class pacienteModificacionEntradaDto {


    @NotNull
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String dni;

    @NotNull
    private LocalDate fechaIngreso;

    @NotNull
    private domicilioModificacionEntradaDto domicilio;

    public pacienteModificacionEntradaDto() {
    }

    public pacienteModificacionEntradaDto(int id, String nombre, String apellido, String dni, LocalDate fechaIngreso, domicilioModificacionEntradaDto domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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
