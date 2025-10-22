package com.spring5.spring5.entities.dto.profesor;

import com.spring5.spring5.entities.dto.curso.CursoDto;

import java.util.List;

public record ProfesorEdit(
        List<CursoDto> cursos
) {
}
