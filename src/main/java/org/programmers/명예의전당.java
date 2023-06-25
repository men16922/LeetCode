package org.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 명예의전당 {

    public int[] solution(int k, int[] score) {
        ArrayList<Integer> resultList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int n : score) {
            linkedList.add(n);
            int minValue = linkedList.stream().mapToInt(Integer::intValue).min().orElseThrow();
            if (linkedList.size() > k) {
                linkedList.remove(Integer.valueOf(minValue));
            }
            minValue = linkedList.stream().mapToInt(Integer::intValue).min().orElseThrow();
            resultList.add(minValue);
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution_other(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int temp = 0;

        for(int i = 0; i < score.length; i++) {

            priorityQueue.add(score[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }



        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int [] score = {10, 100, 20, 150, 1, 100, 200};
        명예의전당 명예의전당 = new 명예의전당();
        for (int n : 명예의전당.solution(k, score)) {
            System.out.println(n);
        }
    }
}
