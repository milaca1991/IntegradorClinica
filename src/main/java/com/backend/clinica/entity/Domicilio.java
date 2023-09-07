package com.backend.clinica.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "DOMICILIO")
public class Domicilio {

@Id
@GeneratedValue(strategy= GenerationType.AUTO, generator = "native")
@GenericGenerator(name = "native", strategy = "native")

    @Column(name = "ID")
    private int id;
    @Column(name = "CALLE")
    private String calle;

    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "LOCALIDAD")
    private String localidad;

    @Column(name = "PROVINCIA")
    private String provincia;



    public Domicilio(int id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }



    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Id: " + id + " - Calle: " + calle + " - Numero: " + numero + " - Localidad: " + localidad + " - Provincia: " + provincia;
    }

    //constructor vacio
    public Domicilio() {
    }

}
