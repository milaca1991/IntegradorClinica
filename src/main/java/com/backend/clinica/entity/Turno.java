package com.backend.clinica.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity(name = "TURNO")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")

    @Column(name = "ID")
    private Long id;
    private Odontologo odontologo;


    @ManyToOne()

    private Paciente paciente;

    @Column(name = "FECHAYHORA")
    private LocalDateTime fechaYhora;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
