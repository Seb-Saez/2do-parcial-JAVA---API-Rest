package com.spring5.spring5.entities.dto.profesor;

import com.spring5.spring5.entities.Profesor;

public class ProfesorMapper {
    public static Profesor toEntity(ProfesorCreate profesorCreate){
        return Profesor.builder()
                .nombre(profesorCreate.nombre())
                .email(profesorCreate.email())
                .build();
        }
    public static ProfesorDto toDto(Profesor profesor){
        return ProfesorDto.builder()
                .id(profesor.getId())
                .nombre(profesor.getNombre())
                .email(profesor.getEmail())
                .build();
    }


}
