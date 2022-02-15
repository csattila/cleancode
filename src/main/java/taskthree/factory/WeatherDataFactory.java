package taskthree.factory;

import taskthree.model.WeatherData;

public class WeatherDataFactory {
    private static final String SPLIT_REGEX = "\\s+";

    public static WeatherData parse(String line){
        line = line.replaceAll("\\*", "");
        String[] result = line.split(SPLIT_REGEX);

        if(result.length > 2) {
            String day = result[1];
            int max = Integer.parseInt(result[2]);
            int min = Integer.parseInt(result[3]);
            return new WeatherData(day, max, min);
        } else {
            throw new IllegalArgumentException("Line " + line + " cannot be parsed to FootballTeam");
        }
    }

}
