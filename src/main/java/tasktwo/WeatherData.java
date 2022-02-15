package tasktwo;

public class WeatherData {
    private int day;
    private int max;
    private int min;

    public WeatherData(String line) {
        String[] result = line.split("\\s+");
        if(result.length > 2) {
            this.day = Integer.parseInt(result[1]);
            this.max = Integer.parseInt(result[2]);;
            this.min = Integer.parseInt(result[3]);;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMinMaxDiff(){
        return max - min;
    }

    @Override
    public String toString() {
        return "tasktwo.WeatherData{" +
                "day=" + day +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
