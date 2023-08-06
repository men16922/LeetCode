package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv2_비밀메뉴 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken()); // M : 비밀 메뉴 조작법 M개의 정수
        int N = Integer.parseInt(st.nextToken()); // N : 사용자의 버튼 조작 N개의 정수
        int K = Integer.parseInt(st.nextToken()); // K 이내의 숫자

        StringBuilder secrets = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < M; i++) {
            secrets.append(st.nextToken());
        }

        StringBuilder userInputs = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i <N; i++) {
            userInputs.append(st.nextToken());
        }

        if (userInputs.toString().contains(secrets.toString())) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}
