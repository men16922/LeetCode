package org.inflearn;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추 {

    final static int MAX = 50 + 10; // 최대 50 + 여분 (10)
    static boolean map[][];
//    static boolean visited [][];
    static int T, N, M, K;
    // y, x를 기준으로 (-1, 0) 이면 위, (1, 0) 이면 아래, (0, -1) 이면 왼쪽, (0, 1) 이면 오른쪽
    static int [] dirY = {-1, 1, 0 ,0};
    static int [] dirX = {0, 0, -1 ,1};

    static void dfs(int y, int x) { // 좌표와 배열의 차이로 x,y 반대로 들어감
//        visited[y][x] = true;
        map[y][x] = false; // visited 사용하지 않는 경우
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i]; // 다음 방문 지점
            int newX = x + dirX[i];

            // 새 방문 지점에 배추가 존재하며, 방문한 적 없음
//            if (map[newY][newX] && visited[newY][newX] == false){
//                dfs(newY, newX);
//            }

            if (map[newY][newX]){
                dfs(newY, newX);
            }
        }

//        dfs(y + 1, x); // 아래인 지점 방문
//        dfs(y - 1, x); // 위
//        dfs(y, x - 1); // 왼쪽
//        dfs(y, x + 1); // 오른쪽
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            map = new boolean[MAX][MAX];
//            visited = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y + 1][x + 1] = true;
            }

            // 2. dfs 수행
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {

                    // map[i][j] 지점에 배추가 존재하는지, 방문하지 않았는지
//                    if (map[i][j] && visited[i][j] == false) {
//                        answer++; // 지렁이 1마리 소비
//                        dfs(i, j);
//                    }

                    if (map[i][j]) {
                        answer++; // 지렁이 1마리 소비
                        dfs(i, j);
                    }
                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
