import java.util.Arrays;

public class insertionSort {
    public static int[] sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }
        

    
     public static void main(String[] args) {
        int []n = {3,5,2,1};
        System.out.println ("Arreglo sin ordenar: ");
        System.out.println (Arrays.toString(n));
        System.out.println ("Arreglo ordenado: ");
        sort(n);
        System.out.println (Arrays.toString(n));

        for (int i = 10000000; i <= 200000000; i = i + 10000000) {

            long ti = System.currentTimeMillis();
   
            sort(new int[i]);
   
            long tf = System.currentTimeMillis();
   
            System.out.println(tf - ti);
   
         }
        
        
    }
}