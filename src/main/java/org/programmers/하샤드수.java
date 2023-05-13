package org.programmers;

import java.util.Arrays;

public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer = false;
        char [] charArray = Integer.toString(x).toCharArray();
        int [] intArray = new int [charArray.length];
        Arrays.setAll(intArray, i -> charArray[i] - '0');
        double divisor = Arrays.stream(intArray).sum();

        if (x / divisor == (int) (x / divisor)) {
            answer = true;
        }
        return answer;
    }

    public boolean isHarshad(int num){
        String [] tmp = String.valueOf(num).split("");
        int sum=0;
        for(String s:tmp) {
            sum+=Integer.parseInt(s);
        }

        if(num%sum==0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        하샤드수 하샤드수 = new 하샤드수();
        int x = 11;
        System.out.println(하샤드수.solution(x));
    }
}
