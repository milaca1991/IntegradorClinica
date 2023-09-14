package com.backend.clinica.controler;

import com.backend.clinica.dto.entrada.modificacion.turnoModificacionEntradaDto;
import com.backend.clinica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinica.dto.salida.Turno.TurnoSalidaDto;
import com.backend.clinica.exceptions.BadRequestException;
import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.service.impl.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.Valid;
import java.util.List;


//marcar una clase como un controlador de servicios web RESTful. Indica que los métodos dentro de esta clase responderán a solicitudes HTTP y devolverán datos en un formato compatible con REST, como JSON.
@RestController

@CrossOrigin(origins = "http://localhost:63342")
//se utiliza para mapear solicitudes HTTP a métodos específicos en el controlador. En este caso, se está configurando el controlador para manejar solicitudes que tengan la ruta "/turnos". Cuando se recibe una solicitud que coincide con esta ruta, el método correspondiente dentro del controlador se ejecutará.
@RequestMapping("/turnos")

public class TurnoController {


    private ITurnoService TurnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.TurnoService = turnoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@Valid @RequestBody TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        return new ResponseEntity<>(TurnoService.registrarTurno(turnoEntradaDto), HttpStatus.CREATED);
    }



    //PUT
    @PutMapping("actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@Valid @RequestBody turnoModificacionEntradaDto.TurnoModificacionEntradaDto turnoModificacionEntradaDto) throws ResourceNotFoundException {
        return new ResponseEntity<>(TurnoService.modificarTurno(turnoModificacionEntradaDto), HttpStatus.OK);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<TurnoSalidaDto> obtenerTurnoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(TurnoService.buscarTurnoPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TurnoSalidaDto>> listarTurnos() {
        return new ResponseEntity<>(TurnoService.listarTurnos(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        TurnoService.eliminarTurno(id);
        return new ResponseEntity<>("Turno eliminado correctamente", HttpStatus.OK);
    }




}
