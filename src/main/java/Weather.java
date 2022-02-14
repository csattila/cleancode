import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Weather {

    public static void main(String[] args) {
        try {
            readFile("src/main/resources/datamunging/weather.dat");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void readFile(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] result = line.split("\\s+");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
