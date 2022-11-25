package com.pinoen.estudiantes.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.estudiantes.entity.Cursada;
import com.pinoen.estudiantes.entity.CursadaDTO;
import com.pinoen.estudiantes.entity.Materia;
import com.pinoen.estudiantes.entity.MateriaDTO;
import com.pinoen.estudiantes.repository.CursadaRepository;
import com.pinoen.estudiantes.service.ICursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CursadaService implements ICursadaService {

    @Autowired
    private CursadaRepository cursadaRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public CursadaDTO leerCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDTO = null;
        if(cursada.isPresent()){
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }
        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> getTodos() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        Set<CursadaDTO> cursadaDTOSet = new HashSet<>();
        for(Cursada cursada : cursadas){
            cursadaDTOSet.add(mapper.convertValue(cursada, CursadaDTO.class));
        }
        return cursadaDTOSet;
    }
}
