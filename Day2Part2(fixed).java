package src.day2;
public class Day2Part2 {
    public static void main(String[] args) {
        String csv = "data/day2.csv";
        ReportAnalyzer analyzer = new ReportAnalyzer(csv);
        analyzer.analyze();
    }
}
