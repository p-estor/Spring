package com.example;

import org.springframework.stereotype.Component;

//Using component here allows beans.xml to scan for objects to execute
@Component
public class Calculadora {

    public Calculadora(){
        System.out.println("Ejecutando constructor CalculatorService");
    }
    public String holaMundo() {
        return "Hola mundo!";

    }
}
