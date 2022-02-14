import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private String filePath;

    public FileParser(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readLines() throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int i = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if(line.length() < 2 || line.contains("Dy") || line.contains("mo")){
                    continue;
                }
                line = line.replaceAll("\\*", "");
                result.add(line);
            }

        }
        return result;
    }

    public List<WeatherData> parseLines(List<String> lines){
        List<WeatherData> result = new ArrayList<>();
        for (String line : lines) {
            WeatherData weatherData = new WeatherData(line);
            result.add(weatherData);
        }
        return result;
    }
}
