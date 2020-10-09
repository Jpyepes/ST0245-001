package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    HashMapPropio obj = new HashMapPropio();

	    obj.put("yepes", 1);
        obj.put("cristi", 2);
        obj.put("moncho", 3);

        System.out.println(obj.get("yepes"));
        System.out.println(obj.get("cristi"));
        System.out.println(obj.get("moncho"));

        HashMap<String, String> empresas = new HashMap<String, String>();

        Taller9.agregar(empresas, "google","usa");
        Taller9.agregar(empresas,"la locura", "colombia");


        System.out.println(Taller9.buscar(empresas,"google"));
        System.out.println(Taller9.contieneValue(empresas,"colombia"));
        System.out.println(Taller9.contieneValue(empresas,"japon"));
    }
}
