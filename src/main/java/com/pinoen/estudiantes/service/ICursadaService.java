package com.pinoen.estudiantes.service;

import com.pinoen.estudiantes.entity.CursadaDTO;
import com.pinoen.estudiantes.entity.MateriaDTO;

import java.util.Set;

public interface ICursadaService {

    void crearCursada(CursadaDTO cursadaDTO);
    CursadaDTO leerCursada(Long id);
    void modificarCursada(CursadaDTO cursadaDTO);
    void eliminarCursada(Long id);
    Set<CursadaDTO> getTodos();
}
