/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CEC recibe eñl nombre de ñla persona clase persona, con metodo post
 *
 */
@RequestMapping("/api/vl/persona/")
@RestController()
public class Saludo {

    List<String> lista = new ArrayList();

    @GetMapping("obtener")
    public List<String> obtener() {
        return lista;
    }

    @PutMapping("guardar")
    public String agregarPersona(@RequestParam String persona) {
        lista.add(persona);
        return "Guardado con éxito";
    }

      @GetMapping("saludo")
    public String obtener(@RequestParam String persona) {
        return "Hola Bienvenido "+persona;
    }

    
}
