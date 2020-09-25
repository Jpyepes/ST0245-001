package com.company;

import java.util.Stack;

public class Polaca {
    public static int notacionPolacaInversa(String s){
        String simbolos = "+-*/";
        Stack<Integer> pila = new Stack();


        if (s.length() > 2) {
            for (String subcadena : s.split(" ")) {

                if (simbolos.contains(subcadena)) {
                    if (subcadena.equals("+")) {
                        pila.push(pila.pop() + pila.pop());
                    }

                    if (subcadena.equals("-")) {
                        pila.push(-1 * pila.pop() + pila.pop());
                    }
                    if (subcadena.equals("*")) {
                        pila.push(pila.pop() * pila.pop());
                    }
                    if (subcadena.equals("/")) {
                        int numeroDeArriba = pila.pop();
                        int numeroDeAbajo = pila.pop();
                        pila.push(numeroDeAbajo / numeroDeArriba);
                    }
                }
                else
                    pila.push(Integer.parseInt(subcadena));
            }
        }
        return pila.pop();
    }
}




