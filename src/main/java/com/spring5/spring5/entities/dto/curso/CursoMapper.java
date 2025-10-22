package com.spring5.spring5.entities.dto.curso;

import com.spring5.spring5.entities.Curso;
import com.spring5.spring5.entities.dto.estudiante.EstudianteMapper;
import com.spring5.spring5.entities.dto.profesor.ProfesorMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CursoMapper {

    public static Curso toEntity (CursoCreate cursoDto){
        Curso curso= new Curso();
        curso.setNombre(cursoDto.nombre());

        return curso;
    };


    public static CursoDto toDto(Curso curso) {
        return CursoDto.builder()
                .id(curso.getId())
                .nombre(curso.getNombre())
                .estudiantes(curso.getEstudiantes().stream().map(EstudianteMapper::toDto).toList())
                .profesor(ProfesorMapper.toDto(curso.getProfesor()))
                .build();
    }
}




