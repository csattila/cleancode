package taskthree.parser;

import taskthree.factory.FootballTeamFactory;
import taskthree.model.DataItem;
import taskthree.model.FootballTeam;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FootballStatistics extends BaseStatistics {

    private final static String HEADER_FILTER = "Pts";
    private final static String INVALID_LINE = "---";

    public FootballStatistics(Path path) {
        super(path, HEADER_FILTER, INVALID_LINE);
    }

    @Override
    public List<? extends DataItem> parseLines(List<String> lines) {
        List<FootballTeam> result = new ArrayList<>();
        for (String line : lines) {
            FootballTeam item = FootballTeamFactory.parse(line);
            log(item.toString());
            result.add(item);
        }
        return result;
    }

}
