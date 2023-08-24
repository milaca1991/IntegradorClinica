package com.backend.clinica.entity;

import java.time.LocalDateTime;

public class Turno {

    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDateTime fechaYhora;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

//constructor vacio
    public Turno() {
    }



}
