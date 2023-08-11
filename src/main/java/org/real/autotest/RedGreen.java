package org.real.autotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RedGreen {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        int[] ans = {0, 0};
        boolean[][][] visit = new boolean[2][N][N];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[k][i][j]) {
                        dfs(i, j, visit[k], map[i][j]);
                        ans[k]++;
                    }
                    if (map[i][j] == 'G')
                        map[i][j] = 'R';
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1]);

        br.close();
    }

    static void dfs(int y, int x, boolean[][] visit, char ch) {
        visit[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visit[ny][nx] && map[ny][nx] == ch)
                dfs(ny, nx, visit, ch);
        }
    }
}
