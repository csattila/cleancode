package taskthree;

import taskthree.parser.BaseStatistics;
import taskthree.parser.FootballStatistics;
import taskthree.parser.WeatherStatistics;

import java.nio.file.Path;

public class FileStatisticsApp {

    private static final Path FOOTBALL_FILE_PATH = Path.of("src/main/resources/datamunging/football.dat");
    private static final Path WEATHER_FILE_PATH = Path.of("src/main/resources/datamunging/weather.dat");

    public static void main(String[] args) {
        try {
            processFootballStats(FOOTBALL_FILE_PATH);
            processWeatherStats(WEATHER_FILE_PATH);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void processFootballStats(Path path){
        BaseStatistics footballStatistics = new FootballStatistics(path);
        printResult(footballStatistics);
    }

    private static void processWeatherStats(Path path){
        BaseStatistics weatherStatistics = new WeatherStatistics(path);
        printResult(weatherStatistics);
    }

    private static void printResult(BaseStatistics statistics){
        System.out.println(statistics.getClass() + " result: " + statistics.getResult());
    }
}
