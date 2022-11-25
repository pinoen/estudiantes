package com.pinoen.estudiantes.controller;

import com.pinoen.estudiantes.entity.MateriaDTO;
import com.pinoen.estudiantes.service.impl.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @PostMapping
    public ResponseEntity<?> crearMateria(@RequestBody MateriaDTO materiaDTO){
        materiaService.crearMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public MateriaDTO getMateria(@PathVariable Long id){
        return materiaService.leerMateria(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarMateria(@RequestBody MateriaDTO materiaDTO){
        materiaService.modificarMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMateria(@PathVariable Long id){
        materiaService.eliminarMateria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<MateriaDTO> getTodosEstudiantes(){
        return materiaService.getTodos();
    }
}
