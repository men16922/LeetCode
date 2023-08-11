package org.softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class lv3_GINI {

    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        char[][] map = new char[R][C];
        int[][] time = new int[R][C];
        boolean[][] visited = new boolean[R][C];

        int startRow = 0, startCol = 0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'H') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int answer = bfs(map, time, visited, startRow, startCol);
        if (answer == -1) {
            System.out.println("FAIL");
        } else {
            System.out.println(answer);
        }
    }

    static int bfs(char[][] map, int[][] time, boolean[][] visited, int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (map[x][y] == 'W') {
                return time[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] != 'X' && map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    time[nx][ny] = time[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
