package tasktwo;

import java.nio.file.Path;

public class FootballApp {

    private static final Path FILE_PATH = Path.of("src/main/resources/datamunging/football.dat");

    public static void main(String[] args) {
        try {
            FootballResult footballResult = new FootballResult(FILE_PATH);
            Team team = footballResult.getSmallestGoalDiff();
            System.out.println("Result: " + team.getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
