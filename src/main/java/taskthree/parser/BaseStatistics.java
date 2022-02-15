package taskthree.parser;

import taskthree.model.DataItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class BaseStatistics {

    private Path path;
    private String headerFilter;
    private String invalidLineFilter;

    public BaseStatistics(Path path, String headerFilter, String invalidLine) {
        this.path = path;
        this.headerFilter = headerFilter;
        this.invalidLineFilter = invalidLine;
    }

    public abstract List<? extends DataItem> parseLines(List<String> lines);

    public String getResult() {
        List<String> lines = readLines();
        List<DataItem> items = (List<DataItem>) parseLines(lines);
        return items.stream().min(Comparator.comparing(DataItem::getDiff)).get().getItemKey();
    }

    protected void log(String msg){
        System.out.println(msg);
    }

    private boolean isNotValidLine(String line){
        return (line.length() < 2 || line.contains(invalidLineFilter));
    }

    private boolean isHeader(String line){
        return line.contains(headerFilter);
    }

    private List<String> readLines() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
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

}
