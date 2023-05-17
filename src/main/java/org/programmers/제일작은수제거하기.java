package org.programmers;

import java.util.Arrays;

public class 제일작은수제거하기 {

    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int [] answer = Arrays.stream(arr).filter(item -> item != min).toArray();
        if (answer.length == 0) answer = new int [] {-1};
        return answer;
    }

    public static void main(String[] args) {
        제일작은수제거하기 제일작은수제거하기 = new 제일작은수제거하기();
        int [] arr = {4,3,2,1};
        System.out.println(제일작은수제거하기.solution(arr));
    }
}
