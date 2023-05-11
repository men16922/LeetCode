package org.programmers;

import java.util.Arrays;

public class Average {

    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        Average average = new Average();
        System.out.println(average.solution(arr));
    }
}
