package org.programmers;

public class 푸드파이트대회 {

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i < food.length; i++){
            count = (food[i] / 2);
            System.out.println(i + " : " + count);
            for (int j = 0; j < count ; j++) {
                if (count != 0) {
                    sb.insert(sb.length() / 2, i);
                    sb.insert(sb.length() / 2, i);
                }
            }
        }
        sb.insert(sb.length() / 2, 0);
        return sb.toString();
    }

    public String solution_other(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        푸드파이트대회 푸드파이트대회 = new 푸드파이트대회();
        int [] food = {1, 7, 1, 2};
        System.out.println(푸드파이트대회.solution(food));
    }
}
