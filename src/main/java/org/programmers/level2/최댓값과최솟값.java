package org.programmers.level2;

import java.util.Arrays;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String [] array = s.split(" ");
        String min = Integer.toString(Arrays.stream(array).mapToInt(item -> Integer.parseInt(item)).min().getAsInt());
        String max = Integer.toString(Arrays.stream(array).mapToInt(item -> Integer.parseInt(item)).max().getAsInt());
        String answer = min + " " + max;
        return answer;
    }

    public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        최댓값과최솟값 최댓값과최솟값 = new 최댓값과최솟값();
        System.out.println(최댓값과최솟값.solution(s));
    }
}
