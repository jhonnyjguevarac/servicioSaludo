/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.exception.ProductoNotFoundException;
import com.example.modelo.Producto;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;



/**
 *
 * @author CEC
 *
 *
 */
@RestController
@RequestMapping("/productos")
public class ProductoService {

    private List<Producto> lista = Arrays.asList(new Producto(1L, "Laptop", 850.00),new Producto(2L, "Mouse", 25.50));

    @GetMapping("/{id}")
    public EntityModel<Producto> getProducto(@PathVariable Long id) {
        Producto p = lista.stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNotFoundException(id)); // Lanza excepción si no existe
        
        return EntityModel.of(p,
                linkTo(methodOn(ProductoService.class).getProducto(id)).withSelfRel(),
                linkTo(methodOn(ProductoService.class).getAll()).withRel("todos"));
    }

    @GetMapping
    public CollectionModel<EntityModel<Producto>> getAll() {
        List<EntityModel<Producto>> productos = lista.stream()
                .map(prod -> EntityModel.of(prod,
                        linkTo(methodOn(ProductoService.class).getProducto(prod.getId())).withSelfRel()))
                .toList();

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoService.class).getAll()).withSelfRel());
    }
}

