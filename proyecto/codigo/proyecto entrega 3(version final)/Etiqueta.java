/**
     * La clase Etiqueta contiene 1 constructor y 2 getters con sus respectivos atributos que permiten tener 
     * presente la columna y el mejor valor para asi lelgar al metodo comparar en donde retorna true en el
     * caso de que el valor sea menor o igual a el mejorValor
     * Esta clase esta basada en el video "Let’s Write a Decision Tree Classifier from Scratch2": https://www.youtube.com/watch?v=LDRbO9a6XPU
  */
public class Etiqueta
{
    private int index;
    private int mejorValor;

    public Etiqueta(int index, int mejorValor){
        this.index=index;
        this.mejorValor=mejorValor;
    }

    public int getIndex(){
        return this.index;
    }

    public int getMejorValor(){
        return this.mejorValor;
    }

    public boolean comparar(String [] fila){
        boolean respuesta = false;
        int valor=(int)Float.parseFloat(fila[this.index]);
        if(valor<=this.mejorValor){
            respuesta = true;
        }
        return respuesta;
    }
    
}
