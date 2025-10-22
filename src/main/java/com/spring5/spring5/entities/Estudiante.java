package com.spring5.spring5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private long matricula;

    @ManyToMany(mappedBy = "estudiantes")
    @Builder.Default // ojo aca toque
    private List<Curso> cursos = new ArrayList<>(); // aca tambien inicialice el array
}
