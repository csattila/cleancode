import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {

    private static final String FILE_PATH = "src/main/resources/datamunging/weather.dat";

    @Test
    void testFileReader() throws IOException {
        FileParser fileParser = new FileParser(FILE_PATH);
        WeatherData result = fileParser.getSmallestMinMaxWeatherData();
        assertEquals(14, result.getDay());
    }
}
