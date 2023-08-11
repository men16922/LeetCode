package org.real.autotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CalendarProgram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String leapFlagInput = br.readLine();
        boolean leapFlag = leapFlagInput.equals("leap");
        String dayInput = br.readLine();
        int day = convertDay(dayInput);
        int[][][] mems = new int[13][7][5]; // [month][day][order]

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (leapFlag) {
            days[2] += 1;
        }

        int m = 1, d = 1;
        while (m <= 12) {
            mems[m][day][0] = d;
            d += 1;
            if (d > days[m]) {
                m += 1;
                d = 1;
            }
            day = (day + 1) % 7;
        }

        Map<String, Integer> convertOrder = new HashMap<>();
        convertOrder.put("first", 0);
        convertOrder.put("second", 1);
        convertOrder.put("third", 2);
        convertOrder.put("fourth", 3);
        convertOrder.put("fifth", 4);
        convertOrder.put("last", 0);

        Map<String, Integer> convertMonth = new HashMap<>();
        convertMonth.put("january", 1);
        convertMonth.put("february", 2);
        convertMonth.put("march", 3);
        convertMonth.put("april", 4);
        convertMonth.put("may", 5);
        convertMonth.put("june", 6);
        convertMonth.put("july", 7);
        convertMonth.put("august", 8);
        convertMonth.put("september", 9);
        convertMonth.put("october", 10);
        convertMonth.put("november", 11);
        convertMonth.put("december", 12);

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String query = br.readLine();
            String[] factors = query.split(" ");
            int qOrder = convertOrder.get(factors[0]);
            int qDay = convertDay(factors[1]);
            int qMonth = convertMonth.get(factors[3]);
            System.out.println(qMonth + " " + mems[qMonth][qDay][qOrder]);
        }
    }

    public static int convertDay(String day) {
        switch (day) {
            case "sunday":
                return 0;
            case "monday":
                return 1;
            case "tuesday":
                return 2;
            case "wednesday":
                return 3;
            case "thursday":
                return 4;
            case "friday":
                return 5;
            case "saturday":
                return 6;
            default:
                return -1; // Invalid day
        }
    }
}

