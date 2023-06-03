package org.programmers;

import java.util.Arrays;

public class 비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map = new int[n][n]; // 지도
        String[] firstArray = Arrays.stream(arr1).mapToObj(item -> String.format("%" + n + "s", Integer.toBinaryString(item)).replace(' ', '0')).toArray(String[]::new);
        String[] secondArray = Arrays.stream(arr2).mapToObj(item -> String.format("%" + n + "s", Integer.toBinaryString(item)).replace(' ', '0')).toArray(String[]::new);

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < firstArray.length; j++) {
                int max = Math.max(Character.getNumericValue(firstArray[i].toCharArray()[j]), Character.getNumericValue(secondArray[i].toCharArray()[j]));
                System.out.println(max);
                temp += max == 1 ? "#" : " ";
            }
            answer[i] = temp;
        }
        return answer;
    }

    public String[] solution_other(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String temp;

        for(int i = 0 ; i < n ; i++){
            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            temp = temp.substring(temp.length() - n);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        비밀지도 비밀지도 = new 비밀지도();
        for (String s : 비밀지도.solution(n, arr1, arr2)) {
            System.out.println(s);
        }
    }
}
