
import java.lang.Math;
public class Punto
{
    private int x;
    private int y;

    public Punto(){

    }

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x(){
        return this.x;
    }

    public int y(){
        return this.y;
    }

    public double radioPolar(){
        double r = Math.sqrt((this.x*this.x)+(this.y*this.y));
        return r;
    }

    public double anguloPolar(){
        double resul = this.y/this.x;
        return Math.atan(resul);

    }
    
    public double distanciaEuclidiana(Punto p1){
       double dx= this.x - p1.x();
       double dy= this.y - p1.y();
       return Math.sqrt (dx*dx+dy*dy);
    }

    public void puntosIntermedios(Punto a, Punto b){

        double m = ((b.y() - a.y()) / (b.x() - a.x()));
        double c = m*(0 - a.x()) + a.y();

        for(int x = a.x(); x <= b.x(); x++){
            int y = (int)(m*x + c);
            System.out.println(x + "," + y);
        }
    }
}