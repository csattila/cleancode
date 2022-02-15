package taskthree.parser;

import taskthree.factory.WeatherDataFactory;
import taskthree.model.DataItem;
import taskthree.model.WeatherData;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WeatherStatistics extends BaseStatistics {

    private final static String HEADER_FILTER = "Dy";
    private final static String INVALID_LINE = "mo";

    public WeatherStatistics(Path path) {
        super(path, HEADER_FILTER, INVALID_LINE);
    }

    @Override
    public List<? extends DataItem> parseLines(List<String> lines) {
        List<WeatherData> result = new ArrayList<>();
        for (String line : lines) {
            WeatherData item = WeatherDataFactory.parse(line);
            log(item.toString());
            result.add(item);
        }
        return result;
    }

}
