package com.pinoen.estudiantes.repository;

import com.pinoen.estudiantes.entity.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursadaRepository extends JpaRepository<Cursada, Long> {
}
