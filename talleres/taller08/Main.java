package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Polaca pol = new Polaca();

        System.out.println(pol.notacionPolacaInversa("14 10 +"));

        Ejercicio2 obj = new Ejercicio2();
        Queue<Solicitud> cola = new LinkedList<>();
        Stack<Nevera> pila = new Stack<>();

        cola.add(new Solicitud("La vaquita", 1));
        cola.add(new Solicitud("exito", 2));
        cola.add(new Solicitud("homecenter", 3));
        //--------------------------------------------------------
        pila.push(new Nevera(1, "Haceb"));
        pila.push(new Nevera(2, "Challenger"));
        pila.push(new Nevera(3, "Whirpool"));
        pila.push(new Nevera(4, "Bosch"));
        pila.push(new Nevera(5, "Samsung"));

        obj.almacen(cola, pila);
    }
}
