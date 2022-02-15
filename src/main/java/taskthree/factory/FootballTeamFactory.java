package taskthree.factory;

import taskthree.model.FootballTeam;

public class FootballTeamFactory {
    private static final String SPLIT_REGEX = "\\s+";

    public static FootballTeam parse(String line){
        String[] result = line.split(SPLIT_REGEX);
        if(result.length > 2) {
            String name = result[2];
            int goalFor = Integer.parseInt(result[7]);
            int goalAgainst = Integer.parseInt(result[9]);
            return new FootballTeam(name, goalFor, goalAgainst);
        } else {
            throw new IllegalArgumentException("Line " + line + " cannot be parsed to FootballTeam");
        }
    }
}
