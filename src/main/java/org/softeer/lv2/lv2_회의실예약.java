package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class lv2_회의실예약 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // Number of meeting rooms
        int M = Integer.parseInt(tokenizer.nextToken());    // Number of meetings

        Map<String, int[][]> reservation = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int[][] temp = new int[9][2];
            for (int j = 0; j < 9; j++) {
                temp[j][0] = j;
                temp[j][1] = j + 1;
            }
            reservation.put(reader.readLine(), temp);
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String key = tokenizer.nextToken();
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            int[][] curr = reservation.get(key);
            for (int j = start; j < end; j++) {
                curr[j - 9][0] = -1;
                curr[j - 9][1] = -1;
            }
        }

        for (Map.Entry<String, int[][]> entry : reservation.entrySet()) {
            sb.append("Room ").append(entry.getKey()).append(":").append("\n");
            StringBuilder temp = new StringBuilder();
            int[][] curr = entry.getValue();
            int total = 0;
            int start = -1;
            int end = -1;
            for (int i = 0; i < 9; i++) {
                if (curr[i][0] != -1) {
                    // Available time slot
                    if (start == -1) {
                        // Start time not set yet
                        start = curr[i][0];
                    }
                } else {
                    // Unavailable time slot
                    if (start != -1) {
                        // Start time set, end time should follow
                        end = curr[i - 1][1];
                    }
                }

                if (start != -1 && end != -1) {
                    temp.append(String.format("%02d", start + 9)).append("-");
                    temp.append(String.format("%02d", end + 9)).append("\n");
                    start = end = -1;
                    total++;
                }
            }

            if (start != -1) {
                // Still some time slot remaining
                total++;
                temp.append(String.format("%02d", start + 9)).append("-").append("18").append("\n");
            }

            if (total == 0) {
                sb.append("Not available").append("\n");
            } else {
                sb.append(total).append(" available:").append("\n");
                sb.append(temp);
            }

            sb.append("-----").append("\n");
        }

        sb.setLength(sb.length() - 6);

        System.out.println(sb);
    }
}
