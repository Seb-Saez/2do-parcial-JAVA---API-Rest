package com.spring5.spring5.services;

import com.spring5.spring5.entities.Curso;
import com.spring5.spring5.entities.Estudiante;
import com.spring5.spring5.entities.Profesor;
import com.spring5.spring5.entities.dto.curso.CursoCreate;
import com.spring5.spring5.entities.dto.curso.CursoDto;
import com.spring5.spring5.entities.dto.curso.CursoMapper;
import com.spring5.spring5.repositories.CursoRepository;
import com.spring5.spring5.repositories.EstudianteRepository;
import com.spring5.spring5.repositories.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;
    private final EstudianteRepository estudianteRepository;

    // listar todos los cursos

    public List<CursoDto> listarCursos(){
        return cursoRepository.findAll()
                .stream()
                .map(CursoMapper::toDto)
                .toList();
    }


    // crear un curso con profesor

    public CursoDto crearCurso(CursoCreate cursoCreate) {

        // espero que esto ande, porque tuve que agregar en CursoCreate el profesorId y tal vez haya que modificarlo
        // aca busco un profe basicamente en el profeRepository y le mando el ID que trae el dtoCreate de curso
        Profesor profesor = profesorRepository.findById(cursoCreate.profesorId())
                .orElseThrow( ()-> new RuntimeException("No se encontro un profesor con id: " + cursoCreate.profesorId()));

        // paso el curso a entidad para setearle el profesor
        Curso curso = CursoMapper.toEntity(cursoCreate);
        curso.setProfesor(profesor);

        // persisto el curso
        cursoRepository.save(curso);
        // paso a DTO de nuevo el curso para devolverselo al cliente
        return CursoMapper.toDto(curso);

    }


    // asignar un estudiante a un curso

    public CursoDto asignarEstudiante(Long cursoId, List<Long> estudianteIds){
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(()-> new RuntimeException("No se encontro un curso con id: " + cursoId));

        List<Estudiante> estudiantes = estudianteRepository.findAllById(estudianteIds);

        if (estudiantes.isEmpty()){
            throw new RuntimeException("No se encontraron estudiantes con esos valores");
        }

        curso.getEstudiantes().addAll(estudiantes);
        cursoRepository.save(curso);
        return CursoMapper.toDto(curso);
    }


    // Listar cursos en los que está un estudiante
    public List<CursoDto> traerCursosPorEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("No se encontro ningun estudiante con id: " + estudianteId));

        return estudiante.getCursos()
                .stream()
                .map(CursoMapper::toDto)
                .toList();
    }

    // traer un curso por id

    public CursoDto traerCursoPorId(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro un curso con id: " + id));
        return CursoMapper.toDto(curso);
    }





}
