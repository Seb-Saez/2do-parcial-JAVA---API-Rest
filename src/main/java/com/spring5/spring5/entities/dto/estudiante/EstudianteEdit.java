package com.spring5.spring5.entities.dto.estudiante;

import com.spring5.spring5.entities.dto.curso.CursoDto;

import java.util.List;

public record EstudianteEdit(
        List<CursoDto> cursos
) {
}
