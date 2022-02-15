import java.util.List;

public class FootballApp {

    private static final String FILE_PATH = "src/main/resources/datamunging/football.dat";

    public static void main(String[] args) {
        try {
            FootballResult footballResult = new FootballResult(FILE_PATH);
            Team team = footballResult.getSmallestGoalDiff();
            System.out.println(team);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
