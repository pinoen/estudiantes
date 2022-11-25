package com.pinoen.estudiantes.controller;

import com.pinoen.estudiantes.entity.EstudianteDTO;
import com.pinoen.estudiantes.service.impl.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EstudianteDTO getEstudiante(@PathVariable Long id){
        return estudianteService.leerEstudiante(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        estudianteService.modificarEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable Long id){
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<EstudianteDTO> getTodosEstudiantes(){
        return estudianteService.getTodos();
    }
}
