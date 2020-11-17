
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
     * La clase recolectarDatos contiene el metodo leer datos para importar los datasets y guardarlos en una matriz,
     * tambien contiene metodos como getMatriz que retorna la matriz y mostrarMatriz que imprime la matriz.
     * Esta clase esta basada en Stackoverrun: https://stackoverrun.com/es/q/11037083
  */
public class recolectarDatos{
    private static String [][] array;
    
    public void leerDatos(String files){
        String archivo;
        if(files.endsWith(".csv")){
            archivo=files;
        }else{
            archivo=files+".csv";
        }
        File file=new File(archivo);

        try{
            Scanner input =new Scanner(file);
            Scanner input1= new Scanner(file);
            String line;
            String line1;
            int i=0;
            int cont=0;
            while(input1.hasNextLine()){
                line1=input1.nextLine();
                cont++;
            }
            this.array=new String[cont][9];
            
            String [][] arr=new String[cont][9];

            while(input.hasNextLine()){
                line=input.nextLine();
                String [] vector =line.split(";");

                arr[i]=vector;
                i++;
                array=arr;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    public String[][] getMatriz(){
        return this.array;
    }

    public String[][] seccionarDataSet( int hasta){
        String[][] matriz= new String[hasta][];
        int cont=0;
        for(int i= 0; i<hasta;i++){
            matriz[cont]=this.array[i];
            cont++;
        }
        System.out.println ("matriz.length: "+matriz.length);
        return matriz;
    }

 }