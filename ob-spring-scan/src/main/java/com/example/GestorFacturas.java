package com.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    Calculadora calculadora;
    String nombre;

    GestorFacturas(Calculadora calculadora){

        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
    }
//
//    GestorFacturas(Calculadora calculadora, String nombre){
//
//        System.out.println("Ejecutando constructor GestorFacturas");
//        this.calculadora = calculadora;
//        this.nombre = nombre;
//    }
}
