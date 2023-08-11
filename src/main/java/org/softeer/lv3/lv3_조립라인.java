package org.softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv3_조립라인 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] work_time = new int[N][2];
        int[][] move_time = new int[N - 1][2];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int a_move = Integer.parseInt(st.nextToken());
            int b_move = Integer.parseInt(st.nextToken());
            work_time[i][0] = a;
            work_time[i][1] = b;
            move_time[i][0] = a_move;
            move_time[i][1] = b_move;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        work_time[N - 1][0] = Integer.parseInt(st.nextToken());
        work_time[N - 1][1] = Integer.parseInt(st.nextToken());

        int[] dp_a = new int[N];
        int[] dp_b = new int[N];
        dp_a[0] = work_time[0][0];
        dp_b[0] = work_time[0][1];

        for (int i = 1; i < N; i++) {
            int a = work_time[i][0];
            int b = work_time[i][1];
            int a_move = move_time[i - 1][0];
            int b_move = move_time[i - 1][1];

            dp_a[i] = Math.min(dp_a[i - 1] + a, dp_b[i - 1] + b_move + a);
            dp_b[i] = Math.min(dp_a[i - 1] + a_move + b, dp_b[i - 1] + b);
        }

        System.out.println(Math.min(dp_a[N - 1], dp_b[N - 1]));
    }
}
