
import java.util.Scanner;
public class Main
{
    public static void main (String []args){
        Scanner scan = new Scanner (System.in);
        Punto p1 = new Punto (10,20);
        Punto p2 = new Punto (0,0);
        Line2D p3 = new Line2D (0,0);
        Line2D p4 = new Line2D (3,3);
        int num = 0;
        int loop = 0;
        
        while (loop == 0){
            System.out.println (" ");
            System.out.println ("En esta sección puedes escoger que punto revisar");
            System.out.println ("- oprima 0 para salir");
            System.out.println ("- oprima 1 para revisar el punto uno");
            System.out.println ("- oprima 3 para revisar el punto tres");
            System.out.println (" ");
            num = scan.nextInt();
            switch(num){
                case 0: 
                loop = 1;
                break;
                case 1:
                System.out.println (" ");
                System.out.println("Radio polar: "+p1.radioPolar());
                System.out.println("Angulo polar: "+p1.anguloPolar()+"radianes");
                System.out.println("Distancia euclidiana: "+p1.distanciaEuclidiana(p2));
                System.out.println (" ");
                break;
                case 3:
                System.out.println (" ");
                p3.puntosIntermedios(p3,p4);
                System.out.println (" ");
                break;
            }
        }
        System.out.println ("Fin del programa");
    }
}
