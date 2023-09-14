package com.backend.clinica.service.impl.impl;

import com.backend.clinica.dto.entrada.odontologo.OdontologoEntradaDto;

import com.backend.clinica.dto.salida.odontologo.OdontologoSalidaDto;

import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.repository.OdontologoRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:applicationTest.properties")



class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;


    @Test
    void deberiaInsertarUnOdontologoDeNombreCamilaConId1(){



        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AS-4589304", "camila","garcia") ;
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertEquals("camila", odontologoSalidaDto.getNombre());
        assertEquals(1, odontologoSalidaDto.getId());
    }


    @Order(2)
    @Test
    void deberiaRetornarseUnaListaNoVaciaDeOdontologos(){
        assertTrue(odontologoService.listarOdontologos().size() > 0);
    }


    @Test
    @Order(3)
    void alIntentarEliminarUnOdontologoYaEliminado_deberiaLanzarseUnResourceNotFoundException(){
        try{
            odontologoService.eliminarOdontologo(1L);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
    }



}