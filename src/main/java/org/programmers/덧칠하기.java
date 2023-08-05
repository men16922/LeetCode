package org.programmers;

import java.util.Arrays;

public class 덧칠하기 {

    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + (m-1);
        int ans = 1;

        for(int i : section){
            if(i>=start && i<=end)
                continue;
            else{
                start = i;
                end = i + (m-1);
                ans++;
            }

        }
        return ans;
    }
    
    public static void main(String[] args) {
        덧칠하기 덧칠하기 = new 덧칠하기();
        int n = 8;
        int m = 4;
        int [] section = {2, 3, 6};
        System.out.println(덧칠하기.solution(n, m, section));
    }
}
