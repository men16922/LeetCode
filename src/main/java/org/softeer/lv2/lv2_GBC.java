package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class lv2_GBC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        List<Integer> meter = new ArrayList<>();
        List<Integer> speed = new ArrayList<>();
        List<Integer> testMeter = new ArrayList<>();
        List<Integer> testSpeed = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] temp = br.readLine().split(" ");
            meter.add(Integer.parseInt(temp[0]));
            speed.add(Integer.parseInt(temp[1]));
        }
        for(int i=0; i<M; i++) {
            String[] temp = br.readLine().split(" ");
            testMeter.add(Integer.parseInt(temp[0]));
            testSpeed.add(Integer.parseInt(temp[1]));
        }
        int maxSpeed = 0;
        int startMeter = 0;
        int endMeter = 0;
        for(int i=0; i<N; i++) {
            if(i==0) {
                endMeter = meter.get(i);
            } else {
                endMeter += meter.get(i);
            }
            int reachNum = startMeter;
            while(reachNum < endMeter) {
                int limitSpeed = speed.get(i);
                int checkSpeed = 0;
                int num = 0;
                for(int j=0; j<testMeter.size(); j++) {
                    num += testMeter.get(j);
                    if(reachNum < num) {
                        checkSpeed = testSpeed.get(j);
                        break;
                    }
                }
                if(limitSpeed < checkSpeed) {
                    maxSpeed = Math.max(maxSpeed, checkSpeed - limitSpeed);
                }
                reachNum++;
            }
            startMeter = endMeter;
        }
        System.out.println(maxSpeed);
        br.close();
    }
}
