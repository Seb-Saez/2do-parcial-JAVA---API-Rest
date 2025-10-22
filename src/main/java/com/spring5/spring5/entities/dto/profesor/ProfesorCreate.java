package com.spring5.spring5.entities.dto.profesor;

import com.spring5.spring5.entities.dto.curso.CursoDto;

import java.util.List;

public record ProfesorCreate(
        String nombre,
        String email
) {
}
