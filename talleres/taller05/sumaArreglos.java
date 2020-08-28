public class sumaArreglos {
    public static int suma (int [] p){
         int sumaaux = 0;
        for (int i = 0; i < p.length; i++){
          sumaaux = p [i]+sumaaux;

        }
        return sumaaux;
    }
    public static void main (String [] args){

        int [] n = {1,2,3,4};
        System.out.println(suma(n));
        for (int i = 10000000; i <= 200000000; i = i + 10000000) {

            long ti = System.currentTimeMillis();
   
            suma(new int[i]);
   
            long tf = System.currentTimeMillis();
   
            System.out.println(tf - ti);
   
         }
    }

}