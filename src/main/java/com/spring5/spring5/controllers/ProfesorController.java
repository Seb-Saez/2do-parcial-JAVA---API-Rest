package com.spring5.spring5.controllers;

import com.spring5.spring5.entities.dto.profesor.ProfesorCreate;
import com.spring5.spring5.entities.dto.profesor.ProfesorDto;
import com.spring5.spring5.services.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    //  con esto spring va a inyectar ProfesorService en el contructor como parametro automatico
    private final ProfesorService profesorService;


    // listar todos los profes (probado)
    /*
    GET al http://localhost:8080/profesores sin nada mas
     */
    @GetMapping
    public ResponseEntity<?> listarProfesores(){
        try{
            List<ProfesorDto> lista = profesorService.listarProfesores();
            return ResponseEntity.ok(lista);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // crear un profe (probado)
   /* Post al http://localhost:8080/profesores
    JSON body:
    {

        "nombre": "Jorge Martinez",
            "email": "jorge@mail.com"
    }*/

    @PostMapping
    public  ResponseEntity<?> crearProfesor(@RequestBody ProfesorCreate profesorCreate){
        try{
            ProfesorDto nuevoProfesor = profesorService.crearProfesor(profesorCreate);
            return ResponseEntity.ok(nuevoProfesor);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // obtener profe por id (probado)
    /*
    GET al http://localhost:8080/profesores/profeID
    */

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProfesorPorId(@PathVariable Long id){
        try{
            ProfesorDto profesor = profesorService.buscarProfesorPorId(id);
            return ResponseEntity.ok(profesor);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
