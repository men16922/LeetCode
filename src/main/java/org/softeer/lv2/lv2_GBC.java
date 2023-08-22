package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv2_GBC {
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] speed = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            speed[i][0] = Integer.parseInt(st.nextToken());
            speed[i][1] = Integer.parseInt(st.nextToken());
        }

        int idx = 0; // 테스트 배열의 인덱스
        for (int i = 0; i < N; i++) {
            for (int j = idx; j < M; j++) {
                if (arr[i][0] < speed[j][0]) { // 원래 구간의 길이가 테스트 배열보다 작은 경우
                    speed[j][0] -= arr[i][0]; // 테스트 구간의 길이에서 원래 구간의 길이를 뺀다
                    if (speed[j][1] - arr[i][1] > 0) { // 테스트 구간의 제한 속도가 원래 구간의 제한 속도보다 큰 경우
                        // 테스트 구간의 제한 속도 - 원래 구간의 제한 속도의 최대값
                        answer = Math.max(answer, speed[j][1] - arr[i][1]);
                    } // 내부 반복문 종료, 다음 원래 구간으로 넘어간다
                    break;
                } else if (arr[i][0] > speed[j][0]) { // 원래 구간의 길이가 테스트 구간의 길이보다 큰 경우
                    arr[i][0] -= speed[j][0]; // 원래 구간의 길이에서 테스트 구간의 길이를 뺀다
                    if (speed[j][1] - arr[i][1] > 0) { // 테스트 구간의 제한속도가 원래 구간의 제한속도보다 큰 경우
                        // 테스트 구간의 제한 속도 - 원래 구간의 제한 속도
                        answer = Math.max(answer, speed[j][1] - arr[i][1]);
                    }
                    idx++; // 다음 테스트 구간으로 넘어간다
                } else { // 테스트 구간과 원래 구간의 길이가 같은 경우
                    if (speed[j][1] - arr[i][1] > 0) { // 테스트 구간의 제한속도가 원래 구간의 제한속도보다 큰 경우
                        // 테스트 구간의 제한 속도 - 원래 구간의 제한 속도
                        answer = Math.max(answer, speed[j][1] - arr[i][1]);
                    }
                    idx++;
                    break; // 내부 반복문 종료, 다음 원래 구간으로 넘어간다
                }
            }
        }

        System.out.println(answer);
    }
}
