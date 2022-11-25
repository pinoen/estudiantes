package com.pinoen.estudiantes.service;

import com.pinoen.estudiantes.entity.EstudianteDTO;
import com.pinoen.estudiantes.entity.MateriaDTO;

import java.util.Set;

public interface IMateriaService {

    void crearMateria(MateriaDTO materiaDTO);
    MateriaDTO leerMateria(Long id);
    void modificarMateria(MateriaDTO materiaDTO);
    void eliminarMateria(Long id);
    Set<MateriaDTO> getTodos();
}
