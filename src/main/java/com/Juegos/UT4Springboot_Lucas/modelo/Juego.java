package com.Juegos.UT4Springboot_Lucas.modelo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "juego")
@Data
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String empresa;
    private int lanzamiento;
    private double valoracion;
}