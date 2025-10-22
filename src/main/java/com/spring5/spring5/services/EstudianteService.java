package com.spring5.spring5.services;

import com.spring5.spring5.entities.Estudiante;
import com.spring5.spring5.entities.dto.estudiante.EstudianteCreate;
import com.spring5.spring5.entities.dto.estudiante.EstudianteDto;
import com.spring5.spring5.entities.dto.estudiante.EstudianteMapper;
import com.spring5.spring5.repositories.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    // listar todos los estudiantes

    public List<EstudianteDto> listarEstudiantes(){
        return estudianteRepository.findAll()
                .stream()
                .map(EstudianteMapper::toDto)
                .toList();
    }


    // crear estudiante nuevo

    public EstudianteDto crearEstudiante(EstudianteCreate estudianteCreate){
        // le paso un dtoCreate para pasarlo a entidad con el mapper
        Estudiante nuevoEstudiante = EstudianteMapper.toEntity(estudianteCreate);
        // guardo la entidad en la BBDD usando el repository
        estudianteRepository.save(nuevoEstudiante);
        // paso la entidad a DTO de vuelta para mostrarla despues en el cliente
        return EstudianteMapper.toDto(nuevoEstudiante);
    }

    // buscar estudiante por ID

    public EstudianteDto buscarEstudiantePorId(Long id){
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro un estudiante con el id: " + id));
        return EstudianteMapper.toDto(estudiante);
    }

}
