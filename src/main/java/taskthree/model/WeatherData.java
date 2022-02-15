package taskthree.model;

public class WeatherData extends DataItem {
    private int max;
    private int min;

    public WeatherData(String day, int max, int min) {
        super(day);
        this.max = max;
        this.min = min;
    }

    @Override
    public int getDiff() {
        return max - min;
    }

    @Override
    public String toString() {
        return "tasktwo.WeatherData{" +
                "day=" + getItemKey() +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
