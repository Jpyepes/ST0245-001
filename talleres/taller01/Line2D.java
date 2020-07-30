
public class Line2D
{
    private int x;
    private int y;

    public Line2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x(){
        return this.x;
    }

    public int y(){
        return this.y;
    }
    
    public void puntosIntermedios(Line2D a, Line2D b){

        double m = ((b.y() - a.y()) / (b.x() - a.x()));
        double c = m*(0 - a.x()) + a.y();

        for(int x = a.x(); x <= b.x(); x++){
            int y = (int)(m*x + c);
            System.out.println(x + "," + y);
        }
    }
}
