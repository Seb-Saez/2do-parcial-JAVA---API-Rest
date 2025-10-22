package com.spring5.spring5.entities.dto.estudiante;

import com.spring5.spring5.entities.Curso;
import com.spring5.spring5.entities.dto.curso.CursoDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstudianteDto {
    private Long id;
    private String nombre;
    private Long matricula;
}

