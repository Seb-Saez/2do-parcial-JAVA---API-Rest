package com.spring5.spring5.controllers;

import com.spring5.spring5.entities.dto.estudiante.EstudianteCreate;
import com.spring5.spring5.entities.dto.estudiante.EstudianteDto;
import com.spring5.spring5.services.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    // traigo los metodos del service
    private final EstudianteService estudianteService;

    // listar todos los estudaintes (probado)

    // Get a http://localhost:8080/estudiantes

    @GetMapping
    public ResponseEntity<?> listarEstudiantes(){
        try{
            List<EstudianteDto> lista = estudianteService.listarEstudiantes();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // crear un estudiante (probado)

    /* POST a http://localhost:8080/estudiantes
     JSON body:

    {
        "nombre": "Carlos Albertinho",
            "matricula": 1003
    }
    */
    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody EstudianteCreate estudianteCreate){
        try{
            EstudianteDto nuevoEstudiante = estudianteService.crearEstudiante(estudianteCreate);
            return ResponseEntity.ok(nuevoEstudiante);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // traer estudiante por id (probado)
    // Get a http://localhost:8080/estudiantes/estudianteId(numero)

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEstudiantePorId(@PathVariable Long id){
        try{
            EstudianteDto estudiante = estudianteService.buscarEstudiantePorId(id);
            return ResponseEntity.ok(estudiante);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
