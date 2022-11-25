package com.pinoen.estudiantes.service.impl;

import com.pinoen.estudiantes.entity.EstudianteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstudianteServiceTest {

    @Autowired
    private EstudianteService estudianteService;

    @Test
    public void testCrearEstudiante(){
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre("Emilio");
        estudianteDTO.setApellido("Pino");

        estudianteService.crearEstudiante(estudianteDTO);

        EstudianteDTO estudianteDTO1 = estudianteService.leerEstudiante(1L);

        Assertions.assertTrue(estudianteDTO1 != null);
    }
}