package org.programmers;

import java.util.Arrays;

public class 삼총사 {
    private static int count = 0;

    public static int solution(int[] number) {
        count = 0;
        Arrays.sort(number); // 정렬하여 백트래킹 수행을 더 효율적으로 만듦
        combination(number, new int[3], new boolean[number.length], 0, 0);
        return count;
    }

    private static void combination(int[] number, int[] selected, boolean[] visited, int idx, int cnt) {
        if (cnt == 3) {
            int sum = selected[0] + selected[1] + selected[2];
            if (sum == 0) {
                count++;
            }
            return;
        }

        for (int i = idx; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = number[i];
                combination(number, selected, visited, i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        삼총사 삼총사 = new 삼총사();
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(삼총사.solution(number));
    }
}
