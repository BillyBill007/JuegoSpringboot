package com.Juegos.UT4Springboot_Lucas.service;

import com.Juegos.UT4Springboot_Lucas.exceptions.RecursoNoEncontradoException;
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

    public void borrarJuego(Long id) {
        Juego juego = repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Juego no encontrado con id " + id));

        repository.delete(juego);
    }

    public Juego actualizarJuego(Long id, Juego juegoActualizado) {
        Juego juego = repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Juego no encontrado con id " + id));

        juego.setNombre(juegoActualizado.getNombre());
        juego.setEmpresa(juegoActualizado.getEmpresa());
        juego.setLanzamiento(juegoActualizado.getLanzamiento());
        juego.setValoracion(juegoActualizado.getValoracion());

        return repository.save(juego);
    }
}