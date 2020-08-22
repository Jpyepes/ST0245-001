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

    public static void main (String []args) {
       for (int n = 10; n<30;n++){
             int [] arr = new int [n];
             for (int j=0; j<n;j++){
                arr [j]= j;
                }
             long tiempoinicial = System.currentTimeMillis();
             maximo(new int [n]);
             long tiempofinal = System.currentTimeMillis();
             System.out.println (tiempofinal-tiempoinicial);
        }
    }
    

}
