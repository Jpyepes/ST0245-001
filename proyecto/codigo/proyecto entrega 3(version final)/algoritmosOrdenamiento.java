/**
     * La clase algoritmos ordenamiento esta basada en la pagina geeks for geeks
     * Merge Sort: https://www.geeksforgeeks.org/merge-sort/
     */
public class algoritmosOrdenamiento
{
    /**
     * El método ordenamientoMatriz es un método que permite ordenar un arreglo de enteros, en este caso de menor a mayor por medio del algoritmo mergeSort con compeljidad O(nlog(n))
     * @param String [][] matriz, matriz a ordenar
     * @param int pos, posicion columna de la matriz a ordenar
     */
    public static String [][] ordenamientoMatriz(String [][] matriz, int pos){
      if(matriz.length==1 ||matriz.length==0){
            return matriz;
        }
        return mergesortMatriz(matriz, 0, matriz.length-1,pos);
    }
    private static String[][] mergesortMatriz(String [][] matriz,int L, int R, int pos){
        String [][] ordenado=new String[matriz.length][matriz[0].length];
        if (L < R){
            int mitad=(L+R)/2;
            mergesortMatriz(matriz,L, mitad, pos);
            mergesortMatriz(matriz,mitad+1, R, pos);                                                                                
            ordenado= mergeauxMatriz(matriz,L, mitad, R,pos);                                                                                 
        }
        return ordenado;
    }
    private static String [][] mergeauxMatriz(String [][] matriz,int L, int mitad, int R, int pos){
        int L1, L2, LG;
        String [][] aux = new String[matriz.length][matriz[0].length]; 
        for (L1=L; L1<=R; L1++)                                            
            aux[L1]= matriz[L1];

        L1=L; L2=mitad+1; LG=L;

        while (L1<=mitad && L2<=R)                                      
            if (Float.parseFloat(aux[L1][pos])<=Float.parseFloat(aux[L2][pos]))
                matriz[LG++]=aux[L1++];
            else
                matriz[LG++]=aux[L2++];

        while (L1<=mitad)         
            matriz[LG++]= aux[L1++]; 
        return matriz;
    }
    /**
     * El método ordenamientoArreglo es un método que permite ordenar un arreglo de enteros, en este caso de menor a mayor por medio del algoritmo mergeSort con compeljidad O(nlog(n))
     * @param String [] array, arreglo a ordenar
     * @param int pos, posicion columna de la matriz a ordenar
     */
    public static String [] ordenamientoArreglo(String [] array){
      if(array.length==1 ||array.length==0){
            return array;
        }
        return mergesortArreglo(array, 0, array.length-1);
    }
    private static String[] mergesortArreglo(String [] array,int L, int R){
        String [] ordenado = new String[array.length];
        if (L < R){
            int mitad=(L+R)/2;
            mergesortArreglo(array,L, mitad);
            mergesortArreglo(array,mitad+1, R);                                                                                
            ordenado= mergeauxArreglo(array,L, mitad, R);                                                                                 
        }
        return ordenado;
    }
    private static String [] mergeauxArreglo(String [] array,int L, int mitad, int R){
        int L1, L2, LG;
        String [] aux = new String[array.length]; 
        for (L1=L; L1<=R; L1++)                                             
            aux[L1]= array[L1];

        L1=L; L2=mitad+1; LG=L;

        while (L1<=mitad && L2<=R)                                      
            if (Float.parseFloat(aux[L1])<=Float.parseFloat(aux[L2]))
                array[LG++]=aux[L1++];
            else
                array[LG++]=aux[L2++];

        while (L1<=mitad)         
            array[LG++]= aux[L1++]; 
        return array;
    }
    
}