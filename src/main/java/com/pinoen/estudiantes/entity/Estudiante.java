package com.pinoen.estudiantes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "estudiante")
    @JsonIgnore
    private Set<Cursada> cursadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Cursada> getCursadas() {
        return cursadas;
    }

    public void setCursadas(Set<Cursada> cursadas) {
        this.cursadas = cursadas;
    }
}
