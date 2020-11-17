import javafx.util.Pair;
/**
 * Esta clase esta basada en el video "Let’s Write a Decision Tree Classifier from Scratch": https://www.youtube.com/watch?v=LDRbO9a6XPU 
 */
public class ElArbolito
{
    private  Nodo raiz;
    /**
     * ElArbolito es un constructor de la clase que recibe una matriz y utiliza las diferente clases de este
     * proyecto para generar el Arbol
     * @param String [][] matriz, matriz a evaluar
     */
    public ElArbolito(String [][] raiz){
        Pair<Float, Pair<Integer, Integer>> mejorCondicion=Gini.mejorCondicion(raiz);
        int mejorValor = mejorCondicion.getValue().getKey();
        int columna = mejorCondicion.getValue().getValue();
        Etiqueta e1=new Etiqueta(columna, mejorValor);
        Pair<String[][], String[][]> division=Gini.dividirMatriz(raiz, columna, mejorValor);
        Nodo Derecho = CrearArbol(division.getKey());
        Nodo Izquierdo = CrearArbol(division.getValue());
        this.raiz= new Nodo(e1,Derecho,Izquierdo,raiz);
        this.CrearArbol(raiz);
    }

    public Nodo getRaiz(){
        return this.raiz;
    }

    /**
     * El metodo crearArbol utiliza un llamado recursivo con las dos ramas para asi crear el arbol, sin emabrgo, 
     * antes de este llamado hay diferentes condiciones para asegurarse de que no haya error alguno
     * @param String [][] datos, datos a evaluar
     * @return Nodo
     */
    public Nodo CrearArbol(String [][] matriz){

        if(matriz.length==0 || matriz==null){
            Nodo nuevaHoja = new Nodo(matriz);
            return nuevaHoja;
        }else{           
            Pair<Float, Pair<Integer, Integer>> mejorCondicion=Gini.mejorCondicion(matriz);
            double contmayorGanancia= mejorCondicion.getKey();
            int mejorValor=mejorCondicion.getValue().getKey();
            int columna=mejorCondicion.getValue().getValue();
            if(contmayorGanancia==0){
                Nodo nuevaHoja = new Nodo(matriz);
                return nuevaHoja;
            }
            Pair<String[][], String[][]> parejaMatriz=Gini.dividirMatriz(matriz, columna, mejorValor);
            if(parejaMatriz.getKey().length==0){
                Nodo nuevaHoja = new Nodo(parejaMatriz.getValue());
                return nuevaHoja;
            } 
            if(parejaMatriz.getValue().length==0){
                Nodo nuevaHoja = new Nodo(parejaMatriz.getKey());
                return nuevaHoja;
            }else{
                Nodo Derecho = CrearArbol(parejaMatriz.getKey()); 
                Nodo Izquierdo = CrearArbol(parejaMatriz.getValue()); 
                Etiqueta e1= new Etiqueta(columna, mejorValor);
                Nodo nodo = new Nodo(e1, Derecho, Izquierdo, matriz);
                return nodo;
            }
        }
    }

    /**
     * El metodo predecir por medio de la recursion intenta hacer la prediccion de un estudiante con base en 
     * los puntajes logrados
     * @param String [] estudiante, estudiante a evaluar
     * @param Nodo nodo raiz a evaluar
     * @return int
     */
    public int predecir(String [] estudiante, Nodo nodo){
        if(tieneHoja(nodo)){            
            return nodo.getHoja().contarPredicciones();
        }else if(nodo!=null){
            if(nodo.getEtiqueta().comparar(estudiante)){
                return predecir(estudiante,nodo.getDerecho()); 
            }else{
                return predecir(estudiante,nodo.getIzquierdo()); 
            }
        }else{
            return 0;
        }
    }

    public boolean tieneHoja (Nodo nodo){
        boolean respuesta = false;
        if(nodo!= null){
            if (nodo.getHoja()!= null){
                respuesta = true;
            }
        }
        return respuesta;
    }

}