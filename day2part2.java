package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day2part2 {
    public static void main(String[] args) throws Exception {
        String csv = "data/day2.csv";
        String line;

        int diff = 0;
        int safe = 0;
        
        List<Integer> list = new ArrayList<Integer>();

        List<Integer> checker = new ArrayList<Integer>();
        int damp = 0;
        int hold = 0;

        int test = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
                while ((line = br.readLine()) != null) {
                    test++;

                    System.out.println("round: " + test + " damp: " + damp);
                    if (damp == 0) {
                        String[] data = line.split(",");
                        for (String value : data) {
                            list.add(Integer.parseInt(value));
                        }
                        int dataLen = list.size();

                        for (int i = 1; i < dataLen; i++){
                            diff = list.get(i) - list.get(i-1);
                            if (diff < 4 && diff > 0 && i == dataLen-1) {
                                safe++;
                            }
                            else if (diff < 4 && diff > 0) {
                                continue;
                            }
                            else{
                                damp++;
                                hold = i;
                                break;
                            }
                        }
                        if (damp == 0){
                            for (int i = 1; i <dataLen; i++){
                                diff = list.get(i) - list.get(i-1);
                                if (diff < 0 && diff > -4 && i == dataLen-1) {
                                    safe++;
                                }
                                else if (diff < 0 && diff > -4) {
                                    continue;
                                }
                                else{
                                    damp++;
                                    hold = i;
                                    break;}
                                }
                        }
                    }
                    if (damp == 1) {
                        System.out.println("test 1");
                        for (Integer value : list) {
                            if (value != hold) {
                                checker.add(value);
                            }
                        }

                        int dataLen = checker.size();

                        for (int i = 1; i < dataLen; i++){
                            diff = checker.get(i) - checker.get(i-1);
                            if (diff < 4 && diff > 0 && i == dataLen-1) {
                                safe++;
                                damp = 0;
                            }
                            else if (diff < 4 && diff > 0) {
                                continue;
                            }
                            else{
                                damp = 0;
                                break;
                            }
                        }
                        
                        for (int i = 1; i <dataLen; i++){
                            diff = checker.get(i) - checker.get(i-1);
                            if (diff < 0 && diff > -4 && i == dataLen-1) {
                                safe++;
                                damp = 0;
                            }
                            else if (diff < 0 && diff > -4) {
                                continue;
                            }
                            else{
                                damp = 0;
                                break;}
                        }
                            damp = 0;
                            checker.clear();
                    } // end of second if
                    else {damp = 0;}
                    list.clear();

                } // end of while loop
                    System.out.println("The amount of safe reports: " + safe);
            } // end of try block
            catch (IOException e) {
                    e.printStackTrace();
            } // end of catch block
        } // end of line 10
    } // end of day2part2
        