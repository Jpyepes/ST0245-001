
public class Main1 {
    public static void main(String[] args) {
        CSVreader obj = new CSVreader();

        //obj.storeFile();

        obj.divide(32);

        for(Pairs i : obj.parejas)
            System.out.println(i);

        //criterio a comparar
        String st = "Estrato 1";
        double res;
        System.out.println(obj.impurity(obj.clasifyNegative(st)));
        System.out.println(obj.impurity(obj.clasifyPositive(st)));

        res= obj.impurityP(obj.clasifyNegative(st),obj.clasifyPositive(st),obj.impurity(obj.clasifyNegative(st)),obj.impurity(obj.clasifyPositive(st)));
        System.out.println("La impureza es: " + res);
    }
}
