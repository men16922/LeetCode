package org.programmers;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int maxWidth = 0; // 가장 긴 가로 길이
        int maxHeight = 0; // 가장 긴 세로 길이

        // 주어진 명함의 가로 길이와 세로 길이 중 최대값을 구합니다.
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];

            maxWidth = Math.max(maxWidth, Math.max(width, height));
            maxHeight = Math.max(maxHeight, Math.min(width, height));
        }

        // 가로 길이와 세로 길이를 곱하여 지갑의 크기를 구합니다.
        int walletSize = maxWidth * maxHeight;

        return walletSize;
    }

    public int solution_other(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }

    public static void main(String[] args) {
        int [][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        최소직사각형 최소직사각형 = new 최소직사각형();
        System.out.println(최소직사각형.solution(sizes));
    }
}
