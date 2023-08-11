package org.softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv3_성적평균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        double [] arr = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            double temp = 0;
            for (int j = A - 1; j < B; j++) {
                temp += arr[j];
            }
            System.out.println(String.format("%.2f", temp / (B - A + 1)));
        }
    }
}
