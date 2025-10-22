package com.spring5.spring5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nombre;
    private String email;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Curso> cursos;
}
