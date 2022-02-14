import java.util.Comparator;
import java.util.List;

public class Weather {
    private static final String FILE_PATH = "src/main/resources/datamunging/weather.dat";

    public static void main(String[] args) {
        try {
            FileParser fileParser = new FileParser(FILE_PATH);
            List<String> lines = fileParser.readLines();
            List<WeatherData> weatherDatas = fileParser.parseLines(lines);
            WeatherData result = weatherDatas.stream().min(Comparator.comparing(WeatherData::getMinMaxDiff)).get();
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
