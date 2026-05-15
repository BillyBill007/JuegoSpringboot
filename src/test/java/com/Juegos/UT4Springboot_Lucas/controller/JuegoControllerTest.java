package com.Juegos.UT4Springboot_Lucas.controller;

import com.Juegos.UT4Springboot_Lucas.modelo.Juego;
import com.Juegos.UT4Springboot_Lucas.service.JuegoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JuegoController.class)
public  class  JuegoControllerTest {

    @Autowired
    private  MockMvc  mockMvc;

    @MockitoBean
    private  JuegoService  service;

    @Test
    void  testListarTodosEndpoint() throws  Exception {
        Juego  e = new  Juego();
        e.setNombre("Doom");

        when(service.obtenerTodos()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/juegos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Doom"));
    }
}