package com.backend.clinica.controler;




import com.backend.clinica.entity.Paciente;

import com.backend.clinica.service.impl.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //POST
    @PostMapping("registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    //PUT
    @PutMapping("actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente pacienteModificado){
        return pacienteService.modificarPaciente(pacienteModificado);
    }

}
