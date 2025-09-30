/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CEC
 *
 *
 */
@RequestMapping("/api/vl/servicio/")
@RestController()
public class Persona {

    @Operation(
            summary = "Obtiene un usuario por ID",
            description = "Retorna un usuario específico si existe en la base de datos"
    )
    @ApiResponse(responseCode = "200", description = "No existe Bienvenida")
    @ApiResponse(responseCode = "404", description = "No existe Bienvenida")

    @GetMapping("/sumar")
    public String sumar(
            @RequestParam int a,
            @RequestParam int b
    ) {
        int suma = a + b;
        return "La suma es: " + suma;
    }
}
