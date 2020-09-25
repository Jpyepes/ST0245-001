package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ejercicio2 {
    public void almacen(Queue<Solicitud> cola, Stack<Nevera> pila){
        while(cola.peek()!= null ){
            int num = cola.peek().cantidad;
            System.out.println(cola.poll().toString()+ ": ");
            for(int i=0; i<num; i++){
                if(!pila.isEmpty()){
                    System.out.println("** " + pila.pop().toString());
                }
            }
        }
    }
}
