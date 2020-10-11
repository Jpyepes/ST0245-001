
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Math;
/*
Method to read and store a csv file in a String array.
 */

public class CSVreader {
    ArrayList<Pairs> parejas;

    public void storeFile(){
        String path = "lito.csv";
        String line = "";
        try {
            BufferedReader b = new BufferedReader(new FileReader(path));
            while((line = b.readLine()) != null){
                String[] info;
                info = line.split(";");
                System.out.println(Arrays.toString(info));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void divide(int index){
        parejas = new ArrayList<Pairs>();

        String path = "lito.csv";
        String line = "";
        try {
            BufferedReader b = new BufferedReader(new FileReader(path));
            while((line = b.readLine()) != null){
                String[] info;
                info = line.split(";");
                parejas.add(new Pairs(info[index],info[info.length-1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Method to group the elements of the positive side of the tree
     */
    public ArrayList<Pairs> clasifyPositive(String toCompare){
        ArrayList<Pairs> positive = new ArrayList<Pairs>();

        for(int i = 0; i < parejas.size(); i++) {
            if (parejas.get(i).condicion.equals(toCompare))
                positive.add(parejas.get(i));
        }

        return positive;
    }

    /*
    Method to group the elements of the negative side of the tree
     */
    public ArrayList<Pairs> clasifyNegative(String toCompare){
        ArrayList<Pairs> negative = new ArrayList<Pairs>();

        for(int i = 0; i < parejas.size(); i++) {
            if (!(parejas.get(i).condicion.equals(toCompare)))
                negative.add(parejas.get(i));
        }

        return negative;
    }

    /*
    Method to calculate Gini impurity of a node
     */
    public double impurity(ArrayList<Pairs> r){
        double n0 = 0;
        double n1 = 0;
        for (Pairs q: r) {
            if(q.exito.equals("0"))
                n0++;
            else n1++;
        }
        double p0 = n0 / (n0 + n1);
        double p1 = n1 / (n0 + n1);

        double gini = 1 - (Math.pow(p0,2) + Math.pow(p1,2));
        return gini;
    }

    /*
    Method to calculate balanced Gini impurity
     */
    public double impurityP(ArrayList<Pairs> negative,ArrayList<Pairs> positive,double left, double right){
        double gini;
        gini = (negative.size()*left) + (positive.size()*right);
        gini = gini/(negative.size() + positive.size());
        return gini;
    }

}
