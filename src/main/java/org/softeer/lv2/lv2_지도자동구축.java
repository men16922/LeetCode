package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lv2_지도자동구축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] dp = new int [16];

        dp[0] = 2;
        for (int i = 1; i < N + 1; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - 1);
        }
        System.out.println((int) Math.pow(dp[N], 2));

//        int point = 2; // 한 변의 점의 개수
//
//        /**
//         * 0단계 : 4, 각 변의 점의 개수 = 2의 제곱
//         * 1단계 : 9, 각 변의 점의 개수 = 3의 제곱, (3 - 2 = 1)
//         * 2단계 : 25, 각 변의 점의 개수 = 5의 제곱 (5 - 3 = 2)
//         * 3단계 : 81, 각 변의 점의 개수 = 9의 제곱 (9 - 5 = 4)
//         * 단계마다 제곱씩 점의 개수가 증가함
//         */
//
//        for (int i = 0; i < N; i++) {
//            point += (int) Math.pow(2, i);
//        }
//
//        System.out.println((int) Math.pow(point, 2));
    }
}
