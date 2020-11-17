import java.lang.Math;
import java.util.ArrayList;

public class Test
{
    public Test(String datasetEntrenamiento, String datasetTest){
        recolectarDatos dato= new recolectarDatos();
        dato.leerDatos(datasetEntrenamiento);
        String [][] raiz=dato.getMatriz();
        //System.out.println ("va a entrar a el arbol");
        ElArbolito arbol = new ElArbolito(dato.seccionarDataSet(200));
        //ElArbolito arbol = new ElArbolito(raiz);
        ArrayList <String> prediccion = new ArrayList<String>();
        ArrayList <String> realidad = new ArrayList<String>();
        recolectarDatos dato1= new recolectarDatos();
        dato1.leerDatos(datasetTest);
        String [][] prueba=dato1.getMatriz();
        long tiempoI; 
        long tiempoF; 
        long diferenciatiempo; 
        tiempoI = System.currentTimeMillis(); 
        
     
        for(int i = 0; i<prueba.length; i++){
            //System.out.println("añadio prediccion "+ Integer.toString(arbol.predecir(prueba[i],arbol.getRoot())));
            prediccion.add(Integer.toString(arbol.predecir(prueba[i],arbol.getRaiz())));
            //System.out.println("añadio realidad "+ Integer.parseInt(prueba[i][8]));
            realidad.add(prueba[i][8]);
        }
        tiempoF = System.currentTimeMillis();
        diferenciatiempo = tiempoF - tiempoI;
        System.out.println("Milisegundos test: " + diferenciatiempo);
        int aciertos = 0;
        int desaciertos = 0;
        int prediccionexito =0;
        int falsosPositivos = 0;
        for (int i= 0 ; i< prediccion.size(); i++){
            if(prediccion.get(i).equals(realidad.get(i))){
                aciertos++;
                //System.out.println("prediccion "+prediccion.get(i));
                //System.out.println("realidad: "+realidad.get(i));
            }else {
                desaciertos++;
            }
        }
        for(int i = 0 ; i<prediccion.size(); i++){
            if(prediccion.get(i).equals("0") && realidad.get(i).equals("1")){
                prediccionexito++;
                //System.out.println("precision: "+prediccionexito);
            }else if (prediccion.get(i).equals("1")){
                falsosPositivos++;
                //System.out.println("falsos positivos: "+falsosPositivos);
            }
        }
        System.out.println("Aciertos :"+aciertos);
        System.out.println("Desaciertos :"+desaciertos);
        double Accuracy =(aciertos*100)/prueba.length;
        //double precision = prediccionexito/(prediccionexito+falsosPositivos);
        System.out.println("Porcentaje de efecticvidad: "+Accuracy+" %");
        //System.out.println("Porcentaje de precision: "+precision+" %");

    }
}
