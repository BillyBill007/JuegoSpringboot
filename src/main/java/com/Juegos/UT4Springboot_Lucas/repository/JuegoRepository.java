package com.Juegos.UT4Springboot_Lucas.repository;

import com.Juegos.UT4Springboot_Lucas.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego,  Long> {
// Al extender JpaRepository, ya tenemos métodos como save(), findAll(), findById(), deleteById()

}