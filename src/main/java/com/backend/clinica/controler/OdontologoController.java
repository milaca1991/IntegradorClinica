package com.backend.clinica.controler;
import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.service.impl.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.backend.clinica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica.dto.entrada.modificacion.odontologoModificacionEntradaDto;
import org.springframework.web.bind.annotation.*;
import com.backend.clinica.service.impl.impl.OdontologoService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/odontologos")
public class    OdontologoController {

    private final IOdontologoService odontologoService;


    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //POST
    @PostMapping("registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody odontologoModificacionEntradaDto odontologo)throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<OdontologoSalidaDto> obtenerOdontologoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologos() {
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo eliminado correctamente", HttpStatus.NO_CONTENT);
    }


}
