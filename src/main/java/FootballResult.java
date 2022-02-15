import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FootballResult {

    private Path path;

    public FootballResult(Path path) {
        this.path = path;
    }

    public Team getSmallestGoalDiff() {
        List<String> lines = readLines();
        List<Team> teams = parseLines(lines);
        return teams.stream().min(Comparator.comparing(Team::getGoalDiffForAndAgainst)).orElse(null);
    }

    private boolean isNotValidLine(String line){
        return (line.length() < 2 || line.contains("---"));
    }

    private boolean isHeader(String line){
        return line.contains("Pts");
    }

    private void log(String msg){
        System.out.println(msg);
    }

    private List<String> readLines() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            int i = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if(isHeader(line) || isNotValidLine(line)){
                    continue;
                }
                log(line);
                result.add(line);
            }
        } catch (IOException e){
            log("Error in readLines: " + e.getMessage());
            e.printStackTrace();
            throw new IllegalArgumentException("Error in readLines: " + e.getMessage());
        }
        return result;
    }

    private List<Team> parseLines(List<String> lines){
        List<Team> result = new ArrayList<>();
        for (String line : lines) {
            Team team = new Team(line);
            log(team.toString());
            result.add(team);
        }
        return result;
    }

}
