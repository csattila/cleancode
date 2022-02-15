package taskthree.model;

public class FootballTeam extends DataItem {
    private int goalFor;
    private int goalAgainst;

    public FootballTeam(String name, int goalFor, int goalAgainst) {
        super(name);
        this.goalFor = goalFor;
        this.goalAgainst = goalAgainst;
    }

    @Override
    public int getDiff() {
        return Math.abs(goalAgainst-goalFor);
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "name='" + getItemKey() + '\'' +
                ", goalFor=" + goalFor +
                ", goalAgainst=" + goalAgainst +
                '}';
    }
}
