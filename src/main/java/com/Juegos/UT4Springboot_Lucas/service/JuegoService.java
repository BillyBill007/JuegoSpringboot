package com.Juegos.UT4Springboot_Lucas.service;

import com.Juegos.UT4Springboot_Lucas.modelo.Juego;
import com.Juegos.UT4Springboot_Lucas.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class JuegoService {
    @Autowired
    private JuegoRepository repository;

    // Crear un estudiante en base de datos
    public Juego guardarJuego(Juego estudiante) {
        return repository.save(estudiante);
    }

    // Obtener todos los estudiantes de la base de datos
    public List<Juego> obtenerTodos() {
        return repository.findAll();
    }
}