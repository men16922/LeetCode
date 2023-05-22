package org.programmers;

public class 행렬의덧셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int [arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [][] arr1 = {{1}, {2}};
        int [][] arr2 = {{3}, {4}};
        행렬의덧셈 행렬의덧셈 = new 행렬의덧셈();
        System.out.println(행렬의덧셈.solution(arr1, arr2));
    }
}
