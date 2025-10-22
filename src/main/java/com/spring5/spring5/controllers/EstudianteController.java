package com.spring5.spring5.controllers;

import com.spring5.spring5.entities.dto.estudiante.EstudianteDto;
import com.spring5.spring5.services.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    // traigo los metodos del service
    private final EstudianteService estudianteService;

    // listar todos los estudaintes

    @GetMapping
    public ResponseEntity<?> listarEstudiantes(){
        try{
            List<EstudianteDto> lista = estudianteService.listarEstudiantes();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // crear un estudiante
}
