package src.day2;

import java.io.*;
import java.util.*;

public class ReportAnalyzer {
    private final String csvPath;
    private int safe = 0;

    public ReportAnalyzer(String csvPath) {
        this.csvPath = csvPath;
    }

    public void analyze() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String values;
            while ((values = br.readLine()) != null) {
                List<Integer> numbers = parseLine(values);
                Report report = new Report(numbers);

                if (report.isSafe() || report.dampener()) {
                    safe++;
                }
            }
            System.out.println(safe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Integer> parseLine(String values) {
        List<Integer> nums = new ArrayList<>();
        for (String s : values.split(",")) {
            nums.add(Integer.parseInt(s.trim()));
        }
        return nums;
    }
}
