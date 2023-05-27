package org.programmers.level2;

import java.util.Arrays;

public class 최솟값만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A); // 배열 A 오름차순 정렬
        Arrays.sort(B); // 배열 B 오름차순 정렬

        int length = A.length;
        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i]; // A의 작은 값과 B의 큰 값부터 순서대로 곱하여 누적합 계산
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] A = {1, 4, 2};
        int [] B = {5, 4, 4};
        최솟값만들기 최솟값만들기 = new 최솟값만들기();
        System.out.println(최솟값만들기.solution(A, B));
    }
}
