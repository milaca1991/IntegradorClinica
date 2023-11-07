package com.backend.clinica.dto.salida.paciente;

import com.backend.clinica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PacienteSalidaDto {


    private Long id;
    private String nombre;
    private String apellido;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;
    private DomicilioSalidaDto domicilio;

    private int dni;


    //constructor vacio
    public PacienteSalidaDto() {
    }



    public PacienteSalidaDto(Long id, String nombre, String apellido, LocalDate fechaIngreso, DomicilioSalidaDto domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DomicilioSalidaDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioSalidaDto domicilio) {
        this.domicilio = domicilio;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre + " - Apellido: " + apellido + " - DNI: " + dni + " - Fechas de ingreso: " + fechaIngreso + " - Domicilio: " + domicilio;
    }
}
