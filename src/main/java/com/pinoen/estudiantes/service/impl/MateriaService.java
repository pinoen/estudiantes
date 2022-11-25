package com.pinoen.estudiantes.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.estudiantes.entity.Estudiante;
import com.pinoen.estudiantes.entity.EstudianteDTO;
import com.pinoen.estudiantes.entity.Materia;
import com.pinoen.estudiantes.entity.MateriaDTO;
import com.pinoen.estudiantes.repository.EstudianteRepository;
import com.pinoen.estudiantes.repository.MateriaRepository;
import com.pinoen.estudiantes.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public MateriaDTO leerMateria(Long id) {
            Optional<Materia> materia = materiaRepository.findById(id);
            MateriaDTO materiaDTO = null;
            if(materia.isPresent()){
                materiaDTO = mapper.convertValue(materia, MateriaDTO.class);
            }
            return materiaDTO;
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public Set<MateriaDTO> getTodos() {
        List<Materia> materias = materiaRepository.findAll();
        Set<MateriaDTO> materiaDTOSet = new HashSet<>();
        for(Materia materia : materias){
            materiaDTOSet.add(mapper.convertValue(materia, MateriaDTO.class));
        }
        return materiaDTOSet;
    }

}
