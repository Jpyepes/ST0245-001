import javafx.util.Pair;
/**
 * La clase nodoHoja contiene 1 constructor y 1 getter con sus respectivos atributos que permiten la 
 * creacion del arbol en posteriores clases
 * Esta clase esta basada en el video "Let’s Write a Decision Tree Classifier from Scratch2": https://www.youtube.com/watch?v=LDRbO9a6XPU
 */
public class nodoHoja
{
    private String [][] NodoHoja;
    private int cont;

    public nodoHoja(String [][] hoja){
        this.NodoHoja = hoja;
        this.cont = this.contarPredicciones();
    }

    public String[][] getHoja(){
        return NodoHoja;
    }

    /**
     * El método contar permite llevar la cuenta de las predicciones teniendo en cuenta el exito o el fracaso
     * @return int cont
     */
    public int contarPredicciones(){        
        int n1=0;
        int total=0;
        for(int i=0;i<this.NodoHoja.length;i++){
            if(Integer.parseInt(this.NodoHoja[i][NodoHoja[0].length-1])==1){
                n1++;
            }else{
                total++;
            }

        }
        total=total+n1;
        if(total==n1){
            return 1;
        }        
        return 0;        
    }
}
