public class EjercicioEuclides
{

    public static void main (String [] args){
        int a = 345;
        int b = 150;
        System.out.println (Euclides(a,b));

    }

    public static int Euclides (int a, int b){
        if (b == 0){
            return a;
        } else {
            return Euclides(b,a%b);

        }

    }
}
