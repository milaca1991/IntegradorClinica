package com.backend.clinica.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "TURNOS")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;



    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private LocalDateTime fechaYHora;



    //constructor vacio
    public Turno() {
    }

    public Turno( Odontologo odontologo, Paciente paciente, LocalDateTime fechaYhora) {

        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaYHora = fechaYhora;
    }

    public Turno(Long id, Odontologo odontologo, Paciente paciente, LocalDateTime fechaYHora) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
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
        return fechaYHora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYHora = fechaYhora;
    }
}


