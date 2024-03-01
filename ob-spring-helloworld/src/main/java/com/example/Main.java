package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Get an object from Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        String text = calculadora.holaMundo();
        System.out.println(text);

        //EJEMPLO 2
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());

        //EJEMPLO 3
        //Singleton beans reuse the code. Prototype does not.
        //Prototype is hardly used
    }
}
