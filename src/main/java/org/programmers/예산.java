package org.programmers;

import java.util.Arrays;

public class 예산 {

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int total = 0;
        for (int i = 0; i < d.length; i++) {
            total += d[i];
            if (total <= budget) {
                answer++;
            } else break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] d = {1,3,2,5,4};
        int budget = 9;
        예산 예산 = new 예산();
        System.out.println(예산.solution(d, budget));
    }
}
