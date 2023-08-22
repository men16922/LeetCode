package org.softeer.lv2;

import java.io.*;
import java.util.StringTokenizer;

public class lv2_바이러스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int K = Integer.parseInt(st.nextToken()); // 처음 바이러스의 수
        int P = Integer.parseInt(st.nextToken()); // 증가율
        int N = Integer.parseInt(st.nextToken()); // 총 시간
        long answer = K;
        for (int i = 0; i < N; i++) {
            answer = answer * P % 1000000007;
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
