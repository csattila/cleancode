
public class Weather {
    private static final String FILE_PATH = "src/main/resources/datamunging/weather.dat";

    public static void main(String[] args) {
        try {
            FileParser fileParser = new FileParser(FILE_PATH);
            WeatherData result = fileParser.getSmallestMinMaxWeatherData();
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
