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
            Double minDiffBetweenMinMax = null;
            String minDay = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                if(line.contains("Dy")){
                    continue;
                }
                String[] result = line.split("\\s+");
                if(result.length > 2) {
                    String dayString = result[1];
                    String maxString = result[2];
                    String minString = result[3];

                    double maxTmp = getNumberFromString(maxString);
                    double minTmp = getNumberFromString(minString);

                    double diffBetweenMinMaxTmp = maxTmp - minTmp;
                    if (minDiffBetweenMinMax == null || diffBetweenMinMaxTmp < minDiffBetweenMinMax) {
                        minDiffBetweenMinMax = diffBetweenMinMaxTmp;
                        minDay = dayString;
                    }
                }
            }

            System.out.println("Result day: " + minDay + ", minDiffBetweenMinMax: " + minDiffBetweenMinMax);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static double getNumberFromString(String input){
        return Double.parseDouble(input.replaceAll("\\*", ""));
    }
}
