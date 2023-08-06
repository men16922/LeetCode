package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class lv2_장애물인식프로그램 {
    final static int MAX = 25 + 10;
    static boolean [][] graph;
    static boolean [][] visited;
    static int countPerBlock;
    static int [] dirY = {-1, 1, 0, 0}; // 상하좌우
    static int [] dirX = {0, 0, -1, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        countPerBlock++;

        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (graph[newY][newX] && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                graph[i][j] = s.charAt(j - 1) == '1'; // 1이면 true
            }
        }

        // 1. dfs
        ArrayList<Integer> countPerBlockList = new ArrayList<>(); // 블록별 장애물 개수
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && graph[i][j]) {
                    countPerBlock = 0;
                    dfs(i, j);
                    countPerBlockList.add(countPerBlock);
                }
            }
        }

        // 2. 출력
        System.out.println(countPerBlockList.size()); // 블록의 개수
        for (int num : countPerBlockList) {
            System.out.println(num);
        }
    }
}
