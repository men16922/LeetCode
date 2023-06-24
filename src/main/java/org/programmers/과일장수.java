package org.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 과일장수 {

    public int solution(int k, int m, int[] score) {
        // m개씩 상자 만들고, 가격은 k가 최대
        // 상자의 가격은 가장 낮은 score로 계산
        // 최대이익 계산
        score = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int answer = 0;
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (i != 0 && i % m == 0) {
                int price = tempList.stream().min(Integer::compareTo).get();
                answer += price * tempList.size();
                tempList.clear();
            }
            tempList.add(score[i]);
        }
        if (tempList.size() >= m) {
            int price = tempList.stream().min(Integer::compareTo).get();
            answer += price * tempList.size();
        }
        return answer;
    }
    public int solution_other(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int [] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        과일장수 과일장수 = new 과일장수();
        System.out.println(과일장수.solution(k, m, score));
    }
}
