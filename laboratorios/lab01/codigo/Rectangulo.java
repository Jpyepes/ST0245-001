public class Rectangulo {
 public static void main(String[] args) {
   System.out.println(ways(4)); 
}

public static int ways(int n){
    if(n<=2) return n;
    return ways(n-1) + ways(n-2);
}

}

