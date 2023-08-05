package org.softeer.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class lv1_근무시간 {

    public static void main(String[] args) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long totalTime = 0;
        for (int i = 0; i < 5; i++) {
            String s = bf.readLine();
            String [] attends = s.split(" ");
            long minDiff = Duration.between(LocalTime.parse(attends[0], formatter), LocalTime.parse(attends[1], formatter)).toMinutes();
            totalTime += minDiff;
        }
        System.out.println(totalTime);
    }
}
