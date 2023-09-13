package com.backend.clinica.dto.entrada.paciente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@JsonIgnoreProperties(ignoreUnknown = true)


public class DomicilioEntradaDto {


    @NotNull(message = "la calle no puede ser nula")
    @NotBlank(message = "debe especificarse el nombre de la calle")
    private String calle;


    @NotNull(message = "el numero no puede ser nulo")
    @Digits(integer = 8, fraction = 0, message = "el numero debe tener maximo 8 digitos")
    private int numero;

    @NotNull(message = "la localidad no puede ser nula")
    @NotBlank(message = "debe especificarse el nombre de la localidad")
    private String localidad;

    @NotNull(message = "la provincia no puede ser nula")
    @NotBlank(message = "debe especificarse el nombre de la provincia")
    private String provincia;



    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public DomicilioEntradaDto() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
