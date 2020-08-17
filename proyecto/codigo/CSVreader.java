
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
/*
Method to read and store a csv file in a String array.
 */
public class CSVreader {
    public void storeFile(){
        String path = "C:\\Users\\usuario\\Downloads\\csv.txt";
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
}
