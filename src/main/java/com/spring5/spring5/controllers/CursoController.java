package com.spring5.spring5.controllers;

import com.spring5.spring5.entities.dto.curso.CursoCreate;
import com.spring5.spring5.entities.dto.curso.CursoDto;
import com.spring5.spring5.repositories.CursoRepository;
import com.spring5.spring5.services.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    // listar todos los cursos

    @GetMapping
    public ResponseEntity<?> listarCursos(){
        try{
            List<CursoDto> cursos = cursoService.listarCursos();
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // crear un curso con un profesor:

    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody CursoCreate cursoCreate){
        try{
            CursoDto nuevoCurso = cursoService.crearCurso(cursoCreate);
            return ResponseEntity.ok(nuevoCurso);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    // asignar un estudianto a un curso mediante las IDs

    @PostMapping("/{cursoId}/asignarEstudiante")
    public ResponseEntity<?> asignarEstudiante(@PathVariable Long cursoId, @RequestBody List<Long> estudianteIds){
        try{
            CursoDto cursoActualizado = cursoService.asignarEstudiante(cursoId, estudianteIds);
            return ResponseEntity.ok(cursoActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // listar cursos en los que esta un estudiante

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<?> CursosPorEstudiante(@PathVariable Long estudianteId){
        try{
            List<CursoDto> cursos = cursoService.traerCursosPorEstudiante(estudianteId);
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // traer curso por ID

    @GetMapping("/{id}")
    public ResponseEntity<?> traerCursoPorId(@PathVariable Long id){
        try {
            CursoDto curso = cursoService.traerCursoPorId(id);
            return ResponseEntity.ok(curso);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
