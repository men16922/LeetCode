package org.inflearn;

import java.io.*;
import java.util.StringTokenizer;

public class 바이러스 {
    static boolean [][] graph;
    static boolean [] visited;
    static int N, M;
    static int answer;

    static void dfs(int idx) {
        visited[idx] = true; // 1번 컴퓨터 true
        answer++;

        // 연결된 Node 호출
        for (int i = 1; i <= N; i++) {
            // 방문한 적이 없고, idx 컴퓨터와 i 번째 컴퓨터가 연결되어 있다면
            if (visited[i] == false && graph[idx][i]) {
                dfs(i); // 재귀함수 호출
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1]; // 0번째 배열도 포함하기 위함
        visited = new boolean[N + 1];

        // 1. graph에 연결 정보 채우기
        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true; // x, y Node는 연결됨
            graph[y][x] = true;
        }
        
        // 2. dfs(재귀함수) 호출
        dfs(1); // 1번 컴퓨터에서 시작, 재귀함수 호출
        
        // 3. 출력
        bw.write(String.valueOf(answer - 1)); // 1번을 제외하고 몇 대가 감염되었는지
        br.close();
        bw.close();
    }
}
