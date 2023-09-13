package com.backend.clinica.service.impl.impl;

import com.backend.clinica.dto.entrada.modificacion.pacienteModificacionEntradaDto;
import com.backend.clinica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

@TestPropertySource(locations = "classpath: applicationTest.properties")


public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;


    @Test
    @Order(1)
    void deberiaInsertarPacienteDeNombreJuanConId1(){


        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("juan", "perez",222, LocalDate.of(2023,12,10), new DomicilioEntradaDto("calle", 123,"engativa","provincia"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertEquals("juan", pacienteSalidaDto.getNombre());
        assertEquals(1,pacienteSalidaDto.getId());



    }

    @Test

    void deberiaRetornarUnaListaNoVaciaDePacientes(){

        assertTrue(pacienteService.listarPacientes().size()>0);



    }
    @Test
    void alIntentarActualizarPacienteId2_deberiaLazarResourceNotFound(){

        pacienteModificacionEntradaDto pacienteModificacionEntradaDto = new pacienteModificacionEntradaDto();

        pacienteModificacionEntradaDto.setId(2L);
        assertThrows(ResourceNotFoundException.class,() -> pacienteService.modificarPaciente(pacienteModificacionEntradaDto));

    }


}
