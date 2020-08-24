import java.util.Random;

public class numeroMayor {

    public static int maximo(int[] a){
        return maximo(a, a.length);
    }

    private static int maximo(int[] a, int lon){
        if (lon == 1)
            return a[0];
        else
            return Math.max(a[lon-1], maximo(a, lon-1)); 
        // T(n) = c2 + T(n-1)
        // T(n) = c1 + c2.n  

    }

    public static void main(String args[]){
        long tiempoInicial=System.currentTimeMillis();
        for(int n=9000;n<9020;n++){
            maximo (new int [n]);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);
        }

    }
}
