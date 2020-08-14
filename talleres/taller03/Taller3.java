
public class Taller3
{
    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }

    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
        if (n == 1){
            System.out.println("*Disco 1 desde "+ origen + " a "+ destino);
        }else{
            torresDeHannoiAux(n - 1, origen, destino, intermedio);
            System.out.println("*Disco "+ n + " desde "+ origen + " a "+ destino);
            torresDeHannoiAux(n - 1, intermedio, origen, destino);
        }
    }
}