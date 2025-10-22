package com.spring5.spring5.entities.dto.curso;

import com.spring5.spring5.entities.dto.estudiante.EstudianteDto;
import com.spring5.spring5.entities.dto.profesor.ProfesorDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDto {

    private long id;
    private String nombre;
    private List<EstudianteDto> estudiantes;
    private ProfesorDto profesor;

}
