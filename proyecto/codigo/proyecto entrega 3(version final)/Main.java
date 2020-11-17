
import javafx.util.Pair;
/**
 * La clase Main permite crear un test y medir su tiempo de ejecucion
 * @author (Juan Pablo Yepes García, Simón Cárdenas Villada) 
 * 
 */
public class Main
{
    public static void main(String[] args){
        long tiempoI; 
        long tiempoF; 
        long diferenciatiempo; 
        tiempoI = System.currentTimeMillis(); 
        Test test=new Test("DatasetEntrenamiento_135000","DatasetTest_25000");
        tiempoF = System.currentTimeMillis();
        diferenciatiempo = tiempoF - tiempoI;
        System.out.println("Milisegundos: " + diferenciatiempo);
       }
}
