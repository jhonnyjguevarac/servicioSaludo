/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import lombok.Data;

/**
 *
 * @author CEC
 */
@Data
public class Empresa {

    private Long id;
    private Long idCategoria;
    private Long ruc;
    private String descripcion;

    public Empresa(Long id, Long idCategoria, Long ruc, String descripcion) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.ruc = ruc;
        this.descripcion = descripcion;
    }

  
}
