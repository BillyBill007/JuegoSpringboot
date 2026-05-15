package com.Juegos.UT4Springboot_Lucas.controller;

import com.Juegos.UT4Springboot_Lucas.modelo.Juego;
import com.Juegos.UT4Springboot_Lucas.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/juegos")

public class JuegoController {
    // Volvemos a usar Inyección de Dependencias para traer el Service
    @Autowired
    private JuegoService service;
    // Endpoint para guardar (POST: http://localhost:8080/api/juegos)
    @PostMapping
    public Juego crear(@RequestBody Juego game) {
        return service.guardarJuego(game);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/estudiantes)
    @GetMapping
    public List<Juego> listarTodos() {
        return service.obtenerTodos();
    }
}
