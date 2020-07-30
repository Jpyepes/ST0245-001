
import java.lang.Math;
public class Punto
{
    private double x;
    private double y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double x(){
        return this.x;
    }

    public double y(){
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

    
}