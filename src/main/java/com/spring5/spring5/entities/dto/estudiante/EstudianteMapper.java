package com.spring5.spring5.entities.dto.estudiante;

import com.spring5.spring5.entities.Estudiante;

public class EstudianteMapper {


    public static EstudianteDto toDto(Estudiante estudiante){
        return EstudianteDto.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .matricula(estudiante.getMatricula())
                .build();
    }

    public static Estudiante toEntity(EstudianteCreate estudianteCreate){
        return Estudiante.builder()
                .nombre(estudianteCreate.nombre())
                .matricula(estudianteCreate.matricula())
                .build();

    }

}
