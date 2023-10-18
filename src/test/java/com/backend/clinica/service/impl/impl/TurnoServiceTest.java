package com.backend.clinica.service.impl.impl;


import com.backend.clinica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinica.dto.salida.Turno.TurnoSalidaDto;
import com.backend.clinica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica.exceptions.BadRequestException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations =  "classpath:applicationTest.properties")
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    private static PacienteEntradaDto paciente;
    private static OdontologoEntradaDto odontologo;


    @BeforeAll
    public static void init() {
        paciente = new PacienteEntradaDto("Lu", "Murga", 65436546, LocalDate.of(2023, 8, 30), new DomicilioEntradaDto("Calle", 1, "Localidad", "Provincia"));
        odontologo = new OdontologoEntradaDto("AD-564656546456", "Patricia", "Lopez");
            }

    @Test
    @Order(1)
    void deberiaRegistrarseUnTurnoAsignadoAOdontologoYPacienteExistentes() throws BadRequestException {
        PacienteSalidaDto pacienteResponseDto = pacienteService.registrarPaciente(paciente);
        OdontologoSalidaDto odontologoResponseDto = odontologoService.registrarOdontologo(odontologo);

        TurnoSalidaDto turnoResponseDto = turnoService.registrarTurno(new TurnoEntradaDto(pacienteResponseDto.getId(), odontologoResponseDto.getId(), LocalDateTime.of(LocalDate.of(2023, 10, 01), LocalTime.of(12, 30))));
        Assertions.assertNotNull(turnoResponseDto);
        Assertions.assertNotNull(turnoResponseDto.getId());
        Assertions.assertEquals("Lu", turnoResponseDto.getPacienteTurnoSalidaDto().getNombre());
    }




    @Test
    @Order(2)
    void deberiaEncontrarTurnoId1() {
        TurnoSalidaDto turnoResponseDto = turnoService.buscarTurnoPorId(1L);
        Assertions.assertNotNull(turnoResponseDto);
        Assertions.assertNotNull(turnoResponseDto.getFechaYHora());

    }

}