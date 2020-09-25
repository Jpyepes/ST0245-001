package com.company;

public class Nevera {
    int codigo;
    String marca;

    public Nevera(int codigo, String marca){
        this.codigo = codigo;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Nevera{" +
                "codigo=" + codigo +
                ", marca='" + marca + '\'' +
                '}';
    }
}
