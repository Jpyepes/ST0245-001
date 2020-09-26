import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class mainTeclado
{
    public static void main (String [] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();

        tecladoRoto t1 = new tecladoRoto();
        t1.teclado (s);

    }
}
