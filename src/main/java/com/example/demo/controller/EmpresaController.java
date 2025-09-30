/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.exception.ProductoNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author CEC
 */
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private List<Empresa> lista = new ArrayList<>();

    @GetMapping
    public CollectionModel<EntityModel<Empresa>> getAll() {
        List<EntityModel<Empresa>> productos = lista.stream()
                .map(prod -> EntityModel.of(prod,
                linkTo(methodOn(ProductoService.class).getProducto(prod.getId())).withSelfRel()))
                .toList();

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoService.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Empresa> getProducto(@PathVariable Long id) {
        Empresa p = lista.stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNotFoundException(id)); // Lanza excepción si no existe

        return EntityModel.of(p,
                linkTo(methodOn(ProductoService.class).getProducto(id)).withSelfRel(),
                linkTo(methodOn(ProductoService.class).getAll()).withRel("todos"));
    }

    @PostMapping("/crear")
    public String setProducto(@RequestBody Empresa empresa) {
        lista.add(empresa);
        return "Ingresado";
    }

    @DeleteMapping("/eliminar")
    public String deleteEmpresa(@RequestBody Empresa empresa) {
        for (Empresa emp : lista) {
            if (emp.getId().equals(empresa.getId())) {
                lista.remove(emp);
                break;
            }
        }

        return "acción realizada";
    }

}
