package com.backend.clinica.service.impl.impl;

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
@TestPropertySource(locations = "classpath:applicationTest.properties")

class PacienteServiceTest {



        @Autowired
        private PacienteService pacienteService;


    @Order(1)
        @Test

        void deberiaInsertarUnPacienteDeNombreJoseConId1(){
            PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Jose", "Diaz", 56798, LocalDate.of(2023, 12, 19), new DomicilioEntradaDto("avenida", 457, "suba", "bogota"));
            PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

            assertEquals("Jose", pacienteSalidaDto.getNombre());
            assertEquals(1, pacienteSalidaDto.getId());
        }

    @Order(2)
    @Test
    void deberiaRetornarseUnaListaNoVaciaDePacientes(){
        assertTrue(pacienteService.listarPacientes().size() > 0);
    }

    @Test
    @Order(3)
    void alIntentarEliminarUnPacienteYaEliminado_deberiaLanzarseUnResourceNotFoundException(){
        try{
            pacienteService.eliminarPaciente(1L);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));
    }





    }