package com.Juegos.UT4Springboot_Lucas.service;

import com.Juegos.UT4Springboot_Lucas.modelo.Juego;
import com.Juegos.UT4Springboot_Lucas.repository.JuegoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JuegoServiceTest {


    @Mock
    private JuegoRepository repository;

    @InjectMocks
    private JuegoService service;

    private Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
        juego.setId(2L);
        juego.setNombre("The Legend of Zelda");
        juego.setEmpresa("Nintendo");
        juego.setLanzamiento(2017);
        juego.setValoracion(9.8);
    }

    @Test
    void  testGuardarJuego() {
        when(repository.save(any(Juego.class))).thenReturn(juego);
        Juego  guardado = service.guardarJuego(new  Juego());
        assertNotNull(guardado);
        assertEquals("The Legend of Zelda", guardado.getNombre());
        verify(repository, times(1)).save(any(Juego.class));
    }

    @Test
    void  testObtenerTodos() {
        when(repository.findAll()).thenReturn(List.of(juego));

        List<Juego> lista = service.obtenerTodos();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        verify(repository, times(1)).findAll();
    }
}