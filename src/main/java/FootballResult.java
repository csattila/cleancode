import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FootballResult {

    private String path;

    public FootballResult(String path) {
        this.path = path;
    }

    public Team getSmallestGoalDiff() throws IOException {
        List<String> lines = readLines();
        List<Team> teams = parseLines(lines);
        return teams.stream().min(Comparator.comparing(Team::getGoalDiffForAndAgainst)).orElse(null);
    }

    private boolean isNotValidLine(String line){
        return (line.length() < 2 || line.contains("Dy") || line.contains("mo"));
    }

    private boolean isHeader(String line){
        return line.contains("Pts");
    }

    private void log(String msg){
        System.out.println(msg);
    }

    private List<String> readLines() throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if(isHeader(line) || isNotValidLine(line)){
                    continue;
                }
                line = line.replaceAll("\\*", "");
                log(line);
                result.add(line);
            }

        }
        return result;
    }

    private List<Team> parseLines(List<String> lines){
        List<Team> result = new ArrayList<>();
        for (String line : lines) {
            Team team = new Team(line);
            result.add(team);
        }
        return result;
    }

}
