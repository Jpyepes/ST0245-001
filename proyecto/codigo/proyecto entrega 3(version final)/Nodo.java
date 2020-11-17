import javafx.util.Pair;
/**
     * La clase Nodo contiene dos constructores y 5 getters con sus respectivos atributos que permiten la 
     * creacion del arbol en posteriores clases.
     * Esta clase esta basada en el video "Let’s Write a Decision Tree Classifier from Scratch2": https://www.youtube.com/watch?v=LDRbO9a6XPU
     *
  */
public class Nodo
{
    private Etiqueta e1;
    private Nodo Derecho;
    private Nodo Izquierdo;
    private String[][] datos;
    private nodoHoja hoja;

    public Nodo(Etiqueta e1, Nodo Derecho, Nodo Izquierdo,  String[][] datos){
        this.e1=e1;
        this.Derecho=Derecho;
        this.Izquierdo=Izquierdo;
        this.datos=datos;
        this.hoja=null;
    }

    public Nodo(String [][] hoja){
        this.e1=null;
        this.Derecho=null;
        this.Izquierdo=null;
        this.datos=null;
        this.hoja=new nodoHoja(hoja);
    }

    public Etiqueta getEtiqueta(){
        return this.e1;
    }

    public Nodo getDerecho(){
        return this.Derecho;
    }

    public Nodo getIzquierdo(){
        return this.Izquierdo;
    }

    public String[][] getDatos(){
        return this.datos;
    }

    public nodoHoja getHoja(){
        return this.hoja;
    }
}
