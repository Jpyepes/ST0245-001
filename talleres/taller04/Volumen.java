
public class Volumen{

    public static boolean sumaGrupo(int[] volumenes, int max){

        return sumaGrupo(0, volumenes, max);

    }

    private static boolean sumaGrupo(int start, int[] volumenes, int max){
        if (start >= volumenes.length) 
            return max == 0; // T(n) = c1 = 5
        else
            return sumaGrupo(start+1,volumenes,max) ||  sumaGrupo(start+1,volumenes,max-volumenes[start]); 
        //Complejidad:
        // T(n) = c2 + T( n - 1 ) + T( n - 1 ) , donde c2 = 7
        // T(n) = c2 (2^n - 1) + c1 2^(n-1) = constantota * 2 ^n + constante
    }

    public static void main(String[] args){

        for (int n = 10; n < 30; n++){

            long ti = System.currentTimeMillis();

            sumaGrupo(new int[n], 10);

            long tf = System.currentTimeMillis();

            System.out.println(tf - ti);

        }

    }

}
