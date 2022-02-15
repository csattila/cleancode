public class Team {
    private String name;
    private int goalFor;
    private int goalAgainst;

    public Team(String line) {
        String[] result = line.split("\\s+");
        if(result.length > 2) {
            this.name = result[2];
            this.goalFor = Integer.parseInt(result[7]);
            this.goalAgainst = Integer.parseInt(result[9]);
        }
    }

    public String getName() {
        return name;
    }

    public int getGoalDiffForAndAgainst(){
        return goalFor-goalAgainst;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", goalFor=" + goalFor +
                ", goalAgainst=" + goalAgainst +
                '}';
    }
}
