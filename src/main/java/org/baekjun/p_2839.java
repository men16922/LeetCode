package org.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int five = N / 5; // 5킬로그램 봉지 개수 계산
        int remainder = N % 5; // 5킬로그램 봉지 사용 후 남은 설탕 무게 계산

        while (five >= 0) {
            if (remainder % 3 == 0) { // 남은 설탕을 3킬로그램 봉지로 정확하게 나눌 수 있는 경우
                int three = remainder / 3; // 3킬로그램 봉지 개수 계산
                System.out.println(five + three);
                return;
            }
            // 5킬로그램 봉지를 하나씩 줄이면서 계산
            five--;
            remainder += 5;
        }

        // 정확한 봉지 개수를 구할 수 없는 경우
        System.out.println(-1);
    }
}
