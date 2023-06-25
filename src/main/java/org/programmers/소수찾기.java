package org.programmers;

import java.util.Arrays;

/**
 * packageName    : org.programmers
 * fileName       : 소수찾기
 * author         : men16
 * date           : 2023-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-25        men16       최초 생성
 */
public class 소수찾기 {

    public int solution(int n) {
        boolean [] primeArr = new boolean[n + 1];
        Arrays.fill(primeArr, true);
        for (int i = 2; i * i <= n; i++) {
            if (primeArr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeArr[j] = false;
                }
            }
        }
        int answer = 0;
        for (int i = 2; i < primeArr.length; i++) {
            if (primeArr[i]) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        소수찾기 소수찾기 = new 소수찾기();
        System.out.println(소수찾기.solution(n));
    }
}

