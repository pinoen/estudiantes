package com.pinoen.estudiantes.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.estudiantes.entity.Estudiante;
import com.pinoen.estudiantes.entity.EstudianteDTO;
import com.pinoen.estudiantes.repository.EstudianteRepository;
import com.pinoen.estudiantes.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IEstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public EstudianteDTO leerEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if(estudiante.isPresent()){
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }
        return estudianteDTO;
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Set<EstudianteDTO> getTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        Set<EstudianteDTO> estudianteDTOSet = new HashSet<>();
        for(Estudiante estudiante : estudiantes){
            estudianteDTOSet.add(mapper.convertValue(estudiante, EstudianteDTO.class));
        }
        return estudianteDTOSet;
    }
}
