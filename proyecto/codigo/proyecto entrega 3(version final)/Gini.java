import java.util.HashSet;
import java.util.*;
import javafx.util.Pair;
import java.lang.Math;
public class Gini

{   
    /**
     * El método Gini permite sacar la impureza de gini de las columnas de la matriz
     * @param float n1 variable de exito
     * @param float n2 variable de fracaso
     * @return float impureza de Gini
     */
    public static float Gini(float n1, float  n0){
        float auxn1=0;
        float auxn0=0;
        float  total=n1+n0;
        if(n1!=0){
            auxn1= (n1/total);
        }
        if(n0!=0){
            auxn0=(n0/total);
        }
        float impureza = (1-(n0*n0)+(n1*n1));
        return impureza;
    }

    /**
     * El método valoresColumnas permite sacar un valor de cada columna sin repetirlo por medio de un HashSet,
     * tambien se podria implementar un treeSet
     * @param String [][] matriz, matriz a evaluar
     * @param int posicion, posicion de la columna
     * @return String [] vals
     */
    public static String[] valoresColumnas(String[][] matriz, int posicion){
        HashSet<String> vals = new HashSet<String>(matriz.length);
        int cont = 0;
        while(cont<matriz.length/*-1*/){
            if(esPosValidaEnMatriz(matriz,cont,posicion)){
                vals.add(matriz[cont][posicion]);
            }
            cont++;
        }
        String[] res = new String[vals.size()];
        return vals.toArray(res);
    }

    public static boolean esPosValidaEnMatriz(String[][] m, int f, int c){
        if(m[f][c] != null){
            if(m[f][c] != ""){
                return true;
            }
        }
        return false;
    }

    /**
     * El método dividirMatriz permite dividir una matriz dada en dos arreglos, guardandola en una pair
     * @param String [][] matriz, matriz a evaluar
     * @param int posicion, posicion de la columna
     * @param int val valor a evaluar
     * @return Pair<String[][],String[][]> matrizDividida
     */

    public static Pair<String[][],String[][]> dividirMatriz(String[][] matriz, int pos, int val){
        String[][] arrayOrdenado= algoritmosOrdenamiento.ordenamientoMatriz(matriz,pos);
        int minimo=0;
        double  valor= (double)val;  
        int cont=0;
        while(Double.parseDouble(arrayOrdenado[cont][pos])<= valor && cont<arrayOrdenado.length){
            minimo++;
            cont++;
        }
        int maximo=arrayOrdenado.length-minimo;
        int filaMayor=0;
        int filaMenor=0;
        String[][] Mayor = new String[maximo][arrayOrdenado[0].length];
        String[][] Menor = new String[minimo][arrayOrdenado[0].length];
        for(int i=0; i< arrayOrdenado.length; i++){
            if(Double.parseDouble(arrayOrdenado[i][pos])<=valor){
                Menor[filaMenor]=arrayOrdenado[i];
                filaMenor++;
            } else{
                Mayor[filaMayor]=arrayOrdenado[i];
                filaMayor++; 
            }
        }
        Pair<String[][], String[][]> matrizDividida= new Pair(Menor,Mayor);
        return matrizDividida;
    }

    /**
     * El método mejorCondicion permite encontrar la mejor condicion 
     * @param String [][] matriz, matriz a evaluar
     * @return Pair<Float, Pair<Integer, Integer>>
     */
    public static  Pair<Float, Pair<Integer, Integer>> mejorCondicion(String[][] matriz){
        float Ganancia=0;
        float GananciaTotal=0;
        int columna=-1;
        int mejorCondicion=0;
        int mejorCondicionTotal=0;
        Pair<Float, Integer> parejaMejorCondicion;
        for(int i=0; i<matriz[0].length-1; i++){
            String [][] arreglo=algoritmosOrdenamiento.ordenamientoMatriz(matriz,i); 
            parejaMejorCondicion= mejorCondicionAux(arreglo,i); 
            Ganancia = parejaMejorCondicion.getKey(); 
            if(Ganancia>GananciaTotal){
                GananciaTotal=Ganancia;
                mejorCondicion=parejaMejorCondicion.getValue();
                columna=i;
            }
        } 
        Pair<Float, Pair<Integer, Integer>> pareja2= new Pair(GananciaTotal, new Pair(mejorCondicion, columna));
        return pareja2;
    }

    /**
     * El método mejorCondicionAux permite encontrar la mejor condicion teniendo en cuenta la impureza y 
     * la impureza ponderada
     * @param String [][] matriz, matriz a evaluar
     * @param int pos 
     * @return Pair<Float, Integer>
     */

    public static Pair<Float, Integer> mejorCondicionAux(String[][] matriz, int pos) 
    { 
        String [] conjuntoValores=algoritmosOrdenamiento.ordenamientoArreglo(valoresColumnas(matriz, pos));
        float[][] matrizValores= new float[conjuntoValores.length][3];
        for(int j=0; j<conjuntoValores.length; j++){ 
            matrizValores[j][0]=Float.parseFloat(conjuntoValores[j]);
            matrizValores[j][1]=0;
            matrizValores[j][2]=0;
        }
        float n1=0;      
        int iteraValores=0;
        int itera=0;
        while(iteraValores<conjuntoValores.length && itera<matriz.length){ 
            if(Float.parseFloat(matriz[itera][pos])==Float.parseFloat(conjuntoValores[iteraValores])){
                if(Integer.parseInt(matriz[itera][matriz[0].length-1])==1){
                    n1++;
                    matrizValores[iteraValores][1]=n1;
                }
                itera++;
                matrizValores[iteraValores][1]=n1;
                matrizValores[iteraValores][2]=itera-n1;
            }else{
                iteraValores++;
            }
        } 
        float n1Total=matrizValores[matrizValores.length-1][1];
        float n0Total=matrizValores[matrizValores.length-1][2];
        float impurezaTotal= Gini(n1Total,n0Total);
        float contGananciaInfo=0;
        float mejorValor=Float.parseFloat(conjuntoValores[0]);
        for(int i=0; i<conjuntoValores.length;i++){ 
            float mayores;
            float menores;
            float giniMenores=Gini(matrizValores[i][1],matrizValores[i][2]);
            float  n1Mayores=n1Total-matrizValores[i][1];
            float  n0Mayores= n0Total-matrizValores[i][2];
            float giniMayores=Gini(n1Mayores,n0Mayores);
            menores= matrizValores[i][1]+matrizValores[i][2];
            mayores= n1Mayores+n0Mayores;
            float impurezaPonderada = impurezaP(mayores,menores,giniMayores,giniMenores);
            float gananciaInfo= impurezaTotal-impurezaPonderada;
            if(gananciaInfo > contGananciaInfo){
                contGananciaInfo=gananciaInfo;
                mejorValor=Float.parseFloat(conjuntoValores[i]);
            }
        }
        Pair<Float,Integer> pareja= new Pair(contGananciaInfo, (int)mejorValor);
        return pareja;
    } 

    public static float impurezaP(float mayores,float menores,float giniMayores,float giniMenores){

        float resultado = ((mayores*giniMayores)+(menores*giniMenores));
        resultado= resultado/(mayores+menores);
        return resultado;
    }


}