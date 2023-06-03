package org.programmers;

import java.util.HashSet;
import java.util.Set;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        return set.stream().sorted().mapToInt(item -> item).toArray();
    }


    public static void main(String[] args) {
        int [] numbers = {2,1,3,4,1};
        두개뽑아서더하기 두개뽑아서더하기 = new 두개뽑아서더하기();
        for (int n : 두개뽑아서더하기.solution(numbers)) {
            System.out.println(n);
        }
    }
}
