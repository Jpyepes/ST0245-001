
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Collection;
import java.util.*;
/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Daniel Mesa
 */
// Nota: Hacen falta algunas partes de las lineas de codigo, estas estan
// indicadas con una linea, ¡debes completarlas!
public class DigraphAL extends Graph {
    private ArrayList<LinkedList< Pareja<Integer,Integer>>> nodo;

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);
        nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>() );
        }

    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        Pareja <Integer,Integer> p1 = new Pareja<Integer,Integer>(destination, weight);
        nodo.get(source).add(p1);
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    /*public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> n = new ArrayList<>();
        if (nodo.get(vertex).size() == 0)
            return null;
        if (nodo.get(vertex) == null)
            return null;
        for(Pareja<Integer,Integer> j : nodo.get(vertex)){
            if(j==null)
                break;
            n.add(j.first);
        }

        Collections.sort(n); 
        return n;
    }*/
    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> n = new ArrayList<>();

        nodo.get(vertice).forEach(i -> n.add(i.first));

        return n;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */	
    public int getWeight(int source, int destination) {
        int result = 0;
        for ( Pareja<Integer, Integer> integerIntegerPair : nodo.get(source)) {
            if (integerIntegerPair.first == destination) result = integerIntegerPair.second;
        }
        return result;
    }

    public  boolean caminoBFS (DigraphAL grafo, int origen,int destino){
        boolean[] verificados = new boolean [grafo.size()+1];
        return auxBFS(grafo,origen, destino,verificados);
    }

    public  boolean auxBFS (DigraphAL grafo, int origen,int destino, boolean[] verificados){
        System.out.println(grafo.getSuccessors(origen));
        ArrayList <Integer> visitados = grafo.getSuccessors(origen);
        Queue <Integer> cola = new LinkedList <Integer>();
        boolean resultado = false;
        verificados[origen] = true;
        if (origen == destino ){
            resultado = true;
        }

        for(int x : visitados){
            cola.add(x);
        }

        while (cola.size() != 0){
            int poll = cola.poll();
            return auxBFS(grafo, poll, destino,verificados);
        }
        return resultado;
    }



    public  boolean caminoDFS (DigraphAL grafo, int origen,int destino){
        boolean[] verificados = new boolean [grafo.size()];
        return auxDFS(grafo,origen, destino,verificados);
    }

    public  boolean auxDFS (DigraphAL grafo, int origen,int destino, boolean[] verificados){
        ArrayList <Integer> lista = grafo.getSuccessors(origen);
        boolean resultado = false;
        verificados[origen] = true;
        if (origen == destino ){
            resultado = true;
        }
        for(int nodo : lista){
            if (verificados[nodo] == false){
                resultado = resultado || auxDFS(grafo,nodo,destino,verificados);
            }
        }

        return resultado;
    }   
}
