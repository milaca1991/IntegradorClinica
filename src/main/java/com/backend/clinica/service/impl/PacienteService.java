package com.backend.clinica.service.impl;

import com.backend.clinica.dto.entrada.modificacion.pacienteModificacionEntradaDto;
import com.backend.clinica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica.entity.Paciente;
import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;


    //hacer la conversion entre el dt y la entidad
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente){
        Paciente pacGuardado = pacienteRepository.save(dtoEntradaAEntidad(paciente));
        PacienteSalidaDto pacienteSalidaDto = entidadADtoSalida(pacGuardado);
        LOGGER.info("Paciente guardado: {}", pacienteSalidaDto);
        return pacienteSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) {

        Paciente pacienteBuscado = pacienteRepository.findById(id).orElse(null);

        PacienteSalidaDto pacienteSalidaDto = null;
        if (pacienteBuscado != null) {
            pacienteSalidaDto = entidadADtoSalida(pacienteBuscado);
            LOGGER.info("Paciente encontrado: {}", pacienteSalidaDto);
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return pacienteSalidaDto;

    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {

    }


    @Override
    public List<PacienteSalidaDto> listarPacientes(){

        List<PacienteSalidaDto> pacientes = pacienteRepository.findAll().stream()
                .map(this::entidadADtoSalida).toList();

        LOGGER.info("Listado de todos los pacientes: {}", pacientes);

        return pacientes;
    }


    public void eliminarPaciente(long id){

        if (buscarPacientePorId(id) != null) {
            pacienteRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el paciente con id {}", id);
            throw new ResourceNotFoundException("no se ha encontrado");
        }
    }



    private void configureMapping() {
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilio, Paciente::setDomicilio));
        modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                .addMappings(mapper -> mapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilio));
        modelMapper.typeMap(pacienteModificacionEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(pacienteModificacionEntradaDto::getDomicilio, Paciente::setDomicilio));

    }



    @Override
    public PacienteSalidaDto modificarPaciente(pacienteModificacionEntradaDto pacienteModificado) {
             /*
      PacienteSalidaDto pacienteSalidaDto = null;
      Paciente pacienteAModificar = pacienteIDao.buscarPorId(pacienteModificado.getId());

      if(pacienteAModificar != null){
          pacienteAModificar = dtoModificadoAEntidad(pacienteModificado);
          pacienteSalidaDto = entidadADtoSalida(pacienteIDao.modificar(pacienteAModificar));

      }

      return pacienteSalidaDto;

          */
        return null;

        }






        //metodos


    public Paciente dtoEntradaAEntidad(PacienteEntradaDto pacienteEntradaDto) {
        return modelMapper.map(pacienteEntradaDto, Paciente.class);
    }

    public PacienteSalidaDto entidadADtoSalida(Paciente paciente) {
        return modelMapper.map(paciente, PacienteSalidaDto.class);
    }

    public Paciente dtoModificadoAEntidad(pacienteModificacionEntradaDto pacienteEntradaDto) {
        return modelMapper.map(pacienteEntradaDto, Paciente.class);
    }

}
