package day1;
import java.util.*;
import java.io.*;

public class day1part1 {

        public static void main(String[] args) throws Exception {
        //Advent of code day 1 START:
            int newVal = 0;
            String csv = "data/day1.csv";
            String line;        
            String csvSplitBy = ",";
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> seclist = new ArrayList<Integer>();

            try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);
                    for (String value : data) {
                        if (value == data[0]) {
                        list.add(Integer.parseInt(value));}
                        else {seclist.add(Integer.parseInt(value));}
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            

            PriorityQueue<Integer> pqfirst = new PriorityQueue<>(list);
            PriorityQueue<Integer> pqsec = new PriorityQueue<>(seclist);

            while (!pqfirst.isEmpty() && !pqsec.isEmpty()) {
                int fmin = pqfirst.poll();
                int secmin = pqsec.poll();
                newVal += Math.abs(fmin - secmin);
            }
            System.out.println("Day 1 part 1: The distance between all locations is " + newVal + "!");
        //Advent of code day 1 FINISH
        }
}