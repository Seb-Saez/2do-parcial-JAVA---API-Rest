package com.spring5.spring5.services;

import com.spring5.spring5.entities.Profesor;
import com.spring5.spring5.entities.dto.profesor.ProfesorCreate;
import com.spring5.spring5.entities.dto.profesor.ProfesorDto;
import com.spring5.spring5.entities.dto.profesor.ProfesorMapper;
import com.spring5.spring5.repositories.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    // listar toos los profes

    public List<ProfesorDto> listarProfesores(){
        return profesorRepository.findAll()
                .stream()
                .map(ProfesorMapper::toDto)
                .toList();
    }

    // crear un profesor nuevo
    // ojo en esta funcion me costo entenderla leer bien los comentarios

    public ProfesorDto crearProfesor(ProfesorCreate profesorCreate){
        // le paso un dto profeCreate, lo paso a entidad para guardarlo
        Profesor profesor = ProfesorMapper.toEntity(profesorCreate);
        // guardo una entidad en la BBDD, porque no se pueden guardar dtos
        profesorRepository.save(profesor);
        // vuelvo a pasarle la entidad a DTO para responderle al cliente, seguramente con un json
        return ProfesorMapper.toDto(profesor);
    }

    // buscar profesor por id

    public ProfesorDto buscarProfesorPorId(Long id){
        // le paso el id de la entidad para traerla de la BBDD
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro un profesor con el id: " + id));
        // paso la entidad a DTO para mostrarlo en el cliente
        return ProfesorMapper.toDto(profesor);
    }

}
