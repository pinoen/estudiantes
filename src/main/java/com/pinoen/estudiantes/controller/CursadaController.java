package com.pinoen.estudiantes.controller;

import com.pinoen.estudiantes.entity.CursadaDTO;
import com.pinoen.estudiantes.service.impl.CursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cursadas")
public class CursadaController {

    @Autowired
    CursadaService cursadaService;

    @PostMapping
    public ResponseEntity<?> crearCursada(@RequestBody CursadaDTO cursadaDTO){
        cursadaService.crearCursada(cursadaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CursadaDTO getCursada(@PathVariable Long id){
        return cursadaService.leerCursada(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarCursada(@RequestBody CursadaDTO cursadaDTO){
        cursadaService.modificarCursada(cursadaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCursada(@PathVariable Long id){
        cursadaService.eliminarCursada(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<CursadaDTO> getTodosEstudiantes(){
        return cursadaService.getTodos();
    }
}
