package src.day2;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private final List<Integer> data;

    public Report(List<Integer> data) {
        this.data = data;
    }

    public boolean isSafe() {
        if (data.size() < 2) return true;
        
        int firstDiff = data.get(1) - data.get(0);
        if (Math.abs(firstDiff) <1 || Math.abs(firstDiff) > 3) return false;
        
        boolean increm = firstDiff > 0;
        
        for(int i = 1; i < data.size(); i++) {
            int diff = data.get(i) - data.get(i - 1);
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) return false;
            if ((increm && diff < 0) || (!increm && diff > 0)) return false;
        }

        return true;
    }

    public boolean dampener() {
        for (int i = 0; i < data.size(); i++) {
            List<Integer> list = new ArrayList<>(data);
            list.remove(i);
            Report modified = new Report(list);
            if (modified.isSafe()) {
                return true;
            }
        }
        return false;
    }
}

